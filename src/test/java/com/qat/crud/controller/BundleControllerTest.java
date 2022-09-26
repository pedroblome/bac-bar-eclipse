package com.qat.crud.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.qat.crud.domain.Bundle.STATUSERROR;
import com.qat.crud.domain.Bundle.BAC.BundleBAC;
import com.qat.crud.domain.Bundle.BAR.BundleBuilder;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;
import com.qat.crud.domain.Bundle.model.Status;

@RunWith(SpringRunner.class)
@WebMvcTest(BundleController.class)
class BundleControllerTest extends BaseTest {
	
	@MockBean
	private BundleBAC bac;
	
	
	  private final String FETCHALL = "/bundle/fetch-all";
	  private final String FETCHBYID = "/bundle/fetch-by-id";
	  private final String INSERT = "/bundle/insert";
	  private final String UPDATE = "/bundle/update";
	  private final String DELETE = "/bundle/delete";
	  

	  @Test
	  public void listAllBundle() throws Exception {

	    BundleRequest givenRequest = new BundleRequest();
	    final BundleResponse responseExpected = new BundleResponse()
	        .withData(givenEmployees())
	        .withStatus(STATUS.OPERATIONSUCCESS);

	    when(BAC.fetchAllEmployees(givenRequest)).thenReturn(responseExpected);

	    final RequestBuilder request = createRequest(FETCHALL, givenRequest);
	    final MvcResult response = performRequest(request);

	    assertJsonEquals(response, responseExpected);
	  }
	  



}
