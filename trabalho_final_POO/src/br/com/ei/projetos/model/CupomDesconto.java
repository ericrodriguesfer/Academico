package br.com.ei.projetos.model;

public class CupomDesconto {
	
	private String nomePromocao;
	private String codigoDesconto;
	private int porcentagemDesconto;
	
	public CupomDesconto() {}
	
	public CupomDesconto(String nomePromocao, String codigoDesconto, int porcentagemDesconto) {
		super();
		this.nomePromocao = nomePromocao;
		this.codigoDesconto = codigoDesconto;
		this.porcentagemDesconto = porcentagemDesconto;
	}
	
	public String getNomePromocao() {
		return nomePromocao;
	}
	public void setNomePromocao(String nomePromocao) {
		this.nomePromocao = nomePromocao;
	}
	public String getCodigoDesconto() {
		return codigoDesconto;
	}
	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}
	public int getPorcentagemDesconto() {
		return porcentagemDesconto;
	}
	public void setPorcentagemDesconto(int porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	@Override
	public String toString() {
		return "CupomDesconto [Nome da Promoção: " + this.nomePromocao + "Código de Desconto: " + this.codigoDesconto
				+ "Porcentagem de Desconto: " + this.porcentagemDesconto + "]";
	}
	
	
	
}
