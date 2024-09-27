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
public class StudentDTO {

	private Integer id;

	private String age;

	private String name;
	
	private String standardId;
	
	private String standardName;
	
	private AddressDTO addressDTO;

}