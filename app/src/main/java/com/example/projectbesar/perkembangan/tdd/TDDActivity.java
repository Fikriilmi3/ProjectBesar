package com.example.projectbesar.perkembangan.tdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.R;
import com.example.projectbesar.perkembangan.PerkembanganActivity;

public class TDDActivity extends AppCompatActivity {

    ImageView backButton;
    CardView  tdd1, tdd2, tdd3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdd);

        tdd1       = findViewById(R.id.tdd1);
        tdd2       = findViewById(R.id.tdd2);
        tdd3       = findViewById(R.id.tdd3);
        backButton = findViewById(R.id.backButton);

        tdd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TDDActivity.this, TDD1.class);
                startActivity(i);
                finish();
            }
        });

        tdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TDDActivity.this, TDD2.class);
                startActivity(i);
                finish();
            }
        });

        tdd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TDDActivity.this, TDD3.class);
                startActivity(i);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TDDActivity.this, PerkembanganActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}