package com.todolist.hinaikhan.mobiletodolist.ui.mvp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.todolist.hinaikhan.mobiletodolist.util.MainActivity;
import com.todolist.hinaikhan.mobiletodolist.R;
import com.todolist.hinaikhan.mobiletodolist.common.Constant;
import java.util.Timer;
import java.util.TimerTask;

/*
SplashActivity class shows splash screen
 */

/**
 * Created by hinaikhan on 7/17/17.
 */

public class SplashActivity extends AppCompatActivity{

    private static final String TAG = SplashActivity.class.getSimpleName();

    /**
     * onCreate method for splash screen
     * @param savedInstanceState save UI state changes
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.splashScreenTheme);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Intent splashIntent;
                splashIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splashIntent);
                //kill the current activity
                finish();
            }
        };
        //show splash screen for 2 seconds
        new Timer().schedule(task, Constant.SPLASH_DELAY);



    }


}
