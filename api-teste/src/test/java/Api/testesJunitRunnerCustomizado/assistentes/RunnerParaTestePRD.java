package Api.testesJunitRunnerCustomizado.assistentes;

import java.util.List;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.junit.ExecutorJunitCustomizado;

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
