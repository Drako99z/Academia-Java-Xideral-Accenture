package com.arturo.v1;

public class Monstruo extends Avatar {

	public Monstruo(String nombre, int posX, int posY) {
		super(nombre, posX, posY);
	}

	@Override
	void moverPlayer() {
		setPosX(getPosX() + 2);
		setPosY(getPosY() + 2);
		System.out.println("Moviendo a la Posicion: (" + getPosX() + ", " + getPosY() + ")");
	}

	@Override
	void atacar() {
		System.out.println("Atacar con garras");
	}

	@Override
	void defenderse() {
		System.out.println("Subir la guardia");
	}

}
