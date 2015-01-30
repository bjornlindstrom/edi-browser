package com.afconsult.edibrowser.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EdiErrorRepositoryJpa implements EdiErrorRepository,
		PagingAndSortingRepository<EdiError, Integer> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<EdiError> findEdiErrors() {
		TypedQuery<EdiError> query = entityManager.createNamedQuery(
				EdiError.FIND_ALL, EdiError.class);
		return query.getResultList();
	}

	@Override
	public <S extends EdiError> S save(S entity) {
		if (entity.getId() == null) {
			entityManager.persist(entity);
		} else {
			entityManager.merge(entity);
		}

		return entity;
	}

	@Override
	public <S extends EdiError> Iterable<S> save(Iterable<S> entities) {
		for (EdiError err : entities) {
			save(err);
		}
		return entities;
	}

	@Override
	public EdiError findOne(Integer id) {
		return entityManager.find(EdiError.class, id);
	}

	@Override
	public boolean exists(Integer id) {
		EdiError error = findOne(id);
		return error != null;
	}

	@Override
	public Iterable<EdiError> findAll() {
		TypedQuery<EdiError> query = entityManager.createNamedQuery(
				EdiError.FIND_ALL, EdiError.class);
		return query.getResultList();
	}

	@Override
	public Iterable<EdiError> findAll(Iterable<Integer> ids) {
		TypedQuery<EdiError> query = entityManager.createNamedQuery(
				EdiError.FIND_ALL_IN, EdiError.class);
		query.setParameter("idList", ids);
		return query.getResultList();		
	}

	@Override
	public long count() {
		TypedQuery<Long> query = entityManager.createNamedQuery(
				EdiError.COUNT_ALL, Long.class);
		return query.getSingleResult();
	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public void delete(EdiError entity) {

	}

	@Override
	public void delete(Iterable<? extends EdiError> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public Iterable<EdiError> findAll(Sort sort) {

		return null;
	}

	@Override
	public Page<EdiError> findAll(Pageable pageable) {
		
		return null;
	}

}
