package se.onroad.edibrowser.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import se.onroad.edibrowser.domain.Partner;
import se.onroad.edibrowser.domain.PartnerJob;
import se.onroad.edibrowser.service.PartnerService;

@RestController
public class AppController {

	@Autowired
	private PartnerService partnerService;
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	
	@RequestMapping("/partners")
	public List<Partner> getPartners(){
		return partnerService.getAllPartners();
	}
	
	@RequestMapping("/partners/{partnerId}")
	public Partner getPartner(@PathVariable Integer partnerId){
		return partnerService.getPartner(partnerId);
	}
	
	@RequestMapping(value = "/partners/savejob", method = RequestMethod.POST)
	public void savePartnerJob(@RequestBody @Valid PartnerJob partnerJob){
		partnerService.savePartnerJob(partnerJob);		
	}
}