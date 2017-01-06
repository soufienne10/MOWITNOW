package com.dq.mowitnow.entity;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.dq.mowitnow.entity.Constants.Action;
import com.dq.mowitnow.entity.Constants.Orientation;

public class TraitementTondeuseTest {
	Coordonnees coordonnesSup = new Coordonnees(5, 5);
	@Test
	public void testExecuterAction_Tondeuse_1() {
		int x = 1;
		int y = 2;				
		
		Coordonnees coordonnees = new Coordonnees(x, y);
		Tondeuse tondeuse = new Tondeuse(coordonnees,Orientation.NORTH);
		Pelouse pelouse = new Pelouse(coordonnesSup);
		List<Action> actionList = new ArrayList<Action>(); 
		actionList.add(Action.GAUCHE);
		actionList.add(Action.AVANCER);
		actionList.add(Action.GAUCHE);
		actionList.add(Action.AVANCER);
		actionList.add(Action.GAUCHE);
		actionList.add(Action.AVANCER);
		actionList.add(Action.GAUCHE);
		actionList.add(Action.AVANCER);
		actionList.add(Action.AVANCER);
		
		TraitementTondeuse traitementTondeuse = new TraitementTondeuse();
		traitementTondeuse.setActionList(actionList);
		traitementTondeuse.setPelouse(pelouse);	
		traitementTondeuse.setTondeuse(tondeuse);
		
		traitementTondeuse.executerAction(traitementTondeuse);
		assertThat(traitementTondeuse.toString()).isEqualTo("1 3 N");
	}

	@Test
	public void testExecuterAction_Tondeuse_2() {
		int x = 3;
		int y = 3;				
		
		Coordonnees coordonnees = new Coordonnees(x, y);
		Tondeuse tondeuse = new Tondeuse(coordonnees,Orientation.EAST);
		Pelouse pelouse = new Pelouse(coordonnesSup);
		List<Action> actionList = new ArrayList<Action>(); 
		actionList.add(Action.AVANCER);
		actionList.add(Action.AVANCER);
		actionList.add(Action.DROITE);
		actionList.add(Action.AVANCER);
		actionList.add(Action.AVANCER);
		actionList.add(Action.DROITE);
		actionList.add(Action.AVANCER);
		actionList.add(Action.DROITE);
		actionList.add(Action.DROITE);
		actionList.add(Action.AVANCER);
		
		TraitementTondeuse traitementTondeuse = new TraitementTondeuse();
		traitementTondeuse.setActionList(actionList);
		traitementTondeuse.setPelouse(pelouse);	
		traitementTondeuse.setTondeuse(tondeuse);
		
		traitementTondeuse.executerAction(traitementTondeuse);
		assertThat(traitementTondeuse.toString()).isEqualTo("5 1 E");
	}

}
