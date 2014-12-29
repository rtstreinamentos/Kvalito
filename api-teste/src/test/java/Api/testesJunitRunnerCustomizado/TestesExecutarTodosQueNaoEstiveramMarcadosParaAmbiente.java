package Api.testesJunitRunnerCustomizado;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.junit.AmbienteExecucaoTeste;
import Api.testesJunitRunnerCustomizado.assistentes.RunnerParaTesteQLT;

@RunWith(RunnerParaTesteQLT.class)
public class TestesExecutarTodosQueNaoEstiveramMarcadosParaAmbiente {

	private static ArrayList<String> listaExecutados;

	@BeforeClass
	public static void antesDoTeste() {
		listaExecutados = new ArrayList<String>();
	}

	@Test
	public void testeSemAnotacao() {
		listaExecutados.add("executou");
	}
	
	@Test
	@AmbienteExecucaoTeste(ambiente = "PRD")
	public void testePrd1() {
		listaExecutados.add("executou");
	}

	@AfterClass
	public static void depoisDoTeste() {
		int totalEsperado = 1;
		assertEquals(totalEsperado, listaExecutados.size());
		Configuracoes.descarregar();
	}
}
