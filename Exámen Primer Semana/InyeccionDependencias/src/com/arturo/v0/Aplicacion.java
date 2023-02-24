package com.arturo.v0;

public class Aplicacion {//CLASE Aplicacion
	
	//LA CLASE Aplicacion TIENE (HAS A) 2 ATRIBUTOS -> UN String Y UNA REFERENCIA A ServicioEmail
	private String nombre;
	private ServicioEmail servEmail;
	
	//CONTRUCTOR DE LA CLASE CON SUS ATRIBUTOS PARA INICIALIZAR
	public Aplicacion(String nombre, ServicioEmail servEmail) {
		this.nombre = nombre;
		this.servEmail = servEmail; 
	}
	
	//METODO PARA ENVIAR EMAILS POR SU ATRIBUTO servEmail
	void enviarEmail() {
		System.out.println("Aplicación: " + nombre);
		servEmail.enviarCorreo();
	}

	//METODOS DE ENCAPSULACION DE LA CLASE
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ServicioEmail getServEmail() {
		return servEmail;
	}

	public void setServEmail(ServicioEmail servEmail) {
		this.servEmail = servEmail;
	}

	@Override
	public String toString() {
		return "Aplicacion [nombre=" + nombre + ", servEmail=" + servEmail + "]";
	}
	
}
