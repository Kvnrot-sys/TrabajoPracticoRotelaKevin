package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.Profesor;
import ar.edu.dominio.Universidad;

class TestAgregarDocente {

	@Test
	public void agregarDocente() throws ParseException {

		Universidad unlam = new Universidad();

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaDeNacimiento = fecha.parse("06-04-2023");

		Profesor profe = new Profesor(1, "Juanma", "Lopez", fechaDeNacimiento, 20202020);

		boolean esperado = true;

		assertEquals(esperado, unlam.agregarDocente(profe));

	}

	@Test
	public void impedirAgregarDocenteConElMismoDni() throws ParseException {

		Universidad unlam = new Universidad();

		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		Date fechaDeNacimiento = fecha.parse("06-04-2023");

		Profesor profe = new Profesor(1, "Juanma", "Lopez", fechaDeNacimiento, 20202020);
		Profesor profe2 = new Profesor(1, "a", "Lopez", fechaDeNacimiento, 20202020);

		unlam.agregarDocente(profe);

		boolean esperado = false;

		assertEquals(esperado, unlam.agregarDocente(profe2));

	}

}
