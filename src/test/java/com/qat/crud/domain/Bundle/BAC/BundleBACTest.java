package com.qat.crud.domain.Bundle.BAC;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.Status;

class BundleBACTest {
	
	@Mock
	private BundleBAC bundleBAC;
	
	public static void main (String [] args) {
		
	}
	
	  @SuppressWarnings("unchecked")
	public void fetchAllBundles() {
		  MockitoAnnotations.initMocks(bundleBAC);
		  List<Bundle> bundle = getBundle();
		  when(bundleBAC.fetchAllBundles()).thenReturn((Response<Bundle>) bundle);
		  System.out.println(bundleBAC.fetchAllBundles());
		  
	  }
	  
	  private List<Bundle> getBundle() {
		  Bundle bundle = new Bundle();
		  bundle.setId(1);
		  bundle.setNamePackage("icebox");
		  bundle.setZipCodeOrigin("72820201");
		  bundle.setZipCodeDestin("72820200");
		  bundle.setDescription("used to keep low temperature");
		  bundle.setStatus(Status.waiting_payment);
		  return (List<Bundle>) bundle;
	  }
	  


	
	private List<Bundle> getBundle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
