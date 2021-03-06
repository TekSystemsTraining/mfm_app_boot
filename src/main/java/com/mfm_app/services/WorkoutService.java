package com.mfm_app.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfm_app.entities.Workout;
import com.mfm_app.repo.WorkoutRepository;

@Service
public class WorkoutService {

	@Autowired
	WorkoutRepository wr;

	public Workout add_workout(Workout workout) {
		Workout return_value = null;

		try {
			wr.save(workout);
			return_value = workout;
			System.out.println("Workout after save: " + return_value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return return_value;
	}

	public Workout get_workout_by_id(Long wId) {
		return wr.getWorkoutById(wId);
	}

	public Boolean delete_workout(Long id) {
		Boolean result = false;
		System.out.println("Id to be deleted: " + id);

		try {
			wr.deleteById(id);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
