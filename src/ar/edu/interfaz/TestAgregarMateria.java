package ar.edu.interfaz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.dominio.Materia;
import ar.edu.dominio.Universidad;

class TestAgregarMateria {

	@Test
	void materiaAgregada() {
		Materia materia = new Materia("PB1", 1);

		Universidad unlam = new Universidad();
		boolean esperado = true;

		assertEquals(esperado, unlam.agregarMaterias(materia));

	}
	
	@Test
	void impedirAgregarMateriaConMismoId2Veces() {
		Materia materia = new Materia("PB1", 1);
		Materia materia2 = new Materia("PB1", 1);

		Universidad unlam = new Universidad();

		unlam.agregarMaterias(materia);

		boolean esperado = false;

		assertEquals(esperado, unlam.agregarMaterias(materia2));

	}

}
