package com.afconsult.edibrowser.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_error")
@NamedQueries({
	@NamedQuery(name = EdiError.FIND_ALL, query = "SELECT e FROM EdiError e"),
	@NamedQuery(name = EdiError.FIND_ALL_IN, query = "SELECT e FROM EdiError e WHERE e.id IN :idList"),
	@NamedQuery(name = EdiError.COUNT_ALL, query = "SELECT COUNT(e) FROM EdiError e")})
public class EdiError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "EdiError.findAll";
	public static final String FIND_ALL_IN = "EdiError.findAllIn";
	public static final String COUNT_ALL = "EdiError.countAll";

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "error_id")
	private Integer id;
	private Integer eventId;
	@Column(name = "error_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "error_module")
	private String module;
	@Column(name = "error_description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
