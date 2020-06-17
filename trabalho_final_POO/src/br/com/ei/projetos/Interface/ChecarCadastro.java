package br.com.ei.projetos.Interface;

public interface ChecarCadastro {
	
	public boolean checarLogin(String login, String senha);
	public boolean checarLogin(String login);
	public boolean checarFuncionario(String idFuncionario);
}
