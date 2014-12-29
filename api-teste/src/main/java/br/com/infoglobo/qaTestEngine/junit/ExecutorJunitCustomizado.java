package br.com.infoglobo.qaTestEngine.junit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.core.Log;
import br.com.infoglobo.qaTestEngine.ordenador.OrdemExecucaoTeste;

public class ExecutorJunitCustomizado extends BlockJUnit4ClassRunner {
	private static final String CHAVE_AMBIENTE_EXECUCAO = "AmbienteExecucaoTeste";

	public ExecutorJunitCustomizado(Class<?> klass)
			throws org.junit.runners.model.InitializationError {
		super(klass);
	}

	@Override
	protected List<FrameworkMethod> computeTestMethods() {
		List<FrameworkMethod> listaDeTestesQueDevemSerExecutados = null;
		try {
			listaDeTestesQueDevemSerExecutados = this.filtrarTestesPorAmbiente(super.computeTestMethods());
			listaDeTestesQueDevemSerExecutados = this.ordenarTestePorOrdemDeExecucao(listaDeTestesQueDevemSerExecutados);
		} catch (Exception e) {
			Log.registrarErro(e);
		}
		
		return listaDeTestesQueDevemSerExecutados;
	}

	private List<FrameworkMethod> filtrarTestesPorAmbiente(
			List<FrameworkMethod> listaDeTestesDaClasse) throws Exception {
		String ambienteEmExecucaoConfigurado = Configuracoes
				.obterConfiguracaoDaChave(CHAVE_AMBIENTE_EXECUCAO);
		List<FrameworkMethod> listaFiltrada = new ArrayList<FrameworkMethod>();

		for (FrameworkMethod teste : listaDeTestesDaClasse) {
			AmbienteExecucaoTeste ambienteExecucaoTeste = teste
					.getAnnotation(AmbienteExecucaoTeste.class);
			if (ambienteExecucaoTeste == null
					|| ambienteExecucaoTeste.ambiente().contains(
							ambienteEmExecucaoConfigurado)) {
				listaFiltrada.add(teste);
			}
		}

		return listaFiltrada;
	}

	private List<FrameworkMethod> ordenarTestePorOrdemDeExecucao(final List<FrameworkMethod> listaDesordenada) {
		List<FrameworkMethod> listaFiltrada = new ArrayList<FrameworkMethod>();
		for (FrameworkMethod teste : listaDesordenada) {
			OrdemExecucaoTeste ordemExecucaoTeste = teste.getAnnotation(OrdemExecucaoTeste.class);
			if (ordemExecucaoTeste != null) {
				listaFiltrada.add(teste);
			}
		}
		
		Collections.sort(listaFiltrada, new Comparator<FrameworkMethod>() {
			public int compare(FrameworkMethod f1, FrameworkMethod f2) {
				OrdemExecucaoTeste item1 = f1
						.getAnnotation(OrdemExecucaoTeste.class);
				OrdemExecucaoTeste item2 = f2
						.getAnnotation(OrdemExecucaoTeste.class);

				if (item1 == null || item2 == null) {
					return -1;
				}

				return item1.Ordem() - item2.Ordem();
			}
		});
		
		for (FrameworkMethod teste : listaDesordenada) {
			OrdemExecucaoTeste ordemExecucaoTeste = teste.getAnnotation(OrdemExecucaoTeste.class);
			if (ordemExecucaoTeste == null) {
				listaFiltrada.add(teste);
			}
		}
		
		return listaFiltrada;
	}

}