package com.afconsult.edibrowser.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_converters")
public class Converter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false, updatable = false, name = "converter_id")
	private Integer id;
	@Column(name = "converter_name")
	private String name;
	@Column(name = "converter_executer")
	private String executer;
	@Column(name = "converter_call")
	private String call;
	@Column(name = "converter_arguments")
	private String arguments;
	@Column(name = "converter_description")
	private String description;

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

	public String getExecuter() {
		return executer;
	}

	public void setExecuter(String executer) {
		this.executer = executer;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getArguments() {
		return arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
