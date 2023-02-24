package com.arturo.v0;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//ASIGNACIÓN DE LA INSTANCIA ÚNICA DE Configuracion A LA VARIABLE DE REFERENCIA config
		Configuracion config = Configuracion.getConfiguracion();
		
		//PRESENTACION DE LA APLICACIÓN
		System.out.println("Gestor de Configuración");
		System.out.println("¿Que desea hacer con la configuración?");
		
		//ELECCION DEL USUARIO RESPECTO A QUE HACER CON LA CONFIGURACION
		int eleccion = 0;
		String data;
		
		//MIENTRAS LA ELECCION SEA DIFERENTE DE 7(SALIR) LAS INSTRUCCIONES SE REPETIRÁN
		while(eleccion != 7) {
			System.out.println("\n");
			System.out.println("1. Ver Configuración");
			System.out.println("2. Ver Configuración desde getConfiguracion()");
			System.out.println("3. Editar ruta de guardado");
			System.out.println("4. Editar tema");
			System.out.println("5. Editar mostrar miniaturas");
			System.out.println("6. Guardar Configuración");
			System.out.println("7. Salir");
			
			//LEER LA ELECCION DEL USUARIO
			eleccion = sc.nextInt();
			sc.nextLine();
			
			switch(eleccion) {
			case 1:
				System.out.println(config);//MOSTRAR EL OBJETO AL QUE APUNTA config
				break;
			case 2:
				//MOSTRAR EL OBJETO AL QUE APUNTA LA VARIABLE static DE LA CLASE CONFIGURACION
				System.out.println(Configuracion.getConfiguracion());
				break;
			case 3:
				data = sc.nextLine();
				config.setSavePath(data);//EDITAR LA RUTA DE GUARDADO
				break;
			case 4:
				data = sc.nextLine();
				config.setTheme(data);//EDITAR EL TEMA DE LA APLICACION
				break;
			case 5:
				config.setShowThumbs(sc.nextBoolean());//EDITAR SI SE DESEA MOSTRAR MINIATURAS EN LA APLICACION
				break;
			case 6:
				config.saveConfig();//METODO saveConfig() DE LA INSTANCIA DE CONFIGURACION
				break;
			default:
			}
			
		}

	}

}
