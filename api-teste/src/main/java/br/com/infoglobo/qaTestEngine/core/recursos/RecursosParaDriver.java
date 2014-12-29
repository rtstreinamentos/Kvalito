package br.com.infoglobo.qaTestEngine.core.recursos;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RecursosParaDriver {
	public static DesiredCapabilities carregar() throws Exception {
		DesiredCapabilities recursos = new DesiredCapabilities();

		// Não funciona no Ghost
		//recursos.setCapability("applicationCacheEnabled", false);
		
		if (ProxyParaDriver.habilitado()) {
			recursos.setCapability(CapabilityType.PROXY, new ProxyParaDriver().obterProxy());
		}
		
		return recursos;
	}
	
}
