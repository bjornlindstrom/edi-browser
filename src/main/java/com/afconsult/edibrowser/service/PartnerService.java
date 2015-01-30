package com.afconsult.edibrowser.service;

import java.util.List;

import com.afconsult.edibrowser.domain.Partner;
import com.afconsult.edibrowser.domain.PartnerJob;

public interface PartnerService {

	List<Partner> getAllPartners();
	Partner getPartner(Integer partnerId);
	void savePartnerJob(PartnerJob partnerJob);
	void savePartner(Partner partner);
}
