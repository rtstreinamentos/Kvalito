package testes.requisicaoHttp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import kvalito.core.Configuracoes;
import kvalito.core.requisicaoHttp.RequisicaoHttp;

import org.junit.Test;

public class TestesManipulacaoCookies {

	@Test
	public void obterValorDoCookie() throws Exception {
		String url = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine") + "pagina-cookie.jsp";
		String resultadoEsperado = "teste";
		String nomeCookie = "teste";

		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		
		assertEquals(resultadoEsperado, requisicao.valorCookie(nomeCookie));
	}
	
	@Test
	public void verificarQuantidadeDeCookies() throws Exception {
		String url = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine") + "pagina-cookie.jsp";

		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		
		
		assertTrue("Nenhum cookie encontrado!", requisicao.getEnderecoDestino().getCookies().size()>0);
	}
	
}