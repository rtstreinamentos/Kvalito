package br.com.infoglobo.qaTestEngine.core;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public class Configuracoes {
	private static final String ARQUIVO_CONFIGURACOES_PRINCIPAL = "src/test/resources/ConfiguracoesTeste.properties";
	private static Properties propriedades;
	private static Properties propriedadesPrincipais;
	private static HashMap<String, String> mapaDeConfiguracoes;

	public static String getUrlConfigurada(String nomePageObject)
			throws Exception {
		carregarPropriedades();
		return getDominio() + getConfiguracaoPagina(nomePageObject);
	}

	public static String getDominio() throws Exception {
		carregarPropriedades();
		String nomePropriedadeDominioUtilizado = getConfiguracaoPagina("dominio-utlizado");
		String dominio = getConfiguracaoPagina(nomePropriedadeDominioUtilizado);
		return dominio;
	}

	private static void carregarPropriedades() throws Exception {
		if (propriedadesPrincipais == null) {
			try {
				File file;

				Log.registrarInformacao("Abrindo arquivo de configurações principal [ConfiguracoesTeste.properties]");
				propriedadesPrincipais = new Properties();
				file = new File(ARQUIVO_CONFIGURACOES_PRINCIPAL);
				propriedadesPrincipais.load(new FileInputStream(file));

				String arquivoConfiguracoesPaginaUtilizado = obterNomeArquivoConfiguracoesPagina();
				Log.registrarInformacao(String.format(
						"Abrindo o arquivo de configurações de página [%s]",
						arquivoConfiguracoesPaginaUtilizado));

				propriedades = new Properties();
				file = new File(arquivoConfiguracoesPaginaUtilizado);
				propriedades.load(new FileInputStream(file));
			} catch (Exception ex) {
				Log.registrarInformacao("Erro ao carregar os arquivos de configurações");
				Log.registrarErro(ex);
				throw ex;
			}
		}
	}

	private static String obterNomeArquivoConfiguracoesPagina()
			throws Exception {
		String nome = System.getProperty("configuracoes-pagina-utlizada");
		if (nome == null || nome.isEmpty()) {
			nome = getConfiguracao("configuracoes-pagina-utlizada",
					propriedadesPrincipais);
		}
		if (nome == null || nome.isEmpty()) {
			nome = "ConfiguracoesPagina.properties";
		}
		return "src/test/resources/" + nome;
	}

	public static String getConfiguracaoPagina(String chaveconfiguracao)
			throws Exception {
		carregarPropriedades();
		return getConfiguracao(chaveconfiguracao, propriedades);
	}

	public static String getConfiguracaoPrincipal(String chaveconfiguracao)
			throws Exception {
		carregarPropriedades();	
		return getConfiguracao(chaveconfiguracao, propriedadesPrincipais);
	}

	private static String getConfiguracao(String chaveconfiguracao,
			Properties aquivoPropriedades) throws Exception {
		try {
			Log.registrarInformacao(String.format(
					"Obtendo a configuração da chave [%s]", chaveconfiguracao));
			String valorChave = aquivoPropriedades
					.getProperty(chaveconfiguracao);
			if (valorChave == null) {
				throw new Exception(
						String.format(
								"Não localizou a chave [%s] no arquivo de configuração",
								chaveconfiguracao));
			}
			return valorChave;
		} catch (Exception ex) {
			Log.registrarInformacao(String.format(
					"Erro ao tentar obter a configuração [%s]",
					chaveconfiguracao));
			Log.registrarErro(ex);
			throw ex;
		}
	}
	
	public static void injetarConfiguracao(String chave, String valor) {
		instanciarMapaDeConfiguracoes();
		mapaDeConfiguracoes.put(chave, valor);
	}

	public static String obterConfiguracaoDaChave(String chave) throws Exception {
		instanciarMapaDeConfiguracoes();
		
		if (mapaDeConfiguracoes.get(chave) != null) {
			return mapaDeConfiguracoes.get(chave);
		}
		
		return getConfiguracaoPagina(chave);
	}

	private static void instanciarMapaDeConfiguracoes() {
		if (mapaDeConfiguracoes == null) {
			mapaDeConfiguracoes = new HashMap<String, String>();
		}
	}

	public static void descarregar() {
		propriedades = null;
		propriedadesPrincipais = null;
	}
}
