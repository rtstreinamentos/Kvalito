package testes.junitRunnerCustomizado;

import static org.junit.Assert.assertEquals;
import kvalito.core.Configuracoes;
import kvalito.junit.AmbienteExecucaoTeste;
import kvalito.ordenador.OrdemExecucaoTeste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import testes.junitRunnerCustomizado.assistentes.RunnerParaTesteQLT;

@RunWith(RunnerParaTesteQLT.class)
public class TestesExecutarMarcadosParaAmbienteEmOrdem {

	private static String executados;

	@BeforeClass
	public static void antesDoTeste() {
		executados = "";
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "QLT")
	@OrdemExecucaoTeste(Ordem = 1)
	public void testePrdQlt1() {
		executados += "1";
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "QLT")
	@OrdemExecucaoTeste(Ordem = 3)
	public void testeQlt1() {
		executados += "3";
	}

	@Test
	@AmbienteExecucaoTeste(ambiente = "QLT")
	@OrdemExecucaoTeste(Ordem = 2)
	public void testeSemAnotacaoAmbiente() {
		executados += "2";
	}
	
	@Test
	@AmbienteExecucaoTeste(ambiente = "QLT")
	public void testeSemAnotacaoAmbienteEOrdem() {
		executados += "4";
	}
	
	@Test
	@AmbienteExecucaoTeste(ambiente = "PRD")
	public void testePrd() {
		executados += "000000004";
	}

	@AfterClass
	public static void depoisDoTeste() {
		String executadosEsperados = "1234";
		assertEquals(executadosEsperados, executados);
		Configuracoes.descarregar();
	}

}
