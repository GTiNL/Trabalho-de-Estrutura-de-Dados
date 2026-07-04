package br.edu.biblioteca.model;

public class Acao { //classe que representa uma ação do sistema

    private String tipo;
    private String descricao;

    public Acao(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String toString() {
        return "[" + tipo + "] " + descricao;
    }
}
