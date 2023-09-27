package ar.edu.dominio;

import java.util.Calendar;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Universidad {
	private Set<Alumno> alumnos = new HashSet<Alumno>();
	private Set<Materia> materias = new HashSet<Materia>();
	private Set<Comision> comisiones = new HashSet<Comision>();
	private Set<Profesor> profesor = new HashSet<Profesor>();

	private Set<CicloLectivo> ciclos = new HashSet<CicloLectivo>(1);

	private Set<AsignacionCursoAlumno> cursoAlumno = new HashSet<AsignacionCursoAlumno>();
	private Set<AsignacionCursoProfe> cursoProfe = new HashSet<AsignacionCursoProfe>();

	private HashMap<List<AsignacionCursoAlumno>, List<AsignacionCursoProfe>> asignaciones = new HashMap<List<AsignacionCursoAlumno>, List<AsignacionCursoProfe>>();

	public boolean agregarMaterias(Materia materia) {
		boolean agregado = false;

		if (!this.materias.contains(materia)) {
			materias.add(materia);
			agregado = true;
		}

		return agregado;

	}

	public boolean agregarAlumno(Alumno alumno) {
		boolean agregado = false;

		if (!this.alumnos.contains(alumno)) {
			alumnos.add(alumno);
			agregado = true;
		}

		return agregado;
	}

	public boolean agregarCicloLectivo(CicloLectivo ciclo) {
		boolean cicloIngresado = false;

		Date max = null;
		Date min = null;

		// AÑADIR LOS CICLOS A LA LISTA

		if (this.ciclos.contains(ciclo)) {
			cicloIngresado = false;
		} else {
			this.ciclos.add(ciclo);
			cicloIngresado = true;
		}

		for (CicloLectivo iterador : this.ciclos) {
			if (iterador.getId().equals(1)) {
				max = ciclo.getFechaFinalizacionCicloLectivo();
				min = ciclo.getFechaInicioInscripcion();
			}

		}

		for (CicloLectivo iterador : this.ciclos) {

			if (iterador == null) {
				if (ciclo.getFechaInicioCicloLectivo().after(min) && ciclo.getFechaInicioCicloLectivo().after(max)
						&& ciclo.getFechaFinalizacionCicloLectivo().after(ciclo.getFechaInicioInscripcion())) {
					this.ciclos.add(ciclo);
					cicloIngresado = true;
				}

			}
		}

		return cicloIngresado;

	}

	public boolean agregarComision(Comision comision) {

		boolean agregada = false;
		if (!this.comisiones.contains(comision)) {
			comisiones.add(comision);
			agregada = true;
		}
		return agregada;
	}

	public boolean agregarDocente(Profesor docente) {

		boolean agregado = false;

		if (!this.profesor.contains(docente)) {
			profesor.add(docente);
			agregado = true;
		}

		return agregado;

	}

	public boolean asignarDocentesAComision(Integer idComision, Integer dniDocente) {

		boolean inscripto = false;

		boolean profeEsta = false;

		boolean comisionEsta = false;

		Profesor profesorAInscribir = null;
		Comision comisionAInscribir = null;

		for (Profesor iterador : this.profesor) {
			if (iterador.getDni().equals(dniDocente)) {
				profesorAInscribir = iterador;
				profeEsta = true;
			}

		}

		for (Comision iterador : this.comisiones) {
			if (iterador.getId().equals(idComision)) {
				comisionAInscribir = iterador;
				comisionEsta = true;
			}
		}


		if (profeEsta == true && comisionEsta == true) {
			Integer dni = profesorAInscribir.getDni();
			Integer id = comisionAInscribir.getId();

			if (this.cursoProfe.stream().anyMatch(elementos -> elementos.getProfesor().getDni().equals(dni) == true)
					&& this.cursoProfe.stream().anyMatch(elemento -> elemento.getId().equals(id) == true)) {
				inscripto = false;

			} else {
				AsignacionCursoProfe asignacion = new AsignacionCursoProfe(profesorAInscribir, comisionAInscribir);
				this.cursoProfe.add(asignacion);
				inscripto = true;
			}

		}

		return inscripto;
	}

	public boolean asignarMateriaCorrelativa(Integer idMateria, Integer idCorrelativa) {

		boolean asignado = false;

		boolean encontrado = false;
		boolean encontrado2 = false;

		Materia materiaInicial = null;
		Materia materiaCorrelativa = null;

		for (Materia materia : this.materias) {
			if (materia.getId().equals(idMateria)) {
				materiaInicial = materia;
				encontrado = true;
			}
		}

		for (Materia materia2 : this.materias) {
			if (materia2.getId().equals(idCorrelativa)) {
				materiaCorrelativa = materia2;
				encontrado2 = true;
			}
		}

		if (encontrado == true && encontrado2 == true) {
			if (materiaInicial == materiaCorrelativa) {
				asignado = false;

			} else {
				materiaInicial.añadirCorrelativa(materiaCorrelativa);
				asignado = true;
			}

		}

		return asignado;

	}

	public boolean eliminarCorrelativa(Integer idMateria, Integer idCorrelativaAEliminar) {

		boolean eliminado = false;

		for (Materia iterador : this.materias) {
			if (iterador.getId().equals(idMateria)) {
				this.materias.remove(iterador.getCorrelativas().contains(idCorrelativaAEliminar));
				eliminado = true;
			}
		}

		return eliminado;

	}

	public boolean asignarAlumnoAComision(Integer dni, Integer idComision) {
		boolean asignado = false;
		boolean alumnoExiste = false;
		boolean cursoExiste = false;
		Alumno alumnoAInscribir = null;
		Comision comisionAInscribir = null;

		for (Alumno iterador : this.alumnos) {
			if (iterador.getDni().equals(dni)) {
				alumnoAInscribir = iterador;
				alumnoExiste = true;
			}

		}

		for (Comision iterador : this.comisiones) {
			if (iterador.getId().equals(idComision)) {
				comisionAInscribir = iterador;
				cursoExiste = true;
			}
		}

		if (alumnoExiste == true && cursoExiste == true) {
			AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(alumnoAInscribir, comisionAInscribir);
			if (this.cursoAlumno.contains(asignacion)) {
				asignado = false;
			} else {
				this.cursoAlumno.add(asignacion);
				asignado = true;
			}

		}

		return asignado;

	}

	public boolean inscribirAlumnoAComision(Integer dni, Integer idComision) {

		Date hoy = new Date();

		boolean inscripto = false;

		boolean alumnoEsta = false;

		boolean comisionEsta = false;

		Alumno alumnoAInscribir = null;
		Comision comisionAInscribir = null;

		for (Alumno iterador : this.alumnos) {
			if (iterador.getDni().equals(dni)) {
				alumnoAInscribir = iterador;
				alumnoEsta = true;
			}

		}

		for (Comision iterador : this.comisiones) {
			if (iterador.getId().equals(idComision)) {
				comisionAInscribir = iterador;
				comisionEsta = true;
			}
		}

		List<Materia> correlativas = comisionAInscribir.getMateria().getCorrelativas();

		boolean correlativasAprobadas = false;

		if (correlativas.stream().allMatch(materias -> materias.getNotas().aprobada() == true)) {
			correlativasAprobadas = true;
		}

		Date fechaInscripcion = comisionAInscribir.getCicloLectivo().getFechaInicioInscripcion();
		Date fechaInscripcionF = comisionAInscribir.getCicloLectivo().getFechaFinalizacionInscripcion();

		if (alumnoEsta == true && comisionEsta == true) {
			if (correlativasAprobadas == true && (hoy.after(fechaInscripcion) && hoy.before(fechaInscripcionF))) {
				AsignacionCursoAlumno asignacion = new AsignacionCursoAlumno(alumnoAInscribir, comisionAInscribir);
				this.cursoAlumno.add(asignacion);
				inscripto = true;

			}

		}

		return inscripto;
	}

	public boolean registrarNota(Integer idComision, Integer idAlumno, Nota nota) {

		boolean notaAsignada = false;

		for (AsignacionCursoAlumno iterador : cursoAlumno) {
			if (iterador.getComision().getId().equals(idComision) && iterador.getAlumnos().getId().equals(idAlumno)) {
				iterador.setNota(nota);
				notaAsignada = true;
			}
		}

		return notaAsignada;

	}

	public Collection<Materia> obtenerListadoMateriasAprobadasParaUnAlumno(Integer idAlumno) {

		Collection<Materia> materiasAprobadas = null;

		for (AsignacionCursoAlumno iterador : this.cursoAlumno) {
			if (iterador.getAlumnos().getId().equals(idAlumno) && iterador.getNota().aprobada() == true) {

				materiasAprobadas.add(iterador.getComision().getMateria());
			}
		}

		return materiasAprobadas;

	}

	public Collection<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer idAlumno) {

		Collection<Materia> materiasAComparar = null;

		for (AsignacionCursoAlumno comision : this.cursoAlumno) {
			if (comision.getAlumnos().getId().equals(idAlumno)) {
				materiasAComparar.add(comision.getComision().getMateria());
			}
		}

		materiasAComparar.addAll(this.materias);

		Set<Materia> set = new HashSet<>(materiasAComparar);
		Collection<Materia> materiasPendientes = new ArrayList<>(set);

		return materiasPendientes;

	}

	public Collection<Nota> ObtenerReporteDeNotasDeAlumnosDeCurso(Integer idCurso) {

		List<Nota> reporte = null;

		for (AsignacionCursoAlumno iterador : this.cursoAlumno) {
			if (iterador.getComision().getId().equals(idCurso)) {
				reporte.add(iterador.getNota());
			}

		}

		return reporte;
	}

	public double calcularPromedio(Integer idAlumno) {

		Integer cantidad = 0;

		Integer notas = 0;

		Double promedio = 0.0;

		for (AsignacionCursoAlumno iterador : this.cursoAlumno) {
			if (iterador.getAlumnos().getId().equals(idAlumno)) {
				promedio += iterador.getNota().promedio();
				cantidad++;
			}

		}
		return promedio / cantidad;

	}

	public double obtenerNota(Integer idAlumno, Integer idMateria) {
		Double nota = 0.0;

		for (AsignacionCursoAlumno buscar : this.cursoAlumno) {
			if (buscar.getAlumnos().getId().equals(idAlumno)
					&& buscar.getComision().getMateria().getId().equals(idMateria)) {
				nota = buscar.getNota().promedio();

			}
		}

		return nota;

	}

	public boolean asignarAulaALaComision(Integer idComision, Aula aula) {

		boolean comisionEsta = false;

		Comision comisionHallada = null;

		for (Comision comision : this.comisiones) {
			if (comision.getId().equals(idComision)) {

				comisionHallada = comision;
				comisionHallada.setAula(aula);
				comisionEsta = true;
			}
		}

		return comisionEsta;

	}

	public boolean asignarProfeAAula(Aula aula, Profesor profesor) {
		boolean asignado = false;

		List<AsignacionCursoProfe> profeAAsignar = null;

		List<AsignacionCursoAlumno> alumnosAAsignar = null;

		Integer contador = 0;

		for (AsignacionCursoAlumno iterador : this.cursoAlumno) {
			if (iterador.getComision().getAula().getId().equals(aula.getId())) {
				alumnosAAsignar.add(iterador);

			}

		}

		for (AsignacionCursoProfe iterador : this.cursoProfe) {
			if (iterador.getProfesor().getDni().equals(profesor.getDni())) {
				profeAAsignar.add(iterador);
			}
		}

		if (!this.asignaciones.containsKey(alumnosAAsignar) && !this.asignaciones.containsValue(profeAAsignar)) {
			this.asignaciones.putIfAbsent(alumnosAAsignar, profeAAsignar);
			asignado = true;
		}

		return asignado;

	}

}
