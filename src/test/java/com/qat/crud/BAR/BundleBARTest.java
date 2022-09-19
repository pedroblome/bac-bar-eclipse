package com.qat.crud.BAR;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.BAR.BundleBARImpl;
import com.qat.crud.domain.Bundle.BAR.BundleBuilder;
import com.qat.crud.domain.Bundle.BAR.mapper.BundleMapper;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;
import com.qat.crud.domain.Bundle.model.Status;

@ExtendWith(MockitoExtension.class)
class BundleBARTest {
	@Mock
	BundleMapper bundleMapper;

	@InjectMocks
	BundleBARImpl bar;

	private Bundle givenBundle() {
		return givenBundle(1);
	}

	private Bundle givenBundle(Integer id) {
		return BundleBuilder.builder().id(id).namePackage("monitor").zipCodeOrigin("72820200").zipCodeDestin("72820201")
				.description("used in computer").status(Status.confirmed).build();
	}

	private List<Bundle> givenBundles() {
		return List.of(givenBundle(1), givenBundle(2));
	}

	@Test
	public void testFetchAllBundles() {

		final List<Bundle> bundleExpected = givenBundles();
		final BundleResponse responseExpected = new BundleResponse(bundleExpected, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest();
		when(bundleMapper.fetchAll()).thenReturn(bundleExpected);

		Response<Bundle> bundlesResponse = bar.fetchAllBundles(request);
		Assertions.assertEquals(responseExpected, bundlesResponse);

	}

	@Test
	public void testFetchBundleById() {

		final Bundle bundleExpected = givenBundle();
		final BundleResponse responseExpected = new BundleResponse(bundleExpected, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(1);
		when(bundleMapper.fetchById(1)).thenReturn(bundleExpected);

		Response<Bundle> bundleResponse = bar.fetchBundleById(request);
		Assertions.assertEquals(responseExpected, bundleResponse);

	}

	@Test
	public void testInsertBundle() {

		final Bundle bundleExpected = givenBundle();
		final BundleResponse responseExpected = new BundleResponse(bundleExpected, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(bundleExpected);
		when(bundleMapper.insert(any(Bundle.class))).thenReturn(true);

		Response<Bundle> bundleResponse = bar.insertBundle(request);
		System.out.println(bundleExpected);
		System.out.println(bundleResponse);

		Assertions.assertEquals(responseExpected, bundleResponse);

	}

	@Test
	public void testUpdateBundleById() {

		final Bundle bundleExpected = givenBundle();
		final BundleResponse responseExpected = new BundleResponse(bundleExpected, STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(bundleExpected);
		when(bundleMapper.updatedById(bundleExpected)).thenReturn(true);

		Response<Bundle> bundleResponse = bar.updateBundle(request);

		Assertions.assertEquals(responseExpected, bundleResponse);

	}

	@Test
	public void testDeleteBundleById() {

		final Bundle bundleExpected = givenBundle();
		final BundleResponse responseExpected = new BundleResponse(STATUSERROR.OPERATIONSUCCESS);

		BundleRequest request = new BundleRequest(bundleExpected);
		when(bundleMapper.deleteById(1)).thenReturn(true);

		Response<Bundle> bundleResponse = bar.deleteBundleById(request);
		Assertions.assertEquals(responseExpected, bundleResponse);

	}

}
