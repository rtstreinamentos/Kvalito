package Api.testesJunitRunnerCustomizado;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import Api.testesJunitRunnerCustomizado.assistentes.RunnerParaTesteQLT;
import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.junit.AmbienteExecucaoTeste;

@RunWith(RunnerParaTesteQLT.class)
public class TestesExecutarQLTQuandoMarcadoParaQLTePRD {

	private static ArrayList<String> listaExecutados;

	@BeforeClass
	public static void antesDoTeste() {
		listaExecutados = new ArrayList<String>();
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "PRD,QLT")
	public void testePrdQlt1() {
		listaExecutados.add("executou PRD e QLT");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "QLT")
	public void testeQlt1() {
		listaExecutados.add("executou QLT");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "PRD")
	public void testePrd1() {
		listaExecutados.add("executou PRD1");
	}

	@AfterClass
	public static void depoisDoTeste() {
		int totalEsperado = 2;
		assertEquals(totalEsperado, listaExecutados.size());
		Configuracoes.descarregar();
	}

}
