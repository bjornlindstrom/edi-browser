package com.afconsult.edibrowser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afconsult.edibrowser.domain.Converter;

public interface ConverterRepository extends JpaRepository<Converter, Integer> {

	@Query("SELECT id FROM Converter c")
    public List<Integer> findAllConverterIds();
}
