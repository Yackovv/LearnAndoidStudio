package com.example.simpleanimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        tv.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Animation anim = null;
        switch (item.getItemId()){
            case R.id.alpha:
                anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
                break;
            case R.id.scale:
                anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
                break;
            case R.id.trans:
                anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
                break;
            case R.id.rotate:
                anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
                break;
            case R.id.combo:
                anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
                break;
        }
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
}