package br.com.ei.projetos.exec;

import java.util.Scanner;

import br.com.ei.projetos.model.Balconista;
import br.com.ei.projetos.model.Cliente;
import br.com.ei.projetos.model.EstoqueImpl;
import br.com.ei.projetos.model.Farmaceutico;
import br.com.ei.projetos.model.FarmaciaImpl;
import br.com.ei.projetos.model.Gerente;
import br.com.ei.projetos.model.Pedido;

public class Principal {
	static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		Farmaceutico farmaceutico = new Farmaceutico();
		Balconista balconista = new Balconista();
		Cliente cliente = new Cliente();
		Pedido pedido = new Pedido();
		FarmaciaImpl farma = new FarmaciaImpl();
		EstoqueImpl estoque = new EstoqueImpl();
		boolean menuPrincipal = true;
		boolean menuLogin = true;
		boolean menuGerente = true;
		while (menuPrincipal) {
			menuPrincipal = true;
			menuLogin = true;
			menuGerente = true;
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("####---Pharmacy Made Yeasy---####");
			System.out.println("1------------Abrir Farmácia-----------");
			System.out.println("2---------Gerenciar Farmácia----------");
			System.out.println("3--------------Contato----------------");
			System.out.println("4---------------Sobre-----------------");
			System.out.println("5----------------Sair-----------------");
			System.out.println("Por Favor, Digite a Opção desejada Para Prosseguir: ");

			int opMenuPrincipal = Integer.parseInt(ler.nextLine());
			switch (opMenuPrincipal) {
			case 1:
				farma.criarFarmacia();
				break;
			case 2:
				menuLogin = true;
				while (menuLogin) {
					System.out.println("1----Login----");
					System.out.println("2----Retornar Para o Menu Principal----");
					System.out.println("Para Prosseguir, digite a Opção desejada a baixo: ");
					int opMenuLogin = Integer.parseInt(ler.nextLine());
					if (opMenuLogin == 1) {
						System.out.println("Digite o login: ");
						String login = ler.nextLine();
						System.out.println("Digite a senha: ");
						String senha = ler.nextLine();
						System.out.println("Os Dados Estão Sendo Verificados em Nosso Banco de Dados!");
						System.out.println("Aguarde um Instante...");
						System.out.println(
								"-------------------------------------------------------------------------------------------------------------------------------");
						boolean checkLogin = farma.checarLogin(login, senha);
						if (checkLogin == false) {
							System.out.println("Login ou Senha Inexistente(s)");
							menuLogin = false;
						} else if (checkLogin == true) {
							int retorno = farma.checaInstanciaLogin(login);
							if (retorno == 1) {
								while (menuGerente) {
									System.out.println("Menu com Nível de Acesso Para: Gerente");
									System.out.println(
											"Você Deseja Acessar o Menu de Gerência de Produtos ou de Usuários ?");
									System.out.println("Menu de Usuários---> Digite 1");
									System.out.println("Menu de Produtos---> Digite 2");
									System.out.println("Voltar para o Menu Anterior----> Digite 3");
									int opMenuGerente = Integer.parseInt(ler.nextLine());
									if (opMenuGerente == 1) {
										System.out.println("Menu---> Âmbito de Controle de Usuários");
										System.out.println("1---Cadastrar Usuário---");
										System.out.println("2---Remover Usuário---");
										System.out.println("3---Buscar Usuário---");
										System.out.println("4---Listar Usuários---");
										System.out.println("5----Sair----");
										System.out.println("Digite a Opção Desejada: ");
										int acaoGerente = Integer.parseInt(ler.nextLine());
										switch (acaoGerente) {
										case 1:
											farma.adicionarUsuario();
											break;
										case 2:
											farma.removerUsuario();
											break;
										case 3:
											farma.buscarUsuario();
											break;
										case 4:
											farma.listarUsuario();
											break;
										case 5:
											menuLogin = false;
											break;
										default:
											System.out.println("Opção Inválida!");
											menuGerente = false;
											break;
										}

									} else if (opMenuGerente == 2) {
										System.out.println("Qual Operação Você deseja Realizar ? ");
										System.out.println("1---> Adicionar Produto ao Estoque");
										System.out.println("2---> Remover Produto do Estoque");
										System.out.println("3---> Buscar Produto no Estoque");
										System.out.println("4---> Listar Produtos");
										System.out.println("5---> Sair");
										int op3 = Integer.parseInt(ler.nextLine());
										switch (op3) {
										case 1:
											estoque.adicionarProduto();
											break;

										case 2:
											estoque.removerProduto();
											break;

										case 3:
											estoque.buscarProduto();
											break;

										case 4:
											estoque.listarProduto();
											break;

										default:
											System.out.println("Opção Inválida!");
											menuGerente = false;
											break;
										}
									} else if (opMenuGerente == 3) {
										menuGerente = false;
									}
								}
							} else if (retorno == 2) {
								int opMenuBalconista;
								System.out.println("Digite a Opção Desejada, abaixo: ");
								System.out.println("MENU com Acesso para Balconista: ");
								System.out.println("1---> Buscar Produto");
								System.out.println("2---> Listar Produtos");
								opMenuBalconista = Integer.parseInt(ler.nextLine());
								if (opMenuBalconista == 1) {
									estoque.buscarProduto();
								} else if (opMenuBalconista == 2) {
									estoque.listarProduto();
								} else {
									System.out.println("Opção Inválida");
								}
							} else if (retorno == 3) {
								int opMenuFarmaceutico;
								System.out.println("Digite a Opção Desejada, abaixo: ");
								System.out.println("MENU com Acesso para Farmacêutico");
								System.out.println("1---> Adicionar Produto");
								System.out.println("2---> Remover Produto");
								System.out.println("3---> Buscar Produto");
								System.out.println("4---> Listar Produtos ");
								System.out.println("5---> Sair");
								opMenuFarmaceutico = Integer.parseInt(ler.nextLine());
								switch (opMenuFarmaceutico) {
								case 1:
									estoque.adicionarProduto();
									break;
								case 2:
									estoque.removerProduto();
									break;
								case 3:
									estoque.buscarProduto();
									break;
								case 4:
									estoque.listarProduto();
								default:
									System.out.println("Opção Inválida! ");
									menuLogin = false;
									break;
								}
							} else if (retorno == 4) {
								System.out.println("Menu de Opções do Cliente: ");
								System.out.println("1---> Realizar Pedido");
								System.out.println("2---> Verificar Seu Pedido");
								System.out.println("3---> Calcular Valor do Pedido");
								System.out.println("Digite abaixo a Opção Desejada: ");
								int opCliente = Integer.parseInt(ler.nextLine());
								switch (opCliente) {
								case 1:
									pedido.realizarPedido();
									break;

								case 2:
									pedido.verificarPedidoParticular();
									break;

								case 3:
									pedido.calcularPedido();
									break;

								default:
									System.out.println("Opção Inválida!");
								}
							} else {
								System.out.println("O Login deste Cargo Não está Cadastrado");
								menuLogin = false;
							}
						}
					} else if (opMenuLogin == 2) {
						menuLogin = false;

					} else {
						System.out.println("Opção Inválida!");
					}
				}
				break;
			case 3:
				System.out.println("Essas são as nossas opções para Contato: ");
				System.out.println("Vem ser um Cliente VIP!");
				System.out.println("Ítalo Lima: ");
				System.out.println("Telefone para Contato: (88) 99925-1547");
				System.out.println("Eric Rodrigues: ");
				System.out.println("Telefone para Contato: (85) 99297-3508");
				System.out.println("Escolha o PME! ");
				break;
			case 4:
				System.out.println("Por Favor, Digite seu Nome abaixo: ");
				String nome = ler.nextLine();
				System.out.println("Olá " + nome
						+ "! Eu sou o seu Sistema de Gerenciamento para Farmácia, o Pharmacy Made Easy (Ou simplesmente PME, se você já é um Cliente VIP)!");
				System.out.println(
						"Fui desenvolvido por dois Alunos do Segundo Semestre de Engenharia de Software, da Universidade Federal do Ceará!");
				System.out.println("Os caras são esses aí: ");
				System.out.println("Ítalo Lima");
				System.out.println("Eric Rodrigues");
				System.out.println("Obrigado por nos escolher, " + nome + "!");
				break;
			case 5:
				System.out.println("Sistema Desconectado!");
				System.exit(1);
				break;

			default:
				System.out.println("Opção Inválida! ");
				break;
			}
		}

	}
}
