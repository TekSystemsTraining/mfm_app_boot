package com.mfm_app.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
		
		assertThat(us.get_all_users(), contains(
				hasProperty("username", is("adam"))));
	}

}
