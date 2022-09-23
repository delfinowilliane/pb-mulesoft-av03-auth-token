package br.pbmulesoft.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.pbmulesoft.api.modelo.Estado;

@Controller
public class EstadosController {
	
	@RequestMapping("/api/v1/estados")
	@ResponseBody
	public List<Estado> lista() {
		Estado estado = new Estado("Pará", "Norte", 8900000, "Belém", 1248000);
		Estado estado2 = new Estado("Pernambuco", "Nordeste", 8900000, "Recife", 1248000);
		Estado estado3 = new Estado("Paraná", "Sul", 8900000, "Curitiba", 1248000);
		return Arrays.asList(estado, estado2, estado3);
	}

}
