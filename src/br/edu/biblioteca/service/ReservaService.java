package br.edu.biblioteca.service;

import java.util.LinkedList;
import java.util.Queue;

public class ReservaService {

    public static class Reserva {
        private String isbn;

        public Reserva(String isbn) {
            this.isbn = isbn;
        }

        public String getIsbn() {
            return isbn;
        }
    }

    private Queue<Reserva> reservas = new LinkedList<>();

    public void reservarLivro(String isbn) {
        reservas.add(new Reserva(isbn));
    }

    public boolean cancelarReserva(String isbn) {
        for (Reserva r : reservas) {
            if (r.getIsbn().equals(isbn)) {
                reservas.remove(r);
                return true;
            }
        }
        return false;
    }

    public Reserva atenderProximaReserva(String isbn) {
        for (Reserva r : reservas) {
            if (r.getIsbn().equals(isbn)) {
                reservas.remove(r);
                return r;
            }
        }
        return null;
    }
}