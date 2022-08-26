package com.consultorioapp.projetopw2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultorioapp.projetopw2.models.Paciente;
import com.consultorioapp.projetopw2.models.PacienteDTO;
import com.consultorioapp.projetopw2.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public PacienteDTO create(Paciente paciente) {
		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO.convert(paciente);
		pacienteRepository.save(paciente);
		return pacienteDTO;
	}
	
	public List<PacienteDTO> getAll() {
		PacienteDTO paciente = new PacienteDTO();
		return paciente.convertList(pacienteRepository.findAll());
	}
}
