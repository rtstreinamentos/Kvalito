package kvalito.core.requisicaoHttp;

public class CabecalhoHttp {
	
	private String nome;
	private String valor;
	
	public CabecalhoHttp(String nome, String valor) {
		this.nome=nome;
		this.valor=valor;
	}

	public String getNome() {
		return nome;
	}

	public String getValor() {
		return valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return this.nome + ": " + this.valor;
	}
}
