package testes.junitRunnerCustomizado.assistentes;

import java.util.List;

import kvalito.core.Configuracoes;
import kvalito.junit.ExecutorJunitCustomizado;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class RunnerParaTesteQLT extends ExecutorJunitCustomizado {

	public RunnerParaTesteQLT(Class<?> klass) throws InitializationError {
		super(klass);

	}

	@Override
	protected List<FrameworkMethod> computeTestMethods() {
		Configuracoes.injetarConfiguracao("AmbienteExecucaoTeste", "QLT");
		return super.computeTestMethods();
	}
}
