package com.consultorioapp.projetopw2.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pacienteController {
	@RequestMapping("/")
	public String form() {
		return "evento/Inicio";
	}
	@GetMapping("/cadastrarPaciente")
	public String form1() {
		return "evento/formPaciente";
	}

	}

