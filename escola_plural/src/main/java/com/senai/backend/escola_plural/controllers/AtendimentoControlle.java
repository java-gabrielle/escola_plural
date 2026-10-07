package com.senai.backend.escola_plural.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import com.senai.backend.escola_plural.models.Atendimento;
import com.senai.backend.escola_plural.services.AtendimentoService;

@RestController 
@RequestMapping("/atendimentos")
public class AtendimentoControlle {

     @Autowired private AtendimentoService atendimentoService;
     @GetMapping("/listar")
     public List<AtendimentoResponseDTO> listarAtendimentos() { return
        atendimentoService.listarAtendimentos();
    }
    @GetMapping("/buscar/{id}")
    public AtendimentoResponseDTO buscarAtendimento(@PathVariable Integer id) {
        return atendimentoService.buscar(id); }

    @DeleteMapping("/deletar/{id}")
    public String deletarAtendimento(@PathVariable Integer id) {
        atendimentoService.deletar(id);
        return "Atendimento deletado com sucesso";
    }

    @PostMapping("/cadastrar")
    public String cadastrarAtendimento(@RequestBody Atendimento atendimento) {
        atendimentoService.cadastrar(atendimento);
        return "Atendimento cadastrado com sucesso";
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarAtendimento(@RequestBody Atendimento atendimento,
        @PathVariable Integer id) {
            atendimentoService.atualizar(atendimento, id);
            return "Atendimento atualizado com sucesso";
        }
}
    

