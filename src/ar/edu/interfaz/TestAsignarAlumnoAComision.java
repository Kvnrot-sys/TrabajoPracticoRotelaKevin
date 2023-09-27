package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import ar.edu.dominio.Alumno;
import ar.edu.dominio.AsignacionCursoAlumno;
import ar.edu.dominio.Aula;
import ar.edu.dominio.CicloLectivo;
import ar.edu.dominio.Comision;
import ar.edu.dominio.Materia;
import ar.edu.dominio.Nota;
import ar.edu.dominio.Profesor;
import ar.edu.dominio.Universidad;

class TestAsignarAlumnoAComision {

	@org.junit.jupiter.api.Test

	public void asignarAlumnoAComision() throws ParseException {
		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		// INSCRIBIR ALUMNO A COMISION

		// Instanciamos las notas
		Nota nota1 = new Nota();
		Nota nota2 = new Nota();

		// les damos sus respectivas calificaciones

		nota1.setP1(10);
		nota1.setP2(10);

		nota2.setP1(6);
		nota2.setP2(7);
		nota2.setR1(7);

		// Instanciamos la universidad
		Universidad unlam = new Universidad();

		// Instanciamos las materias
		Materia materia = new Materia("PB1", 1);
		Materia materia2 = new Materia("PB2", 2);

		// Agregar materia a universidad
		unlam.agregarMaterias(materia);
		unlam.agregarMaterias(materia2);

		// Instanciamos al alumno
		Date fechaInicio = fecha.parse("06-04-2023");
		Date fechaNacimiento = fecha.parse("12-07-2023");

		Alumno alumno = new Alumno("Kevin", "Rotela", 45285663, fechaNacimiento, fechaInicio);

		// Agregamos alumno a la universidad
		unlam.agregarAlumno(alumno);

		// CICLOS

		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		;
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		;
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");

		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		// Instanciamos las comisiones

		Comision comision = new Comision(01, materia, ciclo, "Mañana");

		// Agregamos las comisiones a la universidad

		unlam.agregarComision(comision);

		boolean esperado = true;

		assertEquals(esperado, unlam.asignarAlumnoAComision(alumno.getDni(), comision.getId()));

	}

}
