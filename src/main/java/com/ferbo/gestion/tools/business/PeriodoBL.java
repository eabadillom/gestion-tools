package com.ferbo.gestion.tools.business;

import java.util.Date;
import java.util.Optional;

import com.ferbo.gestion.tools.DateTools;
import com.ferbo.gestion.tools.GestionException;
import com.ferbo.gestion.tools.model.Periodo;

public class PeriodoBL {
	
	public static Optional<Periodo> getSemanaLunesADomingo(Integer anio, Integer semana) {
		Optional<Periodo> respuesta = null;
		Periodo periodo     = null;
		Date    fechaInicio = null;
		Date    fechaFin    = null;
		
		try {
			fechaInicio = DateTools.getDiaDeSemanaDate(anio, semana, DateTools.PROP_CD_LUNES)
					.orElseThrow(() -> new GestionException("La fecha indicada es incorrecta."));
			fechaFin = DateTools.addDay(fechaInicio, 6);
			periodo = new Periodo(fechaInicio, fechaFin);
			respuesta = Optional.of(periodo);
		} catch(Exception ex) {
			respuesta = Optional.empty();
		}
		
		return respuesta;
	}
}
