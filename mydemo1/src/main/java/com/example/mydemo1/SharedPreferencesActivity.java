package com.example.mydemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText etInput;
    TextView tvDisplay;
    private String key = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        etInput = findViewById(R.id.et_input);
        tvDisplay = findViewById(R.id.tv_display);
        if(isTest()){
            Log.d("ddebug","istest true");
        }else {
            Log.d("ddebug","istest false");
        }
        Log.d("ddebug","=======");
    }
    public void get(View v){
        SharedPreferences spf= getPreferences(Context.MODE_PRIVATE);
        boolean contains = spf.contains("abc");
        Log.d("ddebug","contains = " + contains);
        boolean b = spf.getBoolean(key,false);//String option = spf.getString(resources.getString(R.string.FLIGHT_SORT_KEY),
        Log.d("ddebug","b = " + b);
        tvDisplay.setText(String.valueOf(b));
    }
    public boolean isTest(){
        SharedPreferences spf= getPreferences(Context.MODE_PRIVATE);
        boolean b = spf.getBoolean(key,false);
        return b;
    }
    public void put(View v){
        String str  = etInput.getText().toString();
        SharedPreferences spf= getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        boolean b;
        if(str.startsWith("t")){
            b = true;
        }else if(str.startsWith("f")){
            b = false;
        }else {
            throw new RuntimeException("输入不合法");
        }
        editor.putBoolean(key,b);
        editor.commit();
    }
}