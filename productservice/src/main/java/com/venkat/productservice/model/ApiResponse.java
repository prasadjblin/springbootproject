package com.venkat.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {

	@NonNull
	private Boolean isSuccess;
	
	@NonNull
	private String message;
	
	@NonNull
	private Integer internalCode;
	
	@NonNull
	private T response;
	
}
