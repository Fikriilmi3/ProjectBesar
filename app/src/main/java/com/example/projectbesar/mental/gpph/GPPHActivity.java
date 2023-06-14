package com.example.projectbesar.mental.gpph;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.R;
import com.example.projectbesar.mental.MentalActivity;

public class GPPHActivity extends AppCompatActivity {

    ImageView backButton;
    CardView  gpph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpph);

        backButton = findViewById(R.id.backButton);
        gpph       = findViewById(R.id.gpph);

        gpph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GPPHActivity.this, GPPH.class);
                startActivity(i);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GPPHActivity.this, MentalActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}