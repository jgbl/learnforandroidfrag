package org.de.jmg.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class WindowsBufferedReader extends BufferedReader {

	public WindowsBufferedReader(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	public WindowsBufferedReader(Reader in, int size) {
		super(in, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String readLine() throws IOException {

		String s = super.readLine();
		if (s != null) {
			int length = s.length();
			if (length > 1) {
				char c = s.charAt(0);
				int ic = c;
				if (ic == 65279) {
					s = s.substring(1);
				}
			}
		}
		return s;
	}

}
