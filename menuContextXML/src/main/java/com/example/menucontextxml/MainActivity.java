package com.example.menucontextxml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvColor;
    TextView tvSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvColor = findViewById(R.id.tvColor);
        tvSize = findViewById(R.id.tvSize);

        tvColor.setOnCreateContextMenuListener(this);
        tvSize.setOnCreateContextMenuListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch(v.getId()){
            case R.id.tvColor:
                getMenuInflater().inflate(R.menu.context_menu, menu);
                break;
            case R.id.tvSize:
                getMenuInflater().inflate(R.menu.contex_menu_text_size, menu);
                break;
        }
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.contextMenu_Red:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = Red");
                break;
            case R.id.contextMenu_Green:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = Green");
                break;
            case R.id.contextMenu_Blue:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = Blue");
                break;
            case R.id.contextMenu_22:
                tvSize.setTextSize(22);
                tvSize.setText("Text size = 22");
                break;
            case R.id.contextMenu26:
                tvSize.setTextSize(26);
                tvSize.setText("Text size = 26");
                break;
            case R.id.contextMenu30:
                tvSize.setTextSize(300);
                tvSize.setText("Text size = 30");
                break;
        }

        return super.onContextItemSelected(item);
    }
}