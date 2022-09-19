package com.qat.crud.domain.Bundle.model;

import com.qat.crud.domain.Bundle.Request;

public class BundleRequest extends Request<Bundle, Integer> {
		

	  public BundleRequest(Integer integer, Bundle data) {
	    super(integer, data);
	  }

	  public BundleRequest() {
	    super(null, null);
	  }

	  public BundleRequest(Bundle bundle) {
	    super(null,bundle);
	  }

	  public BundleRequest(int id) {
	    super(id, null);
	  }
	}
