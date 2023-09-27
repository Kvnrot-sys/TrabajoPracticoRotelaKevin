package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.CicloLectivo;
import ar.edu.dominio.Universidad;

class TestAgregarCicloLectivo {

	@Test
	public void agregarCicloLectivo() throws ParseException {
		// No se puede asignar 2 ciclos Lectivo con mismo Id y no se pueden superponer
		// los rangos de fechas entre 2 ciclos distintos

		Universidad unlam = new Universidad();

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		;
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		;
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		boolean esperado = true;
		
		assertEquals(esperado, unlam.agregarCicloLectivo(ciclo));

	}

	
	@Test
	public void impedirAgregarCicloLectivoSuperponiendoRango() throws ParseException {
		// No se puede asignar 2 ciclos Lectivo con mismo Id y no se pueden superponer
		// los rangos de fechas entre 2 ciclos distintos

		Universidad unlam = new Universidad();

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		;
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		;
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		CicloLectivo ciclo2 = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		unlam.agregarCicloLectivo(ciclo);

		boolean esperado = false;

		assertEquals(esperado, unlam.agregarCicloLectivo(ciclo2));

	}

	@Test
	public void agregarUnSegundoCicloLectivo() throws ParseException {
		// No se puede asignar 2 ciclos Lectivo con mismo Id y no se pueden superponer
		// los rangos de fechas entre 2 ciclos distintos

		Universidad unlam = new Universidad();

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		;
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		;
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		Date fechaInicioCicloLectivo1 = fecha.parse("12-08-2023");
		;
		Date fechaFinalizacionCicloLectivo1 = fecha.parse("01-12-2023");
		;
		Date fechaInicioInscripcion1 = fecha.parse("20-12-2023");
		Date fechaFinalizacionInscripcion1 = fecha.parse("23-12-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		CicloLectivo ciclo2 = new CicloLectivo(fechaInicioCicloLectivo1, fechaFinalizacionCicloLectivo1,
				fechaInicioInscripcion1, fechaFinalizacionInscripcion1);

		unlam.agregarCicloLectivo(ciclo);

		boolean esperado = true;

		assertEquals(esperado, unlam.agregarCicloLectivo(ciclo2));

	}
	
	

}
