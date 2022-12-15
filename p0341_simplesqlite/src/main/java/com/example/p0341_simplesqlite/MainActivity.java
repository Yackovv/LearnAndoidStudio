package com.example.p0341_simplesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName;
    EditText etEmail;
    Button btnAdd;
    Button btnRead;
    Button btnClear;
    TextView tv;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dbHelper = new DBHelper(this);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        tv = findViewById(R.id.tv);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnAdd:
                dbHelper.addToMyDB(new Data(etName.getText().toString(), etEmail.getText().toString()));
                break;
            case R.id.btnRead:
                ArrayList<Data> list = dbHelper.readMyDB();
                if(list.isEmpty()){
                    Toast.makeText(this, "Database is empty", Toast.LENGTH_LONG).show();
                } else {
                    StringBuilder str = new StringBuilder();
                    for(Data i: list){
                        str =  str.append(i.getId()).append(" ").append(i.getName()).append(" ").append(i.getEmail()).append("\n");
                    }
                    tv.setText(str);
                }
                break;
            case R.id.btnClear:
                dbHelper.clearMyDB();
                break;
        }
    }
}