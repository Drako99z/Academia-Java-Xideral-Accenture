package com.arturo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// ENTIDAD CON METODOS AUTOGENERADOS POR LOMBOK
@Data
@Entity
@Table(name="paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String firstName;
	
	@Column(name="apellido")
	private String lastName;
	
	@Column(name="correo")
	private String email;
	
	@Column(name="num_seguro")
	private String numSeguro;
		
}





