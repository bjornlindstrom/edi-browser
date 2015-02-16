package com.afconsult.edibrowser.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afconsult.edibrowser.domain.TransferMethod;
import com.afconsult.edibrowser.service.TransferService;

@RestController
public class TransferController {
	
	@Autowired
	private TransferService transferService;	
	
	@RequestMapping(value = "/transfermethods", method = RequestMethod.GET)
	public List<TransferMethod> getTransferMethods(){
		return transferService.getTransferMethods();		
	}
	
}