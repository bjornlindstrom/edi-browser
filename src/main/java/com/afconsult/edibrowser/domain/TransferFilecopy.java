package com.afconsult.edibrowser.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transfer_filecopy")
public class TransferFilecopy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "transfer_filecopy_id")
	private Integer id;
	@Column(name = "filecopy_user")
	private String user;
	@Column(name = "filecopy_password")
	private String password;
	@Column(name = "filecopy_path")
	private String path;
	@Column(name = "filecopy_create_path")
	private String createPath;
	@Column(name = "filecopy_description")
	private String description;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCreatePath() {
		return createPath;
	}

	public void setCreatePath(String createPath) {
		this.createPath = createPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
