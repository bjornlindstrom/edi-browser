package com.afconsult.edibrowser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afconsult.edibrowser.domain.ProcessName;

public interface ProcessNameRepository extends JpaRepository<ProcessName, Integer> {

	
}
