package testes.webdriver;

import static org.junit.Assert.*;
import kvalito.core.Configuracoes;
import kvalito.core.NavegadorUtilizado;
import kvalito.core.Pagina;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
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
