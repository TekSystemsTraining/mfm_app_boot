package com.mfm_app.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mfm_app.entities.Exercise;
import com.mfm_app.services.ExerciseService;


@SpringBootTest
class ExerciseServiceTest {
	
	@Autowired
	ExerciseService es;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllExercises() {
		String[] exercises = es.get_all_exercises();
		List<String> list = new ArrayList<>(Arrays.asList(exercises));
		String expectedName = "bench press";
		
		assertTrue(list.contains(expectedName));
	}
	
	@Test
	void testAddExercise() {
		Exercise ex = new Exercise();
		String expectedName = "jumping jack";
		ex.setName("jumping jack");
		ex.setPrimary_bodypart("legs");
		ex.setSecondary_bodypart("shoulders");
		es.add_exercise(ex);
		
		String[] exercises = es.get_all_exercises();
		List<String> list = new ArrayList<>(Arrays.asList(exercises));
		
		assertTrue(list.contains(expectedName));			
		
	}

}
