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

import com.mfm_app.services.SecondaryBodypartService;

@SpringBootTest
class SecondaryBodypartServiceTest {

	@Autowired
	SecondaryBodypartService sbs;
	
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
	void get_all_secondary_test() {
		String[] secondary = sbs.get_all_secondary();
		List<String> list = new ArrayList<>(Arrays.asList(secondary));
		String expected_name = "triceps";
		
		assertTrue(list.contains(expected_name));
	}

}
