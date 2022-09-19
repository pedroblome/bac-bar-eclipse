package com.qat.crud.domain.Bundle.model;

import java.util.List;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.ValidationError;

public class BundleResponse extends Response<Bundle>{
	
	  public BundleResponse(List<Bundle> data, STATUSERROR aStatus, List<ValidationError> errors) {
		    super(data, aStatus, errors);
		  }


		  public BundleResponse(Exception exception) {
		    super(EMPTY_LIST, STATUSERROR.EXCEPTIONERROR, EMPTY_LIST);
		  }

		  public BundleResponse(STATUSERROR validationerror, List<ValidationError> errors) {
		    super(EMPTY_LIST, validationerror, errors);
		  }

		  public BundleResponse(Bundle bundle, STATUSERROR status) {
		    super(List.of(bundle), status, EMPTY_LIST);
		  }

		  public BundleResponse(STATUSERROR status) {
		    super(EMPTY_LIST, status, EMPTY_LIST);
		  }

		  public BundleResponse(List<Bundle> bundles, STATUSERROR status) {
		    super(bundles, status, EMPTY_LIST);
		  }
	
			

}
