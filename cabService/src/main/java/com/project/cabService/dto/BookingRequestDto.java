package com.project.cabService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDto {
	private String customerEmail;
	private Integer carForDriverId;
}
