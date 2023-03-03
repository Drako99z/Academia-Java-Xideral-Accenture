package com.arturo.v0;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraTest {
	
	Calculadora cal;
	
	@Test
	@DisplayName("Valor nulo no inicializado")
	void testNull() {
		cal = new CalculadoraBinario();
		assertNull(cal.getValor());
		cal = new CalculadoraHexa();
		assertNull(cal.getValor());
		cal = new CalculadoraOctal();
		assertNull(cal.getValor());
	}
	
	@Test
	@DisplayName("Conversion desde decimal con valor nulo")
	void testNullConversion() {
		cal = new CalculadoraBinario(null);
		assertThrows(NullPointerException.class, () -> cal.getConversion());
		cal = new CalculadoraHexa(null);
		assertThrows(NullPointerException.class, () -> cal.getConversion());
		cal = new CalculadoraOctal(null);
		assertThrows(NullPointerException.class, () -> cal.getConversion());
	}
	
	@Test
	@DisplayName("Asignar valor a una instancia de Calculadora")
	void testAsignacion() {
		cal = new CalculadoraBinario();
		cal.setValor(18);
		assertEquals(cal.getValor(), 18);
		cal = new CalculadoraHexa();
		cal.setValor(45);
		assertEquals(cal.getValor(), 45);
		cal = new CalculadoraOctal();
		cal.setValor(78);
		assertEquals(cal.getValor(), 78);
	}

	@Test
	@DisplayName("Prueba de conversión a Binario")
	void basic_binario() {
		cal = new CalculadoraBinario(150);
		String conversion = cal.getConversion();
		assertEquals("10010110", conversion);
	}
	
	@Test
	@DisplayName("Prueba de cónversion a Hexadecimal")
	void basic_hexa() {
		cal = new CalculadoraHexa(150);
		String conversion = cal.getConversion();
		assertEquals("96", conversion);
	}
	
	@Test
	@DisplayName("Prueba de conversión a Octal")
	void basic_octal() {
		cal = new CalculadoraOctal(150);
		String conversion = cal.getConversion();
		assertEquals("226", conversion);
	}
	
	@Test
	@DisplayName("Prueba de Conversión desde Binario")
	void from_binario() {
		int decimal = CalculadoraBinario.convertFromBinario("01011001");
		assertEquals(89, decimal);
	}
	
	@Test
	@DisplayName("Prueba de conversión desde Hexadecimal")
	void from_hexa() {
		int decimal = CalculadoraHexa.convertFromHexa("44");
		assertEquals(68, decimal);
	}
	
	@Test
	@DisplayName("Prueba de Conversión desde Octal")
	void from_octal() {
		int decimal = CalculadoraOctal.convertFromOctal("56");
		assertEquals(46, decimal);
	}
	
	@DisplayName("Prueba múltiple de conversión a Binario")
	@ParameterizedTest(name = "{0} en binario es {1}")
	@CsvSource(value = { "283, 100011011", "76, 1001100", "543, 1000011111", "234, 11101010" })
	void multi_binario(int valor, String resultado) {
		cal = new CalculadoraBinario(valor);
		assertEquals(resultado, cal.getConversion());
	}
	
	@DisplayName("Prueba múltiple de conversión a Hexadecimal")
	@ParameterizedTest(name = "{0} en hexadecimal es {1}")
	@CsvSource(value = { "283, 11B", "76, 4C", "543, 21F", "234, EA" })
	void multi_hexa(int valor, String resultado) {
		cal = new CalculadoraHexa(valor);
		assertEquals(resultado, cal.getConversion());
	}
	
	@DisplayName("Prueba múltiple de conversión a Octal")
	@ParameterizedTest(name = "{0} en octal es {1}")
	@CsvSource(value = { "283, 433", "76, 114", "543, 1037", "234, 352" })
	void multi_octal(int valor, String resultado) {
		cal = new CalculadoraOctal(valor);
		assertEquals(resultado, cal.getConversion());
	}
	
	@DisplayName("Prueba múltiple de conversión desde Binario")
	@ParameterizedTest(name = "{0} desde el binario es {1}")
	@CsvSource(value = { "100001010, 266", "10001111, 143", "101011101, 349", "1011111, 95" })
	void multi_from_binario(String binario, int resultado) {
		int decimal = CalculadoraBinario.convertFromBinario(binario);
		assertEquals(resultado, decimal);
	}
	
	@DisplayName("Prueba múltiple de conversión desde Hexadecimal")
	@ParameterizedTest(name = "{0} desde el hexadecimal es {1}")
	@CsvSource(value = { "5D, 93", "1C6, 454", "79, 121", "1DF, 479" })
	void multi_from_hexa(String hexa, int resultado) {
		int decimal = CalculadoraHexa.convertFromHexa(hexa);
		assertEquals(resultado, decimal);
	}
	
	@DisplayName("Prueba múltiple de conversión desde Octal")
	@ParameterizedTest(name = "{0} desde el octal es {1}")
	@CsvSource(value = { "411, 265", "662, 434", "404, 260", "22, 18" })
	void multi_from_octal(String octal, int resultado) {
		int decimal = CalculadoraOctal.convertFromOctal(octal);
		assertEquals(resultado, decimal);
	}
	
	@Test
	@DisplayName("Conversión del 0")
	void convert_cero() {
		cal = new CalculadoraBinario(0);
		assertEquals("0", cal.getConversion());
		assertEquals(0, CalculadoraBinario.convertFromBinario("0"));
		cal = new CalculadoraHexa(0);
		assertEquals("0", cal.getConversion());
		assertEquals(0, CalculadoraHexa.convertFromHexa("0"));
		cal = new CalculadoraOctal(0);
		assertEquals("0", cal.getConversion());
		assertEquals(0, CalculadoraOctal.convertFromOctal("0"));
	}
	
	@Test
	@DisplayName("Conversión de números Negativos")
	void convert_negativos() {
		cal = new CalculadoraBinario(-34);
		assertThrows(NegativeNotSupportedException.class, () -> cal.getConversion());
		cal = new CalculadoraHexa(-21);
		assertThrows(NegativeNotSupportedException.class, () -> cal.getConversion());
		cal = new CalculadoraOctal(-45);
		assertThrows(NegativeNotSupportedException.class, () -> cal.getConversion());
	}
	
	@Test
	@DisplayName("Prueba de Rendimiento en conversión desde decimal")
	void prueba_rendimiento() {
		Random random = new Random();
		Calculadora calBin = new CalculadoraBinario();
		Calculadora calHex = new CalculadoraHexa();
		Calculadora calOct = new CalculadoraOctal();
		assertTimeout(Duration.ofSeconds(1), () -> {
			int valor;
			for (int i = 0; i <= 1000; i++) {
				valor = random.nextInt(501);
				calBin.setValor(valor);
				calHex.setValor(valor);
				calOct.setValor(valor);
				System.out.println(calBin.getValor() + " en binario es: " + calBin.getConversion());
				System.out.println(calHex.getValor() + " en hexadecimal es: " + calHex.getConversion());
				System.out.println(calOct.getValor() + " en octal es: " + calOct.getConversion());
			}
		});
	}
	
	@Test
	@DisplayName("Prueba de herencia en las calculadoras")
	void test_herencia() {
		cal = new CalculadoraBinario();
		assertTrue(cal instanceof Calculadora);
		cal = new CalculadoraHexa();
		assertTrue(cal instanceof Calculadora);
		cal = new CalculadoraOctal();
		assertTrue(cal instanceof Calculadora);
	}

}
