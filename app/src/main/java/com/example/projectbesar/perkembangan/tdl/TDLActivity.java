package com.example.projectbesar.perkembangan.tdl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.projectbesar.R;
import com.example.projectbesar.perkembangan.PerkembanganActivity;

public class TDLActivity extends AppCompatActivity {

    ImageView backButton;
    CardView  tdl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdl);

        tdl1       = findViewById(R.id.tdl1);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TDLActivity.this, PerkembanganActivity.class);
                startActivity(i);
                finish();
            }
        });

        tdl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TDLActivity.this, TDL.class);
                startActivity(i);
                finish();
            }
        });
    }
}