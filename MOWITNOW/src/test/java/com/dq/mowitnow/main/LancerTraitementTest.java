package com.dq.mowitnow.main;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

public class LancerTraitementTest {

	@Test
	public void testMain() {
		String FICHIER = "C:\\Users\\Soufienne\\workspaceLuna\\myTestTechniqueV0\\src\\test\\resources\\fichier_TEST.txt"; 
		LancerTraitement.main(FICHIER);		
		assertThat(LancerTraitement.resultat).contains("1 3 N").contains("5 1 E");
	}

}
