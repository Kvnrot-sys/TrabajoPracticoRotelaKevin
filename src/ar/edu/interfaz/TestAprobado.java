package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.*;

class TestAprobado {

	@Test
	void verficarAprobado() throws ParseException {
		
		Universidad unlam = new Universidad();

		Materia materia = new Materia("PB1", 01);

		unlam.agregarMaterias(materia);

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Comision comision = new Comision(01,materia, ciclo, "Mañana");

		Nota nota = new Nota();

		nota.setP1(5);
		nota.setP2(10);
		nota.setR1(10);
		nota.promedio();

		Date fechaInicio = fecha.parse("06-04-2023");
		Date fechaNacimiento = fecha.parse("12-07-2023");
		Alumno alumno = new Alumno("Kevin", "Rotela", 45285663, fechaNacimiento, fechaInicio);

		
		unlam.agregarComision(comision);
		unlam.agregarAlumno(alumno);
		unlam.asignarAlumnoAComision(alumno.getDni(), comision.getId());
		
		boolean esperado = true;
		assertEquals(esperado, unlam.registrarNota(comision.getId(), alumno.getId(), nota));
		
	}
	
	

}
