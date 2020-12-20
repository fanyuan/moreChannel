package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = Utils.getAppMetaData(this,"UMENG_CHANNEL");
        Log.d("ddebug","str = " + str);
    }

    public void click(View v){
        startActivity(new Intent(this,MainActivity2.class));
    }
    public void MainActivity3(View v){
        startActivity(new Intent(this,MainActivity3.class));
    }
    public void MainActivity4(View v){
        startActivity(new Intent(this,MainActivity4.class));
    }
    public void MainActivity5(View v){
        startActivity(new Intent(this,MainActivity5.class));
    }
}