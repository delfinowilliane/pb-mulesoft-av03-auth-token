package br.pbmulesoft.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/estados")
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}

}
