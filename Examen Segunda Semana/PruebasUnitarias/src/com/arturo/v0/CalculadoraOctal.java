package com.arturo.v0;

public class CalculadoraOctal extends Calculadora{
	
	public CalculadoraOctal() {
		
	}
	
	public CalculadoraOctal(Integer valor) {
		this.valor = valor;
	}

	@Override
	public String getConversion() {
		if(valor == 0)
			return "0";
		if(valor < 0)
			throw new NegativeNotSupportedException("No se permiten numeros negativos");
		StringBuilder octal = new StringBuilder();
	    while (valor > 0) {
	        octal.insert(0, valor % 8);
	        valor = valor / 8;
	    }
	    return octal.toString();
	}

	@Override
	public Integer getValor() {
		return this.valor;
	}

	@Override
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public static int convertFromOctal(String octal) {
		int decimal = 0;
		int digito;
		if (octal.matches("^[0-7]+$")) {
			for (int i = 0; i < octal.length(); i++) {
		        digito = Character.getNumericValue(octal.charAt(i));
		        decimal += digito * Math.pow(8, octal.length() - 1 - i);
		    }
		}else
			throw new IncorrectFormatException("El octal no esta en el formato correcto");
        return decimal;
	}
	
}
