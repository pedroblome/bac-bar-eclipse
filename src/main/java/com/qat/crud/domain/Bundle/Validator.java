package com.qat.crud.domain.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.qat.crud.domain.Bundle.model.Status;

public abstract class Validator {

	public abstract void checkValidState();

	public Boolean validate() {
		checkValidState();
		return getErrors().isEmpty();
	}

	private List<ValidationError> errors;

	public Validator() {
		this.errors = new ArrayList<>();
	}

	public List<ValidationError> getErrors() {
		return errors;
	}

	public void addError(String field, String message) {
		errors.add(ValidationError.of(field, message));
	}

	public void checkRequired(String field, String value) {
		if (value == null || value.isEmpty()) {
			addError(field, field + " is required");
		}
	}

	public void checkStatus(String field, Status value) {
		if (value != Status.analisys && value != Status.confirmed && value != Status.route
				&& value != Status.waiting_payment) {
			addError("status", "must be  confirmed, analisys, waiting_payment or route!");

		}
	}

	public void checkLength(String field, String value, int length) {
		if (value != null && value.length() != length) {
			addError(field, field + " must be equal to  " + length + " characters");
		}
	}
	
	  public void checkMaxLength(String field, String value, int maxLength) {
		    if (value != null && value.length() > maxLength) {
		      addError(field, field + " must be less than " + maxLength + " characters");
		    }
		  }

}
