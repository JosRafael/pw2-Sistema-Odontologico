package com.consultorioapp.projetopw2.repository;

import java.util.List;

import com.consultorioapp.projetopw2.models.Paciente;

public interface PacienteService {
		
		List<Paciente> getAllPacientes();
		
		Paciente salvarPaciente(Paciente Paciente);
		
		Paciente getPacienteById(Long id);
		
		Paciente atualizarPaciente(Paciente Paciente);
		
		void excluirPacienteById(Long id);

	}

