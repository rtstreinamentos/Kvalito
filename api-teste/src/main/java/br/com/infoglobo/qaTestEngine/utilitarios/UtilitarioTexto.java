package br.com.infoglobo.qaTestEngine.utilitarios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilitarioTexto {

	public static String extrair(String texto, String regexExtracao) {
		Pattern pattern = Pattern.compile(regexExtracao);
		Matcher matcher = pattern.matcher(texto);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	public static void escreverArquivo(String caminhoArquivo, String conteudo) throws Exception {
		BufferedWriter writer = null;
		File arquivo = new File(caminhoArquivo);
		writer = new BufferedWriter(new FileWriter(arquivo));
		writer.write(conteudo);
		writer.close();
		
		
	}
	
	

}
