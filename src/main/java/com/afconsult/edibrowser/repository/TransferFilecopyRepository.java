package com.afconsult.edibrowser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afconsult.edibrowser.domain.TransferFilecopy;

public interface TransferFilecopyRepository extends JpaRepository<TransferFilecopy, Integer> {

	@Query("SELECT id FROM TransferFilecopy t")
    public List<Integer> findAllTransferIds();

}
