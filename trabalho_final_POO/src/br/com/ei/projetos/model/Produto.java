package br.com.ei.projetos.model;

public abstract class Produto {
	
	protected String nome;
	protected String genero;	
	protected String marca;
	protected String codigo;
	protected double preco;
	
	
	public Produto() {}
	
	public Produto(String nome, String genero, String marca, String codigo, double preco){
		this.nome = nome;
		this.genero = genero;
		this.marca = marca;
		this.codigo = codigo;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [Nome: " + this.nome + " Gênero: " + this.genero + " Marca: " + this.marca + " Código: " + this.codigo + " Preço: " 
				+ this.preco + "]";
	}

	
	
	
	
	
	
}
