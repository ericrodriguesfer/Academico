package br.com.ei.projetos.model;

import java.util.Scanner;

public class ItemPedido extends Produto{

	private int qtdProdutos;

	Scanner ler = new Scanner(System.in);
	
	public ItemPedido() {
		super();
	}

	public ItemPedido(String nome, String genero, String marca, String codigo, double preco, int qtdPedidos) {
		super(nome, genero, marca, codigo, preco);
		this.qtdProdutos = qtdPedidos;
	}

	
	public double valorItem() {
		double valorItem = 0;
		ItemPedido item = new ItemPedido();
		System.out.println("Quantas unidades deste Item você deseja Adicionar ?");
		item.setQtdProdutos(Integer.parseInt(ler.nextLine()));
		valorItem = (item.getPreco() * item.getQtdProdutos());
			return valorItem;
	}
	
	public int getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}
	
	
	
	
}
