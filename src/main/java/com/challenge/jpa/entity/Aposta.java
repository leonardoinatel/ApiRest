package com.challenge.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aposta {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Usuario usuario;

	@NotNull
	private String apostaRandom;
}
