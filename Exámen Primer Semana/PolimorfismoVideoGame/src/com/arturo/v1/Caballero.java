package com.arturo.v1;

public class Caballero extends Avatar{

	public Caballero(String nombre, int posX, int posY) {
		super(nombre, posX, posY);
	}
	
	@Override
	void moverPlayer() {
		setPosX(getPosX() + 5);
		setPosY(getPosY() + 5);
		System.out.println("Moviendo a la Posicion: (" + getPosX() + ", " + getPosY() + ")");
	}
	
	@Override
	void atacar() {
		System.out.println("Golpear con Espada");
	}
	
	@Override
	void defenderse() {
		System.out.println("Subir el escudo");
	}

}
