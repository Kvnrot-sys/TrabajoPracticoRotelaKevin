package ar.edu.dominio;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class Alumno {

	static int generador = 1;

	private Integer id;
	private String nombre;
	private String apellido;
	private Integer dni;
	private Date fechaDeNacimiento;
	private Date fechaIngreso;

	public Alumno(String nombre, String apellido, Integer dni, Date fechaDeNacimiento, Date fechaInicio) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaIngreso = fechaInicio;
		this.id = generador++;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getId() {
		return dni;
	}

	public void setId(Integer id) {
		this.dni = id;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Alumno)) {
			return false;
		}
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni);
	}

	
}