package com.springcloudapi.util;

import java.util.List;

public class ApiResponse {
	private String message;
	private String decsription;
	private Object object;
	private int status;
	List<String> erroList;
	

	public ApiResponse() {
	}


	public ApiResponse(String message, String decsription, Object object, int status, List<String> erroList) {
		super();
		this.message = message;
		this.decsription = decsription;
		this.object = object;
		this.status = status;
		this.erroList = erroList;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDecsription() {
		return decsription;
	}


	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public List<String> getErroList() {
		return erroList;
	}


	public void setErroList(List<String> erroList) {
		this.erroList = erroList;
	}

	

}

