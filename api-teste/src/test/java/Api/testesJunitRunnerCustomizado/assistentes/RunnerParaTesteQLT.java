package Api.testesJunitRunnerCustomizado.assistentes;

import java.util.List;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.junit.ExecutorJunitCustomizado;

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
