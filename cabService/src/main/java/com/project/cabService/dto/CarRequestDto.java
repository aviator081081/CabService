package com.project.cabService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDto {
	private String driverEmail;
	private String numberPlate;
}
