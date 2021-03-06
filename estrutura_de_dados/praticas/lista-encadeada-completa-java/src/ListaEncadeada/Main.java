package ListaEncadeada;

import java.util.Scanner;

public class Main {
	final static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		Lista lista = new Lista();
		boolean menu = true;
		int escolhaAcao;
		int valor;
		int indice;
		
		while (menu) {
			System.out.println("1 - Inserir no inicio da lista");
			System.out.println("2 - Inserir no em na lista");
			System.out.println("3 - Inserir no meio da lista");
			System.out.println("4 - Inserir no fim da lista");
			System.out.println("5 - Remover no inicio da lista");
			System.out.println("6 - Remover no em na lista");
			System.out.println("7 - Remover no meio da lista");
			System.out.println("8 - Remover no fim da lista");
			System.out.println("9 - Remover elemento da lista");
			System.out.println("10 - Checar elemento na lista");
			System.out.println("11 - Exibir a lista");
			System.out.println("12 - Exibir tamanho da lista");
			System.out.println("13 - Ordenar a lista");
			System.out.println("14 - Encerrar");
			System.out.println("Digite a acao de deseja executar: ");
			escolhaAcao = Integer.parseInt(ler.nextLine());
			
			switch (escolhaAcao) {
				case 1:
					System.out.println("Digite o n�mero de deseja inserir: ");
					valor = Integer.parseInt(ler.nextLine());
					
					if (lista.inserirNoInicio(valor)) {
						System.out.println("SUCESSO: Valor inserido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi inserido!!!");
					}
					
					break;
					
				case 2:
					if (lista.tamanho() == 0) {
						System.out.println("ERRO: A lista n�o possui tamanho para inseir no meio!!!");
						System.out.println("DICA: Execute ao menos duas insercoes ao inicio!!!");
					} else {
						System.out.println("Digite o n�mero de deseja inserir: ");
						valor = Integer.parseInt(ler.nextLine());
						
						System.out.println("======= INDICES ATUAIS DA LISTA =======");
						lista.exibirIndices();
						
						System.out.println("Digite o indice onde inserir esse valor: ");
						indice = Integer.parseInt(ler.nextLine());
						
						if (lista.inserirEm(valor, indice)) {
							System.out.println("SUCESSO: Valor inserido com sucesso!!!");
						} else {
							System.out.println("ERRO: Valor n�o foi inserido!!!");
						}
					}
					
					break;
				
				case 3:
					System.out.println("Digite o n�mero de deseja inserir: ");
					valor = Integer.parseInt(ler.nextLine());
					
					if (lista.inserirNoMeio(valor)) {
						System.out.println("SUCESSO: Valor inserido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi inserido!!!");
					}
					
					break;
					
				case 4:
					System.out.println("Digite o n�mero de deseja inserir: ");
					valor = Integer.parseInt(ler.nextLine());
					
					if (lista.inserirNoFim(valor)) {
						System.out.println("SUCESSO: Valor inserido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi inserido!!!");
					}
					
					break;
					
				case 5:
					if (lista.removerNoInicio()) {
						System.out.println("SUCESSO: Valor removido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi removido!!!");
					}
					
					break;
					
				case 6:
					System.out.println("======= INDICES ATUAIS DA LISTA =======");
					lista.exibirIndices();
					
					System.out.println("Digite o indice no qual deseja remover um valor: ");
					indice = Integer.parseInt(ler.nextLine());
					
					if (lista.removerEm(indice)) {
						System.out.println("SUCESSO: Valor removido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi removido!!!");
					}
					
					break;
					
				case 7:
					if (lista.removerNoMeio()) {
						System.out.println("SUCESSO: Valor removido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi removido!!!");
					}
					
					break;
					
				case 8:
					if (lista.removerNoFim()) {
						System.out.println("SUCESSO: Valor removido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi removido!!!");
					}
					
					break;
					
				case 9:
					System.out.println("Digite o elemento que deseja remover: ");
					valor = Integer.parseInt(ler.nextLine());
					
					if (lista.remover(valor)) {
						System.out.println("SUCESSO: Valor removido com sucesso!!!");
					} else {
						System.out.println("ERRO: Valor n�o foi removido!!!");
					}
					
					break;
					
				case 10:
					System.out.println("Digite o elemento que deseja buscar: ");
					valor = Integer.parseInt(ler.nextLine());
					
					if (lista.pertence(valor)) {
						System.out.println("SUCESSO: Valor esta na lista!!!");
					} else {
						System.out.println("ERRO: Valor nao esta na lista!!!");
					}
					
					break;
					
				case 11:
					lista.exibirLista();
					
					break;
					
				case 12:
					System.out.println("Tamanho da lista: " + lista.tamanho());
					
					break;
					
				case 13:
					lista.ordenar();
					
					break;
					
				default:
					menu = false;
					System.exit(0);
					
					break;
			}
		}
	}
}
