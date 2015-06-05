package org.de.jmg.lib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.EditText;

public class BorderedEditText extends EditText {
	private Paint paint = new Paint();
	public static final int BORDER_TOP = 0x00000001;
	public static final int BORDER_RIGHT = 0x00000002;
	public static final int BORDER_BOTTOM = 0x00000004;
	public static final int BORDER_LEFT = 0x00000008;
	public RectF RoundedRect;
	public boolean showBorders;

	public BorderedEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public BorderedEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BorderedEditText(Context context) {
		super(context);
		init();
	}

	public void setShowBorders(boolean showBorders, int BackColor) {
		this.showBorders = showBorders;
		if (showBorders) {
			this.setBackgroundResource(org.de.jmg.learn.R.layout.roundedbox);
			GradientDrawable drawable = (GradientDrawable) this.getBackground();
			drawable.setColor(BackColor);
		} else {
			this.setBackgroundResource(0);
			// this.setBackgroundColor(BackColor);
		}
		this.invalidate();
	}

	private void init() {
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(4);

	}
	/*
	 * @Override protected void onDraw(Canvas canvas) { //this.setPadding(5, 5,
	 * 5, 5);
	 * 
	 * super.onDraw(canvas); //this.setPadding(0, 0, 0, 0); if(!showBorders)
	 * return; if (RoundedRect == null) RoundedRect = new RectF(0, 0,
	 * getWidth()-0, getHeight()-0); canvas.drawRoundRect(RoundedRect, 6, 6,
	 * paint); }
	 */

}