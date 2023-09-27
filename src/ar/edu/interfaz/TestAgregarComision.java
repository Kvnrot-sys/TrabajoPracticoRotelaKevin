package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.CicloLectivo;
import ar.edu.dominio.Comision;
import ar.edu.dominio.Materia;
import ar.edu.dominio.Universidad;

class TestAgregarComision {

	@Test
	public void agregarComision() throws ParseException {

		Universidad unlam = new Universidad();
		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");
		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Materia materia = new Materia("PB1", 1);

		Comision comision = new Comision(01,materia, ciclo, "Mañana");


		boolean esperado = true;

		assertEquals(esperado, unlam.agregarComision(comision));

	}

	@Test
	public void ImpediragregarComisiones() throws ParseException {

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

		Materia materia = new Materia("PB1", 1);

		Comision comision = new Comision(01,materia, ciclo, "Mañana");
		Comision comision2 = new Comision(01,materia, ciclo, "Mañana");

		unlam.agregarComision(comision);

		boolean esperado = false;

		assertEquals(esperado, unlam.agregarComision(comision2));

	}

}
