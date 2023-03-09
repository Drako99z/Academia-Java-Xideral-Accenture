package com.arturo.springpaciente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ENTIDAD CON METODOS AUTOGENERADOS POR LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	public Paciente(String firstName, String lastName, String email, String numSeguro) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.numSeguro = numSeguro;
	}
		
}





