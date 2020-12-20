package com.example.mydemo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class PopupWindowActivity extends AppCompatActivity {
    Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog2);
        button1 = findViewById(R.id.bnt_1);
        button2 = findViewById(R.id.bnt_2);
        button3 = findViewById(R.id.bnt_3);
    }

    public void click(View v){
        popu(button1);
    }
    public void click2(View v){
        popu(button2);
    }
    public void click3(View v){
        popu(button3);
    }
    void popu(View baseView){
        int[] array = new int[2];
        baseView.getLocationOnScreen(array);

        Log.d("ddebug",((Button)(baseView)).getText().toString());
        View view = View.inflate(this,R.layout.layout_dialog,null);
        View layout = view.findViewById(R.id.layout);
        Button dialogBt1 = view.findViewById(R.id.bnt_dialog_button);
        final PopupWindow popupWindow = new PopupWindow(view,getDisplay().getWidth()*2,getDisplay().getHeight()*2);
        popupWindow.setOutsideTouchable(true);//设置点击外部区域可以取消popupWindow


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        dialogBt1.post(new Runnable() {
            @Override
            public void run() {

                Log.d("ddebug","dialogBt1.post");
                int[] a = new int[2];
                dialogBt1.getLocationOnScreen(a);
                Log.d("ddebug","array = " + Arrays.toString(array) + "---- a = "+ Arrays.toString(a));
                layout.setTranslationX(array[0] - a[0]);//Math.abs(array[0] - a[0])

                layout.setTranslationY(array[1] - a[1]);
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
        popupWindow.showAtLocation(baseView,Gravity.TOP|Gravity.LEFT,0,0);
        backgroundAlpha(0.5f);
        Log.d("ddebug","popupWindow.showAtLocation");
    }

    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }


}