package br.com.infoglobo.qaTestEngine.core.webdrivers;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.core.Log;
import br.com.infoglobo.qaTestEngine.core.recursos.RecursosParaDriver;

public class FabricaGhostDriver {
	public static PhantomJSDriver instanciar() throws Exception {
		String diretorioPhantomJsDriver = Configuracoes.getConfiguracaoPrincipal("diretorio-phantomjs-driver");
		System.setProperty("phantomjs.binary.path",diretorioPhantomJsDriver);
		Log.registrarInformacao(String.format("Diretório do PhantomJSDriver [%s]",diretorioPhantomJsDriver));
		PhantomJSDriver driverTemporario = new PhantomJSDriver(RecursosParaDriver.carregar());
		driverTemporario.manage().window().maximize();
		return driverTemporario;
	}
}
