package com.example.dinamiclayot3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sbWeight;
    Button button1;
    Button button2;
    LinearLayout.LayoutParams lParams1;
    LinearLayout.LayoutParams lParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbWeight = findViewById(R.id.sdWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);

        lParams1 = (LinearLayout.LayoutParams) button1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) button2.getLayoutParams();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int rightValue = seekBar.getMax() - progress;

        lParams1.weight = progress;
        lParams2.weight = rightValue;

        button1.setText(String.valueOf(progress));
        button2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        button1.setText("Button1");
        button2.setText("Button2");
    }
}