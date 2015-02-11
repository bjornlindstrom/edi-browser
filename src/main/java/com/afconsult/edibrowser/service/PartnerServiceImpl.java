package com.afconsult.edibrowser.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.afconsult.edibrowser.domain.Partner;
import com.afconsult.edibrowser.domain.PartnerJob;
import com.afconsult.edibrowser.repository.PartnerRepository;
import com.afconsult.exception.ItemNotFoundException;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;

	private Logger logger = LoggerFactory.getLogger(PartnerServiceImpl.class);
	
	@Override
	public Page<Partner> getAllPartners(Pageable pageable) {
		return partnerRepository.findAll(pageable);
	}

	@Override
	public Partner getPartner(Integer partnerId) {
		Partner partner = partnerRepository.findOne(partnerId);
		if (partner != null) {
			for (PartnerJob partnerJob : partner.getPartnerJobs()) {
				partnerJob.getProcesses();
			}
		}
		if (partner == null || partner.getId() == null || partner.getAliasId() == null) {
			throw new ItemNotFoundException("No partner found with id:" + partnerId);
		}
		return partner;
	}

	@Override
	@Transactional
	public void savePartner(Partner partner) {
		logger.info("Save Partner: {}", partner);
		partnerRepository.save(partner);
	}

}
