package com.afconsult.edibrowser.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afconsult.edibrowser.domain.ProcessName;
import com.afconsult.edibrowser.service.ProcessService;

@RestController
public class ProcessController {
	
	@Autowired
	private ProcessService processService;
	
	@RequestMapping(value = "/processnames", method = RequestMethod.GET)
	public List<ProcessName> getProcessNames(){
		return processService.getAllProcessNames();		
	}
	
	@RequestMapping(value = "/processorids/{processorNameId}", method = RequestMethod.GET)
	public List<Integer> getProcessorIds(@PathVariable Integer processorNameId){
		return processService.getProcessorIds(processorNameId);
	}
}