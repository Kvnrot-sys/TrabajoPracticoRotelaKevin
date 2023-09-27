package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import ar.edu.dominio.*;

class TestObtenerNota {

	@Test
	void ObtenerNota() throws ParseException {
		// Instanciamos universidad
		Universidad unlam = new Universidad();

		// Instanciamos materias
		Materia materia = new Materia("PB1", 01);

		// Ciclo

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");

		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");

		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		// Instanciamos comision
		Comision comision = new Comision(1,materia, ciclo, "Mañana");

		// Instanciamos Alumno
		Date fechaInicio = fecha.parse("06-04-2023");
		Date fechaNacimiento = fecha.parse("12-07-2023");

		Alumno alumno = new Alumno("Kevin", "Rotela", 45285663, fechaNacimiento, fechaInicio);

		// Agregamos a la universidad

		unlam.agregarAlumno(alumno);
		unlam.agregarCicloLectivo(ciclo);
		unlam.agregarComision(comision);
		unlam.agregarMaterias(materia);

		// Instanciamos nota y los parciales

		Nota nota = new Nota();

		nota.setP1(5);
		nota.setP2(10);
		nota.setR1(10);

		// Asignamos la comision a alumno

		unlam.asignarAlumnoAComision(alumno.getDni(), comision.getId());
		unlam.registrarNota(comision.getId(), alumno.getId(), nota);

		double esperado = 10.0;

		assertEquals(esperado, unlam.obtenerNota(alumno.getId(), materia.getId()));

	}

}
