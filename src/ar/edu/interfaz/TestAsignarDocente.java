package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.CicloLectivo;
import ar.edu.dominio.Comision;
import ar.edu.dominio.Materia;
import ar.edu.dominio.Profesor;
import ar.edu.dominio.Universidad;

class TestAsignarDocente {

	@Test

	public void asignarDocenteAComision() throws ParseException {

		Universidad unlam = new Universidad();
		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaDeNacimiento = fecha.parse("06-04-2023");
		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Profesor profe = new Profesor(1, "Juanma", "Lopez", fechaDeNacimiento, 20202020);

		Materia materia = new Materia("PB1", 1);

		Comision comision = new Comision(01, materia, ciclo, "Mañana");

		unlam.agregarDocente(profe);
		unlam.agregarComision(comision);

		boolean esperado = true;

		assertEquals(esperado, unlam.asignarDocentesAComision(comision.getId(), profe.getDni()));

	}

	@Test
	public void impedirasignarElMismoDocenteALaMismaComision() throws ParseException {

		Universidad unlam = new Universidad();
		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaDeNacimiento = fecha.parse("06-04-2023");
		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Profesor profe = new Profesor(1, "Juanma", "Lopez", fechaDeNacimiento, 20202020);
		Profesor profe2 = new Profesor(1, "Juanma", "Lopez", fechaDeNacimiento, 20202020);

		Materia materia = new Materia("PB1", 1);

		Comision comision = new Comision(01, materia, ciclo, "Mañana");
		Comision comision2 = new Comision(02, materia, ciclo, "Mañana");

		unlam.agregarMaterias(materia);
		unlam.agregarDocente(profe);
		unlam.agregarDocente(profe2);
		unlam.agregarComision(comision);
		unlam.agregarComision(comision2);

		unlam.asignarDocentesAComision(comision.getId(), profe.getDni());

		boolean esperado = false;

		assertEquals(esperado, unlam.asignarDocentesAComision(comision2.getId(), profe2.getDni()));

	}

}
