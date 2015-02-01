package com.afconsult.edibrowser.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afconsult.edibrowser.domain.PartnerJob;
import com.afconsult.edibrowser.service.PartnerJobService;

@RestController
public class PartnerJobController {

	@Autowired
	private PartnerJobService partnerJobService;
	
	@RequestMapping(value = "/partnerjob", method = RequestMethod.POST)
	public void savePartnerJob(@RequestBody @Valid PartnerJob partnerJob){
		partnerJobService.savePartnerJob(partnerJob);		
	}
}