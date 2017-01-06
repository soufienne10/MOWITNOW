package com.dq.mowitnow.manager;

import static org.fest.assertions.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dq.mowitnow.entity.Coordonnees;
import com.dq.mowitnow.entity.Pelouse;
import com.dq.mowitnow.entity.Tondeuse;
import com.dq.mowitnow.entity.Constants.Orientation;
import com.dq.mowitnow.entity.Constants.Action;

public class TraitementFichierTest {

	@Test
	public void testTraitementLignePelouse() {
		String PelouseStr = "5 5";
		Pelouse pelouse = TraitementFichier.traitementLignePelouse(PelouseStr);
		assertThat(pelouse).isEqualTo(new Pelouse(new Coordonnees(5, 5)));
	}

	@Test
	public void testTraitementLigneTondeuse() {
		String TondeuseStr = "1 2 N";
		Coordonnees coordonneesTondeuse = new Coordonnees(1, 2);
		Orientation orientation = Orientation.NORTH;
		Tondeuse tondeuse = new Tondeuse(coordonneesTondeuse, orientation);
		Tondeuse tondeuseTraitement = TraitementFichier
				.traitementLigneTondeuse(TondeuseStr);
		assertThat(tondeuseTraitement).isEqualTo(tondeuse);
	}

	@Test
	public void testGetOrientation() {
		char orientationNorth ='N';
		char orientationEast ='E';
		char orientationWest ='W';
		char orientationSouth = 'S';
		assertThat(TraitementFichier.getOrientation(orientationNorth)).isEqualTo(Orientation.NORTH);
		assertThat(TraitementFichier.getOrientation(orientationEast)).isEqualTo(Orientation.EAST);
		assertThat(TraitementFichier.getOrientation(orientationWest)).isEqualTo(Orientation.WEST);
		assertThat(TraitementFichier.getOrientation(orientationSouth)).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void testTraitementLigneAction() {
		String actionList ="GAGAGAGAA";
		List<Action> listAction = new ArrayList<Action>();
		listAction.add(Action.GAUCHE);
		listAction.add(Action.AVANCER);
		listAction.add(Action.GAUCHE);
		listAction.add(Action.AVANCER);
		listAction.add(Action.GAUCHE);
		listAction.add(Action.AVANCER);
		listAction.add(Action.GAUCHE);
		listAction.add(Action.AVANCER);
		listAction.add(Action.AVANCER);
		assertThat(TraitementFichier.traitementLigneAction(actionList)).isEqualTo(listAction);

	}

	@Test
	public void testGetAction() {
		char actionAvancer ='A';
		char actionDroite ='D';
		char actionGauche ='G';
		assertThat(TraitementFichier.getAction(actionAvancer)).isEqualTo(Action.AVANCER);
		assertThat(TraitementFichier.getAction(actionDroite)).isEqualTo(Action.DROITE);
		assertThat(TraitementFichier.getAction(actionGauche)).isEqualTo(Action.GAUCHE);
	}

}
