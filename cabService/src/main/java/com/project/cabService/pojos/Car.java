package com.project.cabService.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "car")
@Embeddable
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity{

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@Column(name = "number_plate", nullable = false, unique = true)
	private String numberPlate;

	@Column(name = "capacity", nullable = false)
	private Short capacity;
}
