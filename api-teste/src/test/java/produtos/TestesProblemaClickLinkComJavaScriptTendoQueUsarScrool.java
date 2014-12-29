package produtos;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import br.com.infoglobo.qaTestEngine.componentes.Elemento;
import br.com.infoglobo.qaTestEngine.core.Localizador;
import br.com.infoglobo.qaTestEngine.core.NavegadorUtilizado;
import br.com.infoglobo.qaTestEngine.core.Pagina;

@Ignore
public class TestesProblemaClickLinkComJavaScriptTendoQueUsarScrool extends Pagina {
	@After
	public void finalizarTeste() throws Exception {
		fechar();
	}
	
	@Test
	public void tentarClickLinkComJavaScriptNoHref_UtilizandoFirefox() throws Exception {
		executarTesteNo(NavegadorUtilizado.FIREFOX);
		this.passosDoTeste();
	}
	
	@Test
	public void tentarClickLinkComJavaScriptNoHref_UtilizandoChrome() throws Exception {
		executarTesteNo(NavegadorUtilizado.CHROME);
		this.passosDoTeste();
	}
	
	@Test
	public void tentarClickLinkComJavaScriptNoHref_UtilizandoGhost() throws Exception {
		executarTesteNo(NavegadorUtilizado.GHOST_DRIVER);
		this.passosDoTeste();
	}
	
	public void passosDoTeste() throws Exception {
		abrirUrl("http://infoecedsvglobo3.globoi.com/rio/webdriver-nao-altere-justica-mantem-leilao-de-casa-de-us-280-mil-devido-divida-de-us-630-25121");
				
		Elemento tagA = localizarElemento("xpath", "/html/body/div[3]/article/div[4]/div[1]/div/div[4]/div[1]/a");
		tagA.clicar();
		esperarCarregamentoPor(1000);
		assertTrue(getUrlAtual().contains("login.qa01"));		
	}
}
