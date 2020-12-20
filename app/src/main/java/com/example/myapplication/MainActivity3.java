package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ActivityMain3Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_main3);
        UserInfo info = new UserInfo();
        info.name = "user Info";
        info.age = 28;
        info.sex = 1;
        info.sign = "问君能有几多愁，恰似一杯二锅头";
        binding.setInfo(info);
    }
}