package RequisicaoHttp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.core.requisicaoHttp.RequisicaoHttp;

public class TestesAvaliarHttpStatus {

	@Test
	public void status200ParaPaginaExsitente() throws Exception {
		String url = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine");
		int resultadoEsperado = 200;
		
		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		assertEquals(resultadoEsperado,requisicao.status());
	}
	
	@Test
	public void status404ParaPaginaExsitente() throws Exception {
		String url = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine")+"befbvieubveuibeuvbe9uvbe";
		int resultadoEsperado = 404;
		
		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		assertEquals(resultadoEsperado,requisicao.status());
	}
	
	@Test
	public void status302ParaPaginaExsitente() throws Exception {

		String url = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine")+"pagina-redireciona.jsp";
		int resultadoEsperado = 302;
		
		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		
		assertEquals(resultadoEsperado,requisicao.getEnderecoOrigem().getHttpStatusCode());
	}
	
	@Test
	public void houveRedirecionamento() throws Exception {
		
		String url = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine")+"pagina-redireciona.jsp";
		
		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		
		assertTrue("Nao houve redirecionamento para o mobi do Extra!",requisicao.houveRedirecionamento());
	}
	
	@Test
	public void naoHouveRedirecionamento() throws Exception {
		
		String url = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine");
		
		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		
		assertFalse("Houve redirecionamentos ao acessar o dominio do Extra!",requisicao.houveRedirecionamento());
	}
}
