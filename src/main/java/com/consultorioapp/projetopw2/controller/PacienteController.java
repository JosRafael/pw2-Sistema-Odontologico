package com.consultorioapp.projetopw2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.consultorioapp.projetopw2.models.Consulta;
import com.consultorioapp.projetopw2.models.Paciente;
import com.consultorioapp.projetopw2.models.PacienteDTO;
import com.consultorioapp.projetopw2.repository.ConsultaRepository;
import com.consultorioapp.projetopw2.repository.PacienteRepository;
import com.consultorioapp.projetopw2.service.PacienteService;

@Controller
public class PacienteController {
	
	@Autowired
	private PacienteRepository pr;
	@Autowired
	private ConsultaRepository cr;
	@Autowired
	private PacienteService pacienteService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String form() {
		return "evento/Inicio";
	}

	@RequestMapping(value = "/cadastrarPaciente", method = RequestMethod.GET)
	public String form1() {
		return "evento/formPaciente";
	}
	
	@RequestMapping(value="/cadastrarPaciente", method = RequestMethod.POST)
		public String form2(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {		
			pr.save(paciente);
			attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso!");
			return "redirect:/cadastrarPaciente";
		}
	
	@RequestMapping("/pacientes")
	public ModelAndView listaPacientes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Paciente> pacientes = pr.findAll();
		mv.addObject("paciente", pacientes);
		return mv;
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesConsulta(@PathVariable("id") long id) {
		Paciente paciente = pr.findById(id);
		ModelAndView mv = new ModelAndView("evento/detalhesConsulta");
		mv.addObject("paciente", paciente);
		
		// ENVIA PARA A VIEW (DETALHES CONSULTA) 
		Iterable<Consulta> consultas = cr.findByPaciente(paciente);
		mv.addObject("consultas", consultas);	
		return mv;
	}

	@RequestMapping("/deletarPaciente")
	public String deletarPaciente(long id) {
		Paciente paciente = pr.findById(id);
		pr.delete(paciente);
		return "redirect:/pacientes";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String detalhesConsultaPost(@PathVariable("id") long id, @Valid Consulta consulta, BindingResult result, RedirectAttributes attributes) {
		Paciente paciente = pr.findById(id);
		consulta.setPaciente(paciente);
		cr.save(consulta);
		attributes.addFlashAttribute("mensagem", "Consulta agendada com sucesso!");
		return "redirect:/{id}";
	}
	@RequestMapping(value="/editarPaciente", method = RequestMethod.GET)
	public ModelAndView editarPaciente(long id) {
		Paciente paciente = pr.findById(id);
		ModelAndView mv = new ModelAndView("evento/editarPaciente");
		mv.addObject("paciente", paciente);
		return mv;
	}
	
	@RequestMapping(value="editarPaciente", method = RequestMethod.POST)
	public String updatePaciente(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {
		pr.save(paciente);
		attributes.addFlashAttribute("mensagem", "Paciente alterado com sucesso!");
		return "redirect:/pacientes";
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PacienteDTO> create(@RequestBody Paciente paciente){
		return new ResponseEntity<>(pacienteService.create(paciente), HttpStatus.CREATED);
	}
	@GetMapping
	@RequestMapping("/teste")
	public ResponseEntity<List<PacienteDTO>> gettAll(){
		return new ResponseEntity<>(pacienteService.getAll(), HttpStatus.OK);
	}
	
}
