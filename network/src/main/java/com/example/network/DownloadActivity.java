package com.example.network;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.File;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DownloadActivity extends AppCompatActivity {
    Retrofit retrofit2 = new Retrofit.Builder().baseUrl("http://dev-play.gxhuancai.com/").addConverterFactory(GsonConverterFactory.create()).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
    }
    public void click(View v){
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tmp";//getExternalFilesDir(null).getAbsolutePath();////Environment.getDownloadCacheDirectory().getAbsolutePath() + File.separator + "tmp";
        Log.d("ddebug","path =" + path);
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        //downLoad();
        int num = 0;
        Intent workIntent = new Intent();
        num++;
        //workIntent.putExtra("work","work num:"+num);
        String url = "http://baize-real.oss-cn-shanghai.aliyuncs.com/apk/app-release.apk";
        workIntent.putExtra(MyJobIntentService.WORK_URL,url);
        MyJobIntentService.ProgressNotifyCallback callBack = new MyJobIntentService.ProgressNotifyCallback() {
            int myProgress;
            @Override
            public boolean isNeedNotify() {
                boolean isNeedNotify = !(myProgress > 30 && myProgress <55);
                Log.d("ddebug",myProgress + "---ProgressNotifyCallback isNeedNotify --- " + isNeedNotify);
                return isNeedNotify;
            }

            @Override
            public void progressNotify(int progress) {
                myProgress = progress;
                Log.d("ddebug","ProgressNotifyCallback --- " + progress);
            }

            @Override
            public void finish() {
                Log.d("ddebug","ProgressNotifyCallback --- 工作已完成");
            }
        };
        MyJobIntentService.enqueueWork(getApplicationContext(),workIntent,callBack);
    }

    private void downLoad() {
        String url = "http://baize-real.oss-cn-shanghai.aliyuncs.com/apk/app-release.apk";
        VersionService versionService = retrofit2.create(VersionService.class);
        Call<ResponseBody> call = versionService.downLoad(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("ddebug","onResponse --- " + response + " --- " + response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("ddebug","onFailure --- " + t.toString());
            }
        });

    }
}