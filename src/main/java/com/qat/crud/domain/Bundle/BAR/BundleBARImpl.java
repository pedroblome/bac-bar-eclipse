package com.qat.crud.domain.Bundle.BAR;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.model.Bundle;

@Repository
public class BundleBARImpl implements BundleBAR {
	@Autowired
	private BundleMapper mapper;

	public BundleBARImpl(BundleMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Response<Bundle> fetchAllBundles() {

		return Response.of(mapper.fetchAll(), HttpStatus.OK);
	}

	@Override
	public Response<Bundle> fetchBundleById(Integer id) {
		Bundle bundle = mapper.fetchById(id);
		if (Objects.nonNull(bundle)) {
			return Response.of(bundle, HttpStatus.OK);
		} else {
			return Response.of(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Response<Bundle> insertBundle(Bundle bundle) {
		if (mapper.insert(bundle)) {
			return Response.of(bundle, HttpStatus.OK);
		} else {
			return Response.of(HttpStatus.BAD_REQUEST);
		}

	}

	@Override
	public Response<Bundle> updateBundle(Bundle bundle) {
		if(mapper.updatedById(bundle)) {
			return Response.of(bundle, HttpStatus.OK);
		}else {
		      return Response.of(HttpStatus.BAD_REQUEST);

		}	
	}

	@Override
	public Response<Bundle> deleteBundleById(Integer id) {
		if(mapper.deleteById(id)) {
			return Response.of(HttpStatus.OK);
		}
		else {
			return Response.of(HttpStatus.BAD_REQUEST);
		}
	}

}
