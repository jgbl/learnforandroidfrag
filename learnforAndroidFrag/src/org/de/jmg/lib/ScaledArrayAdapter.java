package org.de.jmg.lib;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ScaledArrayAdapter<T> extends AbstractScaledArrayAdapter<T> {

	public ScaledArrayAdapter(Context context, int resource) {
		super(context, resource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		boolean blnNew = (convertView == null);
		View V = super.getDropDownView(position, convertView, parent);
		if (V != null)
		{
			if (V.getTag() == null)
				blnNew = true;
			if (blnNew) {
				resizeviews(V);
			}
		}
		
		return V;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		boolean blnNew = (convertView == null);
		View V = super.getView(position, convertView, parent);
		if (V != null)
		{
			if (V.getTag() == null)
				blnNew = true;
			if (blnNew) {
				resizeviews(V);
			}
		}
		
		return V;
	}

	private void resizeviews(View V) {
		if (!(V instanceof TextView)) {
			if (V instanceof ViewGroup) {
				ViewGroup views = (ViewGroup) V;
				for (int i = 0; i < views.getChildCount(); i++) {
					View v = views.getChildAt(i);
					if (v instanceof TextView) {
						TextView t = (TextView) v;
						t.setTextSize(TypedValue.COMPLEX_UNIT_PX,
								t.getTextSize() * Scale);
					}
				}

			}
		} else {
			TextView t = (TextView) V;
			t.setTextSize(TypedValue.COMPLEX_UNIT_PX, t.getTextSize() * Scale);
		}
		if (Scale != 1)
			V.setTag(true);
	}

	public static ScaledArrayAdapter<CharSequence> createFromResource(
			Context context, int textArrayResId, int textViewResId) {
		ArrayAdapter<CharSequence> A = ArrayAdapter.createFromResource(context,
				textArrayResId, textViewResId);
		ScaledArrayAdapter<CharSequence> SA = new ScaledArrayAdapter<CharSequence>(
				context, textViewResId);
		for (int i = 0; i < A.getCount(); i++) {
			SA.add(A.getItem(i));
		}
		return SA;
	}

	{

	}

}
