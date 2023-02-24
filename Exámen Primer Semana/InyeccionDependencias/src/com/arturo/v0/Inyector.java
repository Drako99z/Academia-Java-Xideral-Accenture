package com.arturo.v0;

public class Inyector {
	//INSTANCIAS static DE LOS SERVICIO DE EMAIL DISPONIBLES
	static ServicioEmail so = new ServicioEmailOutlook("test.aplicacion@outlook.com");
	static ServicioEmail sg = new ServicioEmailGmail("test.aplicacion@gmail.com");
	static ServicioEmail sy = new ServicioEmailYahoo("test.aplicacion@yahoo.com");
	static ServicioEmail sc = new ServicioEmailICloud("test.aplicacion@icloud.com");
	
	//METODO QUE DEVUELVE UNA APLICACION CREADA CON SU SERVICIO DE EMAIL INYECTADO
	static Aplicacion getAplicacion(String nombre, TipoServicio tipo) {	
		switch(tipo) {
		case OUTLOOK:
			return new Aplicacion(nombre, so);
		case GMAIL:
			return new Aplicacion(nombre, sg);
		case YAHOO:
			return new Aplicacion(nombre, sy);
		default:
			return new Aplicacion(nombre, sc);
		}
	}
	
	//METODOS QUE INYECTAN INDIVIDUALMENTE LAS INSTANCIAS DE SERVICIO DE EMAIL PARA LA APLICACION RECIBIDA
	static void inyectarOutlook(Aplicacion a) {
		a.setServEmail(so);
	}
	
	static void inyectarGmail(Aplicacion a) {
		a.setServEmail(sg);
	}
	
	static void inyectarYahoo(Aplicacion a) {
		a.setServEmail(sy);
	}
	
	static void inyectarICloud(Aplicacion a) {
		a.setServEmail(sc);
		System.out.println(a);
	}
}
