package com.afconsult.edibrowser.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afconsult.edibrowser.domain.Partner;
import com.afconsult.edibrowser.domain.PartnerJob;
import com.afconsult.edibrowser.service.PartnerService;

@RestController
public class PartnerController {

	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping("/partner")
	public List<Partner> getPartners(){
		return partnerService.getAllPartners();
	}
	
	@RequestMapping("/partner/{partnerId}")
	public Partner getPartner(@PathVariable Integer partnerId){
		return partnerService.getPartner(partnerId);
	}
	
	@RequestMapping(value = "/partner/savejob", method = RequestMethod.POST)
	public void savePartnerJob(@RequestBody @Valid PartnerJob partnerJob){
		partnerService.savePartnerJob(partnerJob);		
	}
	
	@RequestMapping(value = "/partner/save", method = RequestMethod.POST)
	public void savePartner(@RequestBody @Valid Partner partner){
		partnerService.savePartner(partner);		
	}
}