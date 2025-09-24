package com.example.Pratica4;

import org.junit.jupiter.api.Test;
import com.example.Pratica4.domain.Aluno;
import com.example.Pratica4.service.AlunoService;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    private final AlunoService alunoService = new AlunoService();

    // Leonardo
    @Test
    void testarGetNome() {
        // Arrange
        Aluno aluno = new Aluno("Guilherme", 5);

        // Act
        String nome = aluno.getNome();

        // Assert
        assertEquals("Guilherme", nome, "O getter deve retornar o nome correto");
    }

    // Leonardo
    @Test
    void alunoSeTornaPremiumQuandoConclui12Cursos() {
        // Arrange
        Aluno aluno = new Aluno("Guilherme", 12);

        // Act
        alunoService.atualizarPlanoSeElegivel(aluno);

        // Assert
        assertTrue(aluno.isPremium(), "O aluno deveria ser Premium");
    }

    // Guilherme
    @Test
    void alunoNaoSeTornaPremiumAntesDe12Cursos() {
        // Arrange
        Aluno aluno = new Aluno("Leonardo", 10);

        // Act
        alunoService.atualizarPlanoSeElegivel(aluno);

        // Assert
        assertFalse(aluno.isPremium(), "O aluno não deveria ser Premium");
    }

    // Guilherme
    @Test
    void alunoParticipaDoForumEIncrementaCurso() {
        // Arrange
        Aluno aluno = new Aluno("Maria", 11);

        // Act
        alunoService.registrarParticipacaoNoForum(aluno, "Nova mensagem");
        alunoService.atualizarPlanoSeElegivel(aluno);

        // Assert
        assertEquals(12, aluno.getCursosConcluidos(), "Cursos deveriam ter sido incrementados");
        assertTrue(aluno.isPremium(), "O aluno deveria se tornar Premium após 12 cursos");
    }
}