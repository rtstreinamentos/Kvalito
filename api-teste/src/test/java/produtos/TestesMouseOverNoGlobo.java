package produtos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import br.com.infoglobo.qaTestEngine.componentes.Elemento;
import br.com.infoglobo.qaTestEngine.core.NavegadorUtilizado;
import br.com.infoglobo.qaTestEngine.core.Pagina;

@Ignore
public class TestesMouseOverNoGlobo extends Pagina {
	@After
	public void finalizarTeste() throws Exception {
		fechar();
	}
	
	@Test
	@Ignore
	public void executarMouseOverNoFirefox() throws Exception {
		super.executarTesteNo(NavegadorUtilizado.FIREFOX);
		super.abrirUrl("http://globostg.globoi.com/");
		
		Elemento menuEconomia = localizarElemento("xpath", "//*[@id=\"menu\"]/div/ul/li[4]/a");
		Elemento subMenuEconomia = localizarElemento("xpath", "//*[@id=\"menu\"]/div/ul/li[4]/div");
		
		assertFalse(subMenuEconomia.estaVisivel());
		menuEconomia.passarMouseSobre();
		assertTrue(subMenuEconomia.estaVisivel());
	}
}
