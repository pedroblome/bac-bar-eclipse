package com.qat.crud.domain.Bundle.BAR;

import java.util.List;

import com.qat.crud.domain.Bundle.model.Bundle;

public interface BundleBAR {
	
	  public List<Bundle> fetchAllBundles();

	  public Bundle fetchBundleById(Integer id);

	  public boolean insertBundle(Bundle bundle);

	  public boolean updateBundle(Bundle bundle);

	  public boolean deleteBundle(Integer id);
}
