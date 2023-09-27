package ar.edu.dominio;

import java.util.Objects;
import java.util.Set;

public class Comision {
//	Comisión id , Materia, y cicloLectivo, Turno

	private Integer id;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Nota nota;
	private String turno;
	private Aula aula;

	public Comision(Integer id, Materia materia, CicloLectivo cicloLectivo, String turno) {
		super();
		this.id = id;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public int hashCode() {
		return Objects.hash();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(cicloLectivo, other.cicloLectivo)
				&& Objects.equals(id, other.id) && Objects.equals(materia, other.materia)
				&& Objects.equals(nota, other.nota) && Objects.equals(turno, other.turno);
	}

}
