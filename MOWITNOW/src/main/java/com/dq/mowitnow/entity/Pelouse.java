package com.dq.mowitnow.entity;

public class Pelouse {

	private Coordonnees coordonneeSup;
	public Pelouse() {
		// TODO Auto-generated constructor stub
	}
	public Pelouse(Coordonnees coordonneeSup) {
		super();
		this.coordonneeSup = coordonneeSup;
	}
	public Coordonnees getCoordonneeSup() {
		return coordonneeSup;
	}
	public void setCoordonneeSup(Coordonnees coordonneeSup) {
		this.coordonneeSup = coordonneeSup;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordonneeSup == null) ? 0 : coordonneeSup.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelouse other = (Pelouse) obj;
		if (coordonneeSup == null) {
			if (other.coordonneeSup != null)
				return false;
		} else if (!coordonneeSup.equals(other.coordonneeSup))
			return false;
		return true;
	}

	
}
