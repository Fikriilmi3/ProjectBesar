package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.projectbesar.utils.Preferences;

public class Splashscreen extends AppCompatActivity {

    public static int SPLASH_TIMER = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        String Id = Preferences.getKeyId(Splashscreen.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Id.isEmpty()) {
                    Intent intent = new Intent(Splashscreen.this, GetStarted.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, SPLASH_TIMER);
    }
}