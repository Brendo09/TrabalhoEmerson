package br.edu.ifsuldeminas.mch.myapplication;

public class Servico {
    private String nome;
    private float valor;

    public Servico(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public float getValor() {
        return valor;
}
}