package testes.junitRunnerCustomizado;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import kvalito.core.Configuracoes;
import kvalito.junit.AmbienteExecucaoTeste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.junitRunnerCustomizado.assistentes.RunnerParaTesteQLT;

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
