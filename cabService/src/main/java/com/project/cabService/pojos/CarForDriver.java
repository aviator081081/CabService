package com.project.cabService.pojos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "car_to_driver")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CarForDriver extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = false)
	private User driver;

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;

	@Column(name = "assigned_status", nullable = false)
	private AssignedStatus assignedStatus;
}
