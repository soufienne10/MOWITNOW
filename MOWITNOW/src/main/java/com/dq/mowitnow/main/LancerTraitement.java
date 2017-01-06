package com.dq.mowitnow.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.dq.mowitnow.entity.Constants.Action;
import com.dq.mowitnow.entity.Pelouse;
import com.dq.mowitnow.entity.Tondeuse;
import com.dq.mowitnow.entity.TraitementTondeuse;
import com.dq.mowitnow.manager.TraitementFichier;

public class LancerTraitement {
	protected static String resultat;
	public static void main(String args) {
		String chaine = "";
		String premiereLigne = "";
		String fichier = "C:\\Users\\Soufienne\\workspaceLuna\\myTestTechniqueV0\\src\\test\\resources\\fichier_TEST.txt";

		try {
			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			int lingeNbr = 0;
			while ((ligne = br.readLine()) != null) {
				lingeNbr++;
				if (lingeNbr == 1) {
					premiereLigne = ligne;
				} else {
					if (!"".equals(ligne)) {
						chaine += ligne + "\n";
					}
				}
			}
			br.close();
			LancerTraitement instance = new LancerTraitement();
			resultat = instance.splitFichier(premiereLigne, chaine);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private String splitFichier(String premiereLigne, String chaineReste) {
		Pelouse pelouse = TraitementFichier
				.traitementLignePelouse(premiereLigne);
		return traiterTondeuseList(pelouse, chaineReste);
	}

	private String traiterTondeuseList(Pelouse pelouse, String chaineReste) {
		String delimiter = "\n";
		String[] temp = chaineReste.split(delimiter);
		String res = "";
		for (int i = 0; i < temp.length; i++) {
			Tondeuse tondeuse = TraitementFichier
					.traitementLigneTondeuse(temp[i]);
			List<Action> actionList = TraitementFichier
					.traitementLigneAction(temp[i + 1]);
			TraitementTondeuse traitementTondeuse = new TraitementTondeuse();
			traitementTondeuse.setPelouse(pelouse);
			traitementTondeuse.setTondeuse(tondeuse);
			traitementTondeuse.setActionList(actionList);
			traitementTondeuse.executerAction(traitementTondeuse);
			System.out.println(traitementTondeuse);
			res = res + "\n" + traitementTondeuse;
			i = i + 1;
		}
		return res;
	}
}
