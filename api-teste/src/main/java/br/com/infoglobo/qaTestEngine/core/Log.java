package br.com.infoglobo.qaTestEngine.core;

public class Log {

	public static void registrarInformacao(String valorParaRegistrar) {
		System.out.println("[QA-API-INFO] " + valorParaRegistrar);
	}
	
	public static void registrarErro(Exception ex) {
		System.out.println("[QA-API-ERRO] ==================");
		System.out.println("TRACE: ");
		System.out.println(ex.toString());
		System.out.println("==========================");
	}

	public static void registrarAlerta(String valorParaRegistrar) {
		System.out.println("[QA-API-ATENÇÃO] " + valorParaRegistrar);
	}

	public static void registrarErro(String valorParaRegistrar) {
		System.out.println("[QA-API-ERRO] ==================");
		System.out.println("TRACE: " + valorParaRegistrar);
		System.out.println("==========================");
	}

	public static void registrarDebug(String valorParaRegistrar) {
		System.out.println("[QA-API-DEBUG] " + valorParaRegistrar);
	}
}
