package org.de.jmg.learn.vok;

import java.util.ArrayList;

import org.de.jmg.learn.vok.typVok;

public class ArrVok extends ArrayList<typVok> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5138813153169214705L;

	public void AddVokabel(String Wort, String Bed1, String Bed2, String Bed3,
			String Kom, short z) {
		typVok vok = new typVok(Wort, Bed1, Bed2, Bed3, Kom, z);
		this.add(vok);
	}

}
