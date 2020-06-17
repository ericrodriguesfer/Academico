package br.com.ei.projetos.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.ei.projetos.Interface.ChecarProduto;
import br.com.ei.projetos.Interface.CrudProduto;

public class EstoqueImpl implements CrudProduto, ChecarProduto{

	protected Map<String, Produto> estoque;

	Scanner ler = new Scanner(System.in);

	public EstoqueImpl() {
		estoque = new HashMap<String, Produto>();
	}

	public void adicionarProduto() {
		int op2;
		System.out.println("Você deseja Adicionar um Medicamento ou uma Camisinha ?");
		System.out.println("Medicamento --> Digite 1");
		System.out.println("Camisinha --> Digite 2");
		int op = Integer.parseInt(ler.nextLine());
		if (op == 1) {
			System.out.println("O Medicamento é Receitável ?");
			System.out.println("Se sim --> digite 1. Se não --> Digite 2: ");
			op2 = Integer.parseInt(ler.nextLine());
			if (op2 == 1) {
				Medicamento
				mr = new MedicamentoReceitavel();
				System.out.println("Digite o Nome do Medicamento Receitável: ");
				mr.setNome(ler.nextLine());
				System.out.println("Digite o Gênero do Medicamento Receitável: ");
				mr.setGenero(ler.nextLine());
				System.out.println("Digite a Marca do Medicamento Receitável: ");
				mr.setMarca(ler.nextLine());
				System.out.println("Digite o Código do Medicamento Receitável: ");
				mr.setCodigo(ler.nextLine());
				System.out.println("Digite o Preço do Medicamento Receitável: ");
				mr.setPreco(Double.parseDouble(ler.nextLine()));
				((MedicamentoReceitavel)mr).setReceita(true);
				System.out.println("Digite o Tipo do Medicamento Receitável: ");
				((MedicamentoReceitavel)mr).setTipo(ler.nextLine());
				System.out.println("Digite o Órgão Regulador do Medicamento Receitável: ");
				((Medicamento) mr).setOrgaoRegulador(ler.nextLine());
				System.out.println("Por Favor, preencha o Campo de RECEITA! ");
				Receita rc = new Receita();
				System.out.println("Digite o Nome do Médico: ");
				rc.setNomeDoMedico(ler.nextLine());
				System.out.println("Digite a Instituição Médica: ");
				rc.setInstituicao(ler.nextLine());
				System.out.println("Digite o Ano em que a Receita foi Prescrita: ");
				int ano = Integer.parseInt(ler.nextLine());
				System.out.println("Digite o Mês em que a Receita foi Prescrita: ");
				int mes = Integer.parseInt(ler.nextLine());
				System.out.println("Digite o Dia em que a Receita foi Prescrita: ");
				int dia = Integer.parseInt(ler.nextLine());
				rc.setDataPrescricao(LocalDate.of(ano, mes, dia));
				rc.setDataValidade(LocalDate.of(ano, mes, dia));
				System.out.println("Por questões éticas e médicas a Receita possui um prazo máximo de 180 dias pós Prescrição");
				System.out.println(rc.getDataValidade());
				System.out.println("Esse é o Prazo Final para a Validade desta Receita!");
				estoque.put(mr.getCodigo(), mr);
				System.out.println("Produto Adicionado com ao Estoque com Sucesso!");
			 
			} else if (op2 == 2) {
				Medicamento m = new Medicamento();
				System.out.println("Digite o Nome do Medicamento: ");
				m.setNome(ler.nextLine());
				System.out.println("Digite o Gênero do Medicamento: ");
				m.setGenero(ler.nextLine());
				System.out.println("Digite a Marca do Medicamento: ");
				m.setMarca(ler.nextLine());
				System.out.println("Digite o Código do Medicamento: ");
				m.setCodigo(ler.nextLine());
				System.out.println("Digite o Preço do Medicamento: ");
				m.setPreco(Double.parseDouble(ler.nextLine()));
				m.setReceita(false);
				System.out.println("Digite o Tipo do Medicamento: ");
				((Medicamento) m).setTipo(ler.nextLine());
				System.out.println("Digite o Órgão Regulador do Medicamento: ");
				((Medicamento) m).setOrgaoRegulador(ler.nextLine());
				estoque.put(m.getCodigo(), m);
				System.out.println("Produto Adicionado com ao Estoque com Sucesso!");
			}
		} else if (op == 2) {
			Camisinha cm = new Camisinha();
			System.out.println("Digite o Nome da Camisinha: ");
			cm.setNome(ler.nextLine());
			System.out.println("Digite o Gênero da Camisinha: ");
			cm.setGenero(ler.nextLine());
			System.out.println("Digite a Marca da Camisinha: ");
			cm.setMarca(ler.nextLine());
			System.out.println("Digite o Código da Camisinha: ");
			cm.setCodigo(ler.nextLine());
			System.out.println("Digite o Preço da Camisinha: ");
			cm.setPreco(Double.parseDouble(ler.nextLine()));
			System.out.println("Digite o Sabor da Camisinha: ");
			cm.setSabor(ler.nextLine());		
			estoque.put(cm.getCodigo(), cm);
			System.out.println("Produto Adicionado com ao Estoque com Sucesso!");
		}
	}

	@Override
	public void removerProduto() {
		if(estoque.isEmpty()) {
			System.out.println("Não Há Produtos Cadastrados");
		}else {
		System.out.println("Digite o código associado ao Produto que deve ser Removido:");
		exibirMapAuxiliar();
		String codigo = ler.nextLine();
		try {
			estoque.remove(codigo);
			System.out.println("Produto Removido Com SUCESSO!");
		}catch(NullPointerException e) {
			System.out.println("Produto NÃO encontrado em nossa Base de Dados");
		}
		}
	}

	@Override
	public void buscarProduto() {
		if(estoque == null) {
			System.out.println("Erro! Não Há Nenhum Produto Cadastrado.");
		}
		exibirMapAuxiliar();
		System.out.println("Digite o Código Associado ao Produto que você Deseja Buscar: ");
		String codigo = ler.nextLine();
		try {
			System.out.println(estoque.get(codigo));
		}catch(NullPointerException e) {
			System.out.println("Produto NÃO encontrado em nossa Base de Dados");
		}		
	}

	@Override
	public void listarProduto() {
		if(estoque == null) {
			System.out.println("Erro! Não Há Nenhum Produto Cadastrado.");
		}
		for(Entry<String, Produto> estoque : estoque.entrySet()) {
			System.out.println("Produtos Exibidos abaixo: ");
			System.out.println(estoque.getValue());
		}
	}
	
	@Override
	public boolean checarProduto(String codigo) {
		if(estoque.containsKey(codigo)) {
			System.out.println("olá mundo");
		}
		else {
			System.out.println("Produto Não Cadastrado");
		}
		
		return estoque.containsKey(codigo);
		/*for(Entry<String, Produto> estoque : estoque.entrySet()) {
			if(estoque.getKey().equals(codigo)) return true;
		}
		return false;
		*/
	}
	
	public void exibirMapAuxiliar() {
		for(Entry<String, Produto> estoque : estoque.entrySet()) {
			System.out.println(estoque.getKey() + "=>" + estoque.getValue().getNome());
		}
	}

}
