package com.arturo.v2;

public class Arquero implements Avatar { // IMPLEMENTAR LA INTERFACE Avatar

	// ATRIBUTOS YA NO DISPONIBLES EN LA INTERFACE Avatar
	private String nombre;
	private int posX;
	private int posY;

	// SIN CONSTRUCTOR EN LA INTERFACE
	public Arquero(String nombre, int posX, int posY) {
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
	}

	// SOBREESCRIBIR LOS METODOS HEREDADOS DE LA CLASE PADRE Avatar
	@Override
	public void moverPlayer() {
		setPosX(getPosX() + 3);
		setPosY(getPosY() + 3);
		System.out.println("Moviendo a la Posicion: (" + getPosX() + ", " + getPosY() + ")");
	}

	@Override
	public void atacar() {
		System.out.println("Lanzar Flecha");
	}

	@Override
	public void defenderse() {
		System.out.println("Cubrirse");
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	// SOBREESCRITURA DEL METODO toString() YA NO DISPONIBLE EN LA INTERFACE
	@Override
	public String toString() {
		return "Arquero [nombre=" + nombre + ", posX=" + posX + ", posY=" + posY + "]";
	}

	// ENCAPSULACION DE LOS ATRIBUTOS
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}