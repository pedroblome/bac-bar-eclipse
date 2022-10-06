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
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleBuilder;
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
	  
	  

	  private Bundle givenBundle() {
	    return givenBundle(1);
	  }

	  private Bundle givenBundle(Integer id) {
	    return BundleBuilder
	        .builder()
	        .id(id).namePackage("Mateus").zipCodeOrigin("example@gmail.com").zipCodeDestin("abc").description("123456").status(Status.analisys)
	        .build();
	  }

	  private List<Bundle> givenBundles() {
	    return List.of(
	        givenBundle(1), givenBundle(2)
	    );
	  }
	  

	  @Test
	  public void listAllBundleTest() throws Exception {

	    BundleRequest request = new BundleRequest();
	    final BundleResponse responseExpected = new BundleResponse()
	        .withData(givenBundle())
	        .withStatus(STATUSERROR.OPERATIONSUCCESS);

	    when(bac.fetchAllBundles(request)).thenReturn(responseExpected);

	    final RequestBuilder requestController = createRequest(FETCHALL, request);
	    final MvcResult response = performRequestAndReturn(requestController);

	    assertJsonEquals(response, responseExpected);
	  }
	  
	  

      @Test
      public void listByIdBundle() throws Exception {

        BundleRequest request = new BundleRequest();
        final BundleResponse responseExpected = new BundleResponse()
            .withData(givenBundle())
            .withStatus(STATUSERROR.OPERATIONSUCCESS);

        when(bac.fetchBundleById(request)).thenReturn(responseExpected);

        final RequestBuilder requestController = createRequest(FETCHBYID, request);
        final MvcResult response = performRequestAndReturn(requestController);

        assertJsonEquals(response, responseExpected);
      }
      
      @Test
      public void createBundle() throws Exception {

        BundleRequest request = new BundleRequest();
        final BundleResponse responseExpected = new BundleResponse()
            .withData(givenBundle())
            .withStatus(STATUSERROR.OPERATIONSUCCESS);

        when(bac.insertBundle(request)).thenReturn(responseExpected);

        final RequestBuilder requestController = createRequest(INSERT, request);
        final MvcResult response = performRequestAndReturn(requestController);

        assertJsonEquals(response, responseExpected);
      }
      
      
      @Test
      public void updateBundle() throws Exception {

        BundleRequest request = new BundleRequest();
        final BundleResponse responseExpected = new BundleResponse()
            .withData(givenBundle())
            .withStatus(STATUSERROR.OPERATIONSUCCESS);

        when(bac.updateBundle(request)).thenReturn(responseExpected);

        final RequestBuilder requestController = createRequest(UPDATE, request);
        final MvcResult response = performRequestAndReturn(requestController);

        assertJsonEquals(response, responseExpected);
      }
	  
      
      
      @Test
      public void deleteBundle() throws Exception {

        BundleRequest request = new BundleRequest();
        final BundleResponse responseExpected = new BundleResponse()
            .withData(givenBundle())
            .withStatus(STATUSERROR.OPERATIONSUCCESS);

        when(bac.deleteBundleById(request)).thenReturn(responseExpected);

        final RequestBuilder requestController = createRequest(DELETE, request);
        final MvcResult response = performRequestAndReturn(requestController);

        assertJsonEquals(response, responseExpected);
      }

	  



}
