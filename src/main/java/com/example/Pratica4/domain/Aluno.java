package com.example.Pratica4.domain;

public class Aluno {

    private String nome;
    private StatusAluno status;
    private boolean premium; // ✅ NOVO ATRIBUTO

    public Aluno(String nome, int cursosConcluidos) {
        this.nome = nome;
        this.status = StatusAluno.comCursos(cursosConcluidos);
        this.premium = this.status.isPremium();
    }

    public String getNome() {
        return nome;
    }

    public int getCursosConcluidos() {
        return this.status.getCursosConcluidos();
    }

    public boolean isPremium() {
        return this.premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public StatusAluno getStatus() {
        return this.status;
    }

    public void setStatus(StatusAluno novoStatus) {
        this.status = novoStatus;
        this.premium = novoStatus.isPremium();
    }
}
