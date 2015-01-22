package testes.conversores;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import kvalito.conversores.ConversorCores;

import org.junit.Test;

public class TestesConverterRgbParaHexadecimal {

	@Test
	public void verificarConversaoRgbParaHexadecimal() throws Exception {
		String rgb = "rgb(0,0,255)";
		String resultadoEsperado = "#0000FF";

		assertEquals(resultadoEsperado,
				ConversorCores.converterRgbParaHexadecimal(rgb));

	}

	@Test
	public void verificarConversaoRgbParaHexadecimalComEspacoADireita()
			throws Exception {
		String rgb = " rgb(192,192,192)";
		String resultadoEsperado = "#C0C0C0";

		assertEquals(resultadoEsperado,
				ConversorCores.converterRgbParaHexadecimal(rgb));

	}

	@Test
	public void verificarConversaoRgbParaHexadecimalComEspacoAEsquerda()
			throws Exception {
		String rgb = "rgb(0,255,0) ";
		String resultadoEsperado = "#00FF00";

		assertEquals(resultadoEsperado,
				ConversorCores.converterRgbParaHexadecimal(rgb));

	}

	@Test
	public void verificarConversaoDeValorNulo() {

		String resultadoEsperado = "Favor informar a cor RGB! Exemplo: rgb(0,0,0)";

		try {

			ConversorCores.converterRgbParaHexadecimal(null);

		} catch (InvalidParameterException e) {
			assertEquals("Falhou ao tratar valor NULO", resultadoEsperado,
					e.getMessage());
		}

	}

	@Test
	public void verificarConversaoDeValorVazio() {

		String resultadoEsperado = "Favor informar a cor RGB! Exemplo: rgb(0,0,0)";

		try {

			ConversorCores.converterRgbParaHexadecimal("");

		} catch (InvalidParameterException e) {
			assertEquals("Falhou ao tratar String vazia!", resultadoEsperado,
					e.getMessage());
		}

	}

	@Test
	public void verificarConversaoDeEspacoEmBranco() {

		String resultadoEsperado = "Favor informar a cor RGB! Exemplo: rgb(0,0,0)";

		try {

			ConversorCores.converterRgbParaHexadecimal(" ");

		} catch (InvalidParameterException e) {
			assertEquals("Falhou ao tratar espacos em branco!",
					resultadoEsperado, e.getMessage());
		}

	}

	@Test
	public void verificarConversaoDeTABEmBranco() {

		String resultadoEsperado = "Favor informar a cor RGB! Exemplo: rgb(0,0,0)";

		try {

			ConversorCores.converterRgbParaHexadecimal("	");

		} catch (InvalidParameterException e) {
			assertEquals("Falhou ao tratar TAB em branco!", resultadoEsperado,
					e.getMessage());
		}

	}

	@Test
	public void verificarConversaoDeRGBInvalido() {

		String resultadoEsperado = "Cor RGB invalida!";

		try {

			ConversorCores.converterRgbParaHexadecimal("rgb(0,0,0,0,255)");

		} catch (InvalidParameterException e) {
			assertEquals("Falhou ao tratar RGB invalido!", resultadoEsperado,
					e.getMessage());
		}

	}

}
