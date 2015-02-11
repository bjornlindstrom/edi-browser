package com.afconsult.edibrowser.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tb_partner_job")
public class PartnerJob implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "partner_job_id", unique = true, updatable = false, nullable = false)
	private Integer id;
	@NotNull
	private String partnerJobName;
	@NotNull
	private String directoryWatch;
	@NotNull
	private String fileExtension;
	private boolean direction;
	private boolean online;
	@Column(name = "partner_job_path_name")
	@NotNull
	private String jobPathName;
	@Min(value = 1)
	private int numberOfAttemptsAllowed;
	@NotNull
	@Min(value = 1)
	private Integer priority;
	@ManyToOne
	@JoinColumn(name = "partner_id")
	@NotNull
	@JsonBackReference
	private Partner partner;
	@OneToMany(mappedBy = "partnerJob", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
	@Valid
	@JsonManagedReference
	private List<Process> processes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPartnerJobName() {
		return partnerJobName;
	}

	public void setPartnerJobName(String partnerJobName) {
		this.partnerJobName = partnerJobName;
	}

	public String getDirectoryWatch() {
		return directoryWatch;
	}

	public void setDirectoryWatch(String directoryWatch) {
		this.directoryWatch = directoryWatch;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getJobPathName() {
		return jobPathName;
	}

	public void setJobPathName(String jobPathName) {
		this.jobPathName = jobPathName;
	}

	public int getNumberOfAttemptsAllowed() {
		return numberOfAttemptsAllowed;
	}

	public void setNumberOfAttemptsAllowed(int numberOfAttemptsAllowed) {
		this.numberOfAttemptsAllowed = numberOfAttemptsAllowed;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<Process> getProcesses() {
		return processes;
	}

	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}

	@Override
	public String toString() {
		return "PartnerJob [id=" + id + ", partnerJobName=" + partnerJobName
				+ ", directoryWatch=" + directoryWatch + ", fileExtension="
				+ fileExtension + ", direction=" + direction + ", online="
				+ online + ", jobPathName=" + jobPathName
				+ ", numberOfAttemptsAllowed=" + numberOfAttemptsAllowed
				+ ", priority=" + priority + ", partner=" + (partner != null ? partner.getId() : null)
				+ ", processes=" + processes + "]";
	}
}
