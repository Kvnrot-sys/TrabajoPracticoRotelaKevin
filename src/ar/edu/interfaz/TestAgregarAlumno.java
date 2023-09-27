package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.Alumno;
import ar.edu.dominio.Profesor;
import ar.edu.dominio.Universidad;

class TestAgregarAlumno {

	@Test
	void agregarAlumno() throws ParseException {

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicio = fecha.parse("06-04-2023");
		Date fechaNacimiento = fecha.parse("12-07-2023");

		Universidad unlam = new Universidad();

		Alumno alumno = new Alumno("Kevin", "Rotela", 45285663, fechaNacimiento, fechaInicio);

		boolean esperado = true;

		assertEquals(esperado, unlam.agregarAlumno(alumno));

	}
	
	@Test
	public void impedirAgregarAlumnoConElMismoDni() throws ParseException {

		Universidad unlam = new Universidad();

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaInicio = fecha.parse("06-04-2023");
		Date fechaNacimiento = fecha.parse("12-07-2023");
		
		Date fechaInicio2 = fecha.parse("06-04-2023");
		Date fechaNacimiento2 = fecha.parse("12-07-2023");

		Alumno alumno = new Alumno("Kevin", "Rotela", 45285663, fechaNacimiento, fechaInicio);
		Alumno alumno2 = new Alumno("Alexis", "Rotela", 45285663, fechaNacimiento, fechaInicio);

		unlam.agregarAlumno(alumno);

		boolean esperado = false;

		assertEquals(esperado, unlam.agregarAlumno(alumno2) );

	}
	
	
	

}
