package br.com.eric.pds.grasp.controller;

import br.com.eric.pds.grasp.data.RepositorioPosts;
import javax.swing.JOptionPane;

public class Controlador {

    private RepositorioPosts repositorioPosts;

    public Controlador() {
        this.repositorioPosts = new RepositorioPosts();
    }

    public void realizarPostagem(String titulo, String conteudo) {
        if (titulo.equals("Digite o titulo da noticia...") || conteudo.equals("Digite o corpo da noticia...")) {
            JOptionPane.showMessageDialog(null, "Por favor digite um titulo e conteudo", "ERROR", 0);
        } else {
            this.repositorioPosts.adicionar(titulo, conteudo);
        }
    }
}
