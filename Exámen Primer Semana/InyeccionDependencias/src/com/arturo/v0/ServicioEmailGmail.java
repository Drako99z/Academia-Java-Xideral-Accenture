package com.arturo.v0;

public class ServicioEmailGmail extends ServicioEmail{//EXTENDER DE LA CLASE ServicioEmail
	
	//ATRIBUTO PRIVADO DE LA CLASE CON LA DIRECCION DE CORREO ELECTRONICO
	private String direccionCorreo;
	
	//CONSTRUCTOR DE LA CLASE
	public ServicioEmailGmail(String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}
	
	//METODO HEREDADO Y OBLIGATORIO CON SOBREESCRITURA POR LA CLASE abtract ServicioEmail
	@Override
	public void enviarCorreo() {
		System.out.println("Enviando Correo por Gmail a través de: " + direccionCorreo);
	}

	@Override
	public String toString() {
		return "Gmail (" + direccionCorreo + ")";
	}
}
