package com.venkat.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor 
@Getter
@Setter
public class Product {
	
	private @NonNull Integer id;
	
	private @NonNull String name;
	
	private String manufacturer;
	
	private @NonNull Integer price;
	
}
