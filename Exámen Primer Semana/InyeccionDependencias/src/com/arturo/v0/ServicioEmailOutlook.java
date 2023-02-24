package com.arturo.v0;

public class ServicioEmailOutlook extends ServicioEmail{
	
	private String direccionCorreo;
	
	public ServicioEmailOutlook(String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}
	
	@Override
	public void enviarCorreo() {
		System.out.println("Enviando Correo por Outlook a través de: " + direccionCorreo);
	}

	@Override
	public String toString() {
		return "Outlook (" + direccionCorreo + ")";
	}

}
