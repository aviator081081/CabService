package com.project.cabService.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "car_for_driver", uniqueConstraints = @UniqueConstraint(columnNames = { "car_id", "driver_id" }))
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CarForDriver extends BaseEntity {

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.DETACH)
	@JoinColumn(name = "driver_id", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private User driver;

	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.DETACH)
	@JoinColumn(name = "car_id", nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Car car;

	@Column(name = "assigned_status", columnDefinition = "boolean default 0")
	@JsonIgnore
	private Boolean assignedStatus = false;

	public CarForDriver(User driver, Car car) {
		super();
		this.driver = driver;
		this.car = car;
	}
	
	
	
}
