package br.com.ei.projetos.model;

public class Medicamento extends Produto{

	protected boolean receita;
	protected String tipo;
	protected String orgaoRegulador;
	
	public Medicamento() {
		super();
	}
	
	public Medicamento(String nome, String genero, String marca, String codigo, double preco, boolean receita, String tipo, String orgaoRegulador) {
		super(nome, genero, marca, codigo, preco);
		this.receita = receita;
		this.tipo = tipo;
		this.orgaoRegulador = orgaoRegulador;
	}

	public boolean isReceita() {
		return this.receita;
	}

	public void setReceita(boolean receita) {
		this.receita = receita;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrgaoRegulador() {
		return this.orgaoRegulador;
	}

	public void setOrgaoRegulador(String orgaoRegulador) {
		this.orgaoRegulador = orgaoRegulador;
	}

	@Override
	public String toString() {
		return "Medicamento [Nome: " + this.nome + " Gênero: " + this.genero + " Marca: " + this.marca + " Código: " + this.codigo
				+ " Preço: " + this.preco + " Receita: " + this.receita + " Tipo: " + this.tipo
				+ " Orgão Regulador: " + this.orgaoRegulador + "]";
	}
	
	
}
