package br.pbmulesoft.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.pbmulesoft.api.modelo.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	Page<Estado> findByRegiao(String regiao, Pageable paginacao);

}
