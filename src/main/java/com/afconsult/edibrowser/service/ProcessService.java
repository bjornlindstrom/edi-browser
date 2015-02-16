package com.afconsult.edibrowser.service;

import java.util.List;

import com.afconsult.edibrowser.domain.ProcessName;

public interface ProcessService {

	List<ProcessName> getAllProcessNames();
	List<Integer> getProcessorIds(Integer processorNameId, String transferMethodName);
	
}
