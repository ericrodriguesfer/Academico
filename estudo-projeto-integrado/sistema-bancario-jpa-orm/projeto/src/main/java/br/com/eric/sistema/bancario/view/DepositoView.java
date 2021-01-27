package br.com.eric.sistema.bancario.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.eric.sistema.bancario.model.Conta;
import br.com.eric.sistema.bancario.model.Operacao;
import br.com.eric.sistema.bancario.controller.ControllerConta;

public class DepositoView {

	private static Scanner in = new Scanner(System.in);
	private static ControllerConta controllerConta;

	public DepositoView() {
		this.controllerConta = new ControllerConta();
	}

	public Object[] getDataDeposito() {
		List<Conta> retornoClientesConta = new ArrayList<Conta>();
		retornoClientesConta.addAll(controllerConta.listContas());

		for (int i = 0; i < retornoClientesConta.size(); i++) {
			System.out.println((i + 1) + " => Matricula: " + retornoClientesConta.get(i).getMatricula() + " | Nome: "
					+ retornoClientesConta.get(i).getNome() + " | Saldo: R$ " + retornoClientesConta.get(i).getSaldo());
		}

		System.out.println("Digite o número do cliente para o deposito: ");
		int indexConta = Integer.parseInt(in.nextLine());

		System.out
				.println("Digite o valor do deposito para " + retornoClientesConta.get(indexConta - 1).getNome() + ":");
		double valueDeposito = Double.parseDouble(in.nextLine());

		Conta conta = retornoClientesConta.get(indexConta - 1);
		conta.realizarDeposito(valueDeposito);

		Operacao operacao = new Operacao();
		operacao.setMatriculaConta(conta.getMatricula());
		operacao.setEmailConta(conta.getEmail());
		operacao.setTipo('D');
		operacao.setValor(valueDeposito);

		Object[] retornoDeposito = new Object[2];
		retornoDeposito[0] = conta;
		retornoDeposito[1] = operacao;

		return retornoDeposito;
	}

}
