package com.arturo.springclient.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Becario {

	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private String correo;
	
	private BigDecimal monto;
	
}





