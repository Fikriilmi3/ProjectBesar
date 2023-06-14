package com.example.projectbesar.tentang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectbesar.R;
import com.example.projectbesar.TentangActivity;

public class PrivasiActivity extends AppCompatActivity {

    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privasi);

        backButton= findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrivasiActivity.this, TentangActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}