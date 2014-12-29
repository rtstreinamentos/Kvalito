package produtos;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.infoglobo.qaTestEngine.core.requisicaoHttp.RequisicaoHttp;
import static br.com.infoglobo.qaTestEngine.validador.Validator.*;

public class TesteRestClassificados {

	@Test
	public void testeServicoSincrono() throws IOException {
		String urlTokenBarramento = "http://apiqlt/token-autenticacao";

		RequisicaoHttp requisicaoTokenBarramento = new RequisicaoHttp(urlTokenBarramento);
		String nomeCabecalho = "Authorization";
		String valorCabecalho = "Basic c2VydmNhcHRhYW51bmNpb19xbHQ6REBQWmhVTnFWWjBSTjIxNA==";
		requisicaoTokenBarramento.adicionarCabecalhoHttp(nomeCabecalho, valorCabecalho);
		requisicaoTokenBarramento.executar();

		String tokenGerado = requisicaoTokenBarramento.extrairConteudoCorpoResposta("token-acesso\":\"(.*?)\"");			
		String urlAutenticacao = "http://apiqlt/classificados/token-autenticacao";
		RequisicaoHttp requisicaoAutenticacao = new RequisicaoHttp(urlAutenticacao);
		requisicaoAutenticacao.adicionarCabecalhoHttp("classif-authorization", "Basic cm9ic29ud3Q6MTIzNHF3ZXI=");
		requisicaoAutenticacao.adicionarCabecalhoHttp("ig-consumidor", "71EwYhTZpjYe4dW0UubSu3DcfruFv54Cw9R0f7V9a+w=");
		requisicaoAutenticacao.adicionarCabecalhoHttp("Authorization", "OAuth2 " + tokenGerado);
		requisicaoAutenticacao.executar();
		
		String idAnunciante = requisicaoAutenticacao.extrairConteudoCorpoResposta("<idAnunciante>(.*?)</idAnunciante>");
		String urlConsultaSaldo = String.format("http://apiqlt/classificados/anunciante/%s/plano/saldo",idAnunciante);
		String tokenClassificados = requisicaoAutenticacao.extrairConteudoCorpoResposta("<token-autenticacao>(.*?)</token-autenticacao>");;
		
		RequisicaoHttp requisicaoConsultaSaldo = new RequisicaoHttp(urlConsultaSaldo);
		requisicaoConsultaSaldo.adicionarCabecalhoHttp("classif-authorization", "OAuth2 " + tokenClassificados);
		requisicaoConsultaSaldo.adicionarCabecalhoHttp("ig-consumidor", "71EwYhTZpjYe4dW0UubSu3DcfruFv54Cw9R0f7V9a+w=");
		requisicaoConsultaSaldo.adicionarCabecalhoHttp("Authorization", "OAuth2 " + tokenGerado);
		requisicaoConsultaSaldo.executar();
			
		int numeroAnunciosRestantes = Integer.parseInt(requisicaoConsultaSaldo.extrairConteudoCorpoResposta("<numeroAnunciosRestantes>(.*?)</numeroAnunciosRestantes>"));
		greaterThan(numeroAnunciosRestantes,0);
	}
}