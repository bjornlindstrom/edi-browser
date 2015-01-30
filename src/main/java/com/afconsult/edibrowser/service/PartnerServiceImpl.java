package com.afconsult.edibrowser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afconsult.edibrowser.domain.Partner;
import com.afconsult.edibrowser.domain.PartnerJob;
import com.afconsult.edibrowser.domain.PartnerRepository;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;

	private Logger logger = LoggerFactory.getLogger(PartnerServiceImpl.class);
	
	@Override
	public List<Partner> getAllPartners() {
		return partnerRepository.findPartners();
	}

	@Override
	public Partner getPartner(Integer partnerId) {
		Partner partner = partnerRepository.findPartnerById(partnerId);
		if (partner != null) {
			for (PartnerJob partnerJob : partner.getPartnerJobs()) {
				partnerJob.getProcesses();
			}
		}
		return partner;
	}

	@Override
	@Transactional
	public void savePartnerJob(PartnerJob partnerJob) {
		logger.info("Save PartnerJob: {}", partnerJob);
		partnerRepository.savePartnerJob(partnerJob);

	}

	@Override
	@Transactional
	public void savePartner(Partner partner) {
		logger.info("Save Partner: {}", partner);
		partnerRepository.savePartner(partner);
	}

}
