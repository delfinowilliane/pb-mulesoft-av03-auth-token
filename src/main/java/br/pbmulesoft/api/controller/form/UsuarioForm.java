package br.pbmulesoft.api.controller.form;

import br.pbmulesoft.api.modelo.Usuario;
import br.pbmulesoft.api.repository.UsuarioRepository;

public class UsuarioForm {

	private Long id;
    private String nome;
    private String email;
    private String senha;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
	public Usuario converter() {
		return new Usuario(nome, email, senha);
	}
	
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getById(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		
		return usuario;
	}
}
