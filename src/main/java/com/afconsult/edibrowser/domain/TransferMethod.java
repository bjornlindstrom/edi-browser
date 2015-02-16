package com.afconsult.edibrowser.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_transfer_method")
public class TransferMethod implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "transfer_method_id")
	private Integer id;
	@Column(name = "method")
	private String name;
	@OneToMany(mappedBy = "transferMethod")
	@JsonIgnore
	private List<Transfer> transfers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}	
}
