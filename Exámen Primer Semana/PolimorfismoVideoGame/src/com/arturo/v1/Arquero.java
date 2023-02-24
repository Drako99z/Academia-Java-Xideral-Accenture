package com.arturo.v1;

public class Arquero extends Avatar{	//EXTENDER DE LA CLASE Avatar

	public Arquero(String nombre, int posX, int posY) {
		//LLAMAR AL CONSTRUCTOR DE LA CLASE PADRE
		super(nombre, posX, posY);
	}
	
	//SOBREESCRIBIR LOS METODOS HEREDADOS DE LA CLASE PADRE Avatar
	@Override
	void moverPlayer() {
		setPosX(getPosX() + 3);
		setPosY(getPosY() + 3);
		System.out.println("Moviendo a la Posicion: (" + getPosX() + ", " + getPosY() + ")");
	}
	
	@Override
	void atacar() {
		System.out.println("Lanzar Flecha");
	}
	
	@Override
	void defenderse() {
		System.out.println("Cubrirse");
	}

}