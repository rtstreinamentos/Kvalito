package Api.testesQATestEngineWeb;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.core.NavegadorUtilizado;
import br.com.infoglobo.qaTestEngine.core.Pagina;
@Ignore
public class TestesLocalizadorDefault extends Pagina {
	@Before
	public void iniciarTestes() throws Exception {
		executarTesteNo(NavegadorUtilizado.GHOST_DRIVER);
		String urlPagina = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine");
		abrirUrl(urlPagina);
	}
	
	@After
	public void finalizarTeste() throws Exception {
		fechar();
	}
	
	@Test
	public void localizarItemUtilizandoLocalizadorDefualt() throws Exception {
		assertEquals("Por XPATH",localizarElemento("xpath","//*[@id=\"todos-find-elements-by\"]/p[5]").getConteudo());
	}
}
