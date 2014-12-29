package Api.testesJunitRunnerCustomizado;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import Api.testesJunitRunnerCustomizado.assistentes.RunnerParaTestePRD;
import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.junit.AmbienteExecucaoTeste;

@RunWith(RunnerParaTestePRD.class)
public class TestesExecutarSomenteMarcadosParaPRD {

	private static ArrayList<String> listaExecutados;

	@BeforeClass
	public static void antesDoTeste() {
		listaExecutados = new ArrayList<String>();
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "PRD")
	public void testePrd1() {
		listaExecutados.add("executou PRD1");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "PRD")
	public void testePrd2() {
		listaExecutados.add("executou PRD2");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "QLT")
	public void testeQlt1() {
		listaExecutados.add("executou QLT");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "STG")
	public void testeStg1() {
		listaExecutados.add("executou STG1");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "STG")
	public void testeStg4() {
		listaExecutados.add("executou STG4");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "STG")
	public void testeStg2() {
		listaExecutados.add("executou STG2");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "STG")
	public void testeStg3() {
		listaExecutados.add("executou STG3");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "STG-TESTE")
	public void testeStgTeste1() {
		listaExecutados.add("executou STG-TESTE1");
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "STG-TESTE")
	public void testeStgTeste2() {
		listaExecutados.add("executou STG-TESTE2");
	}
	
	@AfterClass
	public static void depoisDoTeste() {
		int totalEsperado = 2;
		assertEquals(totalEsperado,listaExecutados.size());
		Configuracoes.descarregar();
	}
	
}
