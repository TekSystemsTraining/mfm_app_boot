package com.mfm_app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfm_app.entities.PrimaryBodypartList;
import com.mfm_app.entities.SecondaryBodypartList;
import com.mfm_app.repo.SecondaryBodypartRepository;

@Service
public class SecondaryBodypartService {
	
	@Autowired
	SecondaryBodypartRepository sr;
	
	
	public String[] get_all_secondary(){
		List<SecondaryBodypartList> slist = new ArrayList<>();
		
		try {
			slist = sr.findAll();
		} catch (Exception e) {

			e.printStackTrace();
		}
		String[] ex_arr = new String[slist.size()];
		int i =0;
		for(SecondaryBodypartList s: slist ) {
			ex_arr[i] = s.getSecondary_bodypart();
			i++;
		}
		
		return ex_arr;
	}

}
