package com.afconsult.edibrowser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afconsult.edibrowser.domain.Archiver;

public interface ArchiverRepository extends JpaRepository<Archiver, Integer> {

	@Query("SELECT id FROM Archiver a")
    public List<Integer> findAllArchiverIds();
}
