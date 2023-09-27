package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.Aula;
import ar.edu.dominio.CicloLectivo;
import ar.edu.dominio.Comision;
import ar.edu.dominio.Materia;
import ar.edu.dominio.Universidad;

class TestAsignarAulaAComision {

	@Test
	void AsignarAulaAComision() throws ParseException {
		//Instanciamos la comision
		
		Universidad unlam = new Universidad();
		SimpleDateFormat fecha = new SimpleDateFormat("dd-mm-yyyy");

		//Instanciamos el ciclo
		Date fechaInicioCicloLectivo = fecha.parse("06-04-2023");
		;
		Date fechaFinalizacionCicloLectivo = fecha.parse("06-07-2023");
		;
		Date fechaInicioInscripcion = fecha.parse("15-07-2023");
		Date fechaFinalizacionInscripcion = fecha.parse("20-07-2023");
		CicloLectivo ciclo = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		//Instanciamos la materia
		Materia materia = new Materia("PB1", 01);
		
		//Instanciamos la comision
		Comision comision = new Comision(01,materia, ciclo, "Mañana");
		
		//Instanciamos el aula
		Aula aula = new Aula();
		
		//Agregamos los objetos a la universidad
		
		unlam.agregarMaterias(materia);
		unlam.agregarComision(comision);
		
		boolean esperado = true;
		
		assertEquals(esperado, unlam.asignarAulaALaComision(comision.getId(),aula));		
		
		
		
		
		
	}

}
