package com.consultorioapp.projetopw2.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Consulta {
	@Id
	private String rg;
	private String descricao;
	private String dataConsulta;
	private String horarioConsulta;
	private String nomeDentista;
	
	@ManyToOne
	private Paciente paciente;
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getHorarioConsulta() {
		return horarioConsulta;
	}
	public void setHorarioConsulta(String horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}
	public String getNomeDentista() {
		return nomeDentista;
	}
	public void setNomeDentista(String nomeDentista) {
		this.nomeDentista = nomeDentista;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}