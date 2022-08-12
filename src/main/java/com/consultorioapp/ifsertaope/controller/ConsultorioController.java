package com.consultorioapp.ifsertaope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultorioController {
	
	@RequestMapping("/cadastrarPaciente")
	public String form() {
		return "paciente/formPaciente";
	}
}
