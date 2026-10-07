package com.senai.backend.escola_plural.dtos;

import java.time.LocalDate;

import com.senai.backend.escola_plural.models.Aluno;

public class AtendimentoResponseDTO {
    private LocalDate data;
    private Aluno aluno;

    public AtendimentoResponseDTO(){

    }

    public AtendimentoResponseDTO(LocalDate data, Aluno aluno) {
        this.data = data;
        this.aluno = aluno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    
}
