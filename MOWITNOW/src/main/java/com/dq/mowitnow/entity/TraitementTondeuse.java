package com.dq.mowitnow.entity;

import java.util.List;

import com.dq.mowitnow.entity.Constants.Action;
import com.dq.mowitnow.manager.ControleTondeuse;

public class TraitementTondeuse {

	private Pelouse pelouse;
	private Tondeuse tondeuse;
	private List<Action> actionList;

	public TraitementTondeuse() {
		// TODO Auto-generated constructor stub
	}

	public TraitementTondeuse(Pelouse pelouse, Tondeuse tondeuse,
			List<Action> actionList) {
		super();
		this.pelouse = pelouse;
		this.tondeuse = tondeuse;
		this.actionList = actionList;
	}

	public Pelouse getPelouse() {
		return pelouse;
	}

	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}

	public Tondeuse getTondeuse() {
		return tondeuse;
	}

	public void setTondeuse(Tondeuse tondeuse) {
		this.tondeuse = tondeuse;
	}

	public List<Action> getActionList() {
		return actionList;
	}

	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}

	public void executerAction(TraitementTondeuse traitementTondeuse) {
		List<Constants.Action> actionList = traitementTondeuse.getActionList();
		if (actionList.size() > 0) {
			for (int i = 0; i < actionList.size(); i++) {
				ControleTondeuse.actionTondeuse(
						traitementTondeuse.getTondeuse(), actionList.get(i),
						traitementTondeuse.getPelouse().getCoordonneeSup());
			}
		}
	}

	public String toString() {
		String espace = " ";

		return tondeuse.getcTondeuse().getX() + espace
				+ tondeuse.getcTondeuse().getY() + espace
				+ tondeuse.getoTondeuse().getCode();
	}

}
