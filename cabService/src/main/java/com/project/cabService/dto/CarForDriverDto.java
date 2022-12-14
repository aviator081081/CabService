package com.project.cabService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarForDriverDto {
	private Integer id;
	private String driverEmail;
	private String carName;
	private String numberPlate;
}
