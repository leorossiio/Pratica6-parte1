package com.example.Pratica4;

import com.example.Pratica4.entity.Aluno;
import com.example.Pratica4.repository.AlunoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AlunoStoriesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Map<String, String> bodyRequisicao;

    @BeforeEach
    void setUp() {
        alunoRepository.deleteAll();

        bodyRequisicao = new HashMap<>();
        bodyRequisicao.put("mensagem", "Participando do fórum!");
    }

    // Responsável: Leonardo Rossi
    @Test
    void deveFalharAoCriarAlunoComNomeVazio() {

        // Arrange
        String nomeInvalido = "";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Aluno(nomeInvalido, 0);
        });

        assertEquals("Nome não pode ser nulo ou vazio", exception.getMessage());
    }

    // Responsável: Leonardo Rossi
    @Test
    void deveRetornarAlunoPorIdComStatusCorreto() throws Exception {

        // Arrange
        Aluno aluno = new Aluno("Leonardo Rossi", 5);
        Aluno alunoSalvo = alunoRepository.save(aluno);

        // Act & Assert
        mockMvc.perform(get("/alunos/" + alunoSalvo.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Leonardo Rossi")))
                .andExpect(jsonPath("$.cursosConcluidos", is(5)))
                .andExpect(jsonPath("$.premium", is(false)));
    }

    // Responsável: Leonardo Rossi
    @Test
    void deveRegistrarParticipacaoNoForumEIncrementarCursosConcluidos() throws Exception {

        // Arrange
        Aluno aluno = new Aluno("Leonardo Rossi", 10);
        Aluno alunoSalvo = alunoRepository.save(aluno);

        String jsonBody = objectMapper.writeValueAsString(bodyRequisicao);

        // Act & Assert
        mockMvc.perform(post("/alunos/" + alunoSalvo.getId() + "/forum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cursosConcluidos", is(11)))
                .andExpect(jsonPath("$.premium", is(false)));
    }

    // Responsável: Guilherme Massayuki
    @Test
    void devePromoverAlunoParaPremiumAoAlcancar12Cursos() throws Exception {

        // Arrange
        Aluno aluno = new Aluno("Guilherme Massayuki", 11);
        Aluno alunoSalvo = alunoRepository.save(aluno);

        String jsonBody = objectMapper.writeValueAsString(bodyRequisicao);

        // Act & Assert
        mockMvc.perform(post("/alunos/" + alunoSalvo.getId() + "/forum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cursosConcluidos", is(12)))
                .andExpect(jsonPath("$.premium", is(true)));

        Aluno alunoNoBanco = alunoRepository.findById(alunoSalvo.getId()).orElseThrow();
        assertEquals(12, alunoNoBanco.getCursosConcluidos());
        assertTrue(alunoNoBanco.isPremium());
    }

    // Responsável: Guilherme Massayuki
    @Test
    void deveRetornarErroAoBuscarAlunoInexistente() throws Exception {

        // Arrange
        long idInexistente = 9999L;

        // Act & Assert
         mockMvc.perform(get("/alunos/" + idInexistente))
            .andExpect(status().isNotFound());
    }
}
