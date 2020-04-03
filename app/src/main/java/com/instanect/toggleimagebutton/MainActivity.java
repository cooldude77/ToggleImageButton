package com.instanect.toggleimagebutton;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.instanect.toggleimagebuttonmodule.ToggleImageAfterToggleButtonClickListener;
import com.instanect.toggleimagebuttonmodule.ToggleImageBeforeToggleButtonClickListener;
import com.instanect.toggleimagebuttonmodule.ToggleImageButton;
import com.instanect.toggleimagebuttonmodule.ToggleImageButtonObject;

public class MainActivity extends AppCompatActivity implements ToggleImageBeforeToggleButtonClickListener, ToggleImageAfterToggleButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleImageButton toggleImageButton = findViewById(R.id.toggleImageButton);
        ToggleImageButtonObject toggleImageButtonObject = new ToggleImageButtonObject();

        toggleImageButtonObject.setResIdForStateA(R.drawable.ic_arrow_close);
        toggleImageButtonObject.setResIdForStateNotA(R.drawable.ic_arrow_open);
        toggleImageButtonObject.setCurrentState(ToggleImageButtonObject.STATE_A);
        toggleImageButtonObject.setToggleImageBeforeToggleButtonClickListener(this);
        toggleImageButtonObject.setToggleImageAfterToggleButtonClickListener(this);

        toggleImageButton.setToggleImageButtonObject(toggleImageButtonObject);
    }

    @Override
    public void beforeToggle(ToggleImageButton toggleImageButton) {
        toggleImageButton.toggleState();
    }

    @Override
    public void afterToggle(ToggleImageButton toggleImageButton) {
        Toast.makeText(this, "After Toggle", Toast.LENGTH_SHORT).show();
    }
}
