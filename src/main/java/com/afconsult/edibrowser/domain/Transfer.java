package com.afconsult.edibrowser.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transfer")
public class Transfer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "transfer_id")
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transfer_method_id")
	private TransferMethod transferMethod;
	@OneToOne
	@JoinColumn(name = "partner_job_id")
	private PartnerJob partnerJob;
	@Column(name = "selected_transfer_method_id")
	private Integer selectedTransferMethodId;

	@OneToOne
	@JoinColumn(name = "selected_transfer_method_id", insertable = false, updatable = false)
	private TransferFilecopy transferFilecopy;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TransferMethod getTransferMethod() {
		return transferMethod;
	}

	public void setTransferMethod(TransferMethod transferMethod) {
		this.transferMethod = transferMethod;
	}

	public PartnerJob getPartnerJob() {
		return partnerJob;
	}

	public void setPartnerJob(PartnerJob partnerJob) {
		this.partnerJob = partnerJob;
	}

	public Integer getSelectedTransferMethodId() {
		return selectedTransferMethodId;
	}

	public void setSelectedTransferMethodId(Integer selectedTransferMethodId) {
		this.selectedTransferMethodId = selectedTransferMethodId;
	}
}
