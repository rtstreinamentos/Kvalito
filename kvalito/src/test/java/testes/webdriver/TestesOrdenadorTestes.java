package testes.webdriver;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import kvalito.ordenador.OrdemExecucaoTeste;
import kvalito.ordenador.OrdenadorTestes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(OrdenadorTestes.class)
public class TestesOrdenadorTestes {
	private static List<Integer> listaDeOrdemTeste;
	
	@BeforeClass
	public static void iniciarTestes() {
		listaDeOrdemTeste = new ArrayList<Integer>();
	}
	
	@AfterClass
	public static void finalizarTeste() {
		for (Integer i = 0; i < listaDeOrdemTeste.size(); i++) {
			assertEquals(i, listaDeOrdemTeste.get(i));
		}
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem=1)
	public void teste1() {
		listaDeOrdemTeste.add(0);
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem=2)
	public void teste2() {
		listaDeOrdemTeste.add(1);
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem=3)
	public void teste10() {
		listaDeOrdemTeste.add(2);
	}
	
	@Test
	@OrdemExecucaoTeste(Ordem=3)
	public void teste5() {
		listaDeOrdemTeste.add(3);
	}
}
