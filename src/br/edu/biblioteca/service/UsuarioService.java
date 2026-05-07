package br.edu.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    public static class Usuario {

        private int ID;
        private String nome;
        private boolean bloqueado;

        public Usuario(int ID, String nome) {
            this.ID = ID;
            this.nome = nome;
            this.bloqueado = false;
        }

        public int getID() {
            return ID;
        }

        public String getNome() {
            return nome;
        }

        public boolean isBloqueado() {
            return bloqueado;
        }

        public void setBloqueado(boolean bloqueado) {
            this.bloqueado = bloqueado;
        }
    }

    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(int id, String nome) {
        usuarios.add(new Usuario(id, nome));
    }

    public List<Usuario> listar() {
        return usuarios;
    }

    public boolean bloquearUsuario(int id) {

        for (Usuario u : usuarios) {
            if (u.getID() == id) {
                u.setBloqueado(true);
                return true;
            }
        }

        return false;
    }

    public boolean desbloquearUsuario(int id) {

        for (Usuario u : usuarios) {
            if (u.getID() == id) {
                u.setBloqueado(false);
                return true;
            }
        }

        return false;
    }
}