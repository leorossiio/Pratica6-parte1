package com.example.Pratica4.controller;

import com.example.Pratica4.entity.Aluno;
import com.example.Pratica4.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/{id}/forum")
    public ResponseEntity<Aluno> registrarParticipacao(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        
        String mensagem = body.get("mensagem");
        Aluno alunoAtualizado = alunoService.registrarParticipacaoNoForum(id, mensagem);
        
        return ResponseEntity.ok(alunoAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarAlunoPorId(id);
        return ResponseEntity.ok(aluno);
    }
}