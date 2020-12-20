package com.example.mydemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void permission(View v){
        startActivity(new Intent(this,PermissionActivity.class));
    }
    public void diaglog(View v){
        startActivity(new Intent(this, DialogActivity.class));
    }

    public void popupWindow(View v){
        startActivity(new Intent(this, PopupWindowActivity.class));
    }

    public void sharedPreferences(View v){
        startActivity(new Intent(this,SharedPreferencesActivity.class));
    }
    public void progress(View v){
        startActivity(new Intent(this,ProgressActivity.class));
    }
}