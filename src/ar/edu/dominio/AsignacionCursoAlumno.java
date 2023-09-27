package ar.edu.dominio;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class AsignacionCursoAlumno {
	private static Integer id = 0;
	private Comision comision;
	private Alumno alumnos;
	private Nota nota;

	Integer generador = 1;

	public AsignacionCursoAlumno(Alumno alumno, Comision comision) {

		this.comision = comision;
		this.alumnos = alumno;
		id += generador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Comision getComision() {
		return comision;
	}

	public void setCurso(Comision comision) {
		this.comision = comision;
	}

	public Alumno getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno alumnos) {
		this.alumnos = alumnos;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumnos, comision, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsignacionCursoAlumno other = (AsignacionCursoAlumno) obj;
		return Objects.equals(alumnos, other.alumnos) && Objects.equals(comision, other.comision)
				&& Objects.equals(nota, other.nota);
	}
	
	
	


	

}
