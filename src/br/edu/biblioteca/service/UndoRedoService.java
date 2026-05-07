package br.edu.biblioteca.service;

import java.util.Stack;

public class UndoRedoService {

    private Stack<String> undo = new Stack<>();
    private Stack<String> redo = new Stack<>();

    public void registrarAcao(String acao) {
        undo.push(acao);
        redo.clear();
    }

    public String desfazer() {
        if (!undo.isEmpty()) {
            String a = undo.pop();
            redo.push(a);
            return a;
        }
        return null;
    }

    public String refazer() {
        if (!redo.isEmpty()) {
            String a = redo.pop();
            undo.push(a);
            return a;
        }
        return null;
    }
}