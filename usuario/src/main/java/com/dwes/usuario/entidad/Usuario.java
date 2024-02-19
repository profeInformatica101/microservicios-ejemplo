package com.dwes.usuario.entidad;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String email;

	    private String clave;

	    @ElementCollection(fetch = FetchType.EAGER, targetClass = Role.class)
	    @Enumerated(EnumType.STRING)
	    @CollectionTable(name="usuario_rol")
	    @Column(name ="RolesUsuario")
	    private Set<Role> roles = new HashSet<>();

	    @OneToOne(cascade = CascadeType.MERGE)
	    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
	    private PerfilUsuario perfil;

}
