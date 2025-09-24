package com.example.Pratica4.domain;

public class Aluno {

    private String nome;
    private int cursosConcluidos;
    private boolean premium;

    public Aluno(String nome, int cursosConcluidos) {
        this.nome = nome;
        this.cursosConcluidos = cursosConcluidos;
        this.premium = false;
    }

    public String getNome() {
        return nome;
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setCursosConcluidos(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
