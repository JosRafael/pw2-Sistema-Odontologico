package com.consultorioapp.projetopw2.repository;

import org.springframework.data.repository.CrudRepository;

import com.consultorioapp.projetopw2.models.Consulta;
import com.consultorioapp.projetopw2.models.Paciente;


public interface ConsultaRepository extends CrudRepository<Consulta, String> {
	Iterable<Consulta> findByPaciente(Paciente paciente);
	Consulta findByCodigo(long codigo);
}
