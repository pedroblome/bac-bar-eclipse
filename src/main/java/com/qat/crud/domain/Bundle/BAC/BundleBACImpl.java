package com.qat.crud.domain.Bundle.BAC;

import java.util.Collections;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.Validator;
import com.qat.crud.domain.Bundle.BAR.BundleBAR;
import com.qat.crud.domain.Bundle.model.Bundle;

@Component
public class BundleBACImpl implements BundleBAC {

	public BundleBACImpl(BundleBAR bundleBAR) {
		this.bundleBAR = bundleBAR;
	}

	private final BundleBAR bundleBAR;

	@Override
	public Response<Bundle> fetchAllBundles() {
		return Response.of(bundleBAR.fetchAllBundles(), HttpStatus.OK);
	}

	@Override
	public Response<Bundle> fetchBundleById(Integer id) {
//		return Response.of(bundleBAR.fetchBundleById(id), HttpStatus.OK);
		Bundle bundle = bundleBAR.fetchBundleById(id);
		return Response.of(Objects.nonNull(bundle) ? Collections.singletonList(bundle) : Collections.emptyList(),
				Objects.nonNull(bundle) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@Override
	public Response<Bundle> insertBundle(Bundle bundle) {
		Validator validator = new BundleValidator(bundle);

		if (!validator.validate()) {
			return Response.of(HttpStatus.BAD_REQUEST, validator.getErrors());
		}

		boolean transactionStatus = bundleBAR.insertBundle(bundle);

		if (transactionStatus == true) {
			return Response.of(bundle, HttpStatus.OK);
		} else {
			return Response.of(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Response<Bundle> updateBundle(Bundle bundle) {
		Validator validator = new BundleValidator(bundle);

		if (!validator.validate()) {
			return Response.of(HttpStatus.BAD_REQUEST, validator.getErrors());
		}

		boolean transactionStatus = bundleBAR.updateBundle(bundle);

		if (transactionStatus) {
			return Response.of(bundle, HttpStatus.OK);
		} else {
			return Response.of(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public boolean deleteBundleById(Integer id) {
		return bundleBAR.deleteBundle(id);
	}

}
