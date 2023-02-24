package com.arturo.v0;

public class ServicioEmailICloud extends ServicioEmail{
	
	private String direccionCorreo;
	
	public ServicioEmailICloud(String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}
	
	@Override
	public void enviarCorreo() {
		System.out.println("Enviando Correo por iCloud a través de: " + direccionCorreo);
	}
	
	@Override
	public String toString() {
		return "iCloud (" + direccionCorreo + ")";
	}

}
