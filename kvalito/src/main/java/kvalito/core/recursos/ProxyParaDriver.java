package kvalito.core.recursos;

import kvalito.core.Configuracoes;
import kvalito.core.Log;

import org.openqa.selenium.Proxy;

public class ProxyParaDriver {
	
	public static boolean habilitado() throws Exception {
		String habilitado = Configuracoes.getConfiguracaoPrincipal("proxy-habilitado");
		return Boolean.parseBoolean(habilitado);
	}
	
	public Proxy obterProxy() throws Exception {
		Log.registrarInformacao("Carregando as configurações do proxy");
		String proxyHost = Configuracoes.getConfiguracaoPrincipal("proxy-host"); 
		String semProxy = Configuracoes.getConfiguracaoPrincipal("sem-proxy-para"); 
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyHost)
			.setFtpProxy(proxyHost)
			.setSslProxy(proxyHost)
			.setAutodetect(false)
			.setNoProxy(semProxy);
		
		return proxy;
	}
}
