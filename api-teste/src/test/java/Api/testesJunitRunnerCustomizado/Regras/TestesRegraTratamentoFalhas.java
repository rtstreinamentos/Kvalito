package Api.testesJunitRunnerCustomizado.Regras;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import br.com.infoglobo.qaTestEngine.componentes.Elemento;
import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.core.Navegador;
import br.com.infoglobo.qaTestEngine.core.NavegadorUtilizado;
import br.com.infoglobo.qaTestEngine.core.Pagina;
import br.com.infoglobo.qaTestEngine.junit.RegraTratamentoFalhas;

@Ignore
public class TestesRegraTratamentoFalhas extends Pagina{
	private static String urlPagina;
	
	@Rule
	public RegraTratamentoFalhas regraTratamentoFalhas = new RegraTratamentoFalhas();

	@BeforeClass
	public static void iniciarTestes() throws Exception { 
		Navegador.executarTesteNo(NavegadorUtilizado.FIREFOX); 
		urlPagina = Configuracoes.getConfiguracaoPagina("pagina-app-web-qatestengine");
		Navegador.abrirUrl(urlPagina);
	}

	@AfterClass
	public static void finalizarTeste() throws Exception {
		Navegador.fechar();
	}
	
	@Test
	public void testeLancandoErro() throws Exception{
		System.out.println("Lançando Erro...");
		super.localizarElemento("elemento-nao-existe");
	}
	
	@Test
	public void testeLancandoFalha() throws Exception{
		esperarCarregamentoPor(2000);
		System.out.println("Lançando Falha...");
		assertTrue(false);
	}
	
	@Test
	public void testeDevePassar() throws Exception{
		assertTrue(true);
	}
	
	@Test
	public void testeFalhaNaPrimeiraEPassaNaSegunda() throws Exception{
		super.localizarElemento("esperar-visibilidade-button").clicar();
		esperarCarregamentoPor(1000);
		Elemento elemento = super.localizarElemento("esperar-visibilidade-div-que-aparecera");
		assertTrue(elemento.estaVisivel());
	}
	
	
	
}
