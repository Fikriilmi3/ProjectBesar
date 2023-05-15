package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projectbesar.perkembangan.KPSPActivity;
import com.example.projectbesar.perkembangan.PerkembanganActivity;

public class UbahAkunActivity extends AppCompatActivity {

    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_akun);

        backButton= findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UbahAkunActivity.this, ProfileFragment.class);
                startActivity(i);
                finish();
            }
        });
    }
}