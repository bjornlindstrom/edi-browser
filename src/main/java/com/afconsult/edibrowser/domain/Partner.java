package com.afconsult.edibrowser.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_partner")
@NamedQueries(
		@NamedQuery(name = Partner.FIND_ALL, query = "SELECT p FROM Partner p"))
public class Partner implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Partner.findAll";
	
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "partner_id")
	private Integer id;
	@Column(name = "partner_alias_id")
	@NotNull
	private Integer aliasId;
	@Column(name = "partner_name")
	@NotNull
	private String name;
	@Column(name = "partner_path_name")
	@NotNull
	private String pathName;
	@Column(name = "partner_contact")
	private String contact;
	@Column(name = "partner_phone")
	private String phone;
	@Column(name = "partner_email")
	@Email
	private String email;
	@OneToMany(mappedBy = "partner", fetch = FetchType.LAZY)
	@JsonManagedReference
	@Valid
	private List<PartnerJob> partnerJobs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAliasId() {
		return aliasId;
	}

	public void setAliasId(Integer aliasId) {
		this.aliasId = aliasId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PartnerJob> getPartnerJobs() {
		return partnerJobs;
	}

	public void setPartnerJobs(List<PartnerJob> partnerJobs) {
		this.partnerJobs = partnerJobs;
	}

	@Override
	public String toString() {
		return "Partner [id=" + id + ", aliasId=" + aliasId + ", name=" + name
				+ ", pathName=" + pathName + ", contact=" + contact
				+ ", phone=" + phone + ", email=" + email + ", partnerJobs="
				+ partnerJobs + "]";
	}
}
