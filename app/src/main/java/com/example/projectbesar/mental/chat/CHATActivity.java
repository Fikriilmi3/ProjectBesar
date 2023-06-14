package com.example.projectbesar.mental.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.R;
import com.example.projectbesar.mental.MentalActivity;

public class CHATActivity extends AppCompatActivity {

    ImageView backButton;
    CardView chata, chatb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        backButton = findViewById(R.id.backButton);
        chata      = findViewById(R.id.chata);
        chatb      = findViewById(R.id.chatb);

        chata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CHATActivity.this, CHATALO.class);
                startActivity(i);
                finish();
            }
        });

        chatb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CHATActivity.this, CHATPENG.class);
                startActivity(i);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CHATActivity.this, MentalActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}