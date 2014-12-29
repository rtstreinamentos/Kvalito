package validator;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.infoglobo.qaTestEngine.validador.Validator;

public class TestesValidatorIsNumeric {
	@Test
	public void numeroDeveSerVerdadeiro() {
		String valorTestado = "5";
		assertTrue(Validator.isNumeric(valorTestado));
	}
	
	@Test
	public void numeroComPontoDeveSerVerdadeiro() {
		String valorTestado = "1.000";
		assertTrue(Validator.isNumeric(valorTestado));
	}

	@Test
	public void numeroComDecimalDeveSerVerdadeiro() {
		String valorTestado = "5,2";
		assertTrue(Validator.isNumeric(valorTestado));
	}
	
	@Test
	public void numeroComPontoEDecimalDeveSerVerdadeiro() {
		String valorTestado = "1.005,2";
		assertTrue(Validator.isNumeric(valorTestado));
	}
	
	@Test
	public void numeroComMaisDeUmPontoDeveSerVerdadeiro() {
		String valorTestado = "1.000.000";
		assertTrue(Validator.isNumeric(valorTestado));
	}

	@Test
	public void letraDeveSerFalso() {
		String valorTestado = "A";
		assertFalse(Validator.isNumeric(valorTestado));
	}
	
	@Test
	public void letraComNumeroDeveSerFalso() {
		String valorTestado = "A5";
		assertFalse(Validator.isNumeric(valorTestado));
	}
	
	@Test
	public void numeroComDuasViurgulasDeveSerFalso() {
		String valorTestado = "50,,0";
		assertFalse(Validator.isNumeric(valorTestado));
	}
}
