package com.qat.crud.domain.Bundle.BAR;

import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;

public interface BundleBAR {
	
	  public BundleResponse fetchAllBundles(BundleRequest request);

	  public BundleResponse fetchBundleById(BundleRequest request);

	  public BundleResponse  insertBundle(BundleRequest request);

	  public BundleResponse updateBundle(BundleRequest request);

	  public BundleResponse deleteBundleById(BundleRequest request);
}
 