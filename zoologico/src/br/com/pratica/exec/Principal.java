package br.com.pratica.exec;

import java.util.Scanner;

import br.com.pratica.model.Zoologico;
import br.com.pratica.model.Jacare;
import br.com.pratica.model.Raposa;
import br.com.pratica.model.Leao;

public class Principal {
	static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		Zoologico zoo = null;
		boolean menuMaior = true;
		int opMenuMaior;

		while (menuMaior) {
			System.out.println("1 - Criar zoologico");
			System.out.println("2 - Entrar");
			System.out.println("3 - Sair");
			opMenuMaior = Integer.parseInt(ler.nextLine());

			switch (opMenuMaior) {
			case 1:
				if (zoo == null) {
					try {
						zoo = new Zoologico();
						System.out.println("Zoologico criado com sucesso!");
					} catch (NullPointerException e) {
						System.out.println("Não foi possivel criar o zoologico!");
					}
				} else {
					System.out.println("O zoologico ja esta criado");
				}

				System.out.println("Retornando ao menu inicial!");
				break;

			case 2:
				boolean menuZoo = true;
				int opMenuMenor;

				if (zoo != null) {
					while (menuZoo) {
						System.out.println("1 - Adicionar um animal");
						System.out.println("2 - Remover um animal");
						System.out.println("3 - Buscar um animal");
						System.out.println("4 - Listar zoologico");
						System.out.println("5 - Interagir com um animal");
						System.out.println("6 - Ordenar zoologico pelas idades");
						System.out.println("7 - Exibir zoologico por grupamento");
						System.out.println("8 - Sair");
						opMenuMenor = Integer.parseInt(ler.nextLine());

						switch (opMenuMenor) {
						case 1:
							int opMenuAnimal;

							System.out.println("Deseja adicionar qual animal?");
							System.out.println("1 - Leão");
							System.out.println("2 - Jacaré");
							System.out.println("3 - Raposa");
							opMenuAnimal = Integer.parseInt(ler.nextLine());

							switch (opMenuAnimal) {
							case 1:
								boolean jubaL;

								System.out.println("Digite o nome do leão: ");
								String nomeL = ler.nextLine();

								System.out.println("Digite a especie do leão: ");
								String especieL = ler.nextLine();

								System.out.println("Digite o sexo do leão: ");
								String sexoL = ler.nextLine();

								System.out.println("Digite a idade do leão: ");
								int idadeL = Integer.parseInt(ler.nextLine());

								System.out.println("Diigte o peso do leão: ");
								double pesoL = Double.parseDouble(ler.nextLine());

								System.out.println("O leão tem juba (s) ou (n): ");
								String jubaLeaoL = ler.nextLine();
								if (jubaLeaoL.equals("s")) {
									jubaL = true;
								} else {
									jubaL = false;
								}

								Leao leao = new Leao(nomeL, especieL, sexoL, idadeL, pesoL, jubaL);

								zoo.adicionarAnimal(leao);
								break;

							case 2:
								System.out.println("Digite o nome do jacaré: ");
								String nomeJ = ler.nextLine();

								System.out.println("Digite a especie do jacaré: ");
								String especieJ = ler.nextLine();

								System.out.println("Digite o sexo do jacaré: ");
								String sexoJ = ler.nextLine();

								System.out.println("Digite a idade do jacaré: ");
								int idadeJ = Integer.parseInt(ler.nextLine());

								System.out.println("Diigte o peso do jacaré: ");
								double pesoJ = Double.parseDouble(ler.nextLine());

								System.out.println("Diigte o tamanho do jacaré: ");
								double tamanhoJ = Double.parseDouble(ler.nextLine());

								Jacare jacare = new Jacare(nomeJ, especieJ, sexoJ, idadeJ, pesoJ, tamanhoJ);

								zoo.adicionarAnimal(jacare);
								break;

							case 3:
								System.out.println("Digite o nome do raposa: ");
								String nomeR = ler.nextLine();

								System.out.println("Digite a especie do raposa: ");
								String especieR = ler.nextLine();

								System.out.println("Digite o sexo do raposa: ");
								String sexoR = ler.nextLine();

								System.out.println("Digite a idade do raposa: ");
								int idadeR = Integer.parseInt(ler.nextLine());

								System.out.println("Diigte o peso do raposa: ");
								double pesoR = Double.parseDouble(ler.nextLine());

								System.out.println("Digite a cor do raposa: ");
								String corR = ler.nextLine();

								Raposa raposa = new Raposa(nomeR, especieR, sexoR, idadeR, pesoR, corR);

								zoo.adicionarAnimal(raposa);
								break;

							default:
								System.out.println("ERRO: Não é um opção do menu!!!");
							}
							break;

						case 2:
							if (zoo.getAnimais().size() > 0) {
								zoo.exibirListaAuxiliar();
								System.out.println("Digite o numero do animal que deseja remover: ");
								int elemento = Integer.parseInt(ler.nextLine());

								Object animalRetorno = zoo.retornaAnimal(elemento);

								zoo.removerAnimal(animalRetorno);
							} else {
								System.out.println("Cadastre animais para poder excluir!!!");
							}

							break;

						case 3:
							if (zoo.getAnimais().size() > 0) {
								zoo.exibirListaAuxiliar();
								System.out.println("Digite o nome do animal que deseja buscar: ");
								String nomeBuscar = ler.nextLine();

								zoo.buscarAnimal(nomeBuscar);
							} else {
								System.out.println("Cadastre animais para poder buscar!!!");
							}
							break;

						case 4:
							if (zoo.getAnimais().size() > 0) {
								zoo.exibirZoologico();
							} else {
								System.out.println("Cadastre animais para poder exibir o zoologico!!!");
							}
							break;

						case 5:
							if (zoo.getAnimais().size() > 0) {
								zoo.exibirListaAuxiliar();
								System.out.println("Digite o numero do animal que deseja interagir: ");
								int animalInteragir = Integer.parseInt(ler.nextLine());

								Object animalRetornoInteragir = zoo.retornaAnimal(animalInteragir);

								if (animalRetornoInteragir instanceof Leao) {
									System.out.println("");
									System.out.println("Area de interacao com o leao"
											+ zoo.getAnimais().get(animalInteragir).getNome());
									boolean interagirLeao = true;
									while (interagirLeao) {
										System.out.println("");
										System.out.println("1 - Rugir");
										System.out.println("2 - Andar");
										System.out.println("3 - Correr");
										System.out.println("4 - Comer");
										System.out.println("5 - Dormir");
										System.out.println("6 - Brigar");
										System.out.println("7 - Sair");
										int acaoLeao = Integer.parseInt(ler.nextLine());

										switch (acaoLeao) {
										case 1:
											((Leao) zoo.getAnimais().get(animalInteragir)).rugir();
											break;

										case 2:
											((Leao) zoo.getAnimais().get(animalInteragir)).andar();
											break;

										case 3:
											((Leao) zoo.getAnimais().get(animalInteragir)).correr();
											break;

										case 4:
											((Leao) zoo.getAnimais().get(animalInteragir)).comer();
											break;

										case 5:
											((Leao) zoo.getAnimais().get(animalInteragir)).dormir();
											break;

										case 6:
											((Leao) zoo.getAnimais().get(animalInteragir)).brigar();
											break;
										default:
											interagirLeao = false;
											break;
										}
									}
								} else if (animalRetornoInteragir instanceof Jacare) {
									System.out.println("Area de interacao com o jacare"
											+ zoo.getAnimais().get(animalInteragir).getNome());
									boolean interagirJacare = true;
									while (interagirJacare) {
										System.out.println("");
										System.out.println("1 - Nadar");
										System.out.println("2 - Andar");
										System.out.println("3 - Correr");
										System.out.println("4 - Comer");
										System.out.println("5 - Dormir");
										System.out.println("6 - Brigar");
										System.out.println("7 - Sair");
										int acaoLeao = Integer.parseInt(ler.nextLine());

										switch (acaoLeao) {
										case 1:
											((Jacare) zoo.getAnimais().get(animalInteragir)).nadar();
											break;

										case 2:
											((Jacare) zoo.getAnimais().get(animalInteragir)).andar();
											break;

										case 3:
											((Jacare) zoo.getAnimais().get(animalInteragir)).correr();
											break;

										case 4:
											((Jacare) zoo.getAnimais().get(animalInteragir)).comer();
											break;

										case 5:
											((Jacare) zoo.getAnimais().get(animalInteragir)).dormir();
											break;

										case 6:
											((Jacare) zoo.getAnimais().get(animalInteragir)).brigar();
											break;
										default:
											interagirJacare = false;
											break;
										}
									}
								} else if (animalRetornoInteragir instanceof Raposa) {
									System.out.println("Area de interacao com a raposa"
											+ zoo.getAnimais().get(animalInteragir).getNome());
									boolean interagirRaposa = true;
									while (interagirRaposa) {
										System.out.println("");
										System.out.println("1 - Caçar");
										System.out.println("2 - Andar");
										System.out.println("3 - Correr");
										System.out.println("4 - Comer");
										System.out.println("5 - Dormir");
										System.out.println("6 - Brigar");
										System.out.println("7 - Sair");
										int acaoLeao = Integer.parseInt(ler.nextLine());

										switch (acaoLeao) {
										case 1:
											((Raposa) zoo.getAnimais().get(animalInteragir)).cacar();
											break;

										case 2:
											((Raposa) zoo.getAnimais().get(animalInteragir)).andar();
											break;

										case 3:
											((Raposa) zoo.getAnimais().get(animalInteragir)).correr();
											break;

										case 4:
											((Raposa) zoo.getAnimais().get(animalInteragir)).comer();
											break;

										case 5:
											((Raposa) zoo.getAnimais().get(animalInteragir)).dormir();
											break;

										case 6:
											((Raposa) zoo.getAnimais().get(animalInteragir)).brigar();
											break;

										default:
											interagirRaposa = false;
											break;
										}
									}
								} else {
									System.out.println("ERRO: ao buscar o animal para interagir!!!");
								}
							} else {
								System.out.println("Cadastre animais para poder interagir com eles!!!");
							}
							break;

						case 6:
							if (zoo.getAnimais().size() > 1) {
								zoo.ordenaListaIdade();
							} else {
								System.out.println("Adicione mais animais para poder ordenalos!!!");
							}
							break;

						case 7:
							if (zoo.getAnimais().size() > 0) {
								System.out.println("1 - Leão");
								System.out.println("2 - Jacaré");
								System.out.println("3 - Raposa");
								int opcaoExibicao = Integer.parseInt(ler.nextLine());

								if (opcaoExibicao == 1) {
									zoo.exibirLeao();
								} else if (opcaoExibicao == 2) {
									zoo.exibirJacare();
								} else if (opcaoExibicao == 3) {
									zoo.exibirRaposa();
								} else {
									System.out.println("ERRO: a opcao digitada nao esta disponivel!!!");
								}
							} else {
								System.out.println("Adicione mais animais para exibir por grupamento!!!");
							}
							break;

						default:
							menuZoo = false;
						}
					}
				} else {
					System.out.println("O zoologico ainda não foi criado!");
					System.out.println("Retornando ao menu inicial!");
				}
				break;

			default:
				System.out.println("Encerrando o sistema!");
				menuMaior = false;
			}
		}
	}
}
