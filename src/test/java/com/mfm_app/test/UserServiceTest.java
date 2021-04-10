package com.mfm_app.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import com.mfm_app.entities.User;
import com.mfm_app.services.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService us;

	@Test
	@Transactional
	void get_all_users_test() {
//		List<User> users = new ArrayList<>();
//		users = us.get_all_users();
//		String expected_name = "adam";

		assertThat(us.get_all_users(), contains(hasProperty("username", is("adam"))));
	}

	@Test
	@Transactional
	void add_user_test() {
		User add_user = new User("Test", "123", 5, 6512.0);
		User result = us.add_user(add_user);

		assertTrue(result.getUsername().equals("Test"));
	}

//	@Test
//	@Transactional
//	void update_user_increase_test() {
//		User current_user = new User("Test", "123", 5, 6512.0);
//		Long wId = new Random().nextLong();
//		User updated_user = us.update_user_increase(current_user, wId);
//		assertTrue(updated_user.getTotal_workouts() == 4);
//	}

}
