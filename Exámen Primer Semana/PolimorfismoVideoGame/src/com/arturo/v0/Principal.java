package com.arturo.v0;

import java.util.Scanner;

public class Principal {//IMPLEMENTACION DE POLIMORFISMO CON CLASES SIMPLES
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//VARIABLE DE REFERENCIA Avatar
		Avatar avatar;
		
		int eleccion = 0;	//ENETERO PRIMITIVO PARA LA ELECCION DEL USUARIO

		//PETICION DE INFORMACION AL USUARIO HASTA AHORA DESCONOCIDA
		System.out.println("--¡Bienvenido a la Edad Media!--\n¿Cuál es tu nombre?");
		String nombre = sc.nextLine();
		System.out.println("Hora de escoger a tu Avatar " + nombre);

		//MIENTRAS LA ELECCIÓN NO SE ENCUENTRE ENTRE LAS OPCIONES PERMITIDAS REPETIRÁ LAS INSTRUCCIONES
		while (eleccion < 1 | eleccion > 4) {
			System.out.println("1. Caballero");
			System.out.println("2. Mago");
			System.out.println("3. Arquero");
			System.out.println("4. Monstruo");

			eleccion = sc.nextInt();
		}

		//OBTENER EL AVATAR EN BASE A LA DECISIÓN QUE TOMO EL USUARIO
		avatar = getAvatar(eleccion, nombre);
		//ARRANCAR LA PARTIDA
		iniciarPartida(avatar);

	}

	private static Avatar getAvatar(int eleccion, String nombre) {
		//INSTANCIA DEL AVATAR, NO DISPONIBLE CON CLASES ABTRACTAS NI CON INTERFACES
		Avatar avatar = new Avatar("", 0, 0);
		switch (eleccion) {
		case 1:
			//INSTANCIA DE UN Caballero ASIGNADO A LA VARIABLE DE REFERENCIA avatar
			avatar = new Caballero(nombre, 5, 5);
			break;
		case 2:
			//INSTANCIA DE UN Mago ASIGNADO A LA VARIABLE DE REFERENCIA avatar
			avatar = new Mago(nombre, 4, 4);
			break;
		case 3:
			//INSTANCIA DE UN Arquero ASIGNADO A LA VARIABLE DE REFERENCIA avatar
			avatar = new Arquero(nombre, 3, 3);
			break;
		case 4:
			//INSTANCIA DE UN Monstruo ASIGNADO A LA VARIABLE DE REFERENCIA avatar
			avatar = new Monstruo(nombre, 2, 2);
			break;
		default:
		}
		return avatar;
	}
	
	private static void iniciarPartida(Avatar avatar) {
		//INICIO DE LA PARTIDA
		System.out.println("Empezemos a jugar " + avatar.getNombre());
		System.out.println("Que deseas hacer con tu " + avatar.getClass().getSimpleName());
		int eleccion = 0;

		//MIENTRAS LA ELECCION SEA DIFERENTE DE 5, EL PROGRAMA CONTINUARÁ
		while (eleccion != 5) {
			System.out.println("\n");
			System.out.println("1. Moverse");
			System.out.println("2. Atacar");
			System.out.println("3. Defenderse");
			System.out.println("4. Ver mi avatar");
			System.out.println("5. Salir");

			//LECTURA DE LA DECISION DEL USUARIO
			eleccion = sc.nextInt();

			//COMPROBACION DE LA ACCION A REALIZAR
			switch (eleccion) {
			case 1:
				//METODO moverPlayer() DEFINIDO EN LA CLASE AVATAR SOBREESCRITO EN LAS CLASES HIJAS
				avatar.moverPlayer();
				break;
			case 2:
				//METODO atacar() DEFINIDO EN LA CLASE AVATAR SOBREESCRITO EN LAS CLASES HIJAS
				avatar.atacar();
				break;
			case 3:
				//METODO defenderse() DEFINIDO EN LA CLASE AVATAR SOBREESCRITO EN LAS CLASES HIJAS
				avatar.defenderse();
				break;
			case 4:
				//METODO toString() DEFINIDO EN LA CLASE AVATAR HEREDADO A LAS CLASES HIJAS
				System.out.println(avatar);
				break;
			default:
				//CASO default SIN ESPECIFICAR
			}
		}
	}

}
