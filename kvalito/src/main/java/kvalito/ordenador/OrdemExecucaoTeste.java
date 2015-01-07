package kvalito.ordenador;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OrdemExecucaoTeste {
	int Ordem();
}
