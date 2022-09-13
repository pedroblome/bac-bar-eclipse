package com.qat.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qat.crud.domain.Bundle.Response;
import com.qat.crud.domain.Bundle.BAC.BundleBAC;
import com.qat.crud.domain.Bundle.model.Bundle;

@RestController
@RequestMapping("/bundle")
public class BundleController {
	@Autowired
	private final BundleBAC bac;

	public BundleController(BundleBAC bac) {
		this.bac = bac;
	}
	

	@GetMapping("/fetch-all")
	public ResponseEntity<?> listAllBundle() {
	    try{
	        Response<Bundle> response = bac.fetchAllBundles();
	        return response.toResponseEntity();

	      }catch (Exception e){
		        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		        return  response.toResponseEntity();
	      }
	}
	@GetMapping("/fetch-byId/{id}")
	public ResponseEntity<?> listByIdBundle(@PathVariable Integer id) {
	    try{
	        Response<Bundle> response = bac.fetchBundleById(id);
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }

	}

	@PostMapping("/create")
	public ResponseEntity<?> createBundle(@RequestBody Bundle bundleData) {
	    try{
	        Response<Bundle> response = bac.insertBundle(bundleData);
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBundle(@RequestBody Bundle bundleData) {
	    try{
	        Response<Bundle> response = bac.updateBundle(bundleData);
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }


	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBundle(@PathVariable Integer id) {
	    try{
	        Response<Bundle> response = bac.deleteBundleById(id);
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }

	
	}
}
