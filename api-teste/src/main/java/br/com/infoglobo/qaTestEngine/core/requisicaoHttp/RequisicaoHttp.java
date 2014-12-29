package br.com.infoglobo.qaTestEngine.core.requisicaoHttp;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import br.com.infoglobo.qaTestEngine.core.Log;
import br.com.infoglobo.qaTestEngine.utilitarios.UtilitarioTexto;

public class RequisicaoHttp {

	private String url;
	private List<EnderecoHttp> redirecionamentos;
	private List<CabecalhoHttp> cabecalhosHttp;
	private String corpoResposta;

	public RequisicaoHttp(String url) {
		this.url = url;
		this.redirecionamentos = new ArrayList<EnderecoHttp>();
		this.cabecalhosHttp = new ArrayList<CabecalhoHttp>();
		Log.registrarInformacao(String.format("Iniciando uma nova requisição HTTP [%s]", url));
	}

	public void executar() throws IOException {
		Log.registrarInformacao(String.format("Executando a requisição"));
		URL resourceUrl;
		HttpURLConnection.setFollowRedirects(false);
		HttpURLConnection connection;

		CookieManager cookieManager = new CookieManager();
		cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
		CookieHandler.setDefault(cookieManager);
		CookieStore cookieStore = null;
		String body = null;

		while (true) {

			resourceUrl = new URL(url);
			connection = (HttpURLConnection) resourceUrl.openConnection();
			connection.setConnectTimeout(30000); //PADRAO 15000
			connection.setReadTimeout(30000); //PADRAO 15000

			for (CabecalhoHttp cabecalho : this.cabecalhosHttp) {
				connection.setRequestProperty(cabecalho.getNome(), cabecalho.getValor());
			}

			cookieStore = cookieManager.getCookieStore();

			body = carregarBody(connection);

			this.redirecionamentos.add(new EnderecoHttp(url, connection.getResponseCode(), cookieStore.getCookies(), body));

			switch (connection.getResponseCode()) {
			case HttpURLConnection.HTTP_MOVED_PERM:
			case HttpURLConnection.HTTP_MOVED_TEMP:
				url = connection.getHeaderField("Location");
				continue;
			}

			break;
		}
		String mensagem = "Requisição executada [Status: %s]";
		Log.registrarInformacao(String.format(mensagem,this.status()));
	}

	private String carregarBody(HttpURLConnection connection) throws IOException {
		if (connection != null) {
			String encoding = connection.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			corpoResposta = IOUtils.toString(obterStreamDeAcordoComStatus(connection), encoding);
		}
		return corpoResposta;
	}

	private InputStream obterStreamDeAcordoComStatus(HttpURLConnection connection) throws IOException {
		if (connection.getResponseCode() < 400) {
			return connection.getInputStream();
		}
		return connection.getErrorStream();
	}

	public int status() {
		return getEnderecoDestino().getHttpStatusCode();
	}

	public String valorCookie(String nomeCookie) {
		return getEnderecoDestino().getCookie(nomeCookie).getValue();
	}

	public void adicionarCabecalhoHttp(String nomeCabecalho, String valorCabecalho) {
		CabecalhoHttp cabecalho = new CabecalhoHttp(nomeCabecalho, valorCabecalho);
		String mensagem = "Incluiu um cabeçalho na requisição [%s]";
		Log.registrarInformacao(String.format(mensagem, cabecalho.toString()));
		this.cabecalhosHttp.add(cabecalho);
	}

	public void adicionarUserAgent(String valor) {
		adicionarCabecalhoHttp("User-Agent", valor);
	}

	public EnderecoHttp getEnderecoOrigem() {
		return redirecionamentos != null ? redirecionamentos.get(0) : null;
	}

	public EnderecoHttp getEnderecoDestino() {
		return (redirecionamentos != null && redirecionamentos.size() > 0) ? redirecionamentos.get(redirecionamentos.size() - 1) : null;
	}

	public List<EnderecoHttp> getRedirecionamentos() {
		return redirecionamentos;
	}

	public boolean houveRedirecionamento() {
		return redirecionamentos.size() > 1;
	}

	public String corpoResposta() {
		return corpoResposta;
	}

	public String extrairConteudoCorpoResposta(String regexExtracao) {
		return UtilitarioTexto.extrair(corpoResposta(), regexExtracao);
	}

}
