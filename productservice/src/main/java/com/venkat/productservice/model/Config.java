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
public class Config {

	@NonNull
	private String version;
	
	@NonNull
	private String permission;
	
	@NonNull
	private String configStatus;
}
