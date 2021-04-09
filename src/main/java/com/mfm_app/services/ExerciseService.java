package com.mfm_app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfm_app.entities.Exercise;
import com.mfm_app.repo.ExerciseRepository;

@Service
public class ExerciseService {

	@Autowired
	ExerciseRepository er;

	public String[] get_all_exercises() {
		List<Exercise> exercises = new ArrayList<>();
		try {
			exercises = er.findAll();
		} catch (Exception e) {

			e.printStackTrace();
		}
		String[] ex_arr = new String[exercises.size()];
		int i =0;
		for(Exercise exercise: exercises ) {
			ex_arr[i] = exercise.getName();
			i++;
		}
		return ex_arr;
	}

	public boolean add_exercise(Exercise exercise) {
		Boolean return_value = false;		
		try {
			er.save(exercise);
			return_value = true;
		}catch(Exception e) {

			e.printStackTrace();
		}				
		return return_value;
	}
}
