package ar.edu.dominio;

import java.util.List;
import java.util.Objects;

public class Nota {
	Integer generador = 1;
	private Integer id = 0;
	private Integer p1 = 0;
	private Integer p2 = 0;
	private Integer r1 = 0;
	private Integer r2 = 0;
	private Integer eFinal = 0 ;

	public Nota() {
		id += generador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getP1() {
		return p1;
	}

	public void setP1(Integer p1) {

		if (p1 >= 1 && p1 <= 10) {
			this.p1 = p1;
		}

	}

	public Integer getP2() {
		return p2;
	}

	public void setP2(Integer p2) {
		if (p2 >= 1 && p2 <= 10) {
			this.p2 = p2;
		}
	}

	public Integer getR1() {
		return r1;
	}

	public void setR1(Integer r1) {

		if ((r1 >= 1 && r1 <= 10) && p1 < 7) {
			this.p1 = r1;
		}
	}

	public Integer getR2() {
		return r2;
	}

	public void setR2(Integer r2) {
		if ((r2 >= 1 && r2 <= 10) && p2 < 7) {
			this.p2 = r2;
		}
	}

	public Integer geteFinal() {
		return eFinal;
	}

	public void seteFinal(Integer eFinal) {
		this.eFinal = eFinal;
	}

	public Double promedio() {

		Double promedio = (double) ((p1 + p2) / 2);

		return promedio;
	}

	public boolean aprobada() {
		boolean estaAprobada = false;
		if (promedio() >= 4) {
			estaAprobada = true;
		}

		return estaAprobada;
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
		Nota other = (Nota) obj;
		return Objects.equals(eFinal, other.eFinal) && Objects.equals(id, other.id) && Objects.equals(p1, other.p1)
				&& Objects.equals(p2, other.p2) && Objects.equals(r1, other.r1) && Objects.equals(r2, other.r2);
	}


	

}
