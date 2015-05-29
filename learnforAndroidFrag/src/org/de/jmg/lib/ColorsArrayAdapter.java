package org.de.jmg.lib;

import org.de.jmg.learnforandroidfrag.R;
import org.de.jmg.lib.ColorSetting.ColorItems;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ColorsArrayAdapter extends
		AbstractScaledArrayAdapter<ColorSetting> {

	private Activity _Activity;

	// public float scale = 1;
	public ColorsArrayAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		_Activity = (Activity) context;
		SharedPreferences prefs = _Activity
				.getPreferences(Context.MODE_PRIVATE);
		for (int i = 0; i < ColorSetting.ColorItems.values().length; i++) {
			ColorItems ColorItem = ColorSetting.ColorItems.values()[i];
			String Name = _Activity.getResources().getStringArray(
					R.array.spnColors)[i];
			int defValue = 0;
			switch (ColorItem) {
			case word:
				defValue = Color.BLACK;
				break;
			case meaning:
				defValue = Color.BLACK;
				break;
			case comment:
				defValue = Color.BLACK;
				break;
			case background:
				defValue = 0xffffffff;
				break;
			case background_wrong:
				defValue = 0xffc0c0c0;
				break;
			case box_word:
				defValue = 0xffffffff;
				break;
			case box_meaning:
				defValue = 0xffffffff;
				break;
			default:
				defValue = Color.BLACK;
				break;
			}
			int Color = prefs.getInt(ColorItem.name(), defValue);
			this.add(new ColorSetting(ColorItem, Name, Color));
		}

	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	public View getCustomView(int position, View convertView, ViewGroup parent) {
		boolean blnNew = false;
		LayoutInflater inflater = _Activity.getLayoutInflater();
		ColorSetting ColorItem; 
		if (position < 0) 
		{
			return convertView;
			//ColorItem = new ColorSetting(ColorItems.background,"Test", 0);
		}
		else
		{
			ColorItem = getItem(position);
		}
		
		View row;

		if (convertView == null) {
			row = inflater.inflate(R.layout.spinnerrow, parent, false);
			blnNew = true;
		} else {
			row = convertView;
			if (row.getTag() == null)
				blnNew = true;
		}

		TextView label = (TextView) row.findViewById(R.id.txtColors);
		if (blnNew)
			label.setTextSize(TypedValue.COMPLEX_UNIT_PX, label.getTextSize()
					* super.Scale);
		label.setText(ColorItem.ColorName);

		TextView icon = (TextView) row.findViewById(R.id.txtColors2);
		if (blnNew)
			icon.setTextSize(TypedValue.COMPLEX_UNIT_PX, icon.getTextSize()
					* super.Scale);
		icon.setBackgroundColor(ColorItem.ColorValue);
		if (Scale != 1.0f)
			row.setTag(true);
		return row;
	}

}