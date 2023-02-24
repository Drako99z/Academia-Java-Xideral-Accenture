package com.arturo.v2;

public interface Avatar {		//CLASE PADRE Avatar
	
	//SIN ATRIBUTOS
	
	//SIN CONSTRUCTOR
	
	//DECLARACION DE LOS METODOS A SOBREESCRIBIR EN LAS CLASES QUE IMPLEMENTEN
	void moverPlayer();
	
	void atacar();
	
	void defenderse();
	
	String getNombre();
	
}
