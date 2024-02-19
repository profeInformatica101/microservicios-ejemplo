package com.dwes.usuario;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dwes.usuario.entidad.PerfilUsuario;
import com.dwes.usuario.entidad.Role;
import com.dwes.usuario.entidad.Usuario;
import com.dwes.usuario.repositorio.PerfilUsuarioRepository;
import com.dwes.usuario.repositorio.UsuarioRepository;

import lombok.Builder;


@Component
@Profile("default")
public class IniciarDatos implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        
     PerfilUsuario perfilAdmin1 =  PerfilUsuario.builder()
    	        .nombre("Admin")
    	        .apellido("One")
    	        .telefono("111-111-1111")
    	        .build();
     PerfilUsuario perfilAdmin2 = PerfilUsuario.builder()
    	        .nombre("Admin")
    	        .apellido("Two")
    	        .telefono("222-222-2222")
    	        .build();

    	PerfilUsuario perfilUser1 = PerfilUsuario.builder()
    	        .nombre("User")
    	        .apellido("One")
    	        .telefono("333-333-3333")
    	        .build();

    	PerfilUsuario perfilUser2 = PerfilUsuario.builder()
    	        .nombre("User")
    	        .apellido("Two")
    	        .telefono("444-444-4444")
    	        .build();
    	
    	perfilUsuarioRepository.save(perfilAdmin1);
    	perfilUsuarioRepository.save(perfilAdmin2);
    	perfilUsuarioRepository.save(perfilUser1);
    	perfilUsuarioRepository.save(perfilUser2);
    	
    	
    	Usuario admin1 = Usuario.builder()
    	        .email("admin1@example.com")
    	        .clave(passwordEncoder.encode("admin1pass"))
    	        .roles(Set.of(Role.ROLE_ADMIN)) // Asegúrate de que el Builder pueda manejar Set<Role>
    	        .perfil(perfilAdmin1)
    	        .build();

    	Usuario admin2 = Usuario.builder()
    	        .email("admin2@example.com")
    	        .clave(passwordEncoder.encode("admin2pass"))
    	        .roles(Set.of(Role.ROLE_ADMIN))
    	        .perfil(perfilAdmin2)
    	        .build();

    	Usuario user1 = Usuario.builder()
    	        .email("user1@example.com")
    	        .clave(passwordEncoder.encode("user1pass"))
    	        .roles(Set.of(Role.ROLE_USER))
    	        .perfil(perfilUser1)
    	        .build();

    	Usuario user2 = Usuario.builder()
    	        .email("user2@example.com")
    	        .clave(passwordEncoder.encode("user2pass"))
    	        .roles(Set.of(Role.ROLE_USER))
    	        .perfil(perfilUser2)
    	        .build();
    	usuarioRepository.save(admin1);
    	usuarioRepository.save(admin2);
    	usuarioRepository.save(user1);
    	usuarioRepository.save(user2);
     
    }
}
