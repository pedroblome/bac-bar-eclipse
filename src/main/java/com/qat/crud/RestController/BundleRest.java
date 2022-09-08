package com.qat.crud.RestController;

import java.util.List;

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
public class BundleRest {

	private final BundleBAC bundleBAC;

	public BundleRest(BundleBAC bundleBAC) {
		this.bundleBAC = bundleBAC;
	}
	
	

	@GetMapping("/fetch-all")
	public ResponseEntity<?> listAllBundle() {
	    try{
	        Response<Bundle> response = bundleBAC.fetchAllBundles();
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }
	}
	@GetMapping("/fetch-byId/{id}")
	public ResponseEntity<?> listByIdBundle(@PathVariable Integer id) {
	    try{
	        Response<Bundle> response = bundleBAC.fetchBundleById(id);
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }

	}

	@PostMapping("/create")
	public ResponseEntity<?> createBundle(@RequestBody Bundle bundleData) {
	    try{
	        Response<Bundle> response = bundleBAC.insertBundle(bundleData);
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }

	}

	@PutMapping("/update")
	public ResponseEntity<?> updateBundle(@RequestBody Bundle bundleData) {
	    try{
	        Response<Bundle> response = bundleBAC.updateBundle(bundleData);
	        return response.toResponseEntity();

	      }catch (Exception e){
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return  response.toResponseEntity();
	      }


	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBundle(@PathVariable Integer id) {

	    try {
	        boolean transactionStatus = bundleBAC.deleteBundleById(id);

	        if (transactionStatus == true)
	          return  Response.of("Bundle deleted ", HttpStatus.OK).toResponseEntity();
	        else
	          return  Response.of("Bundle id not found", HttpStatus.NOT_FOUND).toResponseEntity();

	      } catch (Exception e) {
	        Response<String> response = Response.of(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        return response.toResponseEntity();
	      }

	
	}
}
