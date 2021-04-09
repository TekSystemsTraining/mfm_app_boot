package com.mfm_app.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mfm_app.services.PrimaryBodyPartService;

@SpringBootTest
class PrimaryBodyPartServiceTest {
	
	@Autowired
	PrimaryBodyPartService pbs;

	@Test
	@Transactional
	void get_all_primary_test() {
		String[] primary = pbs.get_all_primary();
		List<String> list = new ArrayList<>(Arrays.asList(primary));
		String expectedName = "chest";
		
		assertTrue(list.contains(expectedName));
	}

}
