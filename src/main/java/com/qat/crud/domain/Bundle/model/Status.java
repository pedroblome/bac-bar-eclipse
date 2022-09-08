	package com.qat.crud.domain.Bundle.model;

public enum Status {

	confirmed("confirmed"),
	analisys("analisys"),
	waiting_payment("waiting_payment"),
	route("route"),
	unknow("unknow");

	private String status;

	Status(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}

}
