package se.onroad.edibrowser.service;

import java.util.List;

import se.onroad.edibrowser.domain.Partner;
import se.onroad.edibrowser.domain.PartnerJob;

public interface PartnerService {

	List<Partner> getAllPartners();
	Partner getPartner(Integer partnerId);
	void savePartnerJob(PartnerJob partnerJob);
}
