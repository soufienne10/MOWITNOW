package com.dq.mowitnow.entity;

import com.dq.mowitnow.entity.Constants.Orientation;

public class Tondeuse {

	private Coordonnees cTondeuse;
	private Orientation oTondeuse; 
	
	public Tondeuse() {
		// TODO Auto-generated constructor stub
	}

	public Tondeuse(Coordonnees cTondeuse, Orientation oTondeuse) {
		super();
		this.cTondeuse = cTondeuse;
		this.oTondeuse = oTondeuse;
	}

	public Coordonnees getcTondeuse() {
		return cTondeuse;
	}

	public void setcTondeuse(Coordonnees cTondeuse) {
		this.cTondeuse = cTondeuse;
	}

	public Orientation getoTondeuse() {
		return oTondeuse;
	}

	public void setoTondeuse(Orientation oTondeuse) {
		this.oTondeuse = oTondeuse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cTondeuse == null) ? 0 : cTondeuse.hashCode());
		result = prime * result
				+ ((oTondeuse == null) ? 0 : oTondeuse.hashCode());
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
		Tondeuse other = (Tondeuse) obj;
		if (cTondeuse == null) {
			if (other.cTondeuse != null)
				return false;
		} else if (!cTondeuse.equals(other.cTondeuse))
			return false;
		if (oTondeuse != other.oTondeuse)
			return false;
		return true;
	}
	
	

}
