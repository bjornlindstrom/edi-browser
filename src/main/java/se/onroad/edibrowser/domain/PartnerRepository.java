package se.onroad.edibrowser.domain;

import java.util.List;

public interface PartnerRepository {

	List<Partner> findPartners();
	Partner findPartnerById(Integer partnerId);
	
	void savePartnerJob(PartnerJob partnerJob);
}
