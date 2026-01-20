package com.ferbo.gestion.tools.model;

import java.util.Date;

public class Periodo {
	private Date fechaInicio;
	private Date fechaFin;
	
	public Periodo(Date fechaInicio, Date fechaFin) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	@Override
	public String toString() {
		return "Periodo [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
}
