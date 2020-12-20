package com.example.network;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyJobIntentService extends JobIntentService {
    public static final String WORK_URL = "work_url";
    /**
     * 这个Service 唯一的id
     */
    static final int JOB_ID = 10111;
    private static final String TAG = "ddebug";

    private static ProgressNotifyCallback callback;

    static void enqueueWork(Context context, Intent work) {
        Log.d("ddebug","enqueueWork --- " +  Thread.currentThread().getName());
        enqueueWork(context, MyJobIntentService.class, JOB_ID, work);

    }
    /**
     * Convenience method for enqueuing work in to this service.
     */
    static void enqueueWork(Context context, Intent work,ProgressNotifyCallback notifyCallback) {
        Log.d("ddebug","enqueueWork --- " +  Thread.currentThread().getName());
        callback = notifyCallback;
        enqueueWork(context, MyJobIntentService.class, JOB_ID, work);


    }
    Retrofit retrofit2 = new Retrofit.Builder().baseUrl("http://dev-play.gxhuancai.com/").addConverterFactory(GsonConverterFactory.create()).build();
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        String url = intent.getStringExtra(WORK_URL);
        Log.d("ddebug","123456abc url = " + url);

        VersionService versionService = retrofit2.create(VersionService.class);
        Call<ResponseBody> call = versionService.downLoad(url);
        try {
            Response<ResponseBody> response = call.execute();

            String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tmp";//getExternalFilesDir(null).getAbsolutePath();////Environment.getDownloadCacheDirectory().getAbsolutePath() + File.separator + "tmp";
            File file = new File(path);
            if(!file.exists()){
                boolean b = file.mkdirs();
            }

            String apkPath = path + File.separator + "test123.apk";
            writeResponseBodyToDisk(response.body(),apkPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private boolean writeResponseBodyToDisk(ResponseBody body,String path) {

        Log.d("test","0writeResponseBodyToDisk --- path---" + path);
        try {
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(path);//new File(getExternalFilesDir(null) + File.separator + "Future Studio Icon.png");
            Log.d("test","1writeResponseBodyToDisk --- path---" + futureStudioIconFile.getAbsolutePath());
            InputStream inputStream = null;
            OutputStream outputStream = null;



            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                int currentProgress = 0;
                Double totalSize = Double.valueOf(Long.toString(fileSize));
                Double currentSize = 0d;


                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    currentSize = Double.valueOf(Long.toString(fileSizeDownloaded));
//                    double d2 = Double.valueOf(Long.toString(fileSize));
                    int progress = (int) ((currentSize/totalSize)*100);
                    if(currentProgress != progress){
                        currentProgress = progress;
                        if(callback != null ){//&& callback.isNeedNotify()
                            callback.progressNotify(progress);
                        }
                    }
                    if(fileSizeDownloaded == fileSize){
                        if(callback !=null){
                            callback.finish();
                        }
                    }
                    //Log.d(TAG, "file download: " + fileSizeDownloaded + " of " + fileSize + "---" +progress);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 下载进度通知回调
     */
    public interface ProgressNotifyCallback{
        boolean isNeedNotify();

        /**
         * 下载进度通知
         * @param progress
         */
        void progressNotify(int progress);

        /**
         * 工作已完成
         */
        void finish();
    }

}
