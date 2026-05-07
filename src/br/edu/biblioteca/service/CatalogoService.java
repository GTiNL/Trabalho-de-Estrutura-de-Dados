package br.edu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

public class CatalogoService {

    public static class Livro {
        private String ISBNLivro;

        public Livro(String ISBNLivro) {
            this.ISBNLivro = ISBNLivro;
        }

        public String getISBNLivro() {
            return ISBNLivro;
        }
    }

    private List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(String isbn) {
        livros.add(new Livro(isbn));
    }

    public List<Livro> listar() {
        return livros;
    }

    public Livro buscar(String isbn) {
        for (Livro l : livros) {
            if (l.getISBNLivro().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    public boolean remover(String isbn) {
        Livro l = buscar(isbn);
        if (l != null) {
            livros.remove(l);
            return true;
        }
        return false;
    }
}