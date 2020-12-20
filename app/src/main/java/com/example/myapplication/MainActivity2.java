package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMain2Binding;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding dataBinding;
    UserBean bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        bean = new UserBean(23,"nam23");
        dataBinding.setUser123(bean);
    }
    public void click(View v){
        bean.setAge(new Random().nextInt(25));
        bean.setName("name" + bean.getAge());
        dataBinding.setUser123(bean);
    }

    public void click1(View v){
           int i = new Random().nextInt(25);
           bean = new UserBean(i,"name" + i);
           dataBinding.setUser123(bean);
           dataBinding.tvTest.setText("click1");
    }
}