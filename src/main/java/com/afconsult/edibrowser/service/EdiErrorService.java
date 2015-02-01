package com.afconsult.edibrowser.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.afconsult.edibrowser.domain.EdiError;

public interface EdiErrorService {

	Page<EdiError> getAllEdiErrors(Pageable pageable);
	
}
