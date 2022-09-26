package br.pbmulesoft.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.pbmulesoft.api.modelo.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String username);
	
}