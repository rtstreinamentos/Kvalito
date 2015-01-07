package testes.utilitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

import kvalito.core.Navegador;
import kvalito.utilitarios.UtilitarioTexto;

import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class TestesExtracao {

	@Test
	public void extrairTextoComConteudoDesejado() {
		String texto = "{\"expiracao\":35999,\"token-acesso\":\"b762ed8c-d670-4651-b40d-d1f76cf748fc\"}";
		String regexExtracao = "token-acesso\":\"(.*?)\"";
		String textoExtraidoEsperado = "b762ed8c-d670-4651-b40d-d1f76cf748fc";
		String textoExtraido = UtilitarioTexto.extrair(texto, regexExtracao);
		assertEquals(textoExtraidoEsperado, textoExtraido);
	}

	@Test
	public void extrairTextoSemConteudoDesejado() {
		String texto = "{\"expiracao\":35999,\"token-acesso\":\"b762ed8c-d670-4651-b40d-d1f76cf748fc\"}";
		String regexExtracao = "naoexiste\":\"(.*?)\"";
		String textoExtraido = UtilitarioTexto.extrair(texto, regexExtracao);
		assertNull(textoExtraido);
	}
	
	@Test
	public void extrairTextoPrimeiroItemQuandoConteudoDesejadoDuplicado() {
		String texto = "{\"expiracao\":35999,\"expiracao\":22222,\"token-acesso\":\"b762ed8c-d670-4651-b40d-d1f76cf748fc\"}";
		String regexExtracao = "expiracao\":(.*?),";
		String textoExtraidoEsperado = "35999";
		String textoExtraido = UtilitarioTexto.extrair(texto, regexExtracao);
		assertEquals(textoExtraidoEsperado, textoExtraido);
	}
	
	@Test
	public void gravarArquivoHtml() throws Exception{
		WebDriver driver = mock(WebDriver.class);
		when(driver.getPageSource()).thenReturn("aaa");
		Navegador.injetarDriver(driver);
		String nomeArquivo = "teste";
		Navegador.gravarCodigoFontePagina(nomeArquivo);
		File caminhoArquivo = new File("target\\" + nomeArquivo + ".html");
		assertTrue(caminhoArquivo.exists());
		caminhoArquivo.delete();
	}
}
