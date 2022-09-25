package br.pbmulesoft.api.controller.dto;

import org.springframework.data.domain.Page;

import br.pbmulesoft.api.modelo.Estado;
import br.pbmulesoft.api.modelo.Regiao;

public class EstadoDto {

	private Long id;
	private String nome;
	private Regiao regiao;
	private Integer populacao;
	private String capital;
	private Integer area;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.capital = estado.getCapital();
		this.area = estado.getArea();
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public String getCapital() {
		return capital;
	}
	public Integer getArea() {
		return area;
	}

	public static Page<EstadoDto> converter(Page<Estado> estados) {
		return estados.map(EstadoDto::new);
	}

	
}
