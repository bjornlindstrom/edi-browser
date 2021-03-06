package com.afconsult.edibrowser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afconsult.edibrowser.domain.ProcessName;
import com.afconsult.edibrowser.domain.TransferMethodName;
import com.afconsult.edibrowser.repository.ArchiverRepository;
import com.afconsult.edibrowser.repository.ConverterRepository;
import com.afconsult.edibrowser.repository.ProcessNameRepository;
import com.afconsult.edibrowser.repository.TransferFilecopyRepository;
import com.afconsult.edibrowser.repository.ValidatorRepository;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private ProcessNameRepository processNameRepository;

	@Autowired
	private ConverterRepository converterRepository;
	
	@Autowired
	private ValidatorRepository validatorRepository;
	
	@Autowired
	private ArchiverRepository archiverRepository;
	
	@Autowired
	private TransferFilecopyRepository transferFilecopyRepository;
	
	@Override
	public List<ProcessName> getAllProcessNames() {
		return processNameRepository.findAll();
	}

	@Override
	public List<Integer> getProcessorIds(Integer processorNameId, String transferMethodName) {
		List<Integer> processorIds = new ArrayList<Integer>();
		switch (processorNameId) {
		case 1:
			processorIds = converterRepository.findAllConverterIds();
			break;
		case 2:
			
			if (TransferMethodName.FILECOPY.getName().equals(transferMethodName)) {
				processorIds = transferFilecopyRepository.findAllTransferIds();
			}
			// TODO: implement for other types.
			
			break;
		case 3:
			processorIds = archiverRepository.findAllArchiverIds();
			break;
		case 4: 
			processorIds = validatorRepository.findAllValidatorIds();
			break;
		}

		return processorIds;
	}

}
