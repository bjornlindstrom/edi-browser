package se.onroad.edibrowser.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_process")
// @NamedQueries(
// @NamedQuery(name = Partner.FIND_ALL, query = "SELECT p FROM Partner p"))
public class Process implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "process_id")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "partner_job_id")
	@JsonBackReference
	private PartnerJob partnerJob;
	@Column(name = "process_order")
	private int order;
	@Column(name = "process_description")
	private String description;
	// private ProcessNames processNames;
	private int processorId;
	private boolean notifyOnSuccess;
	private boolean notifyOnError;

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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProcessorId() {
		return processorId;
	}

	public void setProcessorId(int processorId) {
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
}
