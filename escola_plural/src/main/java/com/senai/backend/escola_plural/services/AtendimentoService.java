package com.senai.backend.escola_plural.services;

import com.senai.backend.escola_plural.repositories.AtendimentoRepository;
import java.util.List;
import com.senai.backend.escola_plural.dtos.AtendimentoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.backend.escola_plural.models.Atendimento;
@Service 
public class AtendimentoService {


    private final AtendimentoRepository atendimentoRepository_1;
    @Autowired
    private AtendimentoRepository atendimentoRepository;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private UsuarioService usuarioService;

    AtendimentoService(AtendimentoRepository atendimentoRepository_1) {
        this.atendimentoRepository_1 = atendimentoRepository_1;
    }

    public List<AtendimentoResponseDTO> listarAtendimentos() {
        return atendimentoRepository.listarAtendimentos().stream()
                .map(atendimento -> new AtendimentoResponseDTO(atendimento.getData(), atendimento.getAluno()))
                .toList();
    }

    public AtendimentoResponseDTO buscar(Integer id) {
        Atendimento atendimento = atendimentoRepository.findById(id).get();
        return new AtendimentoResponseDTO(atendimento.getData(),
                atendimento.getAluno());
    }

    public void deletar(Integer id) {
        atendimentoRepository.deleteById(id);
    }

    public Atendimento cadastrar(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento atualizar(Atendimento atendimento, Integer id) {
        Atendimento atendimentoExistente
                = atendimentoRepository.findById(id).get();
        if (atendimentoExistente == null) {
            throw new RuntimeException("Atendimento não encontrado");
        }
        if (atendimento.getData() != null) {
            atendimentoExistente.setData(atendimento.getData());
        }
        if (atendimento.getAluno() != null) {
            atendimentoExistente.setAluno(alunoService.buscar(atendimento.getAluno().getId()));
        }
        if (atendimento.getUsuario() != null) {
            atendimentoExistente.setUsuario(usuarioService.buscar(atendimento.getUsuario().getId()));
        }
        return atendimentoRepository_1.save(atendimentoExistente);
    }
}




    

