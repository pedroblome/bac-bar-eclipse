package com.qat.crud.domain.Bundle.BAC;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.model.Bundle;

public interface BundleBAC {

	  public Response<Bundle> fetchAllBundles();

	  public Response<Bundle> fetchBundleById(Integer id);

	  public Response<Bundle>  insertBundle(Bundle bundle);

	  public Response<Bundle> updateBundle(Bundle bundle);

	  public Response<Bundle> deleteBundleById(Integer id);
	

}
