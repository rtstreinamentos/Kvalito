package br.com.infoglobo.qaTestEngine.junit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AmbienteExecucaoTeste {
	String ambiente();
}
