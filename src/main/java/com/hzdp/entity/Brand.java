package com.hzdp.entity;

import java.io.Serializable;

public class Brand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1739553494987590866L;
	
	private int id;
	private String name;
	private String enName;
	private String url;
	private int companyId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
