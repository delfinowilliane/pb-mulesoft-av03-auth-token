package br.pbmulesoft.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.pbmulesoft.api.modelo.Estado;

public class EstadoDto {

	private Long id;
	private String nome;
	private String regiao;
	private Integer populacao;
	private String capital;
	private Integer area;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
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
	public String getRegiao() {
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

	public static List<EstadoDto> converter(List<Estado> estados) {
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
	}

	
}
