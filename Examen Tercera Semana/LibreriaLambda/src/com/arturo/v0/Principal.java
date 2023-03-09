package com.arturo.v0;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class Principal {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Sistema de Librería");
		System.out.println("¿Qué desea realizar?");
		int opc = 0;
		int exit = 9;

		// LISTA DE LIBROS
		List<Libro> libros = new ArrayList<>();
		libros.add(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, 350.0));
		libros.add(new Libro("La Iliada", "Homero", -750, 480.99));
		libros.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, 330.5));
		libros.add(new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, 120.89));
		libros.add(new Libro("Klara y el Sol", "Kazuo Ishiguro", 2021, 200.99));
		libros.add(new Libro("Percy Jackson y el Cáliz de los dioses", "Rick Riordan", 2023, 600.99));

		// Supplier PARA OBTENER EL AÑO ACTUAL
		Supplier<Integer> proveedorFecha = () -> LocalDate.now().getYear();

		while (opc != exit) {
			System.out.println("");
			System.out.println("1. Ordenar por Titulo (Comparator)");
			System.out.println("2. Ordenar por Autor (Comparator)");
			System.out.println("3. Ordenar por Año de Publicación (Comparator)");
			System.out.println("4. Ordenar por Precio (Comparator)");
			System.out.println("5. Aumentar Precio (Function, Consumer)");
			System.out.println("6. Filtrar libros por año (Predicate, Consumer)");
			System.out.println("7. Aplicar 10% de descuento (UnaryOperator)");
			System.out.println("8. Remover libros viejos (Predicate)");
			System.out.println(exit + ". Salir");
			opc = scan.nextInt();

			if (opc < 5)
				ordenar(opc, libros);
			else if (opc == 5)
				aumentarPrecio(libros);
			else if (opc == 6)
				filtrar(libros);
			else if (opc == 7)
				aplicarDescuento(libros);
			else if (opc == 8)
				removerLibrosViejos(libros, proveedorFecha);

			if (opc != 6 && opc != exit)
				//MOSTRANDO LOS REGISTROS DE LA LISTA LIBROS CON FOREACH Y UN Consumer
				libros.forEach(lib -> System.out.println(lib));
		}

	}

	private static void removerLibrosViejos(List<Libro> libros, Supplier<Integer> proveedorFecha) {
		// Predicate PARA REMOVER LOS LIBROS DE LA LISTA QUE SEAN MENOR AL AÑO PASADO
		// POR PARÁMETRO
		libros.removeIf(lib -> lib.getAnioPublicacion() < proveedorFecha.get());
	}

	private static void aplicarDescuento(List<Libro> libros) {
		// UnaryOperator PARA APLICAR UN DESCUENTO AL PRECIO DE LOS LIBROS
		libros.replaceAll(lib -> {
			lib.setPrecio(lib.getPrecio() * 0.9);
			return lib;
		});
	}

	private static void filtrar(List<Libro> libros) {
		System.out.println("Introduzca el año desde el que desea filtrar");
		int year = scan.nextInt();

		// Predicate PARA FILTRAR LOS LIBROS PUBLICADOS EN UN AÑO MAYOR AL INGRESADO
		Predicate<Libro> filtrar = lib -> lib.getAnioPublicacion() > year;
		libros.forEach(lib -> {
			if (filtrar.test(lib))
				System.out.println(lib);
		});
	}

	private static void aumentarPrecio(List<Libro> libros) {
		System.out.println("Introduzca el monto que desea sumar");
		double incremento = scan.nextDouble();

		// Function PARA AUMENTAR EL PRECIO DE UN LIBRO RECIBIENDO EL LIBRO Y
		// DEVOLVIENDO EL NUEVO PRECIO
		Function<Libro, Double> descuento = lib -> lib.getPrecio() + incremento;
		// APLICANDO Function DEFINIDA MEDIANTE FOREACH
		libros.forEach(lib -> lib.setPrecio(descuento.apply(lib)));
	}

	private static void ordenar(int opc, List<Libro> libros) {
		// Comparator DEFINIDO EN FUNCIÓN DE LA OPCION DEL USUARIO PARA ORDENAR LA LISTA
		// DE LIBROS
		Comparator<Libro> ordenar;
		switch (opc) {
		case 1:
			ordenar = (lib1, lib2) -> lib1.getTitulo().compareTo(lib2.getTitulo());
			break;
		case 2:
			ordenar = (lib1, lib2) -> lib1.getAutor().compareTo(lib2.getAutor());
			break;
		case 3:
			ordenar = (lib1, lib2) -> lib1.getAnioPublicacion() - lib2.getAnioPublicacion();
			break;
		case 4:
			ordenar = (lib1, lib2) -> (int) (lib1.getPrecio() - lib2.getPrecio());
			break;
		default:
			ordenar = (lib1, lib2) -> lib1.getTitulo().compareTo(lib2.getTitulo());
		}

		Collections.sort(libros, ordenar);
	}

}
