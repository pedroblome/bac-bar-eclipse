package com.qat.crud.domain.Bundle.BAC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.Validator;
import com.qat.crud.domain.Bundle.BAR.BundleBAR;
import com.qat.crud.domain.Bundle.model.Bundle;

@Component
public class BundleBACImpl implements BundleBAC {

	public BundleBACImpl(BundleBAR bar) {
		this.bar = bar;
	}


	@Autowired
	private BundleBAR bar;

	@Override
	public Response<Bundle> fetchAllBundles() {
		return bar.fetchAllBundles();

	}

	@Override
	public Response<Bundle> fetchBundleById(Integer id) {
		return bar.fetchBundleById(id);
	}

	@Override
	public Response<Bundle> insertBundle(Bundle bundle) {
		Validator validator = new BundleValidator(bundle);
		if (!validator.validate()) {
			return Response.of(HttpStatus.BAD_REQUEST);
		} else {
			return bar.insertBundle(bundle);
		}
	}

	@Override
	public Response<Bundle> updateBundle(Bundle bundle) {

		Validator validator = new BundleValidator(bundle);
		if (!validator.validate()) {
			return Response.of(HttpStatus.BAD_REQUEST);
		} else {
			return bar.updateBundle(bundle);
		}

	}

	@Override
	public Response<Bundle> deleteBundleById(Integer id) {

		return bar.deleteBundleById(id);

	}

}
