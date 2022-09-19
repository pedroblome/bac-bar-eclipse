package com.qat.crud.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.BAC.BundleBAC;
import com.qat.crud.domain.Bundle.BAR.BundleBuilder;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;
import com.qat.crud.domain.Bundle.model.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(BundleController.class)
class BundleControllerTest {
	
	@MockBean
	private BundleBAC bac;
	
	
	  private final String FETCHALL = "/bundle/fetch-all";
	  private final String FETCHBYID = "/bundle/fetch-by-id";
	  private final String INSERT = "/bundle/insert";
	  private final String UPDATE = "/bundle/update";
	  private final String DELETE = "/bundle/delete";
	  

	  private Bundle givenBundle(Integer id) {
	    return BundleBuilder
	        .builder()
	        .id(id).namePackage("package").zipCodeOrigin("72820201").zipCodeDestin("72820200").description("description").status(Status.analisys)
	        .build();
	  }

	  private List<Bundle> givenBundles() {
	    return List.of(givenBundle(1), givenBundle(2));
	  }
	  

	  @Test
	  public void fetchList() throws Exception {

	    final List<Bundle> givenBundles = givenBundles();
	    BundleRequest request = new BundleRequest();
	    final BundleResponse responseExpected = new BundleResponse(givenBundles,
	        STATUSERROR.OPERATIONSUCCESS);
	    System.out.println(responseExpected);

	    when(bac.fetchAllBundles(request)).thenReturn(responseExpected);


	    assertJsonEquals(response, responseExpected);
	  }


}
