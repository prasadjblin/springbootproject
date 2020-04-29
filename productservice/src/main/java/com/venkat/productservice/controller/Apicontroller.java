package com.venkat.productservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.productservice.model.ApiResponse;
import com.venkat.productservice.model.Config;
import com.venkat.productservice.model.Product;

@RestController
@Validated
public class Apicontroller {

	@GetMapping(value = "/api/getconfigdetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getconfigdetails() {
		Config config = null;
		try {
			ApiResponse<Config> apiResponse = new ApiResponse<Config>();
			apiResponse.setIsSuccess(true);
			apiResponse.setMessage("config details api responded");
			apiResponse.setInternalCode(1);
			
			config = new Config("v1.0","granted","active");
			apiResponse.setResponse(config);
			
			return new ResponseEntity<ApiResponse<Config>>(apiResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			ApiResponse<Config> errorResponse = new ApiResponse<Config>();
			errorResponse.setIsSuccess(false);
			errorResponse.setMessage(e.getMessage());
			errorResponse.setInternalCode(2);
			errorResponse.setResponse(config);
			
			return new ResponseEntity<ApiResponse<Config>>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/api/getproductdetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getproductdetails() {
		List<Product> products = null;
		try {
			ApiResponse<List<Product>> apiResponse = new ApiResponse<List<Product>>();
			apiResponse.setIsSuccess(true);
			apiResponse.setMessage("product details api responded");
			apiResponse.setInternalCode(1);
			products = new ArrayList<Product>(Arrays.asList(
						new Product(101, "Ms Office", "Microsoft", 1500),
						new Product(102, "Norton Antivirus", "Norton", 899),
						new Product(103, "Maya 3D", "Autodesk", 5500)
					));
			apiResponse.setResponse(products);
			
			return new ResponseEntity<ApiResponse<List<Product>>>(apiResponse, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			
			ApiResponse<List<Product>> errorResponse = new ApiResponse<List<Product>>();
			errorResponse.setIsSuccess(false);
			errorResponse.setMessage(e.getMessage());
			errorResponse.setInternalCode(2);
			errorResponse.setResponse(products);
			
			return new ResponseEntity<ApiResponse<List<Product>>>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
