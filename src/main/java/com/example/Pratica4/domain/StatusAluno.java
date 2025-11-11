package com.example.Pratica4.domain;

public class StatusAluno {

    private static final int CURSOS_PREMIUM = 12;

    private final int cursosConcluidos;
    private final boolean premium;

    private StatusAluno(int cursosConcluidos) {
        this.cursosConcluidos = cursosConcluidos;
        this.premium = (cursosConcluidos >= CURSOS_PREMIUM);
    }

    public static StatusAluno inicial() {
        return new StatusAluno(0);
    }
    
    public static StatusAluno comCursos(int totalCursos) {
        return new StatusAluno(totalCursos);
    }

    public int getCursosConcluidos() {
        return cursosConcluidos;
    }

    public int getCursos() {
        return this.cursosConcluidos;
    }

    public boolean isPremium() {
        return premium;
    }

    public StatusAluno adicionarCurso() {
        return new StatusAluno(this.cursosConcluidos + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusAluno that = (StatusAluno) o;
        return cursosConcluidos == that.cursosConcluidos;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(cursosConcluidos);
    }
}
