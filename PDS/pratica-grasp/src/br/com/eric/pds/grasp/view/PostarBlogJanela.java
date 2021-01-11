package br.com.eric.pds.grasp.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.eric.pds.grasp.controller.Controlador;

@SuppressWarnings("serial")
public class PostarBlogJanela extends JFrame implements ActionListener {

    JButton publicar;
    JTextField titulo;
    JTextArea corpo;
    Controlador controlador;

    public PostarBlogJanela() {
        titulo = new JTextField("Digite o titulo da noticia...");
        this.add(titulo, BorderLayout.NORTH);

        corpo = new JTextArea("Digite o corpo da noticia...");
        this.add(corpo, BorderLayout.CENTER);

        publicar = new JButton("Publicar Post");
        publicar.addActionListener(this);
        this.add(publicar, BorderLayout.SOUTH);

        this.controlador = new Controlador();
    }

    public void mostrar() {
        this.setSize(400, 400);
        this.setLocation(100, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent publicarPost) {
        this.controlador.realizarPostagem(this.titulo.getText(), this.corpo.getText());
    }
}
