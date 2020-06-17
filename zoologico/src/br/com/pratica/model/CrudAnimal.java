package br.com.pratica.model;

public interface CrudAnimal {
	public void adicionarAnimal(Animal a);
	public void removerAnimal(Object a);
	public void buscarAnimal(String nome);
	public void exibirZoologico();
}
