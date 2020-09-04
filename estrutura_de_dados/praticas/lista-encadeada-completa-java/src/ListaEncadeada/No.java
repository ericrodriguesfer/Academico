package ListaEncadeada;

public class No {
	private int valor;
	private No proximo;
	
	public No () {
		this.valor = Integer.MAX_VALUE;
		this.proximo = null;
	}

	public No (int valor, No proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getProximo() {
		return proximo;
	}

	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
}
