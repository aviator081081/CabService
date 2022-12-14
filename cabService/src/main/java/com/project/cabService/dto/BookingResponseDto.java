package com.project.cabService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
	private String customerEmail;
	private String driverEmail;
	private String carName;
	private String numberPlate;
}
