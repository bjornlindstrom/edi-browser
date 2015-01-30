package com.afconsult.edibrowser.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afconsult.edibrowser.domain.EdiError;
import com.afconsult.edibrowser.service.EdiErrorService;

@RestController
public class EdiErrorController {

	@Autowired
	private EdiErrorService ediErrorService;
	
	@RequestMapping("/edierror")
	public List<EdiError> getEdiErrors(){
		return ediErrorService.getAllEdiErrors();
	}
	
	
}
