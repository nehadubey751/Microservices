package com.springcloudapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	private Integer id;

	private String perAddress;

	private String city;
	
	private String pinCode;

}