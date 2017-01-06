package com.dq.mowitnow.manager;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

import com.dq.mowitnow.entity.Constants.Action;
import com.dq.mowitnow.entity.Constants.Orientation;
import com.dq.mowitnow.entity.Coordonnees;
import com.dq.mowitnow.entity.Pelouse;
import com.dq.mowitnow.entity.Tondeuse;
import com.dq.mowitnow.manager.ControleTondeuse;

public class ControleTondeuseTest {

	@Test
	public void testValidateAction() {
		Pelouse pelouse = new Pelouse(new Coordonnees(5, 5));
		Coordonnees coordonneeTendeuse1 = new Coordonnees(1, 6);
		Coordonnees coordonneeTendeuse2 = new Coordonnees(1, 2);
		assertThat(
				ControleTondeuse.validateAction(coordonneeTendeuse1,
						pelouse.getCoordonneeSup())).isFalse();
		assertThat(
				ControleTondeuse.validateAction(coordonneeTendeuse2,
						pelouse.getCoordonneeSup())).isTrue();
	}

	@Test
	public void testAvancerTondeuse() {
		int xSup = 5;
		int ySup = 5;
		int x = 3;
		int y = 5;
		Coordonnees coordonneesSup = new Coordonnees(xSup, ySup);
		Coordonnees coordonnees = new Coordonnees(x, y);

		Tondeuse tondeuse = new Tondeuse(coordonnees, Orientation.NORTH);
		ControleTondeuse.avancerTondeuse(tondeuse, coordonneesSup);
		assertThat(tondeuse.getcTondeuse()).isEqualTo(new Coordonnees(3, 5));
		assertThat(tondeuse.getoTondeuse()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void testActionDroite() {
		Orientation orientation = ControleTondeuse
				.actionDroite(Orientation.EAST);
		assertThat(orientation).isEqualTo(Orientation.SOUTH);

		orientation = ControleTondeuse.actionDroite(Orientation.WEST);
		assertThat(orientation).isEqualTo(Orientation.NORTH);

		orientation = ControleTondeuse.actionDroite(Orientation.NORTH);
		assertThat(orientation).isEqualTo(Orientation.EAST);

		orientation = ControleTondeuse.actionDroite(Orientation.SOUTH);
		assertThat(orientation).isEqualTo(Orientation.WEST);
	}

	@Test
	public void testActionGauche() {
		Orientation orientation = ControleTondeuse
				.actionGauche(Orientation.EAST);
		assertThat(orientation).isEqualTo(Orientation.NORTH);

		orientation = ControleTondeuse.actionGauche(Orientation.WEST);
		assertThat(orientation).isEqualTo(Orientation.SOUTH);

		orientation = ControleTondeuse.actionGauche(Orientation.NORTH);
		assertThat(orientation).isEqualTo(Orientation.WEST);

		orientation = ControleTondeuse.actionGauche(Orientation.SOUTH);
		assertThat(orientation).isEqualTo(Orientation.EAST);
	}

	@Test
	public void testActionTondeuse() {
		int xSup = 5;
		int ySup = 5;
		int x = 1;
		int y = 3;
		Coordonnees coordonneesSup = new Coordonnees(xSup, ySup);
		Coordonnees coordonnees = new Coordonnees(x, y);
		Tondeuse tondeuse = new Tondeuse(coordonnees, Orientation.NORTH);
		ControleTondeuse.actionTondeuse(tondeuse, Action.AVANCER,
				coordonneesSup);
		assertThat(tondeuse.getcTondeuse()).isEqualTo(new Coordonnees(1, 4));
		assertThat(tondeuse.getoTondeuse()).isEqualTo(Orientation.NORTH);

	}

}
