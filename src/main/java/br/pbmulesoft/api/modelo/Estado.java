package br.pbmulesoft.api.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome; //estado
	private String regiao;
	private Integer populacao;
	private String capital;
	private Integer area;
	
	
	public Estado() {
	}

	public Estado(String nome, String regiao, Integer populacao, String capital, Integer area) {
		this.nome = nome;
		this.regiao = regiao;
		this.populacao = populacao;
		this.capital = capital;
		this.area = area;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	
}
