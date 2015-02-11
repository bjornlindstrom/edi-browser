package com.afconsult.edibrowser.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afconsult.edibrowser.domain.Partner;
import com.afconsult.edibrowser.service.PartnerService;

@RestController
public class PartnerController {

	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping(value = "/partner", method = RequestMethod.GET)
	public Page<Partner> getPartners(Pageable pageable){
		return partnerService.getAllPartners(pageable);
	}
	
	@RequestMapping(value = "/partner/{partnerId}", method = RequestMethod.GET)
	public Partner getPartner(@PathVariable Integer partnerId){
		return partnerService.getPartner(partnerId);
	}
	
	@RequestMapping(value = "/partner", method = RequestMethod.POST)
	public void savePartner(@RequestBody @Valid Partner partner){
		partnerService.savePartner(partner);		
	}
	
	@RequestMapping(value = "/partner", method = RequestMethod.PUT)
	public void updatePartner(@RequestBody @Valid Partner partner){
		partnerService.savePartner(partner);		
	}
}