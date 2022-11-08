package com.example.p0111_resvalues;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    private static final String TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Найдем все View элементы");
        tvOut = findViewById(R.id.tvOut);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        Log.d(TAG, "Присваиваем обработчик кнопкам");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "По id определяем кнопку, вызвавшую этот обработчик");
        Toast.makeText(this, "Определяем кто вызвал обработчик", Toast.LENGTH_LONG).show();
        switch (v.getId()){
            case R.id.btnOk:
                Log.d(TAG,"Нажата кнопка Ok");
                tvOut.setText("Нажата кнопка Оk");
                Toast.makeText(this, "Была нажата кнопка Ok", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCancel:
                Log.d(TAG,"Нажата кнопка Cancel");
                tvOut.setText("Нажата кнопка Cancel");
                Toast.makeText(this, "Была нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                break;
        }
    }
}