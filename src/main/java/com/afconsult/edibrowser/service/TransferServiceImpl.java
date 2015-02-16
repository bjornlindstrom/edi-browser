package com.afconsult.edibrowser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afconsult.edibrowser.domain.TransferMethod;
import com.afconsult.edibrowser.repository.TransferMethodRepository;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferMethodRepository transferMethodRepository;
	
	@Override
	public List<TransferMethod> getTransferMethods() {
		return transferMethodRepository.findAll();
	}

	
	
}
