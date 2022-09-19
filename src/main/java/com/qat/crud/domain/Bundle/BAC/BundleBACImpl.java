package com.qat.crud.domain.Bundle.BAC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.Validator;
import com.qat.crud.domain.Bundle.BAR.BundleBAR;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;

@Component
public class BundleBACImpl implements BundleBAC {


	@Autowired
	private BundleBAR bar;
	
	public BundleBACImpl(BundleBAR bar) {
		this.bar = bar;
	}



	@Override
	public Response<Bundle> fetchAllBundles(BundleRequest request) {
		return bar.fetchAllBundles(request);

	}

	@Override
	public Response<Bundle> fetchBundleById(BundleRequest request) {
		return bar.fetchBundleById(request);
	}

	@Override
	public Response<Bundle> insertBundle(BundleRequest request) {
		Validator validator = new BundleValidator(request.getData());
		if (!validator.validate()) {
			return new BundleResponse(STATUSERROR.VALIDATIONERROR, validator.getErrors());
		} else {
			return bar.insertBundle(request);
		}
	}

	@Override
	public Response<Bundle> updateBundle(BundleRequest request) {

		Validator validator = new BundleValidator(request.getData());
		if (!validator.validate()) {
			return new BundleResponse(STATUSERROR.VALIDATIONERROR, validator.getErrors());
		} else {
			return bar.updateBundle(request);
		}

	}

	@Override
	public Response<Bundle> deleteBundleById(BundleRequest request) {

		return bar.deleteBundleById(request);

	}

}
