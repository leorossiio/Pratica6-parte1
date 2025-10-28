package com.example.Pratica4.domain;

public class Aluno {

    private String nome;
    private StatusAluno status;

    public Aluno(String nome, int cursosConcluidos) {
        this.nome = nome;
        this.status = StatusAluno.comCursos(cursosConcluidos);
    }

    public String getNome() {
        return nome;
    }

    public int getCursosConcluidos() {
        return this.status.getCursosConcluidos();
    }

    public boolean isPremium() {
        return this.status.isPremium();
    }
    
    public StatusAluno getStatus() {
        return this.status;
    }

    public void setStatus(StatusAluno novoStatus) {
        this.status = novoStatus;
    }
}
