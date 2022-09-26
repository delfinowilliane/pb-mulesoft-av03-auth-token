package br.pbmulesoft.api.controller.dto;

import org.springframework.data.domain.Page;

import br.pbmulesoft.api.modelo.Usuario;

public class UsuarioDto {

	private Long id;
    private String nome;
    private String email;
    private String senha;
	
    public UsuarioDto(Usuario usuarios) {
    	this.id = usuarios.getId();
		this.nome = usuarios.getNome();
		this.email = usuarios.getEmail();
		this.senha = usuarios.getSenha();
	}

	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	
	public static Page<UsuarioDto> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDto::new);
	}   
    
}
