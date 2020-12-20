package com.example.mydemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class ProgressActivity extends AppCompatActivity {
    private static final String TAG = "ddebug";
    View move;
    ProgressBar progressBar;
    ProgressBar progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        move = findViewById(R.id.move);
        progressBar = findViewById(R.id.progress_01);
        progressBar2 = findViewById(R.id.progress_02);
    }
    int i = 5;
    public void move(View v){
        progressBar.setProgress(i);
        progressBar.setSecondaryProgress(i + 12);
        progressBar2.setProgress(i);
        updateLocation(i,progressBar,move);

        i += 5;
        Log.d("ddebug","i = " + i);
    }

    /**
     * 根据进度条更新位置
     * @param progress
     * @param progressBar
     * @param move
     */
    private void updateLocation(int progress, ProgressBar progressBar, View move) {
        //move.setTranslationX(i);
        float scale = (float)progress/progressBar.getMax();
        Log.d(TAG, "updateLocation: w = "+ scale);
        int totalWidth = progressBar.getWidth();
        int targetX = (int) (scale * totalWidth);
        Log.d(TAG, "updateLocation: targetX = "+ targetX + "---totalWidth =" + totalWidth);
        int[] progressLocation = new int[2];
        progressBar.getLocationOnScreen(progressLocation);
        Log.d(TAG, "000: progressLocation[0] = "+ progressLocation[0]);
        progressLocation[0] += targetX;
        Log.d(TAG, "111: progressLocation[0] = "+ progressLocation[0]);
        int[] moveLocation = new int[2];
        move.getLocationOnScreen(moveLocation);
        int d = progressLocation[0] - moveLocation[0];
        d = d - move.getWidth()/2;
        //move.setTranslationX(progressLocation[0] - moveLocation[0]);
        move.layout(move.getLeft()+d,move.getTop(),move.getRight() + d,move.getBottom());
    }
}