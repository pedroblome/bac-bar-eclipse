package com.qat.crud.domain.Bundle.BAR;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.model.Bundle;

public interface BundleBAR {
	
	  public Response<Bundle> fetchAllBundles();

	  public Response<Bundle> fetchBundleById(Integer id);

	  public Response<Bundle>  insertBundle(Bundle bundle);

	  public Response<Bundle> updateBundle(Bundle bundle);

	  public Response<Bundle> deleteBundleById(Integer id);
}
 