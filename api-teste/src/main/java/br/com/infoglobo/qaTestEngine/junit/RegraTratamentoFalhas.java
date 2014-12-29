package br.com.infoglobo.qaTestEngine.junit;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import br.com.infoglobo.qaTestEngine.core.Configuracoes;
import br.com.infoglobo.qaTestEngine.core.Log;
import br.com.infoglobo.qaTestEngine.core.Navegador;

public class RegraTratamentoFalhas implements MethodRule {

	public Statement apply(final Statement base, final FrameworkMethod metodo, Object target) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				Throwable pegarErro = null;
				String valorChave = Configuracoes.getConfiguracaoPrincipal("quantidade-reexecucoes-falhas");
				int tentativas = Integer.parseInt(valorChave);
				String nomeTeste = metodo.getName();

				for (int i = 1; i <= tentativas; i++) {
					try {
						base.evaluate();
						return;
					} catch (Throwable t) {
						pegarErro = t;
						String mensagemLog = String.format("Reexecutando teste que falhou [%s - Tentativa %d]", nomeTeste, i);
						Log.registrarInformacao(mensagemLog);
					}
				}
				Navegador.capturarPrintTela(nomeTeste);
				Navegador.gravarCodigoFontePagina(nomeTeste);
				throw pegarErro;
			}

		};
	}
}
