package kvalito.conversores;

import org.apache.commons.lang3.StringUtils;

public class ConveteCor {

	public static String converterRgbParaHexadecimal(String corRgb) throws Exception {

		if (StringUtils.isBlank(corRgb)) throw new Exception("Favor informar a cor RGB! Exemplo: rgb(0,0,0)");
		
		String rgb[] = corRgb.trim().replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))", "")
				.split(",");
		
		String hexadecimal = String.format("#%s%s%s",
				extrairHexadecimal(Integer.parseInt(rgb[0])),
				extrairHexadecimal(Integer.parseInt(rgb[1])),
				extrairHexadecimal(Integer.parseInt(rgb[2])));

		return hexadecimal;

	}

	private static String extrairHexadecimal(int number) {
		StringBuilder builder = new StringBuilder(
				Integer.toHexString(number & 0xff));
		while (builder.length() < 2) {
			builder.append("0");
		}
		return builder.toString().toUpperCase();
	}

}
