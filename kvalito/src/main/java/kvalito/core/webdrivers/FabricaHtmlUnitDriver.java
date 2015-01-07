package kvalito.core.webdrivers;

import kvalito.core.Configuracoes;
import kvalito.core.recursos.RecursosParaDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FabricaHtmlUnitDriver {
	public static HtmlUnitDriver instanciar() throws Exception {
		HtmlUnitDriver driverTemporario = new HtmlUnitDriver(RecursosParaDriver.carregar());
		((HtmlUnitDriver) driverTemporario).setJavascriptEnabled(javaScriptHabilitado());
		return driverTemporario;
	}
	
	private static boolean javaScriptHabilitado() throws Exception {
		String habilitado = Configuracoes.getConfiguracaoPrincipal("html-unit-java-script-habilitado");
		return Boolean.parseBoolean(habilitado);
	}
}
