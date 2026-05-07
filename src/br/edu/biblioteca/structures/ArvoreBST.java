package br.edu.biblioteca.structures;

public class ArvoreBST<K extends Comparable<K>, V> {

    private class No {
        K chave;
        V valor;
        No esquerda;
        No direita;

        No(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private No raiz;
    private int size;

    public ArvoreBST() {
        this.raiz = null;
        this.size = 0;
    }

    public void put(K chave, V valor) {
        raiz = inserir(raiz, chave, valor);
    }

    private No inserir(No no, K chave, V valor) {
        if (no == null) {
            size++;
            return new No(chave, valor);
        }

        int comparacao = chave.compareTo(no.chave);
        if (comparacao < 0) {
            no.esquerda = inserir(no.esquerda, chave, valor);
        } else if (comparacao > 0) {
            no.direita = inserir(no.direita, chave, valor);
        } else {
            no.valor = valor;
        }
        return no;
    }

    public V get(K chave) {
        No resultado = buscar(raiz, chave);
        if (resultado != null) {
            return resultado.valor;
        }
        return null;
    }

    private No buscar(No no, K chave) {
        if (no == null) {
            return null;
        }

        int comparacao = chave.compareTo(no.chave);
        if (comparacao < 0) {
            return buscar(no.esquerda, chave);
        } else if (comparacao > 0) {
            return buscar(no.direita, chave);
        } else {
            return no;
        }
    }

    public boolean containsKey(K chave) {
        return get(chave) != null;
    }

    public V remove(K chave) {
        V valor = get(chave);
        if (valor != null) {
            raiz = remover(raiz, chave);
            size--;
        }
        return valor;
    }

    private No remover(No no, K chave) {
        if (no == null) {
            return null;
        }

        int comparacao = chave.compareTo(no.chave);
        if (comparacao < 0) {
            no.esquerda = remover(no.esquerda, chave);
        } else if (comparacao > 0) {
            no.direita = remover(no.direita, chave);
        } else {

            if (no.esquerda == null) {
                return no.direita;
            }
            if (no.direita == null) {
                return no.esquerda;
            }
            No sucessor = encontrarMinimo(no.direita);
            no.chave = sucessor.chave;
            no.valor = sucessor.valor;
            no.direita = remover(no.direita, sucessor.chave);
        }
        return no;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    public Vetor<V> inOrder() {
        Vetor<V> resultado = new Vetor<>();
        percorrerEmOrdem(raiz, resultado);
        return resultado;
    }

    private void percorrerEmOrdem(No no, Vetor<V> resultado) {
        if (no == null) {
            return;
        }
        percorrerEmOrdem(no.esquerda, resultado);
        resultado.add(no.valor);
        percorrerEmOrdem(no.direita, resultado);
    }

    public Vetor<K> chaves() {
        Vetor<K> resultado = new Vetor<>();
        percorrerChaves(raiz, resultado);
        return resultado;
    }

    private void percorrerChaves(No no, Vetor<K> resultado) {
        if (no == null) {
            return;
        }
        percorrerChaves(no.esquerda, resultado);
        resultado.add(no.chave);
        percorrerChaves(no.direita, resultado);
    }

    public int tamanho() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        Vetor<V> valores = inOrder();
        return "ArvoreBST " + valores.toString();
    }
}
