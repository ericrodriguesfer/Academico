package br.com.ei.projetos.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido extends EstoqueImpl {
	private String codigoPedido;
	private List<ItemPedido> pedido;
	private CupomDesconto cupomDesconto;

	public static Scanner ler = new Scanner(System.in);

	public Pedido() {
		this.pedido = new ArrayList<ItemPedido>();

	}

	public Pedido(String codigoPedido, List<ItemPedido> pedido, CupomDesconto cupomDesconto) {
		super();
		this.codigoPedido = codigoPedido;
		this.pedido = pedido;
		this.cupomDesconto = cupomDesconto;
		this.pedido = new ArrayList<ItemPedido>();

	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public List<ItemPedido> getProdutos() {
		return pedido;
	}

	public void setProdutos(List<ItemPedido> produtos) {
		this.pedido = produtos;
	}

	public CupomDesconto getCupomDesconto() {
		return cupomDesconto;
	}

	public void setCupomDesconto(CupomDesconto cupomDesconto) {
		this.cupomDesconto = cupomDesconto;
	}

	public void realizarPedido() {
		Pedido pedido = new Pedido();
		System.out.println("Digite o Código do Pedido: ");
		pedido.setCodigoPedido(ler.nextLine());
		System.out.println("---MENU GERENCIÁVEL---");
		System.out.println("Digite abaixo a Opção Desejada: ");
		System.out.println("1---> Adicionar Produto");
		System.out.println("2---> Remover Produto");
		System.out.println("3---> Adicionar Cupom de Desconto");
		System.out.println("4---> Sair");
		int op = Integer.parseInt(ler.nextLine());
		while (op != 4) {
			while (op != 1 || op != 2 || op !=3 || op!=4 ) {
				if (op == 1) {
					pedido.adicionarProduto();
				} else if (op == 2) {
					pedido.removerProduto();
				}else if(op == 3) {
					pedido.aplicarDesconto();
				} else {
					System.out.println("Opção Inválida, Favor Digitar Novamente!");
				}
			}
		}
	}

	public void adicionarProduto() {
		String codigo;
		System.out.println("Digite o Código do Produto a ser Adicionado:");
		codigo = ler.nextLine();
		System.out.println(estoque.get(codigo));
		if (estoque.containsKey(codigo)) {
			pedido.add((ItemPedido) estoque.get(codigo));
			System.out.println("Produto Adicionado!");
		} else {
			System.out.println("Produto Inexistente! Código Inválido.");
		}
	}
	
	public void removerProduto() {
		String codigo;
		System.out.println("Digite o Código do Produto a ser Removido:");
		codigo = ler.nextLine();
		if (((EstoqueImpl) estoque).checarProduto(codigo)) {
			pedido.remove((ItemPedido) estoque.get(codigo));
			System.out.println("Produto Removido!");
		} else {
			System.out.println("Produto Inexistente! Código Inválido.");
		}
	}

	public void verificarPedido() {
		for(ItemPedido ip: pedido ) {
			System.out.println("Lista de Pedidos Já Realizados: ");
			System.out.println(ip);
		}
	}
	
	public void verificarPedidoParticular() {
		System.out.println("Digite o Código do Pedido: ");
		String codigo = ler.nextLine();
		for(ItemPedido ip: pedido ) {
			if((ip.getCodigo()).equals(codigo)) {
			System.out.println(ip);
			}
		}
	}

	public double calcularPedido() {
		double valorTotal = 0;
		for (ItemPedido ip : pedido) {
			valorTotal += ip.valorItem();
		}
		return valorTotal;
	}

	public void aplicarDesconto() {
		CupomDesconto cupom = new CupomDesconto();
		System.out.println("Digite o Nome da Promoção a ser Aplicada: ");
		cupom.setNomePromocao(ler.nextLine());
		System.out.println("Digite o Código do Cupom de Desconto: ");
		cupom.setCodigoDesconto(ler.nextLine());
		System.out.println("Digite a Porcentagem de Desconto a ser Aplicada:");
		System.out.println("Digite apenas o Número, sem o %!");
		System.out.println("Exemplo: 15");
		cupom.setPorcentagemDesconto(Integer.parseInt(ler.nextLine()));
		double valorTotal = calcularPedido();
		double valorComDesconto = 0;
		valorComDesconto = (valorTotal - (valorTotal * cupom.getPorcentagemDesconto()));
		System.out.println("O Seu Pedido Após o Desconto custa :" + valorComDesconto);
	}

}
