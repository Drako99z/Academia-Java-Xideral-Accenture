package com.arturo.v2;

public class Monstruo implements Avatar {
	
	private String nombre;
	private int posX;
	private int posY;

	public Monstruo(String nombre, int posX, int posY) {
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
	}

	@Override
	public void moverPlayer() {
		setPosX(getPosX() + 2);
		setPosY(getPosY() + 2);
		System.out.println("Moviendo a la Posicion: (" + getPosX() + ", " + getPosY() + ")");
	}

	@Override
	public void atacar() {
		System.out.println("Atacar con garras");
	}

	@Override
	public void defenderse() {
		System.out.println("Subir la guardia");
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	// SOBREESCRITURA DEL METODO toString() YA NO DISPONIBLE EN LA INTERFACE
	@Override
	public String toString() {
		return "Monstruo [nombre=" + nombre + ", posX=" + posX + ", posY=" + posY + "]";
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
