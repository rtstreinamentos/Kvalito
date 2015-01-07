package testes.junitRunnerCustomizado.assistentes;

import java.util.List;

import kvalito.core.Configuracoes;
import kvalito.junit.ExecutorJunitCustomizado;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class RunnerParaTestePRD extends ExecutorJunitCustomizado {

	public RunnerParaTestePRD(Class<?> klass) throws InitializationError {
		super(klass);
		
	}

	@Override
	protected List<FrameworkMethod> computeTestMethods() {		
		Configuracoes.injetarConfiguracao("AmbienteExecucaoTeste", "PRD");
		return super.computeTestMethods();
	}
}
