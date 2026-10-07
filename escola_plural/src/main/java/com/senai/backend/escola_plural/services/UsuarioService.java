package com.senai.backend.escola_plural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.senai.backend.escola_plural.models.Usuario;
import com.senai.backend.escola_plural.repositories.UsuarioRepository;

@Service
public class UsuarioService {

   
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO usuario) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha()));
        Usuario usuarioRetornado
                = usuarioRepository.findByEmail(usuario.getEmail()).orElseThrow();
        String token = jwtService.generateToken(usuarioRetornado.getEmail(),
                usuarioRetornado.getPerfil());
        return new LoginResponseDTO(usuarioRetornado.getEmail(),
                usuarioRetornado.getNome(), usuarioRetornado.getPerfil(), token);
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario, Integer id) {
        Usuario usuarioExistente = buscar(id);

        if (usuario.getNome() != null) {
            usuarioExistente.setNome(usuario.getNome());
        }

        if (usuario.getEmail() != null) {
            usuarioExistente.setEmail(usuario.getEmail());
        }

        if (usuario.getSenha() != null) {
            usuarioExistente.setSenha(
                    passwordEncoder.encode(usuario.getSenha())
            );
        }

        if (usuario.getPerfil() != null) {
            usuarioExistente.setPerfil(usuario.getPerfil());
        }

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario buscar(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Usuário não encontrado")
                );
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}

