package ar.edu.dominio;

import java.util.Date;
import java.util.Objects;

public class CicloLectivo {
//	CicloLectivo . Id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo, fechaInicioInscripcion,
//	fechaFinalizacionInscripcion
	
	Integer generador = 1;
	private static Integer id = 0;
	private Date fechaInicioCicloLectivo;
	private Date fechaFinalizacionCicloLectivo;
	private Date fechaInicioInscripcion;
	private Date fechaFinalizacionInscripcion;
	
	public CicloLectivo(Date fechaInicioCicloLectivo, Date fechaFinalizacionCicloLectivo,
			Date fechaInicioInscripcion, Date fechaFinalizacionInscripcion) {
		id+=generador;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}
	public void setFechaInicioCicloLectivo(Date fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}
	public Date getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}
	public void setFechaFinalizacionCicloLectivo(Date fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}
	public Date getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}
	public void setFechaInicioInscripcion(Date fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}
	public Date getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}
	public void setFechaFinalizacionInscripcion(Date fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CicloLectivo)) {
			return false;
		}
		CicloLectivo other = (CicloLectivo) obj;
		return Objects.equals(fechaFinalizacionCicloLectivo, other.fechaFinalizacionCicloLectivo)
				&& Objects.equals(fechaFinalizacionInscripcion, other.fechaFinalizacionInscripcion)
				&& Objects.equals(fechaInicioCicloLectivo, other.fechaInicioCicloLectivo)
				&& Objects.equals(fechaInicioInscripcion, other.fechaInicioInscripcion);
	}
	
	
	
	
	
	

}
