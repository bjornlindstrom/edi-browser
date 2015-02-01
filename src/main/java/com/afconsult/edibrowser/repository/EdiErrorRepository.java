package com.afconsult.edibrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afconsult.edibrowser.domain.EdiError;

public interface EdiErrorRepository extends JpaRepository<EdiError, Integer> {

	
}
