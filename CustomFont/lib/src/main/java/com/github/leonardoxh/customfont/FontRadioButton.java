package com.github.leonardoxh.customfont;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

public class FontRadioButton extends RadioButton {

    public FontRadioButton(Context context) {
        super(context);
    }

    public FontRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setCustomFont(context, attrs);
    }

    public FontRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setCustomFont(context, attrs);
    }

    protected void setCustomFont(Context context, AttributeSet attrs) {
        TypedArray style = context.obtainStyledAttributes(attrs, R.styleable.font);
        this.setCustomFont(context, style.getString(R.styleable.font_font));
        style.recycle();
    }

    public boolean setCustomFont(Context context, String font) {
        try {
            this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/"+font+".ttf"));
            return true;
        }
        catch(Exception e) {
            Log.d("FontRadioButton", "Error to obtain the font: " + font, e);
        }
        return false;
    }

}