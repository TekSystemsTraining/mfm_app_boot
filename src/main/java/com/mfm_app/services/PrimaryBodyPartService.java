package com.mfm_app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfm_app.entities.Exercise;
import com.mfm_app.entities.PrimaryBodypartList;
import com.mfm_app.repo.PrimaryBodypartRepository;

@Service
public class PrimaryBodyPartService {
	
	@Autowired
	PrimaryBodypartRepository pr;
	

	
	public String[] get_all_primary(){
		List<PrimaryBodypartList> plist = new ArrayList<>();
		
		try {
			plist = pr.findAll();
		} catch (Exception e) {

			e.printStackTrace();
		}
		String[] ex_arr = new String[plist.size()];
		int i =0;
		for(PrimaryBodypartList p: plist ) {
			ex_arr[i] = p.getPrimary_bodypart();
			i++;
		}
		
		return ex_arr;
	}
	

}
