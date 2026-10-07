package com.senai.backend.escola_plural.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.senai.backend.escola_plural.models.Responsavel;
import java.util.List;
public interface ResponsavelRepository extends JpaRepository<Responsavel,Integer>{
    @Query(value="select * from responsavel where nome like '%'||:termo||'%';",
nativeQuery=true)
public List<Responsavel> listarResponsaveis(String termo);
}
