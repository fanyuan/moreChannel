package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMain4Binding;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    UserInfo2 info ;
    ActivityMain4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main4);
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_main4);
        info = new UserInfo2();
        binding.setUser(info);
        
    }
    public void click(View v){
        int i = new Random().nextInt(info.tripMode.length);
        Toast.makeText(this,"i = " + i,Toast.LENGTH_SHORT).show();
        binding.setIndex(i);
    }
}