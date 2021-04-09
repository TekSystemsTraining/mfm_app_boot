package com.mfm_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfm_app.entities.PrimaryBodypartList;

@Repository
public interface PrimaryBodypartRepository extends JpaRepository<PrimaryBodypartList, String>{

	
}
