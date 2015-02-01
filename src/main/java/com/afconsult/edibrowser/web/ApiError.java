package com.afconsult.edibrowser.web;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ApiError implements Serializable {

	private static final long serialVersionUID = 1L;
	private String message;

	public ApiError() {
	}

	public ApiError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
