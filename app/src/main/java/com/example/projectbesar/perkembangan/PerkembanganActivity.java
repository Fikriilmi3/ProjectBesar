package com.example.projectbesar.perkembangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectbesar.LoginActivity;
import com.example.projectbesar.MainActivity;
import com.example.projectbesar.R;
import com.example.projectbesar.RegisterActivity;

public class PerkembanganActivity extends AppCompatActivity {

    ImageView backButton;
    CardView card_kpsp, card_tdd, card_tdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perkembangan);

        backButton= findViewById(R.id.backButton);
        card_kpsp = findViewById(R.id.card_kpsp);
        card_tdd= findViewById(R.id.card_tdd);
        card_tdl = findViewById(R.id.card_tdl);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PerkembanganActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        card_kpsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PerkembanganActivity.this, KPSPActivity.class);
                startActivity(i);
                finish();
            }
        });

        card_tdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PerkembanganActivity.this, TDDActivity.class);
                startActivity(i);
                finish();
            }
        });

        card_tdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PerkembanganActivity.this, TDLActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}