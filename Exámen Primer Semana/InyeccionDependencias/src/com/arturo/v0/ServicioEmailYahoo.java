package com.arturo.v0;

public class ServicioEmailYahoo extends ServicioEmail{
	
	private String direccionCorreo;
	
	public ServicioEmailYahoo(String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}
	
	@Override
	public void enviarCorreo() {
		System.out.println("Enviando Correo por Yahoo! a través de: " + direccionCorreo);
	}
	
	@Override
	public String toString() {
		return "Yahoo! (" + direccionCorreo + ")";
	}

}
