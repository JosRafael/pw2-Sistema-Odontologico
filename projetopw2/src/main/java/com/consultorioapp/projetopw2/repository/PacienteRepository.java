package com.consultorioapp.projetopw2.repository;

import org.springframework.data.repository.CrudRepository;

import com.consultorioapp.projetopw2.models.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, String> {
	
}