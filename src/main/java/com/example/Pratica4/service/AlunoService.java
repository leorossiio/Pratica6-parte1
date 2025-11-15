package com.example.Pratica4.service;

import com.example.Pratica4.entity.Aluno;
import com.example.Pratica4.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Aluno registrarParticipacaoNoForum(Long alunoId, String mensagem) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> 
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aluno com id " + alunoId + " não encontrado"
                        )
                );

        aluno.registrarParticipacaoNoForum(mensagem);
        return alunoRepository.save(aluno);
    }

    @Transactional(readOnly = true)
    public Aluno buscarAlunoPorId(Long alunoId) {
        return alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aluno com id " + alunoId + " não encontrado"
                        )
                );
    }
}
