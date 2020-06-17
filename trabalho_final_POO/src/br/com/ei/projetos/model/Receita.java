package br.com.ei.projetos.model;

import java.util.Scanner;
import java.time.LocalDate;

public class Receita {
	private String nomeDoMedico;
	private String instituicao;
	private LocalDate dataPrescricao;
	private LocalDate dataValidade;
	
	Scanner ler = new Scanner(System.in);
	
	/*
	Calendar hoje = Calendar.getInstance();
	int ano = hoje.get(Calendar.YEAR);
	int mes = hoje.get(Calendar.MONTH);
	int diaMes = hoje.get(Calendar.DAY_OF_YEAR);
	*/
	
	public Receita() {
		super();
	}
	
	public Receita(String nomeDoMedico, String instituicao, LocalDate dataPrescricao, LocalDate dataValidade) {
		super();
		this.nomeDoMedico = nomeDoMedico;
		this.instituicao = instituicao;
		this.setDataPrescricao(dataPrescricao);
		this.dataValidade = dataValidade;
	}

	public String getNomeDoMedico() {
		return this.nomeDoMedico;
	}

	public void setNomeDoMedico(String nomeDoMedico) {
		this.nomeDoMedico = nomeDoMedico;
	}

	public String getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public LocalDate getDataPrescricao() {
		return this.dataPrescricao;
	}

	public void setDataPrescricao(LocalDate dataPrescricao) {
		this.dataPrescricao = dataPrescricao;
	}

	public LocalDate getDataValidade() {
		return this.dataValidade;
	}

	public void setDataValidade(LocalDate dataPrescricao) {
		this.dataValidade = this.getDataPrescricao().plusDays(180);
	}
	
	
	
	
}
