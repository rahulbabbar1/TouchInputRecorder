package com.sdsmdg.touchinputrecorder;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by rahul on 3/3/17.
 */
public class RecorderService extends Service implements View.OnTouchListener{
    private static final String TAG = RecorderService.class.getSimpleName();

    @Override
    public void onCreate(){
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                PixelFormat.TRANSLUCENT
        );

        View view = new View(this);
        view.setBackgroundColor(Color.argb(0,0,0,0));
        //view.setOnClickListener(this);
        view.setOnTouchListener(this);

        windowManager.addView(view,layoutParams);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    @Override
//    public void onClick(View view) {
//        Log.d(TAG, "onClick() called with: view = [" + view + "]");
//    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d(TAG, "onTouch() called with: view = [" + view + "], motionEvent = [" + motionEvent + "]");
        return true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}
