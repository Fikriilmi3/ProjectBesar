package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.projectbesar.tentang.KontakActivity;
import com.example.projectbesar.tentang.LainActivity;
import com.example.projectbesar.tentang.PrivasiActivity;

public class TentangActivity extends AppCompatActivity {

    ImageView backButton, privasi, kontak, lain;
    private TextView aboutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        backButton= findViewById(R.id.backButton);
        privasi = findViewById(R.id.privasi);
        kontak = findViewById(R.id.kontak);
        lain = findViewById(R.id.lain);
//        aboutTextView = findViewById(R.id.aboutTextView);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TentangActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        privasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TentangActivity.this, PrivasiActivity.class);
                startActivity(i);
                finish();
            }
        });

        kontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TentangActivity.this, KontakActivity.class);
                startActivity(i);
                finish();
            }
        });

        lain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TentangActivity.this, LainActivity.class);
                startActivity(i);
                finish();
            }
        });

//        Spinner aboutSpinner = findViewById(R.id.aboutSpinner);
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.tentang_options, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        aboutSpinner.setAdapter(adapter);
//        aboutSpinner.setOnItemSelectedListener(this);
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String selectedItem = parent.getItemAtPosition(position).toString();
//        showAboutText(selectedItem);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Tidak ada yang dipilih
//    }
//
//    private void showAboutText(String selectedItem) {
//        String aboutText = "";
//
//        // Memperbarui teks yang ditampilkan berdasarkan item yang dipilih
//        if (selectedItem.equals("Tentang Aplikasi")) {
//            aboutText = "Ini adalah aplikasi yang dibuat untuk...";
//        } else if (selectedItem.equals("Kebijakan Privasi")) {
//            aboutText = "Kebijakan privasi kami adalah untuk meningakatkan kesehatan dan perkembangan anak";
//        } else if (selectedItem.equals("Kontak Kami")) {
//            aboutText = "No Whatsapp";
//        } else if (selectedItem.equals("Versi Aplikasi")) {
//            aboutText = "Versi 1.0";
//        } else if (selectedItem.equals("Pengembang")) {
//            aboutText = "www.example.com";
//        }
//
//        aboutTextView.setText(aboutText);
//    }
}