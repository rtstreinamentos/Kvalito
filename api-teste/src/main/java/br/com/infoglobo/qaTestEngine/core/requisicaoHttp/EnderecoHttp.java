package br.com.infoglobo.qaTestEngine.core.requisicaoHttp;

import java.net.HttpCookie;
import java.util.List;

public class EnderecoHttp {

	private String url;
	private String body;
	private int httpStatusCode;
	private List<HttpCookie> cookies;

	public EnderecoHttp() {
		this.url = "";
		this.httpStatusCode = 0;
	}

	public EnderecoHttp(String url, int httpStatusCode) {
		this.url = url;
		this.httpStatusCode = httpStatusCode;
	}

	public EnderecoHttp(String url, int httpStatusCode, List<HttpCookie> cookies, String body) {
		this.url = url;
		this.httpStatusCode = httpStatusCode;
		this.cookies = cookies;
		this.body = body;
	}

	public String getUrl() {
		return url;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public HttpCookie getCookie(String nome) {

		for (HttpCookie cookie : this.cookies) {
			if (cookie.getName().equals(nome)) {
				return cookie;
			}
		}

		return new HttpCookie("COOKIE_NAO_ENCONTRADO","COOKIE_NAO_ENCONTRADO");

	}

	public List<HttpCookie> getCookies() {
		return this.cookies;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
    public String getBody() {
    	return this.body;
    }
	
    public void setBody(String body) {
    	this.body = body;
    }

}

