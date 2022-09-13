package com.qat.crud.domain.Bundle.BAR;

import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.Status;

public class BundleBuilder {

	private Integer id;
	private String namePackage;
	private String zipCodeOrigin;
	private String zipCodeDestin;
	private String description;
	private Status status;

	public BundleBuilder id(Integer id) {
		this.id = id;
		return this;
	}

	public BundleBuilder namePackage(String namePackage) {
		this.namePackage = namePackage;
		return this;

	}

	public BundleBuilder zipCodeOrigin(String zipCodeOrigin) {
		this.zipCodeOrigin = zipCodeOrigin;
		return this;

	}

	public BundleBuilder zipCodeDestin(String zipCodeDestin) {
		this.zipCodeDestin = zipCodeDestin;
		return this;

	}

	public BundleBuilder description(String description) {
		this.description = description;
		return this;

	}

	public BundleBuilder status(Status status) {
		this.status = status;
		return this;

	}

	public static BundleBuilder builder() {
		return new BundleBuilder();
	}	
	public Bundle build() {
		return new Bundle(id, namePackage, zipCodeOrigin, zipCodeDestin, description, status);
	}

}
