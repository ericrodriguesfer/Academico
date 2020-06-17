package br.com.ei.projetos.model;

public class Camisinha extends Produto{
	
	private String sabor;

	public Camisinha() {
		super();
	}

	public Camisinha(String nome, String genero, String marca, String codigo, double preco, String sabor) {
		super(nome, genero, marca, codigo, preco);
		this.sabor = sabor;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public String toString() {
		return "Camisinha [Nome: " + this.nome + " Gênero: " + this.genero + " Marca: " + this.marca + " Código: " + this.codigo + " Preço: "
				+ preco + " Sabor: " + this.sabor + "]";
	}
	
	
	
	
	
	
}
