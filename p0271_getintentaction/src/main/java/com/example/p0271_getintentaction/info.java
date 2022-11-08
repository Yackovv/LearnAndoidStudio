package com.example.p0271_getintentaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String action = intent.getAction();
        String format = "";
        String textInfo = "";

        if(action.equals("com.example.intent.action.showTime")){
            format = "HH:mm:ss";
            textInfo = "Time: ";
        } else if (action.equals("com.example.intent.action.showDate")){
            format = "dd.MM.yyyy";
            textInfo = "Date: ";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateTime = sdf.format(new Date(System.currentTimeMillis()));

        TextView tv = findViewById(R.id.tvInfo);
        tv.setText(textInfo + dateTime);
    }
}