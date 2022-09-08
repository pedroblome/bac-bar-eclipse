package com.qat.crud.domain.Bundle;

import java.util.ArrayList;
import java.util.List;

public abstract class Validator {


	  public abstract Boolean validate();
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
	

}
