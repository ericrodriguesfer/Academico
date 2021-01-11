package br.com.eric.pds.grasp.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import br.com.eric.pds.grasp.model.Post;
import br.com.eric.pds.grasp.model.Predicado;

public class RepositorioPosts {

    private static Integer idSequence = 0;
    private TreeMap<Integer, Post> posts = new TreeMap<Integer, Post>(new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1); // inverte a ordenacao
        }
    });

    public RepositorioPosts() {

    }

    public void adicionar(String titulo, String conteudo) {
        idSequence++;
        Post post = new Post();
        post.setId(idSequence);
        post.setTitulo(titulo);
        post.setCorpoTexto(conteudo);
        posts.put(post.getId(), post);
        System.out.println("NOVO POST: " + post.getTitulo() + " :: " + post.getCorpoTexto());
    }

    public void removerPor(Integer id) {
        posts.remove(id);
    }

    public List<Post> getUltimos(int quantidadeResultados) {
        List<Post> ultimosPosts = new ArrayList<Post>();
        for (Post postDaVez : posts.values()) {
            if (quantidadeResultados > 0) {
                ultimosPosts.add(postDaVez);
                quantidadeResultados--;
            }
        }
        return ultimosPosts;
    }

    public List<Post> getPorTitulo(String titulo) {
        return filtrar(contemTitulo, titulo);
    }

    Predicado<Post> contemTitulo = new Predicado<Post>() {
        public boolean aplicarA(Post post, Object titulo) {
            return post.getTitulo().contains((String) titulo);
        }
    };

    private List<Post> filtrar(Predicado<Post> consulta, String termoBusca) {
        List<Post> resultado = new ArrayList<Post>();
        for (Post postDaVez : posts.values()) {
            if (consulta.aplicarA(postDaVez, termoBusca)) {
                resultado.add(postDaVez);
            }
        }
        return resultado;
    }

}
