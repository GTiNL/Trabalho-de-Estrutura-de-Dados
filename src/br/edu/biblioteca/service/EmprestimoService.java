package br.edu.biblioteca.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoService {

    public static class Emprestimo {
        private int ID;
        private LocalDate prevista;
        private LocalDate devolucao;

        public Emprestimo(int ID, LocalDate prevista) {
            this.ID = ID;
            this.prevista = prevista;
        }

        public int getID() { return ID; }
        public LocalDate getDataPrevista() { return prevista; }
        public void setDataPrevista(LocalDate d) { this.prevista = d; }
        public LocalDate getDataDevolucao() { return devolucao; }
        public void setDataDevolucao(LocalDate d) { this.devolucao = d; }
    }

    public static class Multa {
        private int idEmprestimo;
        private int dias;
        private double valor;

        public void setEmprestimoId(int id) { this.idEmprestimo = id; }
        public void setDiasAtraso(int d) { this.dias = d; }
        public void setValor(double v) { this.valor = v; }
    }

    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void emprestar(int id, LocalDate prevista) {
        emprestimos.add(new Emprestimo(id, prevista));
    }

    public boolean devolver(int id) {
        for (Emprestimo e : emprestimos) {
            if (e.getID() == id) {
                e.setDataDevolucao(LocalDate.now());
                return true;
            }
        }
        return false;
    }

    public boolean renovar(int id, int dias) {
        for (Emprestimo e : emprestimos) {
            if (e.getID() == id) {
                e.setDataPrevista(e.getDataPrevista().plusDays(dias));
                return true;
            }
        }
        return false;
    }

    public Multa calcularMulta(Emprestimo e) {

        if (e.getDataDevolucao() == null) return null;

        long atraso = ChronoUnit.DAYS.between(e.getDataPrevista(), e.getDataDevolucao());

        if (atraso <= 0) return null;

        Multa m = new Multa();
        m.setEmprestimoId(e.getID());
        m.setDiasAtraso((int) atraso);
        m.setValor(atraso * 2);

        return m;
    }
}