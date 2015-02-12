package com.afconsult.edibrowser.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_archive_settings")
public class Archiver implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "archive_settings_id")
	private Integer id;
	private boolean compress;
	@Column(name = "archive_directory")
	private String directory;
	@Column(name = "archive_name")
	private String name;
	@Column(name = "partner_path_name")
	private String partnerPathName;
	@Column(name = "partner_job_path_name")
	private String partnerJobPathName;
	@Column(name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isCompress() {
		return compress;
	}

	public void setCompress(boolean compress) {
		this.compress = compress;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartnerPathName() {
		return partnerPathName;
	}

	public void setPartnerPathName(String partnerPathName) {
		this.partnerPathName = partnerPathName;
	}

	public String getPartnerJobPathName() {
		return partnerJobPathName;
	}

	public void setPartnerJobPathName(String partnerJobPathName) {
		this.partnerJobPathName = partnerJobPathName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
