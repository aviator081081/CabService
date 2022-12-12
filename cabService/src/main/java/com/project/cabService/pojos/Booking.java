package com.project.cabService.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Booking extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", nullable = false)

	private User customer;

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "car_for_driver_id", nullable = false)

	private CarForDriver car;
}
