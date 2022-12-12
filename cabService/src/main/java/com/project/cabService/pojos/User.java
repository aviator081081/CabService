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

	@Column(name = "password", nullable = false, unique = true)
	private String password;

	@Column(name = "role", nullable = false, unique = true)
	private Role role;

}
