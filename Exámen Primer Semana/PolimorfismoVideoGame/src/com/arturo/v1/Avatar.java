package com.arturo.v1;

public abstract class Avatar {		//CLASE PADRE Avatar
	
	//ATRIBUTOS PRIVADOS DE LAS INSTANCIAS DE LA CLASE Avatar
	private String nombre;
	private int posX;
	private int posY;
	
	//CONSTRUCTOR HEREDADO A LAS CLASES HIJAS
	public Avatar(String nombre, int posX, int posY) {
		this.nombre = nombre;
		this.posX = posX;
		this.posY = posY;
	}
	
	//DECLARACION DE LOS METODOS A SOBREESCRIBIR EN LAS CLASES HIJAS
	abstract void moverPlayer();
	
	abstract void atacar();
	
	abstract void defenderse();

	//SOBREESCRITURA DEL METODO toString AUTOADAPTABLE PARA LAS CLASES HIJAS
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [nombre=" + nombre + ", posX=" + posX + ", posY=" + posY + "]";
	}
	
	//ENCAPSULACION DE LOS ATRIBUTOS
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

	public String getNombre() {
		return nombre;
	}
	
	
	
}
