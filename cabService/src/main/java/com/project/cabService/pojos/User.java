package com.project.cabService.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Embeddable
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class User extends BaseEntity {

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false, unique = false)
	private String password;

	@Column(name = "role", nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	private Role role;

}
