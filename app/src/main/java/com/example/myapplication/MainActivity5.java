package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMain5Binding;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMain5Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_main5);
        binding.tv.setText("event Binding");
        binding.setAct(this);
        binding.setUser(new UserInfo2());
        binding.setStr("binding str");
    }
    public void click(View v){
        toast("click");
    }
    public void click2(){
        toast("click2");
    }
    public boolean longClick(){
        toast("longClick");
        return true;
    }
    private void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    public void showSign(View v,UserInfo info){
           String str ;
           if(v instanceof TextView){
               str = ((TextView)v).getText().toString();
           }else {
               str = v.toString();
           }
           toast("showSign --- " + str + " --- " + info.name);
    }
    public void showStr(View v,String info){
        String str ;
        if(v instanceof TextView){
            str = ((TextView)v).getText().toString();
        }else {
            str = v.toString();
        }
        toast("showSign --- " + str + " --- " + info);
    }
    public void showStr2(UserInfo2 info,String str){

        toast("showStr2 --- " + info.name + " --- " + str );
    }
}