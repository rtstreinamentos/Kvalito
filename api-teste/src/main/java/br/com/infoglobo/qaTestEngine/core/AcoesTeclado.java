package br.com.infoglobo.qaTestEngine.core;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AcoesTeclado {
	private WebElement elemento;

	public AcoesTeclado(WebElement elemento) {
		this.elemento = elemento;
	}

	public void pressionarEnter() {
		this.elemento.sendKeys(Keys.ENTER);
	}
	
	public void pressionarEsc() {
		this.elemento.sendKeys(Keys.ESCAPE);
	}
}
