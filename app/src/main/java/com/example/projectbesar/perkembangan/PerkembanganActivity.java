package com.example.projectbesar.perkembangan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.MainActivity;
import com.example.projectbesar.R;
import com.example.projectbesar.perkembangan.kpsp.KPSPActivity;
import com.example.projectbesar.perkembangan.tdd.TDDActivity;
import com.example.projectbesar.perkembangan.tdl.TDLActivity;

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