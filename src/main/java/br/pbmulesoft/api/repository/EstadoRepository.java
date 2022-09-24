package br.pbmulesoft.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pbmulesoft.api.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	List<Estado> findByRegiao(String regiao);

}
