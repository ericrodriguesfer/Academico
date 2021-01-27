package br.com.eric.sistema.bancario.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.eric.sistema.bancario.model.Conta;
import br.com.eric.sistema.bancario.model.Operacao;
import br.com.eric.sistema.bancario.model.Transacoes;
import br.com.eric.sistema.bancario.controller.ControllerConta;

public class TransferenciaView {

	private static Scanner in = new Scanner(System.in);
	private static ControllerConta controllerConta;

	public TransferenciaView() {
		this.controllerConta = new ControllerConta();
	}

	public Object[] getDataTransacaObjects() {
		List<Conta> retornoClientesConta = new ArrayList<Conta>();
		retornoClientesConta.addAll(controllerConta.listContas());

		for (int i = 0; i < retornoClientesConta.size(); i++) {
			System.out.println((i + 1) + " => Matricula: " + retornoClientesConta.get(i).getMatricula() + " | Nome: "
					+ retornoClientesConta.get(i).getNome() + " | Saldo: R$ " + retornoClientesConta.get(i).getSaldo());
		}

		System.out.println("Digite o número do cliente que fara a transferencia: ");
		int indexContaSend = Integer.parseInt(in.nextLine());
		Conta contaSend = retornoClientesConta.get(indexContaSend - 1);

		System.out.println("Digite o número do cliente que recebera a transferencia: ");
		int indexContaReceive = Integer.parseInt(in.nextLine());
		Conta contaReceive = retornoClientesConta.get(indexContaReceive - 1);

		System.out.println("O cliente " + contaSend.getNome() + ", pode transferir no maximo: " + contaSend.getSaldo());
		System.out.println("Digite o valor da transferencia: ");
		double valueTransferencia = Double.parseDouble(in.nextLine());

		while (valueTransferencia > contaSend.getSaldo()) {
			System.out.println(
					"O cliente " + contaSend.getNome() + ", pode transferir no maximo: " + contaSend.getSaldo());
			System.out.println("Digite o valor da transferencia: ");
			valueTransferencia = Double.parseDouble(in.nextLine());
		}

		contaSend.realizarSaque(valueTransferencia);
		contaReceive.realizarDeposito(valueTransferencia);

		Operacao operacaoSend = new Operacao();
		operacaoSend.setMatriculaConta(contaSend.getMatricula());
		operacaoSend.setEmailConta(contaSend.getEmail());
		operacaoSend.setTipo('E');
		operacaoSend.setValor(valueTransferencia);

		Operacao operacaoReceive = new Operacao();
		operacaoReceive.setMatriculaConta(contaReceive.getMatricula());
		operacaoReceive.setEmailConta(contaReceive.getEmail());
		operacaoReceive.setTipo('R');
		operacaoReceive.setValor(valueTransferencia);

		Transacoes transacao = new Transacoes();
		transacao.setMatriculaContaRealizou(contaSend.getMatricula());
		transacao.setEmailContaRealizou(contaSend.getEmail());
		transacao.setMatriculaContaRecebeu(contaReceive.getMatricula());
		transacao.setEmailContaRecebeu(contaReceive.getEmail());
		transacao.setValor(valueTransferencia);

		Object[] retornoTransacao = new Object[5];
		retornoTransacao[0] = contaSend;
		retornoTransacao[1] = contaReceive;
		retornoTransacao[2] = operacaoSend;
		retornoTransacao[3] = operacaoReceive;
		retornoTransacao[4] = transacao;

		return retornoTransacao;
	}

}
