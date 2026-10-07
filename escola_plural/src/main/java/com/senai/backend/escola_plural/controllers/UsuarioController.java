package com.senai.backend.escola_plural.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import com.senai.backend.escola_plural.models.Usuario;
import com.senai.backend.escola_plural.services.UsuarioService;

@RestController 
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestBody Usuario usuario) { 
        usuarioService.cadastrar(usuario);
    return "Usuário cadastrado com sucesso";
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            LoginResponseDTO response = usuarioService.login(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Falha na autenticação: e-mail
    ou senha inválidos");
        }
    }
    @PostMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "Logout realizado com sucesso";
    }
    @PutMapping ("/atualizar/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable Integerid)
    {
        return usuarioService.atualizar(usuario, id);
    }
    @DeleteMapping ("/deletar/{id}")
    public String deletar(@PathVariable Integer id) {
        usuarioService.deletar(id);
        return "Usuário deletado com sucesso";
    }
    @GetMapping("/buscar/{id}")
    public Usuario buscar(@PathVariable Integer id) { return
        usuarioService.buscar(id); }
    @GetMapping ("/listar")
    public List<Usuario> listarUsuarios() { return
        usuarioService.listarUsuarios(); }
}
