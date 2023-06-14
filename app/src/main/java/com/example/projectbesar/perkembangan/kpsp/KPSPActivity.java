package com.example.projectbesar.perkembangan.kpsp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.R;
import com.example.projectbesar.perkembangan.PerkembanganActivity;

public class KPSPActivity extends AppCompatActivity {

    ImageView backButton;
    CardView kpsp24, kpsp30, kpsp36, kpsp42, kpsp48;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp);

        kpsp24 = findViewById(R.id.kpsp24bulan);
        kpsp30 = findViewById(R.id.kpsp30bulan);
        kpsp36 = findViewById(R.id.kpsp36bulan);
        kpsp42 = findViewById(R.id.kpsp42bulan);
        kpsp48 = findViewById(R.id.kpsp48bulan);
        backButton= findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KPSPActivity.this, PerkembanganActivity.class);
                startActivity(i);
                finish();
            }
        });

        kpsp24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KPSPActivity.this, KPSP24.class);
                startActivity(i);
                finish();
            }
        });

        kpsp30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KPSPActivity.this, KPSP30.class);
                startActivity(i);
                finish();
            }
        });

        kpsp36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KPSPActivity.this, KPSP36.class);
                startActivity(i);
                finish();
            }
        });

        kpsp42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KPSPActivity.this, KPSP42.class);
                startActivity(i);
                finish();
            }
        });

        kpsp48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(KPSPActivity.this, KPSP48.class);
                startActivity(i);
                finish();
            }
        });
    }
}