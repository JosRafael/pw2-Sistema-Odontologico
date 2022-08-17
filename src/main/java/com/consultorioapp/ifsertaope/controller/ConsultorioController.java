package com.consultorioapp.ifsertaope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsultorioController {
	
	@RequestMapping("/Inicio")
	public String form() {
		return "paciente/Inicio";
	}
	@GetMapping("/cadastrarPaciente")
	public String form1() {
		return "paciente/formPacientee";
	}
}
