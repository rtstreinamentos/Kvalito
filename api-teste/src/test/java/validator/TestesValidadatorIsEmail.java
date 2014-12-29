package validator;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.infoglobo.qaTestEngine.validador.Validator;

public class TestesValidadatorIsEmail {
	@Test
	public void emailValidoComPontoCom() {
		String emailValidar = "teste@email.com";
		assertTrue(Validator.isEmail(emailValidar));		
	}
	
	@Test
	public void emailValidoComPontoComPontoBr(){
		String emaiValidar = "teste@email.com.br";
		assertTrue(Validator.isEmail(emaiValidar));
	}
	
	@Test
	public void emailValidoComLetrasENumerosNoDominio(){
		String emailValidar = "teste@email2.com";
		assertTrue(Validator.isEmail(emailValidar));
	}

	@Test
	public void invalidarEmailComDominioComUmCaracter(){
		String emailValidar = "teste@e.com";
		assertFalse(Validator.isEmail(emailValidar));
	}
	
	@Test
	public void invalidarEmailComDominioIniciadoPorHifen(){
		String emailValidar = "teste@-dosakdosa.com";
		assertFalse(Validator.isEmail(emailValidar));
	}
	
	
}

/*

Regra domínio:
	Tamanho mínimo de 2 e máximo de 26 caracteres, não incluindo a categoria. Por exemplo: no domínio xxxx.com.br, esta limitação se refere ao xxxx;
	Caracteres válidos são letras de "a" a "z", números de "0" a "9", o hífen, e os seguintes caracteres acentuados: à, á, â, ã, é, ê, í, ó, ô, õ, ú, ü, ç
	Não conter somente números;
	Não iniciar ou terminar por hífen

Exemplos errados:
aaaaaa
t_este.@99email2-.com
guilhermemoraes.@-g4mail.com.br
teste@e.com
teste@esdafkjahsdfkjasdhfkasjfhkasjfhaskdjfhaskdjfhdafgsdfgsdfgsdfgsdfgsdfgsdfgsdfgs.com
@hfghfdhgdfhdf

Exemplos válidos:
aaaa@email.com
teste@email.com.br
teste@email2.com
t_este@email2.com
t_este.@email2.com
t_este.@email_2.com
t_este.@email-2.com
t_este.@99email-2.com
t_este.@99email-2.com


*/