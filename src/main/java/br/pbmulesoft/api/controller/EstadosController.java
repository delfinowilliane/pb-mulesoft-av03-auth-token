package br.pbmulesoft.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.pbmulesoft.api.controller.dto.EstadoDto;
import br.pbmulesoft.api.modelo.Estado;
import br.pbmulesoft.api.repository.EstadoRepository;

@RestController
public class EstadosController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@RequestMapping("/api/v1/estados")
	@ResponseBody
	public List<EstadoDto> lista(String regiao) {
		System.out.println(regiao);
		List<Estado> estados = estadoRepository.findAll(); //carregar todos os registros do banco de dados
		
		return EstadoDto.converter(estados);
	}

}
