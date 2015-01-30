package com.afconsult.edibrowser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afconsult.edibrowser.domain.EdiError;
import com.afconsult.edibrowser.domain.EdiErrorRepository;

@Service
public class EdiErrorServiceImpl implements EdiErrorService {

	@Autowired
	private EdiErrorRepository errorRepository;
	
	@Override
	public List<EdiError> getAllEdiErrors() {
		return errorRepository.findEdiErrors();
	}

}
