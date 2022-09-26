package br.pbmulesoft.api.controller;


import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.pbmulesoft.api.controller.dto.UsuarioDto;
import br.pbmulesoft.api.controller.form.AtualizarUsuarioForm;
import br.pbmulesoft.api.controller.form.UsuarioForm;
import br.pbmulesoft.api.modelo.Usuario;
import br.pbmulesoft.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public Page<UsuarioDto> lista(@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		
		Page<Usuario> usuario = usuarioRepository.findAll(paginacao);
		return UsuarioDto.converter(usuario);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);

		URI uri = uriBuilder.path("/api/v1/usuarios").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @RequestBody AtualizarUsuarioForm form) {

		Optional<Usuario> optional = usuarioRepository.findById(id); // Tratamento do erro 404

		if (optional.isPresent()) {
			Usuario usuarios = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuarios));
		}

		return ResponseEntity.notFound().build();

	}
	
}
