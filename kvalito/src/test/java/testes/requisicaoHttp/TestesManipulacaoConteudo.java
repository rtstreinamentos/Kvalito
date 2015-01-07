package testes.requisicaoHttp;

import static org.junit.Assert.assertTrue;

import java.util.regex.Pattern;

import kvalito.core.Configuracoes;
import kvalito.core.requisicaoHttp.RequisicaoHttp;

import org.junit.Test;

public class TestesManipulacaoConteudo {

	@Test
	public void verificarConteudoHtml() throws Exception {

		String url = Configuracoes
				.getConfiguracaoPagina("pagina-app-web-qatestengine");

		Pattern htmlPattern = Pattern.compile(".*\\<[^>]+>.*", Pattern.DOTALL);

		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		assertTrue("Formato fora do padrao HTML:"
				+ requisicao.getEnderecoDestino().getBody(), htmlPattern
				.matcher(requisicao.getEnderecoDestino().getBody()).matches());

	}

	@Test
	public void verificarConteudoJson() throws Exception {

		String url = Configuracoes
				.getConfiguracaoPagina("pagina-app-web-qatestengine")+"pagina-conteudo.json";
		
		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		assertTrue("Formato fora do padrao JSON:"
				+ requisicao.getEnderecoDestino().getBody(), requisicao.getEnderecoDestino().getBody().contains("[{\"conteudos\":"));

	}

	@Test
	public void verificarConteudoXML() throws Exception {
		
		String url = Configuracoes
				.getConfiguracaoPagina("pagina-app-web-qatestengine")+"pagina-conteudo.xml";

		Pattern xmlPattern = Pattern.compile(".*\\<[^>]+>.*", Pattern.DOTALL);
		
		RequisicaoHttp requisicao = new RequisicaoHttp(url);
		requisicao.executar();
		assertTrue("Formato fora do padrao XML:"
				+ requisicao.getEnderecoDestino().getBody(), xmlPattern
				.matcher(requisicao.getEnderecoDestino().getBody()).matches());

	}

}
