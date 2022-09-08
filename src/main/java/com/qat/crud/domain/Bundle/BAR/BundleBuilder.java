package com.qat.crud.domain.Bundle.BAR;

import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.Status;

public class BundleBuilder {

	private Integer id;
	private String namePackage;
	private String zipCodeOrigin;
	private String zipCodeDestin;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public BundleBuilder(Integer id, String namePackage, String zipCodeOrigin, String zipCodeDestin, Status status) {
		super();
		this.id = id;
		this.namePackage = namePackage;
		this.zipCodeOrigin = zipCodeOrigin;
		this.zipCodeDestin = zipCodeDestin;
		this.status = status;
	}
	@Override
	public String toString() {
		return "BundleBuilder [id=" + id + ", namePackage=" + namePackage + ", zipCodeOrigin=" + zipCodeOrigin
				+ ", zipCodeDestin=" + zipCodeDestin + ", status=" + status + "]";
	}




}
