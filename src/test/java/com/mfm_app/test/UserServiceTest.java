package com.mfm_app.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import com.mfm_app.entities.User;
import com.mfm_app.entities.Workout;
import com.mfm_app.repo.UserRepository;
import com.mfm_app.services.UserService;
import com.mfm_app.services.WorkoutService;

@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class UserServiceTest {

	@Autowired
	UserService us;
	
	@Autowired
	WorkoutService ws;
	
	@Autowired
	UserRepository ur;
	

	User current_user = new User("Test", "123", 5, 6512.0);
	Long l = 867646951397008260L;
	Workout w = new Workout(l, new Date(), 3000.0, "", "", "");
	
	

	@Test
	@Order(1)
	@Transactional	
	void get_all_users_test() {
//		List<User> users = new ArrayList<>();
//		users = us.get_all_users();
//		String expected_name = "adam";

		assertThat(us.get_all_users(), contains(hasProperty("username", is("Test"))));
	}

	@Test
	@Order(2)
	@Transactional
	
	void add_user_test() {
		User add_user = new User("Test", "123", 5, 6512.0);
		User result = us.add_user(add_user);

		assertTrue(result.getUsername().equals("Test"));
	}

	@Test
	@Order(3)
	void update_user_increase_test() {
		ws.add_workout(w);	
		System.out.println("increase id "+ w.getId());
		us.add_user(current_user);
		User updated_user = us.update_user_increase(current_user.getUsername(), w);
		assertTrue(updated_user.getTotal_workouts() == 6);
	}
	@Test
	@Order(4)
	void get_all_workouts_for_user_test() {
		List<Workout> test_list = us.get_all_workouts_for_user(current_user);
		System.out.println("test list" + test_list);
		assertTrue(test_list.size()<0);
	}
	
	
	@Test
	@Order(5)
	void update_user_decrease_test() {

		System.out.println("decrease id "+ w.getId());
		User updated_user = us.update_user_decrease(current_user.getUsername(), l);
		assertTrue(updated_user.getTotal_workouts() == 5);
	}
	
	@Test
	@Order(6)
	void login_user_test() {
		User return_user = us.login_user(current_user.getUsername(), current_user.getPassword());
		
		assertTrue(return_user.getUsername().equals(current_user.getUsername()));		
	}
	


}
