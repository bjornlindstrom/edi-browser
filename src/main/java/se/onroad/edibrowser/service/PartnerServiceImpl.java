package se.onroad.edibrowser.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.onroad.edibrowser.domain.Partner;
import se.onroad.edibrowser.domain.PartnerJob;
import se.onroad.edibrowser.domain.PartnerRepository;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;

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

	@Transactional
	public void savePartnerJob(PartnerJob partnerJob) {

		partnerRepository.savePartnerJob(partnerJob);

	}

}
