package se.onroad.edibrowser.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class PartnerRepositoryJpa implements PartnerRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Partner> findPartners() {
		
		TypedQuery<Partner> query = entityManager.createNamedQuery(Partner.FIND_ALL, Partner.class);
		return query.getResultList();
	}

	@Override
	public Partner findPartnerById(Integer partnerId) {		
		return entityManager.find(Partner.class, partnerId);		
	}

	@Override
	public void savePartnerJob(PartnerJob partnerJob) {
		if (partnerJob.getId() == null) {
			entityManager.persist(partnerJob);
		} else {
			entityManager.merge(partnerJob);
		}
	}

	
}
