package com.afconsult.edibrowser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.afconsult.edibrowser.domain.EdiError;
import com.afconsult.edibrowser.repository.EdiErrorRepository;

@Service
public class EdiErrorServiceImpl implements EdiErrorService {

	@Autowired
	private EdiErrorRepository ediErrorRepository;
	
	@Override
	public Page<EdiError> getAllEdiErrors(Pageable pageable) {	
		return ediErrorRepository.findAll(pageable);
	}

}
