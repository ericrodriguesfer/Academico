package br.com.eric.sistema.bancario.view;

import java.util.Scanner;

import br.com.eric.sistema.bancario.model.Conta;

public class ContaView {

	private static Scanner in = new Scanner(System.in);
	private Conta conta;

	public ContaView() {
		this.conta = new Conta();
	}

	public Conta getDataConta() {
		System.out.println("Digite a matricula do cliente (USE O FORMATO 000000):");
		this.conta.setMatricula(in.nextLine());

		System.out.println("Digite o nome do cliente:");
		this.conta.setNome(in.nextLine());

		System.out.println("Digite o CPF do cliente (USE O FORMATO 000.000.000-00):");
		this.conta.setCpf(in.nextLine());

		System.out.println("Digite o email do cliente:");
		this.conta.setEmail(in.nextLine());

		System.out.println("Digite a senha do cliente:");
		this.conta.setSenha(in.nextLine());

		System.out.println("Digite o saldo do cliente:");
		this.conta.setSaldo(Double.parseDouble(in.nextLine()));

		return this.conta;
	}

}
