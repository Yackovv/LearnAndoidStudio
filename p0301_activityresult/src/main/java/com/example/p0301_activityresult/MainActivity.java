package com.example.p0301_activityresult;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnColor;
    Button btnAlign;
    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnColor = findViewById(R.id.btnColor);
        btnAlign = findViewById(R.id.btnAlign);
        tvText = findViewById(R.id.tvText);

        btnColor.setOnClickListener(this);
        btnAlign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btnColor:

                break;
            case R.id.btnAlign:

                break;
        }
    }
}