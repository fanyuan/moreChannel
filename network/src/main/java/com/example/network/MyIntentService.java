package com.example.network;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class MyIntentService extends IntentService {


    /**
     * 必须要写一个无参数的构造函数，然后调用父类的 super("MyIntentService");
     * 其中MyIntentService就是执行onHandleIntent对应的线程的名字
     * */
    public MyIntentService() {
        super("MyIntentService");
    }




    /**
     * onHandleIntent函数是在子线程中去执行处理的，所以这里就没有必要去开启线程
     * */

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("123456","onHandleIntent is called");
        /**
         * 模拟耗时操作
         * */
        SystemClock.sleep(10000);
        Log.d("123456","onHandleIntent is out");
    }

    /**
     * onHandleIntent函数中的耗时任务执行完成后，服务会自动销毁
     * 调用onDestroy函数
     *
     * */

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("123456","onDestroy is called");
    }
}