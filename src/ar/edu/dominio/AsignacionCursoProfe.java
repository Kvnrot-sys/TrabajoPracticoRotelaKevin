package ar.edu.dominio;

import java.util.Collection;
import java.util.HashMap;

public class AsignacionCursoProfe {

	private static Integer id = 0;
	private Comision comision;
	private Profesor profesor;
	
	

public AsignacionCursoProfe(Profesor profesor, Comision comision) {
	
	this.comision = comision;
	this.profesor = profesor;
	id++;
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Comision getCurso() {
		return comision;
	}

	public void setCurso(Comision comision) {
		this.comision = comision;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public boolean equals(Object otro) {
		if(this == otro) {
			return true;
		}
		
		if(otro == null) {
			return false;
		}
		
		if(otro.getClass() != AsignacionCursoProfe.class) {
			return false;
		}
		
		
		AsignacionCursoProfe asignacion = (AsignacionCursoProfe) otro;
		
		if(asignacion.getProfesor().equals(this.profesor) && asignacion.getCurso().equals(this.comision) ){
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	



//	private HashMap<Curso,Profesor> Asignacion;

}
