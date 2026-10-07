package com.senai.backend.escola_plural.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.senai.backend.escola_plural.models.Atendimento;
import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
   @Query(
        value = "select at.id, at.data, at.aluno_id, at.usuario_id, "
              + "al.nome as aluno_nome, "
              + "r.nome as responsavel_nome, r.cpf as responsavel_cpf "
              + "from atendimento at "
              + "inner join aluno al on al.id = at.aluno_id "
              + "inner join responsavel r on r.id = al.responsavel_id "
              + "order by at.data",
        nativeQuery = true
    )    public List<Atendimento> listarAtendimentos();
}

