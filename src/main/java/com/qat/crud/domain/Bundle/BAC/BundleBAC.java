package com.qat.crud.domain.Bundle.BAC;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;

public interface BundleBAC {

	  public Response<Bundle> fetchAllBundles(BundleRequest request);

	  public Response<Bundle> fetchBundleById( BundleRequest request);

	  public Response<Bundle>  insertBundle(BundleRequest request );

	  public Response<Bundle> updateBundle( BundleRequest request);

	  public Response<Bundle> deleteBundleById(BundleRequest request);
	

}
