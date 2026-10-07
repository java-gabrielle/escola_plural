package com.senai.backend.escola_plural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.backend.escola_plural.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
