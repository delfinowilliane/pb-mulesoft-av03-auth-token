package br.pbmulesoft.api.controller.form;

import br.pbmulesoft.api.modelo.Estado;
import br.pbmulesoft.api.repository.EstadoRepository;

public class AtualizarEstadoForm {

	private String nome; //estado
	private Integer populacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	public Estado atualizar(Long id, EstadoRepository estadoRepository) {
		Estado estado = estadoRepository.getById(id);
		estado.setPopulacao(this.populacao);
		return estado;
	}
	
}
