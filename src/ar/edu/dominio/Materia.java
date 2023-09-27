package ar.edu.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Materia {
	private String nombre;
	private Integer id;
	private ArrayList<Materia> correlativas = new ArrayList<Materia>();
	private Nota notas;

	public Materia(String nombre, Integer id) {
		this.nombre = nombre;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

	public void añadirCorrelativa(Materia materia) {
		correlativas.add(materia);
	}

	public Nota getNotas() {
		return notas;
	}

	public void setNotas(Nota notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	

}
