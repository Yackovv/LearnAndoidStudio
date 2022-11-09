package com.example.twoactivitystate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity_Two extends AppCompatActivity {

    final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(TAG, "Activity_Two: onCreate()");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "Activity_Two: onRestart");
    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG, "Activity_Two: onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Activity_Two: onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Activity_Two: onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Activity_Two: onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Activity_Two: onDestroy");
    }
}