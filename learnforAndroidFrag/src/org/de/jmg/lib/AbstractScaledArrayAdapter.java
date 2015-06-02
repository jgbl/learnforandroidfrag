package org.de.jmg.lib;

import java.util.Collection;

import android.content.Context;
import android.widget.ArrayAdapter;

public class AbstractScaledArrayAdapter<T> extends ArrayAdapter<T> {

	public AbstractScaledArrayAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}

	public float Scale = 1.0f;
	
	@Override
	public void addAll(Collection<? extends T>collection)
	{
		for (T s: collection)
		{
			this.add(s);
		}
	}
	
	@Override
	public int getCount()
	{
		int count = super.getCount();
		return count;
	}

}
