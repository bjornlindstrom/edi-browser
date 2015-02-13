package com.afconsult.edibrowser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afconsult.edibrowser.domain.Validator;

public interface ValidatorRepository extends JpaRepository<Validator, Integer> {

	@Query("SELECT id FROM Validator v")
    public List<Integer> findAllValidatorIds();
}
