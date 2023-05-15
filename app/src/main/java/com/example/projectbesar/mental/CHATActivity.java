package com.example.projectbesar.mental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projectbesar.R;
import com.example.projectbesar.perkembangan.KPSPActivity;
import com.example.projectbesar.perkembangan.PerkembanganActivity;

public class CHATActivity extends AppCompatActivity {

    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        backButton= findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CHATActivity.this, MentalActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}