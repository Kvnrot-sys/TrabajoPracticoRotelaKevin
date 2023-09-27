package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.Alumno;
import ar.edu.dominio.CicloLectivo;
import ar.edu.dominio.Comision;
import ar.edu.dominio.Materia;
import ar.edu.dominio.Nota;
import ar.edu.dominio.Universidad;

class TestCalcularPromedio {

	@Test
	void test() throws ParseException {
		// Instanciamos universidad
		Universidad unlam = new Universidad();

		// Instanciamos materias
		Materia materia = new Materia("PB1", 01);
		Materia materia2 = new Materia("BD", 02);

		// Ciclo

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");

		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");

		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Date fechaInicioCicloLectivo2 = fecha.parse("1-08-2023");

		Date fechaFinalizacionCicloLectivo2 = fecha.parse("01-12-2023");

		Date fechaInicioInscripcion2 = fecha.parse("20-12-2023");
		Date fechaFinalizacionInscripcion2 = fecha.parse("23-12-2023");

		CicloLectivo ciclo2 = new CicloLectivo(fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);

		// Instanciamos comision
		Comision comision = new Comision(01,materia, ciclo, "Mañana");
		Comision comision2 = new Comision(02,materia2, ciclo, "Mañana");

		// Instanciamos Alumno
		Date fechaInicio = fecha.parse("06-04-2023");
		Date fechaNacimiento = fecha.parse("12-07-2023");

		Alumno alumno = new Alumno("Kevin", "Rotela", 45285663, fechaNacimiento, fechaInicio);

		// Agregamos a la universidad

		unlam.agregarAlumno(alumno);
		unlam.agregarCicloLectivo(ciclo);
		unlam.agregarComision(comision);
		unlam.agregarComision(comision2);
		unlam.agregarMaterias(materia);

		// Instanciamos nota y los parciales

		Nota nota = new Nota();

		nota.setP1(5);
		nota.setP2(10);
		nota.setR1(10);
		
		Nota nota2 = new Nota();

		nota2.setP1(7);
		nota2.setP2(7);

		// Asignamos la comision a alumno

		unlam.asignarAlumnoAComision(alumno.getDni(), comision.getId());
		unlam.asignarAlumnoAComision(alumno.getDni(), comision2.getId());
		
		unlam.registrarNota(comision.getId(), alumno.getId(), nota);
		unlam.registrarNota(comision2.getId(), alumno.getId(), nota2);

		double esperado = 8.5;

		assertEquals(esperado, unlam.calcularPromedio(alumno.getId()));

	}

}
