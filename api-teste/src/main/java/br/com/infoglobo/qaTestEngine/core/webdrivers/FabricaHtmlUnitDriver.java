package br.com.infoglobo.qaTestEngine.core.webdrivers;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.core.recursos.RecursosParaDriver;

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
