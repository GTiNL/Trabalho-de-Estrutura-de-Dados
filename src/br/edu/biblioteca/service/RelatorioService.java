package br.edu.biblioteca.service;

import java.util.List;

public class RelatorioService {

    public void topMaisEmprestados() {
        System.out.println("Top livros emprestados");
    }

    public void usuariosComMaisAtrasos() {
        System.out.println("Usuários com atrasos");
    }

    public List<?> emAtraso(List<?> lista) {
        return lista;
    }

    public void estatisticasMensais() {
        System.out.println("Estatísticas mensais geradas");
    }
}
