package org.de.jmg.lib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class BorderedTextView extends TextView {
	private Paint paint = new Paint();
	public static final int BORDER_TOP = 0x00000001;
	public static final int BORDER_RIGHT = 0x00000002;
	public static final int BORDER_BOTTOM = 0x00000004;
	public static final int BORDER_LEFT = 0x00000008;

	public boolean showBorders;

	// private RectF RoundedRect;

	public BorderedTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public BorderedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public BorderedTextView(Context context) {
		super(context);
		init();
	}

	public void setShowBorders(boolean showBorders, int backColor) {
		this.showBorders = showBorders;
		if (showBorders) {
			this.setBackgroundResource(org.de.jmg.learn.R.layout.roundedbox);
			GradientDrawable drawable = (GradientDrawable) this.getBackground();
			drawable.setColor(backColor);

		} else {
			this.setBackgroundResource(0);
		}
		this.invalidate();
	}

	private void init() {
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(4);
		// this.setPadding(5, 5, 5, 5);

	}
	/*
	 * @Override protected void onDraw(Canvas canvas) { //this.setPadding(5, 5,
	 * 5, 5); super.onDraw(canvas); //this.setPadding(0, 0, 0, 0);
	 * if(!showBorders) return; if (RoundedRect == null || RoundedRect.width()
	 * != getWidth()) RoundedRect = new RectF(0, 0, getWidth()-0,
	 * getHeight()-0); canvas.drawRoundRect(RoundedRect, 6, 6, paint); }
	 */
}