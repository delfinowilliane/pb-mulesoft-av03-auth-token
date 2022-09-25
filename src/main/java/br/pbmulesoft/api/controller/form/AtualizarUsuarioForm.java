package br.pbmulesoft.api.controller.form;

import br.pbmulesoft.api.modelo.Usuario;
import br.pbmulesoft.api.repository.UsuarioRepository;

public class AtualizarUsuarioForm {

	private String nome; // estado
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getById(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		return usuario;
	}

}
