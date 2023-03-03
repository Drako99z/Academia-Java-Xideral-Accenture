package com.arturo.v0;

public class CalculadoraBinario extends Calculadora{
	
	public CalculadoraBinario() {
		
	}
	
	public CalculadoraBinario(Integer valor) {
		this.valor = valor;
	}

	@Override
	public String getConversion() {
		if(valor == 0)
			return "0";
		if(valor < 0)
			throw new NegativeNotSupportedException("No se permiten numeros negativos");
		StringBuilder binario = new StringBuilder();
	    while (valor > 0) {
	        binario.insert(0, valor % 2);
	        valor = valor / 2;
	    }
	    return binario.toString();
	}

	@Override
	public Integer getValor() {
		return this.valor;
	}

	@Override
	public void setValor(Integer valor) {
		this.valor = valor;		
	}
	
	public static int convertFromBinario(String binario) {
		int decimal = 0;
		char digito;
		if (binario.matches("^[01]+$")) {
			for (int i = 0; i < binario.length(); i++) {
				digito = binario.charAt(i);
				if (digito == '1') 
					decimal += Math.pow(2, binario.length() - i - 1);					
			}
		}else
			throw new IncorrectFormatException("El binario no esta en el formato correcto");
        return decimal;
	}
	
}
