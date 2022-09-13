package com.qat.crud.domain.Bundle.BAC;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.BAR.BundleBAR;
import com.qat.crud.domain.Bundle.BAR.BundleBuilder;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.Status;

@ExtendWith(MockitoExtension.class)
public class BundleBACTest {

	@Mock
	BundleBAR bar;
	@Mock
	BundleBACImpl bac;

	@Test
	public void testFetchBundleById() {
		
	    final Bundle bundleExpected = 
	    		BundleBuilder.builder().
	    		id(1).
	    		namePackage("brush teeth").
	    		zipCodeOrigin("72820200").
	    		zipCodeDestin("72820201").
	    		description("used to clean teeth").
	    		status(Status.confirmed).
	    		build();

	    final Response<Bundle> responseExpected = Response.of(bundleExpected, HttpStatus.OK);
	    System.out.println("asdasdasd abaixo");
	    System.out.println(responseExpected.toString());
	    when(bar.fetchBundleById(anyInt())).thenReturn(responseExpected);
	    Response<Bundle> bundleResponse = bac.fetchBundleById(1);
	   assertEquals(responseExpected, bundleResponse);

	}
	
	

}
