package org.de.jmg.lib;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AbstractScaledArrayAdapter<T> extends ArrayAdapter<T> {

	public AbstractScaledArrayAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}

	public float Scale = 1.0f;

}
