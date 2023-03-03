package com.arturo.v0;

public class CalculadoraHexa extends Calculadora{
	
	public CalculadoraHexa() {
		
	}
	
	public CalculadoraHexa(Integer valor) {
		this.valor = valor;
	}

	@Override
	public String getConversion() {
		if(valor == 0)
			return "0";
		if(valor < 0)
			throw new NegativeNotSupportedException("No se permiten numeros negativos");
		StringBuilder hex = new StringBuilder();
	    while (valor > 0) {
	        int residuo = valor % 16;
	        if (residuo < 10) {
	            hex.insert(0, residuo);
	        } else {
	            hex.insert(0, (char) ('A' + residuo - 10));
	        }
	        valor = valor / 16;
	    }
	    return hex.toString();
	}

	@Override
	public Integer getValor() {
		return this.valor;
	}

	@Override
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public static int convertFromHexa(String hex) {
		int decimal = 0;
		char digito;
		int valorDigito;
		if (hex.matches("[0-9A-Fa-f]+")) {
			for (int i = 0; i < hex.length(); i++) {
				digito = hex.charAt(i);
				valorDigito = Character.isDigit(digito) ? digito - '0' : digito - 'A' + 10;
				decimal += valorDigito * Math.pow(16, hex.length() - i - 1);
			}
		}else
			throw new IncorrectFormatException("El hexadecimal no esta en el formato correcto");
        return decimal;
	}
	
}
