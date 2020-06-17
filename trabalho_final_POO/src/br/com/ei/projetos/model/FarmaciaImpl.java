package br.com.ei.projetos.model;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import br.com.ei.projetos.Interface.CrudUsuario;
import br.com.ei.projetos.Interface.ChecarCadastro;

public class FarmaciaImpl implements CrudUsuario, ChecarCadastro {
	Scanner ler = new Scanner(System.in);

	private String nomeFarmacia;
	private String cnpj;
	private String inscricaoEstadual;
	private Gerente gerente;
	private List<Usuario> usuarios;

	public FarmaciaImpl() {
		super();
		this.usuarios = new ArrayList<Usuario>();
	}

	public FarmaciaImpl(String nomeFarmacia, String cnpj, String inscricaoEstadual, Gerente gerente) {
		super();
		this.nomeFarmacia = nomeFarmacia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.gerente = gerente;
		this.usuarios = new ArrayList<Usuario>();
	}

	public void criarFarmacia() {
		Usuario g = new Gerente();
		Endereco e = new Endereco();
		System.out.println("Digite o nome da Farmácia a ser criada: ");
		nomeFarmacia = ler.nextLine();
		System.out.println("Digite o cnpj da Farmácia a ser criada: ");
		cnpj = ler.nextLine();
		System.out.println("Digite a Inscrição Estadual da Farmácia a ser criada: ");
		inscricaoEstadual = ler.nextLine();
		System.out.println("Digite o Nome do Gerente da Farmácia: ");
		g.setNome(ler.nextLine());
		System.out.println("A Data de Nascimento segue o seguinte parâmetro: YYYY/MM/DD ");
		System.out.println("Digite o Ano de Nascimento do Gerente da Farmácia: ");
		int ano = Integer.parseInt(ler.nextLine());
		System.out.println("Digite o Mês de Nascimento do Gerente da Farmácia: ");
		int mes = Integer.parseInt(ler.nextLine());
		System.out.println("Digite o Dia de Nascimento do Gerente da Farmácia: ");
		int dia = Integer.parseInt(ler.nextLine());
		g.setDataNascimento(LocalDate.of(ano, mes, dia));
		System.out.println("Digite a Cidade do Gerente da Farmácia: ");
		e.setCidade(ler.nextLine());
		System.out.println("Digite a Rua do Gerente da Farmácia: ");
		e.setRua(ler.nextLine());
		System.out.println("Digite o Bairro do Gerente da Farmácia: ");
		e.setBairro(ler.nextLine());
		System.out.println("Digite o Número da Casa Gerente da Farmácia: ");
		e.setNumero(Integer.parseInt(ler.nextLine()));
		g.setEndereco(e);
		System.out.println("Digite o Email do Gerente da Farmácia: ");
		g.setEmail(ler.nextLine());
		System.out.println("Digite o CPF do Gerente da Farmácia: ");
		g.setCpf(ler.nextLine());
		System.out.println("Crie um Login para o Gerente da Farmácia: ");
		g.setLogin(ler.nextLine());
		System.out.println("Crie uma Senha para o Gerente da Farmácia: ");
		g.setSenha(ler.nextLine());
		usuarios.add(g);
		System.out.println("Farmácia Aberta Com SUCESSO!");
		System.out.println("Sob responsabilidade do Gerente: " + g.getNome());
	}

	public void adicionarUsuario() {
		System.out.println("Você deseja Adicioar um Cliente ou um Funcionário ?");
		System.out.println("Cliente --> Digite 1");
		System.out.println("Funcionário --> Digite 2");
		int op = Integer.parseInt(ler.nextLine());
		if (op == 1) {
			Usuario c = new Cliente();
			System.out.println("Campo de DADOS PESSOAIS");
			System.out.println("Digite o Nome do Cliente: ");
			c.setNome(ler.nextLine());
			System.out.println("A Data de Nascimento segue o seguinte parâmetro: YYYY/MM/DD ");
			System.out.println("Digite o Ano de Nascimento do Cliente: ");
			int ano = Integer.parseInt(ler.nextLine());
			System.out.println("Digite o Mês de Nascimento do Cliente: ");
			int mes = Integer.parseInt(ler.nextLine());
			System.out.println("Digite o Dia de Nascimento do Cliente: ");
			int dia = Integer.parseInt(ler.nextLine());
			c.setDataNascimento(LocalDate.of(ano, mes, dia));
			System.out.println("Endereço do Cliente: ");
			Endereco e = new Endereco();
			System.out.println("Digite a Cidade de Residência do Cliente");
			e.setCidade(ler.nextLine());
			System.out.println("Digite a Rua de Residência do Cliente");
			e.setRua(ler.nextLine());
			System.out.println("Digite o Bairro de Residência do Cliente");
			e.setBairro(ler.nextLine());
			System.out.println("Digite o Número da Residência do Cliente");
			e.setNumero(Integer.parseInt(ler.nextLine()));
			c.setEndereco(e);
			System.out.println("Digite o Email do Cliente a ser Adicionado");
			c.setEmail(ler.nextLine());
			System.out.println("Digite o CPF da Residência do Cliente");
			c.setCpf(ler.nextLine());
			System.out.println("Campo dos DADOS DE ACESSO");
			System.out.println("Digite o LOGIN do Cliente a ser Adicionado");
			c.setLogin(ler.nextLine());
			while (checarLogin(c.getLogin())) {
				System.out.println("Aviso: ");
				System.out.println("Este Login já está Cadastrado!");
				System.out.println("Favor Digitar Outro Login");
				c.setLogin(ler.nextLine());
			}
			System.out.println("Digite a SENHA do Cliente a ser Adicionado");
			System.out.println("Dica: Senhas fortes são compostas por sequências de letras, números e caracteres!");
			System.out.println("Cuidado ao compartilhar seus Dados de Acesso!");
			c.setSenha(ler.nextLine());
			usuarios.add(c);
			System.out.println("Cliente Adicionado com SUCESSO!");
		} else if (op == 2) {
			System.out.println("Você deseja Adicionar um Balconista ou Farmacêutico ?");
			System.out.println("Balconista --> Digite 1");
			System.out.println("Farmacêutico --> Digite 2");
			int op2 = Integer.parseInt(ler.nextLine());
			switch (op2) {

			case 1:
				Usuario b = new Balconista();
				System.out.println("Digite o Nome do Balconista: ");
				b.setNome(ler.nextLine());
				System.out.println("A Data de Nascimento segue o seguinte parâmetro: YYYY/MM/DD ");
				System.out.println("Digite o Ano de Nascimento do Balconista da Farmácia: ");
				int ano = Integer.parseInt(ler.nextLine());
				System.out.println("Digite o Mês de Nascimento do Balconista da Farmácia: ");
				int mes = Integer.parseInt(ler.nextLine());
				System.out.println("Digite o Dia de Nascimento do Balconista da Farmácia: ");
				int dia = Integer.parseInt(ler.nextLine());
				b.setDataNascimento(LocalDate.of(ano, mes, dia));
				System.out.println("Digite a Cidade do Balconista da Farmácia: ");
				Endereco e = new Endereco();
				e.setCidade(ler.nextLine());
				System.out.println("Digite a Rua do Balconista da Farmácia: ");
				e.setRua(ler.nextLine());
				System.out.println("Digite o Bairro do Balconista da Farmácia: ");
				e.setBairro(ler.nextLine());
				System.out.println("Digite o Número da Casa do Balconista da Farmácia: ");
				e.setNumero(Integer.parseInt(ler.nextLine()));
				b.setEndereco(e);
				System.out.println("Digite o Email do Balconista da Farmácia: ");
				b.setEmail(ler.nextLine());
				System.out.println("Digite o CPF do Balconista da Farmácia: ");
				b.setCpf(ler.nextLine());
				System.out.println("Crie um Login para o Balconista da Farmácia: ");
				b.setLogin(ler.nextLine());
				while (checarLogin(b.getLogin())) {
					System.out.println("Aviso: ");
					System.out.println("Este Login já está Cadastrado!");
					System.out.println("Favor Digitar Outro Login");
					b.setLogin(ler.nextLine());
				}
				System.out.println("Crie uma Senha para o Balconista da Farmácia: ");
				b.setSenha(ler.nextLine());
				System.out.println("Digite o Salário do Balconista da Farmácia: ");
				((Balconista) b).setSalario(Double.parseDouble(ler.nextLine()));
				System.out.println("Digite o Identificador de Cargo do Balconista da Farmácia: ");
				System.out.println("O identificador para Gerente deve ser finalizado com: 00");
				System.out.println("O identificador para Farmacêutico deve ser finalizado com: 01");
				System.out.println("O identificador para Bauconista deve ser finalizado com: 02");
				((Balconista) b).setIdFuncionario(ler.nextLine());
				while (checarLogin(((Balconista) b).getIdFuncionario())) {
					System.out.println("Aviso: ");
					System.out.println("Este Identificador já está Cadastrado!");
					System.out.println("Favor Digitar Outro ID");
					((Balconista) b).setIdFuncionario((ler.nextLine()));
				}
				System.out.println("A Prioridade de Acesso representa o nível de acesso que o Usuário possui");
				System.out.println("A Prioridade para o Gerente deve ser de : 100");
				System.out.println("A Prioridade para o Farmacêutico deve ser de : 50");
				System.out.println("A Prioridade para Balconista deve ser de : 25");
				((Balconista) b).setPrioridadeDeAcesso(25);
				usuarios.add(b);
				System.out.println("Balconista Adicionado com SUCESSO!");
				break;

			case 2:
				Usuario f = new Farmaceutico();
				System.out.println("Digite o Nome do Farmacêutico: ");
				f.setNome(ler.nextLine());
				System.out.println("A Data de Nascimento segue o seguinte parâmetro: YYYY/MM/DD ");
				System.out.println("Digite o Ano de Nascimento do Farmacêutico da Farmácia: ");
				int ano1 = Integer.parseInt(ler.nextLine());
				System.out.println("Digite o Mês de Nascimento do Farmacêutico da Farmácia: ");
				int mes1 = Integer.parseInt(ler.nextLine());
				System.out.println("Digite o Dia de Nascimento do Farmacêutico da Farmácia: ");
				int dia1 = Integer.parseInt(ler.nextLine());
				f.setDataNascimento(LocalDate.of(ano1, mes1, dia1));
				System.out.println("Digite a Cidade do Farmacêutico da Farmácia: ");
				Endereco e1 = new Endereco();
				e1.setCidade(ler.nextLine());
				System.out.println("Digite a Rua do Farmacêutico da Farmácia: ");
				e1.setRua(ler.nextLine());
				System.out.println("Digite o Bairro do Farmacêutico da Farmácia: ");
				e1.setBairro(ler.nextLine());
				System.out.println("Digite o Número da Casa do Farmacêutico da Farmácia: ");
				e1.setNumero(Integer.parseInt(ler.nextLine()));
				f.setEndereco(e1);
				System.out.println("Digite o Email do Farmacêutico da Farmácia: ");
				f.setEmail(ler.nextLine());
				System.out.println("Digite o CPF do Farmacêutico da Farmácia: ");
				f.setCpf(ler.nextLine());
				System.out.println("Crie um Login para o Farmacêutico da Farmácia: ");
				f.setLogin(ler.nextLine());
				while (checarLogin(f.getLogin())) {
					System.out.println("Aviso: ");
					System.out.println("Este Login já está Cadastrado!");
					System.out.println("Favor Digitar Outro Login");
					f.setLogin(ler.nextLine());
				}
				System.out.println("Crie uma Senha para o Farmacêutico da Farmácia: ");
				f.setSenha(ler.nextLine());
				System.out.println("Digite o Salário do Balconista da Farmácia: ");
				((Farmaceutico) f).setSalario(Double.parseDouble(ler.nextLine()));
				System.out.println("Digite o Identificador de Cargo do Balconista da Farmácia: ");
				System.out.println("O identificador para Gerente deve ser finalizado com: 00");
				System.out.println("O identificador para Farmacêutico deve ser finalizado com: 01");
				System.out.println("O identificador para Bauconista deve ser finalizado com: 02");
				((Farmaceutico) f).setIdFuncionario(ler.nextLine());
				while (checarLogin(((Farmaceutico) f).getIdFuncionario())) {
					System.out.println("Aviso: ");
					System.out.println("Este Identificador já está Cadastrado!");
					System.out.println("Favor Digitar Outro ID");
					((Farmaceutico) f).setIdFuncionario((ler.nextLine()));
				}
				System.out.println("A Prioridade de Acesso representa o nível de acesso que o Usuário possui");
				System.out.println("A Prioridade para o Gerente é de : 100");
				System.out.println("A Prioridade para o Farmacêutico é de : 50");
				System.out.println("A Prioridade para Balconista é de : 25");
				((Farmaceutico) f).setPrioridadeDeAcesso(50);
				System.out.println("Digite o CRF do Farmacêutico da Farmácia: ");
				((Farmaceutico) f).setCodigoCrf(ler.nextLine());
				usuarios.add(f);
				System.out.println("Farmacêutico Adicionado com SUCESSO!");
				break;

			default:
				System.out.println("Opção Inválida, favor tentar Novamente!");
			}

		} else {
			System.out.println("Opção Inválida, favor tentar Novamente!");
		}
	}

	@Override
	public void removerUsuario() {
		System.out.println(("Por Favor, Digite o Indíce do Usuário a ser Removido"));
		exibirListaAuxiliar();
		int tchauFuncionario = Integer.parseInt(ler.nextLine());
		try {
			usuarios.remove(tchauFuncionario);
			System.out.println("Funcionário Removido com SUCESSO!");
		} catch (NullPointerException e) {
			System.out.println("Falha na Remoção do Usuário!");
		}
	}

	@Override
	public void buscarUsuario() {
		if(usuarios == null) {
			System.out.println("Não Há Usuários Cadastrados");
		}else {
		System.out.println("Digite o Login do Usuário a ser Buscado: ");
		exibirListaAuxiliar();
		String login = ler.nextLine();
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login)) {
				System.out.println(usuario);
				return;
			}
		}
		}
		System.out.println("Usuário não Encontrado em nossa BASE DE DADOS");
	}

	@Override
	public void listarUsuario() {
		if (usuarios == null) {
			System.out.println("Erro! Não Há Usuários Cadastrados.");
		}else {
		System.out.println("Exibindo Usuários Cadastrados: ");
		System.out.println(usuarios);
		}
	}

	public boolean checarLogin(String login, String senha) {
		for (Usuario usuariosLogin : usuarios) {
			if (usuariosLogin.getLogin().equals(login) && usuariosLogin.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	public boolean checarLogin(String login) {
		for (Usuario usuariosCadastrados : usuarios) {
			if (usuariosCadastrados.getLogin().equals(login))
				return true;
		}
		return false;
	}

	public boolean checarFuncionario(String idFuncionario) {
		for (Usuario funcionariosCadastrados : usuarios) {
			if (((Funcionario) funcionariosCadastrados).getIdFuncionario().equals(idFuncionario))
				return true;
		}
		return false;
	}

	public int checaInstanciaLogin(String login) {
		for (Usuario usuariosLogin : usuarios) {
			if (usuariosLogin.getLogin().equals(login)) {
				if (usuariosLogin instanceof Gerente) {
					return 1;
				} else if (usuariosLogin instanceof Farmaceutico) {
					return 2;
				} else if (usuariosLogin instanceof Balconista) {
					return 3;
				} else if (usuariosLogin instanceof Cliente) {
					return 4;
				}
			}
		}
		return 0;
	}

	public void exibirListaAuxiliar() {
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(i + " => " + usuarios.get(i).getLogin());
		}
	}
}
