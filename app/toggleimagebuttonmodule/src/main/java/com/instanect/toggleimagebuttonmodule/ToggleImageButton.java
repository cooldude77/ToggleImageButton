package com.instanect.toggleimagebuttonmodule;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;

public class ToggleImageButton extends AppCompatImageButton implements View.OnClickListener {
    public ToggleImageButton(Context context) {
        super(context);
    }

    public ToggleImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToggleImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private ToggleImageButtonObject toggleImageButtonObject;

    public ToggleImageButtonObject getToggleImageButtonObject() {
        return toggleImageButtonObject;
    }

    public void setToggleImageButtonObject(ToggleImageButtonObject toggleImageButtonObject) {
        this.toggleImageButtonObject = toggleImageButtonObject;

        setOnClickListener(this);
        setImageDrawable(
                getDrawableBasedOnState());

    }

    private Drawable getDrawableBasedOnState() {
        return ContextCompat.getDrawable(getContext(),
                toggleImageButtonObject.getCurrentState() == ToggleImageButtonObject.STATE_A ?
                        toggleImageButtonObject.getResIdForStateA() :
                        toggleImageButtonObject.getResIdForStateNotA());
    }

    public void toggleState() {
        if (toggleImageButtonObject.getCurrentState() == ToggleImageButtonObject.STATE_A)
            toggleImageButtonObject.setCurrentState(ToggleImageButtonObject.STATE_NOT_A);
        else
            toggleImageButtonObject.setCurrentState(ToggleImageButtonObject.STATE_A);

        setImageDrawable(getDrawableBasedOnState());

        if (toggleImageButtonObject.getToggleImageAfterToggleButtonClickListener() != null)
            toggleImageButtonObject.getToggleImageAfterToggleButtonClickListener().afterToggle(this);

    }

    public int getState() {
        return toggleImageButtonObject.getCurrentState();
    }

    @Override
    public void onClick(View v) {

        if (v == this)
            if (toggleImageButtonObject.getToggleImageBeforeToggleButtonClickListener() == null)
                toggleState();
            else
                toggleImageButtonObject.getToggleImageBeforeToggleButtonClickListener().beforeToggle(this);
    }
}
