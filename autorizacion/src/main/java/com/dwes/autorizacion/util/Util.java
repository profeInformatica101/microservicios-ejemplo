package com.dwes.autorizacion.util;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.dwes.autorizacion.dto.response.UsuarioResponse;
import com.dwes.autorizacion.entidad.Role;
import com.dwes.autorizacion.entidad.Usuario;

public class Util {
	public static UsuarioResponse mapToUsuarioResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setNombre(usuario.getFirstName());
        response.setApellido(usuario.getLastName());
        response.setEmail(usuario.getEmail());

        Set<String> roles = usuario.getRoles().stream()
            .map(role -> new SimpleGrantedAuthority(role.name()).getAuthority())
            .collect(Collectors.toSet());

        response.setRoles(roles);

        return response;
    }
	

    public static Usuario mapToUsuario(UsuarioResponse usuarioResponse) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioResponse.getId());
        usuario.setFirstName(usuarioResponse.getNombre());
        usuario.setLastName(usuarioResponse.getApellido());
        usuario.setEmail(usuarioResponse.getEmail());
        // Asumiendo que tienes un método para convertir un String a un Role
        Set<Role> roles = usuarioResponse.getRoles().stream()
            .map(roleString -> Role.valueOf(roleString)) // Asegúrate de manejar las excepciones aquí si el string no corresponde a un valor válido de Role
            .collect(Collectors.toSet());

        usuario.setRoles(roles);

        // Omitimos la contraseña ya que normalmente no se incluiría en un objeto de respuesta y no se podría mapear desde ella.
        // Además, considera si necesitas manejar casos donde ciertos campos no deben ser actualizados o mapeados.

        return usuario;
    }
}



