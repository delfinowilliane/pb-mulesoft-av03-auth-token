package br.pbmulesoft.api.controller;


import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//	@GetMapping
//	@ResponseBody
//	public Page<UsuarioDto> lista(@RequestParam(required = false) String email) {
//
//		
//		if (email == null) {
//
//			Page<Usuario> usuarios = usuarioRepository.findAll(email); // carregar todos os registros do banco de
//																			// dados
//			return UsuarioDto.converter(usuarios);
//
//		} else {
//			Page<Usuario> usuarios = usuarioRepository.findByEmail(email);
//			return UsuarioDto.converter(usuarios);
//
//		}
//
//	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuarios = form.converter();
		usuarioRepository.save(usuarios);

		URI uri = uriBuilder.path("/api/v1/usuarios").buildAndExpand(usuarios.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuarios));
	}
	
	@PutMapping("{id}")
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
