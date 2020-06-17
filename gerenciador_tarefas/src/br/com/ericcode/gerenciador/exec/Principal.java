package br.com.ericcode.gerenciador.exec;

import java.util.Scanner;

import br.com.ericcode.gerenciador.model.Tarefa;
import br.com.ericcode.gerenciador.model.Usuario;
import br.com.ericcode.gerenciador.model.Gerenciador;

public class Principal {
	public static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		Gerenciador gerencia = new Gerenciador();
		boolean menuMaior = true;
		int escolhaMenuMaior;
		
		while(menuMaior) {
			System.out.println("1 - Cadastrar um usuario");
			System.out.println("2 - Remover um usuario");
			System.out.println("3 - Efetuar login");
			System.out.println("4 - Exibir lista de usuarios");
			System.out.println("5 - Sair");
			escolhaMenuMaior = Integer.parseInt(ler.nextLine());
			
			switch(escolhaMenuMaior) {
				case 1:
					String loginUsuario;
					String senhaUsuario;
					
					System.out.println("Digite o login deste novo usuario: ");
					loginUsuario = ler.nextLine();
					
					System.out.println("Digite a senha deste novo usuario: ");
					senhaUsuario = ler.nextLine();
					
					Usuario usuario = new Usuario(loginUsuario, senhaUsuario);
					
					if(gerencia.getUsuarios().size() >= 0) {
						if(gerencia.confereCadastro(loginUsuario) == false) {
							gerencia.adicionarUsuario(usuario);
						}else {
							System.out.println("Já temos um usuario com o este login! Favor tentar outro!");
						}
					}else {
						System.out.println("Primeiro inicie o sistema, para depois efetuar cadastros!");
					}
					
					loginUsuario = null;
					senhaUsuario = null;
					
					break;
				
				case 2:
					int escolhaRemover;
					
					if(gerencia.getUsuarios().size() >= 1) {
						gerencia.listaAuxiliar();
						System.out.println("Digite o numero do usuario que deseja remover: ");
						escolhaRemover = Integer.parseInt(ler.nextLine());
						
						Usuario usuarioRemover = gerencia.retornaUsuario(escolhaRemover - 1);
						
						gerencia.removerUsuario(usuarioRemover);
					}else {
						System.out.println("Adicione usuarios antes, para depois poder remove-los!");
					}
					
					escolhaRemover = 0;
					
					break;
					
				case 3:
					if(gerencia.getUsuarios().size() >= 1) {
						String loginUsuarioLogar;
						String senhaUsuarioLogar;
						
						System.out.println("Digite o login do usuario que deseja logar: ");
						loginUsuarioLogar = ler.nextLine();
						
						System.out.println("Digite a senha do usuario que deseja logar: ");
						senhaUsuarioLogar = ler.nextLine();
						
						boolean menuLogado = gerencia.efetuarLogin(loginUsuarioLogar, senhaUsuarioLogar);
						int escolhaMenuLogado;
						
						if(menuLogado == true) {
							System.out.println("Logado com sucesso!");
						}else {
							System.out.println("Favor tentar efetuar login novamente!");
						}
						
						while(menuLogado) {
							System.out.println("1 - Adicionar uma tarefa");
							System.out.println("2 - Remover uma tarefa");
							System.out.println("3 - Concluir uma tarefa");
							System.out.println("4 - Atualizar titulo de uma tarefa");
							System.out.println("5 - Atualizar a ação de uma tarefa");
							System.out.println("6 - Exibir minhas tarefas");
							System.out.println("7 - Atualizar meu login");
							System.out.println("8 - Atualizar minha senha");
							System.out.println("9 - Sair");
							escolhaMenuLogado = Integer.parseInt(ler.nextLine());
							
							switch(escolhaMenuLogado) {
								case 1:
									String tituloTarefa;
									String acaoTarefa;
									
									System.out.println("Digite o titulo da sua nova tarefa: ");
									tituloTarefa = ler.nextLine();
									
									System.out.println("Digite a ação desta tarefa: ");
									acaoTarefa = ler.nextLine();
									
									Tarefa tarefa = new Tarefa(tituloTarefa, acaoTarefa);
									
									gerencia.adicionarTarefa(loginUsuarioLogar, senhaUsuarioLogar, tarefa);
									
									tituloTarefa = null;
									acaoTarefa = null;
									
									break;
									
								case 2:
									int escolhaTarefaRemocao;
									
									if(gerencia.quantidadeTarefas(loginUsuarioLogar) >= 1) {
										gerencia.listaAuxiliarTarefas(loginUsuarioLogar);
										System.out.println("Digite o numero da tarefa que deseja remover: ");
										escolhaTarefaRemocao = Integer.parseInt(ler.nextLine());
										
										Tarefa tarefaRemocao = gerencia.retornarTarefa(loginUsuarioLogar, (escolhaTarefaRemocao - 1));
										
										if(tarefaRemocao == null) {
											System.out.println("Ocorreu algum erro ao tentar remover a tarefa!");
											gerencia.removerTarefa(loginUsuarioLogar, senhaUsuarioLogar, tarefaRemocao);
										}
									}else {
										System.out.println(" ");
										System.out.println("Este usuario não possui tareafas para poder apagar!");
										System.out.println(" ");
									}
									
									escolhaTarefaRemocao = 0;
									
									break;	
									
								case 3:
									String tituloTarefaConcluir;
									
									if(gerencia.quantidadeTarefas(loginUsuarioLogar) >= 1) {
										System.out.println("Digite o nome da tarefa que deseja realizar: ");
										tituloTarefaConcluir = ler.nextLine();
										
										gerencia.realizarTarefa(loginUsuarioLogar, senhaUsuarioLogar, tituloTarefaConcluir);
									}else {
										System.out.println(" ");
										System.out.println("Este usuario não possui tareafas para poder conclui-las!");
										System.out.println(" ");
									}
									
									tituloTarefaConcluir = null;
									
									break;
									
								case 4:
									String tituloAtualTarefa;
									String tituloNovoTarefa;
									
									if(gerencia.quantidadeTarefas(loginUsuarioLogar) >= 1) {
										System.out.println("Digite o titulo da tarefa que deseja mudar o titulo: ");
										tituloAtualTarefa = ler.nextLine();
										
										System.out.println("Digite o novo titulo para essa tarefa: ");
										tituloNovoTarefa = ler.nextLine();
										
										gerencia.atualizarTituloTarefa(loginUsuarioLogar, senhaUsuarioLogar, tituloAtualTarefa, tituloNovoTarefa);
									}else {
										System.out.println(" ");
										System.out.println("Este usuario não possui tareafas para poder alterar titulos!");
										System.out.println(" ");
									}
									
									tituloAtualTarefa = null;
									tituloNovoTarefa = null;
									
									break;
									
								case 5:
									String tituloTarefaMudarAcao;
									String novaAcaoTarefa;
									
									if(gerencia.quantidadeTarefas(loginUsuarioLogar) >= 1) {
										System.out.println("Digite o tituloda tarefa que deseja mudar a ação: ");
										tituloTarefaMudarAcao = ler.nextLine();
										
										System.out.println("Digite a nova ação para essa tarefa: ");
										novaAcaoTarefa = ler.nextLine();
										
										gerencia.atualizarAcaoTarefa(loginUsuarioLogar, senhaUsuarioLogar, tituloTarefaMudarAcao, novaAcaoTarefa);
									}else {
										System.out.println(" ");
										System.out.println("Este usuario não possui tareafas para poder alterar suas ações!");
										System.out.println(" ");
									}
									
									tituloTarefaMudarAcao = null;
									novaAcaoTarefa = null;
									
									break;
									
								case 6:
									if(gerencia.quantidadeTarefas(loginUsuarioLogar) >= 1) {
										gerencia.exibirTarefas(loginUsuarioLogar);
									}else {
										System.out.println(" ");
										System.out.println("Este usuario não possui tareafas para exibir!");
										System.out.println(" ");
									}
									
									break;
									
								case 7:
									String novoLogin;
									
									System.out.println("Digite o novo login desejado: ");
									novoLogin = ler.nextLine();
									
									gerencia.atualizarLogin(loginUsuarioLogar, senhaUsuarioLogar,novoLogin);
									
									novoLogin = null;
									
									break;
									
								case 8:
									String novaSenha;
									
									System.out.println("Digite a nova senha desejada para esse usuario: ");
									novaSenha = ler.nextLine();
									
									gerencia.atualizaSenha(loginUsuarioLogar, senhaUsuarioLogar, novaSenha);
									
									novaSenha = null;
									
									break;
									
								default:
									menuLogado = false;
									loginUsuarioLogar = null;
									senhaUsuarioLogar = null;
							}
						}
					}else {
						System.out.println("Adicione usuarios antes, para depois poder logar!");
					}
					
					break;
					
				case 4:
					if(gerencia.getUsuarios().size() >= 1) {
						gerencia.exibirUsuarios();
					}else {
						System.out.println("Adicione usuarios antes, para depois poder exibi-los!");
					}
					
					break;
					
				default:
					menuMaior = false;
			}
		}
	}
}
