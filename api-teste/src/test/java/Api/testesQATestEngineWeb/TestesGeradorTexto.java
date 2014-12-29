package Api.testesQATestEngineWeb;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.com.infoglobo.qaTestEngine.componentes.Elemento;
import static org.mockito.Mockito.*;

public class TestesGeradorTexto {
	private WebElement elementoMockado;
	
	@Before
	public void antesDoTeste() {
		elementoMockado = mock(WebElement.class);
	}
	
	@Test
	public void gerarTextoAleatorio() throws Exception {
		Elemento elemento = new Elemento(elementoMockado);
		int quantidadePalavras = 3;
		String texto = elemento.preencherComTextoAleatorio(quantidadePalavras);
		assertEquals(quantidadePalavras, texto.split(" ").length);
	}
	
	@Test
	public void gerarCaracteresAleatorios() throws Exception {
		Elemento elemento = new Elemento(elementoMockado);
		int quantidadeCaracteres = 3;
		String texto = elemento.preencherComCaracteresAleatorios(quantidadeCaracteres);
		assertEquals(quantidadeCaracteres, texto.length());
	}
}
