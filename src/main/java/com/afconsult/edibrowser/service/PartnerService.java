package com.afconsult.edibrowser.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.afconsult.edibrowser.domain.Partner;

public interface PartnerService {

	Page<Partner> getAllPartners(Pageable pageable);
	Partner getPartner(Integer partnerId);
	void savePartner(Partner partner);
}
