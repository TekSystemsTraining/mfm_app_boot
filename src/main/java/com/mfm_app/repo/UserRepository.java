package com.mfm_app.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfm_app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	User getUserByUsername(String username);
	
	@Query(value = "SELECT * FROM USERS ORDER BY total_weight_lifted DESC", nativeQuery = true)
	List<User> findAllSorted();
}
