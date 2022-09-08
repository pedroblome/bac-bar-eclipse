package com.qat.crud.domain.Bundle;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qat.crud.domain.Bundle.model.Bundle;

public class Response<R> {
	
	private List<R> data;
	private HttpStatus httpStatus;
	private final List<ValidationError> validationErrors;
	
	  private Response(List<R> data, HttpStatus aStatus, List<ValidationError> errors) {
		    this.data = data;
		    this.httpStatus = aStatus;
		    this.validationErrors = errors;
		  }
	  
	  public static <R> Response<R> of(List<R> data, HttpStatus aStatus) {
		    return new Response<>(data, aStatus, Collections.emptyList());
		  }

		  public static <R> Response<R> of(R data, HttpStatus aStatus) {
		    return new Response<>(Collections.singletonList(data), aStatus, Collections.emptyList());
		  }

		  public static <R> Response<R> of(HttpStatus aStatus , List<ValidationError> errors) {
		    return new Response<>( null, aStatus, errors);
		  }

		  public static Response<Bundle> of(HttpStatus aStatus) {
		    return new Response<>( null, aStatus, Collections.emptyList());
		  }

		  public List<R> getData() {
		    return data;
		  }


		  public List<ValidationError> getValidationErrors() {
		    return validationErrors;
		  }

		public HttpStatus getHttpStatus() {
			return httpStatus;
		}

		public ResponseEntity<?> toResponseEntity() {
			return new ResponseEntity<>(this, httpStatus);
		}


}
