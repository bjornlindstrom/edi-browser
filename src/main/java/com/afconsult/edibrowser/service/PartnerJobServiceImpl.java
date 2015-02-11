package com.afconsult.edibrowser.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afconsult.edibrowser.domain.PartnerJob;
import com.afconsult.edibrowser.repository.PartnerJobRepository;

@Service
public class PartnerJobServiceImpl implements PartnerJobService {

	private Logger logger = LoggerFactory.getLogger(PartnerJobServiceImpl.class);
	
	@Autowired
	private PartnerJobRepository partnerJobRepository;
	
	@Override
	@Transactional
	public PartnerJob savePartnerJob(PartnerJob partnerJob) {
		logger.info("Save PartnerJob: {}", partnerJob);
		return partnerJobRepository.save(partnerJob);
	}

}
