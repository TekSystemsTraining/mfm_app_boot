package com.mfm_app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfm_app.entities.Workout;
import com.mfm_app.repo.WorkoutRepository;

@Service
public class WorkoutService {
	
	@Autowired
	WorkoutRepository wr;

	public Long add_workout(Workout workout)
	{
		Long return_value = 0L;
		
		try {
			wr.save(workout);
			System.out.println("workout Id" + workout.getId());
			return_value = workout.getId();
			System.out.println("Wservice workout" + return_value);
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return return_value;
	}
	
	public Workout get_workout_by_id(Long wId) {
		return wr.getWorkoutById(wId);
	}
	
	public Boolean delete_workout(Long id) {
		Boolean result = false;
		
		try {
			wr.deleteById(id);
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
