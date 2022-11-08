package com.example.simplecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;
    Button btnAdd;
    Button btnSup;
    Button btnMult;
    Button btnDiv;
    Button btnClear;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSup = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        btnClear = findViewById(R.id.btnClear);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSup.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String strNum1 = etNum1.getText().toString();
        String strNum2 = etNum2.getText().toString();
        boolean b = (strNum1.isEmpty() || strNum1.equals("0")) && (strNum2.isEmpty() || strNum2.equals("0"));

        switch (v.getId()){
            case R.id.btnAdd:
                if(b){
                    tvResult.setText("0");
                } else if(strNum1.isEmpty() || strNum1.equals("0")){
                    tvResult.setText(strNum2);
                } else if(strNum2.isEmpty() || strNum2.equals("0")){
                    tvResult.setText(strNum1);
                } else {
                    double num1 = Double.parseDouble(strNum1);
                    double num2 = Double.parseDouble(strNum2);
                    tvResult.setText(String.valueOf(num1+num2));
                }
                break;
            case R.id.btnSub:
                if(b){
                    tvResult.setText("0");
                } else if(strNum1.isEmpty() || strNum1.equals("0")){
                    tvResult.setText("-" + strNum2);
                } else if(strNum2.isEmpty() || strNum2.equals("0")){
                    tvResult.setText(strNum1);
                } else {
                    double num1 = Double.parseDouble(strNum1);
                    double num2 = Double.parseDouble(strNum2);
                    tvResult.setText(String.valueOf(num1-num2));
                }
                break;
            case R.id.btnMult:
                if(b){
                    tvResult.setText("0");
                } else if(strNum1.isEmpty() || strNum1.equals("0")){
                    tvResult.setText("0");
                } else if(strNum2.isEmpty() || strNum2.equals("0")){
                    tvResult.setText("0");
                } else {
                    double num1 = Double.parseDouble(strNum1);
                    double num2 = Double.parseDouble(strNum2);
                    tvResult.setText(String.valueOf(num1*num2));
                }
                break;
            case R.id.btnDiv:
                if(b){
                    tvResult.setText("ERROR");
                } else if(strNum1.isEmpty() || strNum1.equals("0")){
                    tvResult.setText("0");
                } else if(strNum2.isEmpty() || strNum2.equals("0")){
                    tvResult.setText("ERROR");
                } else {
                    double num1 = Double.parseDouble(strNum1);
                    double num2 = Double.parseDouble(strNum2);
                    tvResult.setText(String.valueOf(num1/num2));
                }
                break;
            case R.id.btnClear:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
        }
    }
}