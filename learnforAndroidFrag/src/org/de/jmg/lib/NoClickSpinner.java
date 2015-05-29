package org.de.jmg.lib;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Spinner;

public class NoClickSpinner extends Spinner {
	public boolean blnDontCallOnClick;

	public NoClickSpinner(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public NoClickSpinner(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public NoClickSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		if (!blnDontCallOnClick)
			super.onClick(dialog, which);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (!blnDontCallOnClick) {
			return super.onTouchEvent(event);
		} else {
			return true;
		}

	}

}
