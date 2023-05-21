package com.example.projectbesar.cancel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.projectbesar.R;

public class TambahAnggotaActivity extends AppCompatActivity {

    ImageView backButton;
    Button btn_simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_anggota);

        backButton= findViewById(R.id.backButton);
        btn_simpan= findViewById(R.id.btn_simpan);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TambahAnggotaActivity.this, ProfilTertautActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}