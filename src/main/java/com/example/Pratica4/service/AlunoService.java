package com.example.Pratica4.service;

import com.example.Pratica4.domain.Aluno;
import com.example.Pratica4.domain.StatusAluno;

public class AlunoService {
    
    public void registrarParticipacaoNoForum(Aluno aluno, String mensagem) {
        
        StatusAluno statusAtual = aluno.getStatus();
        
        StatusAluno proximoStatus = statusAtual.adicionarCurso();
        
        aluno.setStatus(proximoStatus);
    }
}
