package com.dwes.usuario.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dwes.usuario.entidad.Usuario;
import com.dwes.usuario.repositorio.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuario) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalStateException("Usuario with id " + id + " does not exist.");
        }
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        boolean exists = usuarioRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Usuario with id " + id + " does not exist.");
        }
        usuarioRepository.deleteById(id);
    }



	public Optional<Usuario> findUsuarioByEmail(String email) {
		
		return usuarioRepository.findByEmail(email);
	}
}