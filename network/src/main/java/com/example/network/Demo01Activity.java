package com.example.network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class Demo01Activity extends AppCompatActivity {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.douban.com/v2/").build();
    Retrofit retrofit2 = new Retrofit.Builder().baseUrl("http://dev-play.gxhuancai.com/").addConverterFactory(GsonConverterFactory.create()).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo01);
    }
    public void click01(View v){
        BookService bookService = retrofit.create(BookService.class);
        Call<ResponseBody> call = bookService.getBook(1220562);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                //+ response.body().toString()
                Log.d("ddebug","onResponse --- " + response + " --- " + response.body());

                Log.d("ddebug","onResponse --- " + response.message() + "---" + response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("ddebug","onFailure --- " + t.toString());
            }
        });
    }
    int num = 0;
    public void click02(View v){
        Intent workIntent = new Intent();
        num++;
        Log.d("ddebug", "onClick: "+num + " --- " + Thread.currentThread().getName());
        workIntent.putExtra("work","work num:"+num);
        MyJobIntentService.enqueueWork(getApplicationContext(),workIntent);
    }
    public void click03(View v){
        VersionService versionService = retrofit2.create(VersionService.class);
        Call<VersionResult<VersionBean>> call = versionService.getVersionResult();
        call.enqueue(new Callback<VersionResult<VersionBean>>() {
            @Override
            public void onResponse(Call<VersionResult<VersionBean>> call, Response<VersionResult<VersionBean>> response) {
                VersionResult<VersionBean> versionResult = response.body();
                VersionBean bean = versionResult.data;
                Log.d("ddebug","versionResult.errCode = " + versionResult.errCode+ "---versionResult.errMsg=" + versionResult.errMsg );
                Log.d("ddebug","getDownloadUrl = " + bean.getDownloadUrl() );

            }

            @Override
            public void onFailure(Call<VersionResult<VersionBean>> call, Throwable t) {
                Log.d("ddebug","click03 onFailure --- " + t.toString());
            }
        });
    }

    void test(){
        VersionService versionService = retrofit2.create(VersionService.class);
        Call<ResponseBody> call = versionService.getVersion();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                //+ response.body().toString()
                try {
                    Log.d("ddebug","click03 onResponse --- " + response + " --- " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Log.d("ddebug","click03 onResponse --- " + response.message() + "---" );
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("ddebug","click03 onFailure --- " + t.toString());
            }
        });
    }
}