package com.mfm_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfm_app.entities.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String>{

	Exercise getExerciseByName(String name);
}
