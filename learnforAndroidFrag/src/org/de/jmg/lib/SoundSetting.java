package org.de.jmg.lib;

public class SoundSetting {
	public String SoundName;
	public String SoundPath;
	public lib.Sounds Sound;

	public SoundSetting(lib.Sounds Sound, String SoundName, String SoundPath) {
		// TODO Auto-generated constructor stub
		this.Sound = Sound;
		this.SoundName = SoundName;
		this.SoundPath = SoundPath;
	}

}
