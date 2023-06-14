package com.example.projectbesar.perkembangan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projectbesar.R;
import com.example.projectbesar.perkembangan.pertanyaan.kpsp.KPSP24;

public class KPSPActivity extends AppCompatActivity {

    ImageView backButton;
    CardView kpsp24, kpsp30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp);

        kpsp24 = findViewById(R.id.kpsp24bulan);
        kpsp30 = findViewById(R.id.kpsp30bulan);
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
    }
}