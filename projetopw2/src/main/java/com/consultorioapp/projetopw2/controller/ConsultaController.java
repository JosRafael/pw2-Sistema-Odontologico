package com.consultorioapp.projetopw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consultorioapp.projetopw2.models.Consulta;
import com.consultorioapp.projetopw2.models.Paciente;
import com.consultorioapp.projetopw2.repository.ConsultaRepository;

@Controller
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository cr;
	
	@RequestMapping("/deletarConsulta")
	public String deletarConsulta(long codigo) {
		Consulta consulta = cr.findByCodigo(codigo);
		cr.delete(consulta);
		
		Paciente paciente = consulta.getPaciente();
		long codigoLong = paciente.getId();
		String cod = "" + codigoLong;
		return "redirect:/" + cod;
	}
}