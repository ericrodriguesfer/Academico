package br.com.ericcode.agenda.exec;

import java.util.Scanner;

import br.com.ericcode.agenda.model.Agenda;
import br.com.ericcode.agenda.model.Contato;
import br.com.ericcode.agenda.model.Pessoa;
import br.com.ericcode.agenda.model.Telefone;

public class UsaAgenda {
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		Agenda agendaContatos = null;
		boolean menuMaior = true;
		int opcaoMenuMaior;
		
		while(menuMaior) {
			System.out.println("1 - Criar agenda");
			System.out.println("2 - Usar agenda");
			System.out.println("3 - Sair agenda");
			opcaoMenuMaior = Integer.parseInt(ler.nextLine());
			
			switch(opcaoMenuMaior) {
				case 1:
					if(agendaContatos == null) {
						try {
							agendaContatos = new Agenda();
							System.out.println(" ");
							System.out.println("Agenda criada com sucesso!");
							System.out.println(" ");
						}catch(NullPointerException e) {
							System.out.println(" ");
							System.out.println("Fala ao criar a agenda! Favor tentar novamente!");
							System.out.println(" ");
						}
					}else {
						System.out.println(" ");
						System.out.println("A agenda já esta criada!");
						System.out.println(" ");
					}
					
					break;
				
				case 2:
					if(agendaContatos != null) {
						System.out.println(" ");
						boolean menuAgenda = true;
						int opcaoMenuAgenda;
						
						while(menuAgenda) {
							System.out.println("1 - Adicionar um contato");
							System.out.println("2 - Remover um contato");
							System.out.println("3 - Favoritar um contato");
							System.out.println("4 - Desfavoritar um contato");
							System.out.println("5 - Lista de contatos");
							System.out.println("6 - Lista de favoritos");
							System.out.println("7 - Buscar um contato");
							System.out.println("8 - Ordenar pela idade");
							System.out.println("9 - Ligar para contato");
							System.out.println("10 - Sair");
							opcaoMenuAgenda = Integer.parseInt(ler.nextLine());
							System.out.println(" ");
							
							switch(opcaoMenuAgenda) {
								case 1:
									String nomeContato;
									String nomePessoa;
									String sobreNomePessoa;
									String apelidoPessoa;
									int idadePessoa;
									String operadoraTelefone;
									int numeroTelefone;
									
									System.out.println("Digite o nome do contato: ");
									nomeContato = ler.nextLine();
									
									System.out.println("Digite o nome da pessoa do contato: ");
									nomePessoa = ler.nextLine();
									
									System.out.println("Digite o sobre nome da pessoa do contato: ");
									sobreNomePessoa = ler.nextLine();
									
									System.out.println("Digite o apelido da pessoa do contato: ");
									apelidoPessoa = ler.nextLine();
									
									System.out.println("Digite a idade da pessoa do contato: ");
									idadePessoa = Integer.parseInt(ler.nextLine());
									
									System.out.println("Digite a operadora do contato: ");
									operadoraTelefone = ler.nextLine();
									
									System.out.println("Digite o numero do contato: ");
									numeroTelefone = Integer.parseInt(ler.nextLine());
									
									Pessoa p =  new Pessoa(nomePessoa, sobreNomePessoa, apelidoPessoa, idadePessoa);
									Telefone t = new Telefone(operadoraTelefone, numeroTelefone);
									Contato c = new Contato(nomeContato, p, t);
									
									agendaContatos.adicionarContato(c);
									
									break;
									
								case 2:
									if(agendaContatos.getContatos().size() != 0) {
										int escolhaRemocao;
										
										agendaContatos.listaAuxiliar();
										System.out.println("Digite o número do contato que deseja remover: ");
										escolhaRemocao = Integer.parseInt(ler.nextLine());
										
										Contato ct = agendaContatos.retornaContato(escolhaRemocao - 1);
										
										agendaContatos.removeContato(ct);
									}else {
										System.out.println("Para remover contatos da agenda, antes adicione contatos!");
									}
								
									break;
									
								case 3:
									if(agendaContatos.getContatos().size() != 0) {
										int escolhaFavorito;
										
										agendaContatos.listaAuxiliar();
										System.out.println("Digite o número do contato que deseja favoritar: ");
										escolhaFavorito = Integer.parseInt(ler.nextLine());
										
										agendaContatos.tornarFavotiro(escolhaFavorito - 1);
									}else {
										System.out.println("Para favoritar contatos da agenda, antes adicione contatos!");
									}
										
									break;
									
								case 4:
									if(agendaContatos.getContatos().size() != 0) {
										if(agendaContatos.temFavorito() == true) {
											int escolhaDesfavoritar;
											
											agendaContatos.listaAuxiliarFavoritos();
											System.out.println("Digite o número do contato que deseja desfavoritar: ");
											escolhaDesfavoritar = Integer.parseInt(ler.nextLine());
											
											agendaContatos.removerFavorito(escolhaDesfavoritar - 1);
										}else {
											System.out.println("Só pode remover numeros favoritos, se antes adicionar algum favorito!");
										}
									}else {
										System.out.println("Para desfavoritar contatos da agenda, antes adicione contatos!");
									}
									
									break;
									
								case 5:
									if(agendaContatos.getContatos().size() != 0) {
										agendaContatos.exibirContatos();
									}else {
										System.out.println("Para exibir contatos da agenda, antes adicione contatos!");
									}
									
									break;
									
								case 6:
									if(agendaContatos.getContatos().size() != 0) {
										agendaContatos.exibirFavoritos();
									}else {
										System.out.println("Para exibir contatos favoritos da agenda, antes adicione contatos!");
									}
									
									break;
									
								case 7:
									if(agendaContatos.getContatos().size() != 0) {
										String nomebusca;
									
										System.out.println("Digite o nome do contato que deseja buscar: ");
										nomebusca = ler.nextLine();
										
										agendaContatos.buscarContato(nomebusca);
									}else {
										System.out.println("Para buscar contatos da agenda, antes adicione contatos!");										
									}
									
									break;
									
								case 8:
									if(agendaContatos.getContatos().size() != 0) {
										agendaContatos.ordenarContatosIdade();
									}else {
										System.out.println("Para ordenar a agenda, antes adicione contatos!");	
									}
									
									break;
								
								case 9:
									boolean ligacao = true;
									int contatoLigacao;
									String paraLigacao;
									
									if(agendaContatos.getContatos().size() != 0) {
										agendaContatos.listaAuxiliar();
										System.out.println("Digite o numero do contato para qual deseja ligar: ");
										contatoLigacao = Integer.parseInt(ler.nextLine());
										
										System.out.println("Ligando para: " + agendaContatos.getContatos().get(contatoLigacao - 1).getNome());
										System.out.println("Chama em curso!");
										
										while(ligacao) {
											System.out.println("Deseja encerrar a ligação (s) ou (n):");
											paraLigacao = ler.nextLine();
											
											if(paraLigacao.contentEquals("s")) {
												ligacao = false;
											}
										}
										
										System.out.println("Chama encerrada!");
									}else {
										System.out.println("Para ligar para alguém, antes adicione contatos!");
									}
									
									break;
								
								default:
									menuAgenda = false;
							}
						}
					}else {
						System.out.println(" ");
						System.out.println("Para usar a agenda, primeiro crie uma agenda!");
						System.out.println(" ");
					}
					
					break;
					
				default:
					menuMaior = false;
			}
		}
	}
}