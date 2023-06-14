package com.example.projectbesar.mental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.MainActivity;
import com.example.projectbesar.R;
import com.example.projectbesar.mental.chat.CHATActivity;
import com.example.projectbesar.mental.gpph.GPPHActivity;
import com.example.projectbesar.mental.kmme.KMMEActivity;

public class MentalActivity extends AppCompatActivity {

    ImageView backButton;
    CardView card_kmme, card_chat, card_gpph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental);

        backButton= findViewById(R.id.backButton);
        card_kmme = findViewById(R.id.card_kmme);
        card_chat= findViewById(R.id.card_chat);
        card_gpph = findViewById(R.id.card_gpph);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MentalActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        card_kmme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MentalActivity.this, KMMEActivity.class);
                startActivity(i);
                finish();
            }
        });

        card_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MentalActivity.this, CHATActivity.class);
                startActivity(i);
                finish();
            }
        });

        card_gpph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MentalActivity.this, GPPHActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}