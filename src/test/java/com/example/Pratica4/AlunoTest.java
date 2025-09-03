package com.example.Pratica4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void alunoSeTornaPremiumQuandoConclui12Cursos() {

        // Arrange
        Aluno aluno = new Aluno("Guilherme", 12);

        // Act
        aluno.atualizarPlanoSeElegivel(); // stub: não faz nada

        // Assert
        assertTrue(aluno.isPremium(), "O aluno deveria ser Premium");
    }

    @Test
    void alunoNaoSeTornaPremiumAntesDe12Cursos() {
    	
        // Arrange
        Aluno aluno = new Aluno("Leonardo", 10);

        // Act
        aluno.atualizarPlanoSeElegivel(); // stub: não faz nada

        // Assert
        assertFalse(aluno.isPremium(), "O aluno não deveria ser Premium");
    }

    @Test
    void alunoParticipaDoForumEIncrementaCurso() {
    	
        // Arrange
        Aluno aluno = new Aluno("Maria", 11);

        // Act
        aluno.registrarParticipacaoNoForum("Nova mensagem"); // stub: não incrementa cursos

        // Assert
        assertEquals(12, aluno.getCursosConcluidos(), "Cursos deveriam ter sido incrementados");
    }
}