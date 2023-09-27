package ar.edu.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Aula {
//	Aula id, Cantidad De Alumnos
	Integer generador = 1;
	private Integer id = 0;
	private Integer cantidad;

	public Aula() {
		id += generador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
		if (!(obj instanceof Aula)) {
			return false;
		}
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id);
	}

}
