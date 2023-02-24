package com.arturo.v0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		//LISTA DE APLICACIONES
		List<Aplicacion> aplicaciones = new ArrayList<>();
		//VARIABLE DE REFERENCIA AUXILIAR DE TIPO Aplicacion
		Aplicacion app;
		
		//VARIABLE DE ELECCION DEL USUARIO
		int eleccion = 0;
		String data;
		
		//PRESENTACION DE LA APLICACION
		System.out.println("Bienvenido a al sistema administrador de email de Aplicaciones");
		System.out.println("¿Qué acción desea ejecutar?");
		
		//MIENTRAS LA ELECCION SEA DIFERENTE DE 6 CONTINUARÁ MOSTRANDO EL MENÚ
		while(eleccion != 6) {
			System.out.println("\n");
			System.out.println("1. Crear nueva App");
			System.out.println("2. Cambiar el servicio a una App");
			System.out.println("3. Enviar correos de una App");
			System.out.println("4. Mostrar todas las Apps");
			System.out.println("5. Enviar correos de todas las Apps");
			System.out.println("6. Salir");
			
			//LECTURA DE LA OPCIÓN
			eleccion = sc.nextInt();
			sc.nextLine();
			
			switch(eleccion) {
			case 1:
				System.out.println("Inserte el Nombre");
				data = sc.nextLine();
				//CREACIÓN DE UNA NUEVA APLICACION A TRAVÉS DEL Inyector
				aplicaciones.add(Inyector.getAplicacion(data, getTipoServicioEmail()));
				break;
			case 2:
				//EDICIÓN DE UNA Aplicacion GUARDADA EN LA LISTA
				System.out.println("Inserte el Índice de la Aplicacion");
				app = getAppFromIndex(sc.nextInt(), aplicaciones);
				if(app != null) {
					changeTipoServicioEmail(app);
				}
				break;
			case 3:
				//EJECUCION DEL METODO DE UNA INSTANCIA EN LA LISTA
				System.out.println("Inserte el Índice de la Aplicacion");
				app = getAppFromIndex(sc.nextInt(), aplicaciones);
				if(app != null) {
					app.enviarEmail();
				}
				break;
			case 4:
				//MOSTRAR TODAS LAS APLICACIONES EN LA LISTA
				for(Aplicacion a: aplicaciones)
					System.out.println(a);
				break;
			case 5:
				//EJECUCION DEL METODO DE CADA INSTANCIA EN LA LISTA
				for(Aplicacion a: aplicaciones)
					a.enviarEmail();
				break;
			}
		}

	}
	
	//METODO PARA OBTENER EL TIPO DE SERVICIO QUE EL USUARIO ELIGIÓ
	private static TipoServicio getTipoServicioEmail() {
		System.out.println("Inserte el Tipo de Servicio de Email");
		System.out.println("1. Outlook (default)");
		System.out.println("2. Gmail");
		System.out.println("3. Yahoo!");
		System.out.println("4. iCloud");
		int tipo = sc.nextInt();
		System.out.println(tipo);
		switch(tipo) {
		case 1:
			return TipoServicio.OUTLOOK;
		case 2:
			return TipoServicio.GMAIL;
		case 3:
			return TipoServicio.YAHOO;
		case 4:
			return TipoServicio.ICLOUD;
		default:
			return TipoServicio.OUTLOOK;
		}
	}

	//METODO PARA OBTENER UNA INSTANCIA ESPECÍFICA QUE EL USUARIO ELIGIÓ SIN SALIR DE LOS LIMITES DE LA LISTA
	private static Aplicacion getAppFromIndex(int index, List<Aplicacion> aplicaciones) {
		if(index < aplicaciones.size() && index >= 0) {
			return aplicaciones.get(index);
		}else {
			return null;
		}
	}
	
	//METODO PARA CAMBIAR EL TIPO DE SERVICIO DE CORREO A TRAVÉS DEL INYECTOR
	private static void changeTipoServicioEmail(Aplicacion app) {
		switch(getTipoServicioEmail()) {
		case OUTLOOK:
			Inyector.inyectarOutlook(app);
			break;
		case GMAIL:
			Inyector.inyectarGmail(app);
			break;
		case YAHOO:
			Inyector.inyectarYahoo(app);
			break;
		case ICLOUD:
			Inyector.inyectarICloud(app);
			break;
		default:
			Inyector.inyectarOutlook(app);
		}
	}
}
