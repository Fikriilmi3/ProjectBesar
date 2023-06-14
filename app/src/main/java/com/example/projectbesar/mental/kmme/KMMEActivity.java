package com.example.projectbesar.mental.kmme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.R;
import com.example.projectbesar.mental.MentalActivity;

public class KMMEActivity extends AppCompatActivity {

    ImageView backButton;
    CardView  kmme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmme);

        backButton = findViewById(R.id.backButton);
        kmme       = findViewById(R.id.kmme);

        kmme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KMMEActivity.this, KMME.class);
                startActivity(i);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KMMEActivity.this, MentalActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}