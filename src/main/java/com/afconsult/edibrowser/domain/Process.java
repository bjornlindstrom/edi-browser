package com.afconsult.edibrowser.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_process")
public class Process implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "process_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "partner_job_id")
	@NotNull
	@JsonBackReference
	private PartnerJob partnerJob;
	@Column(name = "process_order")
	@NotNull
	private Integer order;
	@Column(name = "process_description")
	private String description;
	@NotNull
	private Integer processorId;
	private boolean notifyOnSuccess;
	private boolean notifyOnError;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "process_name_id")
	@Valid
	@NotNull
	private ProcessName processName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PartnerJob getPartnerJob() {
		return partnerJob;
	}

	public void setPartnerJob(PartnerJob partnerJob) {
		this.partnerJob = partnerJob;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProcessorId() {
		return processorId;
	}

	public void setProcessorId(Integer processorId) {
		this.processorId = processorId;
	}

	public boolean isNotifyOnSuccess() {
		return notifyOnSuccess;
	}

	public void setNotifyOnSuccess(boolean notifyOnSuccess) {
		this.notifyOnSuccess = notifyOnSuccess;
	}

	public boolean isNotifyOnError() {
		return notifyOnError;
	}

	public void setNotifyOnError(boolean notifyOnError) {
		this.notifyOnError = notifyOnError;
	}

	public ProcessName getProcessName() {
		return processName;
	}

	public void setProcessName(ProcessName processName) {
		this.processName = processName;
	}

	@Override
	public String toString() {
		return "Process [id=" + id + ", partnerJob=" + (partnerJob != null ? partnerJob.getId() : null) + ", order="
				+ order + ", description=" + description + ", processorId="
				+ processorId + ", notifyOnSuccess=" + notifyOnSuccess
				+ ", notifyOnError=" + notifyOnError + "]";
	}
	
	@PrePersist
	@PreUpdate
	public void update(){
		if (getProcessName() != null) {
			setDescription(getProcessName().getName());
		}
	}
}
