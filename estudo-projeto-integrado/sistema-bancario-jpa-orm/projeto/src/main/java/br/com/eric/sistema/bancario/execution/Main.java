package br.com.eric.sistema.bancario.execution;

import java.util.Scanner;

import br.com.eric.sistema.bancario.controller.ControllerBanco;
import br.com.eric.sistema.bancario.controller.ControllerConta;
import br.com.eric.sistema.bancario.controller.ControllerOperacao;
import br.com.eric.sistema.bancario.controller.ControllerTransacoes;
import br.com.eric.sistema.bancario.model.Conta;
import br.com.eric.sistema.bancario.model.Operacao;
import br.com.eric.sistema.bancario.model.Transacoes;
import br.com.eric.sistema.bancario.view.ContaView;
import br.com.eric.sistema.bancario.view.DepositoView;
import br.com.eric.sistema.bancario.view.SaqueView;
import br.com.eric.sistema.bancario.view.TransferenciaView;

public class Main {

	private static Scanner in = new Scanner(System.in);
	private static ControllerBanco controllerBanco = new ControllerBanco();
	private static ControllerConta controllerConta = new ControllerConta();
	private static ControllerOperacao controllerOperacao = new ControllerOperacao();
	private static ControllerTransacoes controllerTransacoes = new ControllerTransacoes();
	private static ContaView contaView = new ContaView();
	private static DepositoView depositoView = new DepositoView();
	private static SaqueView saqueView = new SaqueView();
	private static TransferenciaView transferenciaView = new TransferenciaView();
	private static boolean menu = true;

	public static void main(String[] args) {
		while (menu) {
			System.out.println("1 - Cadastrar um novo cliente");
			System.out.println("2 - Fazer deposito para cliente");
			System.out.println("3 - Fazer saque para cliente");
			System.out.println("4 - Fazer transferencia entre clientes");
			int chooseActionBanco = Integer.parseInt(in.nextLine());

			switch (chooseActionBanco) {
			case 1:
				controllerConta.createConta(contaView.getDataConta());
				break;

			case 2:
				if (controllerBanco.totalClient() >= 1) {
					Object[] retornoDepositoViewObjects = depositoView.getDataDeposito();
					controllerConta.depositoConta((Conta) retornoDepositoViewObjects[0]);
					controllerOperacao.createOperacao((Operacao) retornoDepositoViewObjects[1]);
				} else {
					System.out.println("Para realizar um deposito precisa existir ao menos um cliente!");
					System.out.println("Cadastre pelo menos um cliente para fazer um deposito a ele!");
				}

				break;

			case 3:
				if (controllerBanco.totalClient() >= 1) {
					Object[] retornoSaqueViewObjects = saqueView.getDataSaqueObjects();
					controllerConta.depositoConta((Conta) retornoSaqueViewObjects[0]);
					controllerOperacao.createOperacao((Operacao) retornoSaqueViewObjects[1]);
				} else {
					System.out.println("Para realizar um saque precisa existir ao menos um cliente!");
					System.out.println("Cadastre pelo menos um cliente para fazer um saque a ele!");				
				}

				break;

			case 4:
				if (controllerBanco.totalClient() >= 2) {
					Object[] retornoTransferenciaView = transferenciaView.getDataTransacaObjects();

					controllerConta.saqueConta((Conta) retornoTransferenciaView[0]);
					controllerConta.depositoConta((Conta) retornoTransferenciaView[1]);
					controllerOperacao.createOperacao((Operacao) retornoTransferenciaView[2]);
					controllerOperacao.createOperacao((Operacao) retornoTransferenciaView[3]);
					controllerTransacoes.crateTransacao((Transacoes) retornoTransferenciaView[4]);
				} else {
					System.out.println("Para realizar uma transferencia precisa existir ao menos dois cliente!");
					System.out.println("Cadastre pelo menos dois cliente para fazer uma transferencia entre eles!");
				}

				break;

			default:
				menu = false;
			}
		}

	}

}
