package com.example.Pratica4.service;

import com.example.Pratica4.domain.Aluno;

public class AlunoService {

    private static final int CURSOS_PREMIUM = 12;

    public void registrarParticipacaoNoForum(Aluno aluno, String mensagem) {
        aluno.setCursosConcluidos(aluno.getCursosConcluidos() + 1);
        atualizarPlanoSeElegivel(aluno);
    }

    public void atualizarPlanoSeElegivel(Aluno aluno) {
        aluno.setPremium(aluno.getCursosConcluidos() >= CURSOS_PREMIUM);
    }
}