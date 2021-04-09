package com.mfm_app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mfm_app.entities.Exercise;
import com.mfm_app.entities.PrimaryBodypartList;
import com.mfm_app.entities.SecondaryBodypartList;
import com.mfm_app.entities.User;
import com.mfm_app.entities.Workout;
import com.mfm_app.services.ExerciseService;
import com.mfm_app.services.PrimaryBodyPartService;
import com.mfm_app.services.SecondaryBodypartService;
import com.mfm_app.services.UserService;
import com.mfm_app.services.WorkoutService;

@Controller
public class main_controller {

	
	//services
	@Autowired
	private UserService user_service;

	@Autowired
	private ExerciseService exercise_service;

	@Autowired
	private WorkoutService workout_service;

	@Autowired
	private PrimaryBodyPartService primary_bodypart_service;

	@Autowired
	private SecondaryBodypartService secondary_bodypart_service;

	String current_user = "";

	//main landing page
	@RequestMapping({ "/", "/landing_page" })
	public ModelAndView welcome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("landing_page");
		//clearing errors if we hit this page before trying to log in again
		request.getSession().setAttribute("error", "");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	
	
	// main profile page for a user
	@RequestMapping("/profile_page")
	public ModelAndView profile_page(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("profile_page");
		if(!current_user.equals("")){			
			//get the list of all workouts to be displayed on the page
			User current = (User) request.getSession().getAttribute("user");
			System.out.println("Current user" + current);
			List<Workout> all_workouts = user_service.get_all_workouts_for_user(current);
			System.out.println("==============");
			System.out.println(all_workouts);
			mav.addObject("all_workouts", all_workouts);
			mav.addObject("user", (User)request.getSession().getAttribute("user"));
		}
		return mav;
		
	}

	
	//route to page for entering workouts
	@RequestMapping(path = "/workout", method = RequestMethod.GET)
	public ModelAndView workout(@ModelAttribute("command") Workout workout) {
		ModelAndView mav = new ModelAndView("workout");
		//get all the exercises available in the system
		String[] all_exercises = exercise_service.get_all_exercises();
		mav.addObject("exercises", all_exercises);
		return mav;
	}

	//saving a workout
	@RequestMapping(path = "/save_workout", method = RequestMethod.GET)
	public ModelAndView save_workout(HttpServletRequest request, @ModelAttribute Workout workout,
			@RequestParam String exercise_one_completed, @RequestParam String exercise_two_completed,
			@RequestParam String exercise_three_completed) {
		Workout new_workout = new Workout();
		Long saved_workout;
		User updated_user;
		//setting all variables
		new_workout.setDate_of_workout(new Date());
		new_workout.setTotal_weight_lifted(workout.getTotal_weight_lifted());
		new_workout.setExercise_one_completed(exercise_one_completed);
		new_workout.setExercise_two_completed(exercise_two_completed);
		new_workout.setExercise_three_completed(exercise_three_completed);
		//adding the workout to the workout table
		saved_workout = workout_service.add_workout(new_workout);
		//saving the workout to the current users list of workouts
		updated_user = user_service.update_user_increase((User)request.getSession().getAttribute("user"), saved_workout);
		request.getSession().setAttribute("user", updated_user);
		//route back to the profile_page after saving
		return profile_page(request);
	}

	@RequestMapping(value = "/delete_workout/{id}")
	public String delete_workout(@PathVariable("id") Long delete_id, HttpServletRequest request) {
		//remove the id from the list of workouts the user has
		User updated_user = user_service.update_user_decrease((User)request.getSession().getAttribute("user"), delete_id);
		//delete the workout from the workout table
		Boolean delete_result = workout_service.delete_workout(delete_id);

		//reset the user to the session
		request.getSession().setAttribute("user", updated_user);
		if (delete_result) {
			System.out.println("Successfully deleted workout");
		} else {
			System.out.println("Couldnt delete workout");
		}
		//route back to the profile_page after deleting
		return "redirect:/profile_page";
	}

	@RequestMapping("/leaderboard")
	public ModelAndView leaderboard() {
		ModelAndView mav = new ModelAndView("leaderboard");
		//get all users for the leaderboard. Already sorted with query
		List<User> all_users = new ArrayList<>();
		all_users = user_service.get_all_users();
		mav.addObject("all_users", all_users);
		return mav;
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute User user, HttpServletRequest request) {

		User register_user = new User();
		User valid_user = new User();
		register_user.setUsername(user.getUsername());
		register_user.setPassword(user.getPassword());

		try {
			valid_user = user_service.add_user(register_user);

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getSession().setAttribute("user", valid_user);
		return profile_page(request);
	}

	@RequestMapping("/verify_login")
	public ModelAndView verify_login(@ModelAttribute User user, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		User login_user = new User();

		try {
			login_user = user_service.login_user(user.getUsername(), user.getPassword());
			System.out.println("controller user: " + login_user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (login_user == null) {
			mav.setViewName("login");
			request.getSession().setAttribute("error", "Login failed, please try again");
			return mav;
		} else {
			mav.addObject("user", login_user);
			request.getSession().setAttribute("user", login_user);
			request.getSession().setAttribute("error", "");
			current_user = "logged-in";
			return profile_page(request);
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		current_user = "";
		request.getSession().setAttribute("user", null);
		request.getSession().setAttribute("error", "");
		return "landing_page";
	}

	@RequestMapping("/add_exercise")
	public ModelAndView add_exercise(@ModelAttribute("command") Exercise exercise) {
		ModelAndView mav = new ModelAndView("add_exercise");
		if(!current_user.equals("")){
			String[] pbody = primary_bodypart_service.get_all_primary();
			String[] sbody = secondary_bodypart_service.get_all_secondary();
			mav.addObject("primary_bodypart", pbody);
			mav.addObject("secondary_bodypart", sbody);
			mav.setViewName("add_exercise");
		}
		return mav;
	}

	@RequestMapping("/save_exercise")
	public ModelAndView save_exercise(@ModelAttribute Exercise exercise, HttpServletRequest request,
			@RequestParam String primary_bodypart, @RequestParam String secondary_bodypart) {
		ModelAndView mav = new ModelAndView();
		Exercise new_exercise = new Exercise();
		new_exercise.setName(exercise.getName());
		new_exercise.setPrimary_bodypart(primary_bodypart);
		new_exercise.setSecondary_bodypart(secondary_bodypart);
		Boolean result = exercise_service.add_exercise(new_exercise);
		mav.setViewName("profile_page");
		return mav;
	}

}
