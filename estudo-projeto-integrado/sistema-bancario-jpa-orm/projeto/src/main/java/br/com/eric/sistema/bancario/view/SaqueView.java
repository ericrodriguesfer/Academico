package br.com.eric.sistema.bancario.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.eric.sistema.bancario.model.Conta;
import br.com.eric.sistema.bancario.model.Operacao;
import br.com.eric.sistema.bancario.controller.ControllerConta;

public class SaqueView {
	
	private static Scanner in = new Scanner(System.in);
	private static ControllerConta controllerConta;

	public SaqueView() {
		this.controllerConta = new ControllerConta();
	}

	public Object[] getDataSaqueObjects() {
		List<Conta> retornoClientesConta = new ArrayList<Conta>();
		retornoClientesConta.addAll(controllerConta.listContas());

		for (int i = 0; i < retornoClientesConta.size(); i++) {
			System.out.println((i + 1) + " => Matricula: " + retornoClientesConta.get(i).getMatricula() + " | Nome: "
					+ retornoClientesConta.get(i).getNome() + " | Saldo: R$ " + retornoClientesConta.get(i).getSaldo());
		}

		System.out.println("Digite o número do cliente para o saque: ");
		int indexConta = Integer.parseInt(in.nextLine());

		System.out.println("O cliente" + retornoClientesConta.get(indexConta - 1).getNome() + ", pode sacar no máximo: "
				+ retornoClientesConta.get(indexConta - 1).getSaldo());
		System.out.println("Digite o valor do saque: ");
		double valueSaque = Double.parseDouble(in.nextLine());

		while (valueSaque > retornoClientesConta.get(indexConta - 1).getSaldo()) {
			System.out.println("Este cliente não tem esse saldo todo, ele so pode sacar ate: "
					+ retornoClientesConta.get(indexConta - 1).getSaldo());
			System.out.println("Digite o valor do saque: ");
			valueSaque = Double.parseDouble(in.nextLine());
		}

		Conta conta = retornoClientesConta.get(indexConta - 1);
		conta.realizarSaque(valueSaque);

		Operacao operacao = new Operacao();
		operacao.setMatriculaConta(conta.getMatricula());
		operacao.setEmailConta(conta.getEmail());
		operacao.setTipo('S');
		operacao.setValor(valueSaque);

		Object[] retornoSaque = new Object[2];
		retornoSaque[0] = conta;
		retornoSaque[1] = operacao;

		return retornoSaque;
	}

}
