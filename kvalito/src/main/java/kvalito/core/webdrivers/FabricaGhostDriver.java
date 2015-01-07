package kvalito.core.webdrivers;

import kvalito.core.Configuracoes;
import kvalito.core.Log;
import kvalito.core.recursos.RecursosParaDriver;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

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
