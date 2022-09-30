package com.qat.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.BAC.BundleBAC;
import com.qat.crud.domain.Bundle.model.Bundle;
import com.qat.crud.domain.Bundle.model.BundleRequest;
import com.qat.crud.domain.Bundle.model.BundleResponse;

@RestController
@RequestMapping("/bundle")
public class BundleController {
	@Autowired
	private final BundleBAC bac;

	public BundleController(BundleBAC bac) {
		this.bac = bac;
	}
	
	
	  private final String FETCHALL = "/fetch-all";
	  private final String FETCHBYID = "/fetch-by-id";
	  private final String INSERT = "/insert";
	  private final String UPDATE = "/update";
	  private final String DELETE = "/delete";

	@PostMapping(FETCHALL)
	public ResponseEntity<?> listAllBundle(@RequestBody BundleRequest request) {
	    try {
	        BundleResponse response = bac.fetchAllBundles(request);
	        return response.toResponseEntity();

	      } catch (Exception exception) {
	        return new BundleResponse().withException(exception).toResponseEntity();
	      }

	}

	@PostMapping(FETCHBYID)
	public ResponseEntity<?> listByIdBundle(@RequestBody BundleRequest request) {
        try {
            BundleResponse response = bac.fetchBundleById(request);
            return response.toResponseEntity();

          } catch (Exception exception) {
            return new BundleResponse().withException(exception).toResponseEntity();
          }

	}

	@PostMapping(INSERT)
	public ResponseEntity<?> createBundle(@RequestBody BundleRequest request) {
        try {
            System.out.println("passando controlller");
            BundleResponse response = bac.insertBundle(request);
            return response.toResponseEntity();

          } catch (Exception exception) {
            return new BundleResponse().withException(exception).toResponseEntity();
          }

	}

	@PostMapping(UPDATE)
	public ResponseEntity<?> updateBundle(@RequestBody BundleRequest request) {
        try {
            BundleResponse response = bac.updateBundle(request);
            return response.toResponseEntity();

          } catch (Exception exception) {
            return new BundleResponse().withException(exception).toResponseEntity();
          }

	}

	@PostMapping(DELETE)
	public ResponseEntity<?> deleteBundle(@RequestBody BundleRequest request) {
        try {
            BundleResponse response = bac.deleteBundleById(request);
            return response.toResponseEntity();

          } catch (Exception exception) {
            return new BundleResponse().withException(exception).toResponseEntity();
          }
	}
}
