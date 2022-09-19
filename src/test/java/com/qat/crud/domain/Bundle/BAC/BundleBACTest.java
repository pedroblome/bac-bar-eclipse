package com.qat.crud.domain.Bundle.BAC;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.ValidationError;
import com.qat.crud.domain.Bundle.BAR.BundleBAR;
import com.qat.crud.domain.Bundle.BAR.BundleBuilder;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;
import com.qat.crud.domain.Bundle.model.Status;

@ExtendWith(MockitoExtension.class)
public class BundleBACTest {

	@Mock
	BundleBAR bar;
	@InjectMocks
	BundleBACImpl bac;

	private Bundle givenBundle() {
		return givenBundle(1);
	}

	private Bundle givenBundle(Integer id) {
		return BundleBuilder.builder().id(id).namePackage("monitor").zipCodeOrigin("72820200").zipCodeDestin("72820201")
				.description("used in computer").status(Status.confirmed).build();
	}
	

	 private List<Bundle> givenBundles() {
	    return List.of(
	    		givenBundle(1), givenBundle(2)
	    );
	  }

	@Test
	public void testFetchAllBundles() {

		final List<Bundle> givenBundles = givenBundles();

		final Response<Bundle> responseExpected = new BundleResponse(givenBundles, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest();

		when(bar.fetchAllBundles(request)).thenReturn(responseExpected);
		Response<Bundle> bundlesResponse = bac.fetchAllBundles(request);
		assertEquals(responseExpected, bundlesResponse);

	}

	@Test
	public void testFetchBundleById() {

		final Bundle givenBundle = givenBundle(1);

		final Response<Bundle> responseExpected = new BundleResponse(givenBundle, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(1);

		when(bar.fetchBundleById(request)).thenReturn(responseExpected);
		Response<Bundle> bundleResponse = bac.fetchBundleById(request);
		assertEquals(responseExpected, bundleResponse);

	}

	@Test
	public void testInsertBundle() {

		final Bundle givenBundle = givenBundle();

		final Response<Bundle> responseExpected = new BundleResponse(givenBundle, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(givenBundle);
		
		when(bar.insertBundle(request)).thenReturn(responseExpected);
		Response<Bundle> bundleResponse = bac.insertBundle(request);
		assertEquals(responseExpected, bundleResponse);

	}

	@Test
	public void testUpdateBundle() {

		final Bundle givenBundle = givenBundle();

		final Response<Bundle> responseExpected = new BundleResponse(givenBundle, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(givenBundle);
		

		when(bar.updateBundle(request)).thenReturn(responseExpected);
		Response<Bundle> bundleResponse = bac.updateBundle(request);
		assertEquals(responseExpected.getData(), bundleResponse.getData());

	}
	@Test
	public void testDeleteBundleById() {
		
		final Bundle givenBundle = givenBundle();

		final Response<Bundle> responseExpected = new BundleResponse(STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(givenBundle);
		when(bar.deleteBundleById(request)).thenReturn(responseExpected);
		Response<Bundle> bundleResponse = bac.deleteBundleById(request);

		assertEquals(responseExpected.getData(), bundleResponse.getData());

	}
	 @Test
	  public void testUpdateBundleWithInvalidData() {
	    final Bundle givenBundle = givenBundle();
	    final BundleResponse responseExpected = new BundleResponse(STATUSERROR.VALIDATIONERROR,
	        List.of());
	    BundleRequest request = new BundleRequest(givenBundle);
	    when(bar.updateBundle(request)).thenReturn(responseExpected);

	    Response<Bundle> bundleResponse = bac.updateBundle(request);
	    assertEquals(responseExpected, bundleResponse);
	  }

	  @Test
	  public void testInsertWithInvalidData() {
		    final Bundle givenBundle = givenBundle();
		    final BundleResponse responseExpected = new BundleResponse(STATUSERROR.VALIDATIONERROR,
		        List.of());
		    BundleRequest request = new BundleRequest(givenBundle);
		    when(bar.updateBundle(request)).thenReturn(responseExpected);

		    Response<Bundle> bundleResponse = bac.updateBundle(request);
		    assertEquals(responseExpected, bundleResponse);
	  }

	  @Test
	  public void testValidations() {
	    final Bundle giveBundle = new Bundle();
	    giveBundle.setNamePackage(null);
	    givenBundle().setZipCodeOrigin("728202001");
	    givenBundle().setZipCodeDestin("728202001");
	    givenBundle().setStatus(Status.unknow);


	    final BundleResponse responseExpected = new BundleResponse(STATUSERROR.VALIDATIONERROR, List.of(
				ValidationError.of("namePackage", "namePackage is required"),
				ValidationError.of("zipCodeOrigin", "zipCodeOrigin must be equal to  8 characters"),
				ValidationError.of("zipCodeDestin", "zipCodeDestin must be equal to  8 characters"),
				ValidationError.of("status", "must be  confirmed, analisys, waiting_payment or route!")));
	    BundleRequest request = new BundleRequest(giveBundle);

	    Response<Bundle> bundleResponse = bac.insertBundle(request);
	    assertEquals(responseExpected.getStatus(), bundleResponse.getStatus());
	    assertEquals(responseExpected.getData(), bundleResponse.getData());
	  }

}
