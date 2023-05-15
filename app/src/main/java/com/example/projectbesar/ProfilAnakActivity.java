package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projectbesar.perkembangan.KPSPActivity;
import com.example.projectbesar.perkembangan.PerkembanganActivity;

public class ProfilAnakActivity extends AppCompatActivity {

    ImageView backButton;
    Button btn_simpan, btn_hapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_anak);

        backButton= findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfilAnakActivity.this, ProfilTertautActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}