package org.de.jmg.lib;

public class ColorSetting {
	public String ColorName;
	public int ColorValue;
	public ColorItems ColorItem;

	public enum ColorItems {
		word, meaning, comment, background, box_word, box_meaning, background_wrong
	}

	public ColorSetting(ColorItems ColorItem, String ColorName, int ColorValue) {
		// TODO Auto-generated constructor stub
		this.ColorItem = ColorItem;
		this.ColorName = ColorName;
		this.ColorValue = ColorValue;
	}

}
