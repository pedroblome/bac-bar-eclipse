package com.qat.crud.domain.Bundle.BAR;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.BAR.mapper.BundleMapper;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;

@Repository
public class BundleBARImpl implements BundleBAR {
	@Autowired
	private BundleMapper mapper;

	public BundleBARImpl(BundleMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Response<Bundle> fetchAllBundles(BundleRequest request) {

		return new BundleResponse(mapper.fetchAll(), STATUSERROR.OPERATIONSUCCESS);
	}

	@Override
	public Response<Bundle> fetchBundleById(BundleRequest request) {
		final Bundle bundle = mapper.fetchById(request.getId());
		if (Objects.nonNull(bundle)) {
			return new BundleResponse(bundle, STATUSERROR.OPERATIONSUCCESS);
		} else {
			return new BundleResponse( STATUSERROR.NOROWSFOUNDERROR);
		}
	}

	@Override
	public Response<Bundle> insertBundle(BundleRequest request) {
		final Bundle bundle = request.getData();
		if(mapper.insert(bundle)) {
			return new BundleResponse(bundle, STATUSERROR.OPERATIONSUCCESS);
		}else {
			return new BundleResponse(STATUSERROR.PERSISTENCEERROR);
		}

	}

	@Override
	public Response<Bundle> updateBundle(BundleRequest request) {
		final Bundle bundle = request.getData();
		if(mapper.insert(bundle)) {
			return new BundleResponse(bundle, STATUSERROR.OPERATIONSUCCESS);
		}else {
			return new BundleResponse(STATUSERROR.PERSISTENCEERROR);
		}
	}

	@Override
	public Response<Bundle> deleteBundleById(BundleRequest request) {
		final Bundle bundle = request.getData();
		if(mapper.deleteById(bundle.getId())) {
			return new BundleResponse(STATUSERROR.OPERATIONSUCCESS);
		}else {
			return new BundleResponse(STATUSERROR.NOROWSREMOVEDERROR);

		}
	}

}
