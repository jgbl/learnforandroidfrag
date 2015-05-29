package org.de.jmg.learn.vok;

import org.de.jmg.lib.lib.libString;

public class typVok {
	// Aufbau einer Vokabel
	public String Wort;
	public String Bed1;
	public String Bed2;
	public String Bed3;

	public String[] getBedeutungen() {
		return new String[] { Bed1, Bed2, Bed3 };
	}

	public int getAnzBed() {
		int functionReturnValue = 0;
		for (String Bed : getBedeutungen()) {
			if (!libString.IsNullOrEmpty(Bed))
				functionReturnValue += 1;
		}
		return functionReturnValue;
	}

	// Kommentar
	public String Kom;
	// Zähler wie oft gewußt
	public short z;

	public typVok(String Wort, String Bed1, String Bed2, String Bed3,
			String Kom, short z) {
		this.Wort = Wort;
		this.Bed1 = Bed1;
		this.Bed2 = Bed2;
		this.Bed3 = Bed3;
		this.Kom = Kom;
		this.z = z;
	}

	public typVok() {
		// TODO Auto-generated constructor stub
	}
}
