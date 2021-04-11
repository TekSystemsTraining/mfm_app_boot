package com.mfm_app.test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mfm_app.entities.Workout;
import com.mfm_app.services.WorkoutService;

@SpringBootTest
public class WorkoutServiceTest {

	@Autowired
	WorkoutService ws;
	
	Long l = 867646951397008654L;
	Workout w = new Workout(l, new Date(), 5000.0, "", "", "");
	
	
	@Test
	@Transactional
	void add_workout_test() {
		Workout result = ws.add_workout(w);
		
		assertTrue(result.equals(w));
	}
	
	@Test
	@Transactional
	void get_workout_by_id_test() {
		ws.add_workout(w);
		Workout result = ws.get_workout_by_id(l);
		
		assertTrue(result.equals(w));
	}
	
	@Test
	@Transactional
	void delete_workout_test() {
		ws.add_workout(w);
		Boolean result = ws.delete_workout(l);
		
		assertTrue(result);
	
	}
}
