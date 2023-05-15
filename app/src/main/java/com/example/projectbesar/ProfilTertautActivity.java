package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projectbesar.perkembangan.KPSPActivity;
import com.example.projectbesar.perkembangan.PerkembanganActivity;

public class ProfilTertautActivity extends AppCompatActivity {

    ImageView backButton, btn_profilanak;
    Button btn_tambahanggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_tertaut);

        backButton= findViewById(R.id.backButton);
        btn_profilanak = findViewById(R.id.btn_profilanak);
        btn_tambahanggota = findViewById(R.id.btn_tambahanggota);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilTertautActivity.this, ProfileFragment.class);
                startActivity(i);
                finish();
            }
        });

        btn_profilanak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilTertautActivity.this, ProfilAnakActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn_tambahanggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilTertautActivity.this, TambahAnggotaActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}