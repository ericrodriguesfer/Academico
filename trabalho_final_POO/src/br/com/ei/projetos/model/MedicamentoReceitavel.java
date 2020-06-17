package br.com.ei.projetos.model;

public class MedicamentoReceitavel extends Medicamento {
	
	private Receita receita;
	
	public MedicamentoReceitavel() {
		receita  = new Receita(); 
	}
	
	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	@Override
	public String toString() {
		return "MedicamentoReceitavel [Nome: " + this.nome + " Gênero: " + this.genero + "Marca: " + this.marca + "Código: " + this.codigo
				+ "Preço: " + this.preco + 
				" Receita[Nome do Médico: " + this.receita.getNomeDoMedico() + " Instituição: " + this.receita.getInstituicao()+" Data de Prescrição: "+ this.receita.getDataPrescricao() + " Data de Validade: " + this.receita.getDataValidade()+"]";
	}
	
	
	
	

}
