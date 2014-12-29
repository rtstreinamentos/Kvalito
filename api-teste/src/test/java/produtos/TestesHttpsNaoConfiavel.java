package produtos;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import br.com.infoglobo.qaTestEngine.componentes.Elemento;
import br.com.infoglobo.qaTestEngine.core.NavegadorUtilizado;
import br.com.infoglobo.qaTestEngine.core.Pagina;

@Ignore
public class TestesHttpsNaoConfiavel extends Pagina {
	@After
	public void finalizarTeste() throws Exception {
		fechar();
	}	
	
	@Test
	public void tentarLogarGloboComNoFirefox_EConseguirVoltarParaProdutoGloboRedesenho() throws Exception {
		executarTesteNo(NavegadorUtilizado.FIREFOX);
		abrirUrl("http://infoecedsvglobo3.globoi.com/rio/webdriver-nao-altere-justica-mantem-leilao-de-casa-de-us-280-mil-devido-divida-de-us-630-25121");
		
		Elemento linkLogin = localizarElemento("xpath", "/html/body/div[3]/article/div[4]/div[1]/div/div[4]/div[1]/a");
		linkLogin.clicar();
		esperarCarregamentoPor(1000);
		
		assertTrue(getUrlAtual().contains("login.qa01"));
		
		localizarElemento("nome","login-passaporte").preencherCom("testecadun2@hotmail.com");
		localizarElemento("nome","senha-passaporte").preencherCom("secret123");
		localizarElemento("xpath", "//*[@id=\"passaporte-globo\"]/div/form/fieldset/input[3]").clicar();
		
		super.aceitarAlertaSeguranca();
		
		System.out.println(getUrlAtual());
		
		esperarCarregamentoPor(5000);
		assertTrue(super.getUrlAtual().contains("globostg.globoi.com"));
		
		super.fechar();
	}
	
	
	
}
