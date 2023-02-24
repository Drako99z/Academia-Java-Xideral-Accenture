package com.arturo.v1;

public class Mago extends Avatar{

	public Mago(String nombre, int posX, int posY) {
		super(nombre, posX, posY);
	}
	
	@Override
	void moverPlayer() {
		setPosX(getPosX() + 4);
		setPosY(getPosY() + 4);
		System.out.println("Moviendo a la Posicion: (" + getPosX() + ", " + getPosY() + ")");
	}
	
	@Override
	void atacar() {
		System.out.println("Lanzar Hechizo al Enemigo");
	}
	
	@Override
	void defenderse() {
		System.out.println("Escudo de magia");
	}

}