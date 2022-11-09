package com.example.twoactivitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "States";
    Button btnActTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActTwo = findViewById(R.id.btnActTwo);
        btnActTwo.setOnClickListener(this);

        Log.d(TAG, "MainActivity: onCreate");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart");
    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG, "MainActivity: onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG, "MainActivity: onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG, "MainActivity: onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG, "MainActivity: onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
            Log.d(TAG, "MainActivity: onDestroy");
        }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnActTwo){
            Intent intent = new Intent(this, Activity_Two.class);
            startActivity(intent);
        }
    }
}