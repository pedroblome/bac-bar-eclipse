package com.qat.crud.domain.Bundle.model;

public class Bundle {
	public Bundle() {
		
	}

	private Integer id;
	private String namePackage;
	private String zipCodeOrigin;
	private String zipCodeDestin;
	private String description;
	private Status status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNamePackage() {
		return namePackage;
	}
	public void setNamePackage(String namePackage) {
		this.namePackage = namePackage;
	}
	public String getZipCodeOrigin() {
		return zipCodeOrigin;
	}
	public void setZipCodeOrigin(String zipCodeOrigin) {
		this.zipCodeOrigin = zipCodeOrigin;
	}
	public String getZipCodeDestin() {
		return zipCodeDestin;
	}
	public void setZipCodeDestin(String zipCodeDestin) {
		this.zipCodeDestin = zipCodeDestin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Bundle(Integer id, String namePackage, String zipCodeOrigin, String zipCodeDestin, String description,
			Status status) {
		super();
		this.id = id;
		this.namePackage = namePackage;
		this.zipCodeOrigin = zipCodeOrigin;
		this.zipCodeDestin = zipCodeDestin;
		this.description = description;
		this.status = status;
	}
	
	
	
	
	

}
