package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectbesar.utils.Preferences;
import com.example.projectbesar.utils.ServerApi;

import java.util.HashMap;
import java.util.Map;

public class UbahAkunActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private EditText username, nama_anak, jenis_kelamin, tempat_lahir, tgl_lahir, nama_ibu, telepone, password, id_pengguna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_akun);

        id_pengguna   = findViewById(R.id.id_pengguna);
        username      = findViewById(R.id.username);
        nama_anak     = findViewById(R.id.nama_anak);
        jenis_kelamin = findViewById(R.id.jenis_kelamin);
        tempat_lahir  = findViewById(R.id.tempat_lahir);
        tgl_lahir     = findViewById(R.id.tgl_lahir);
        nama_ibu      = findViewById(R.id.nama_ibu);
        telepone      = findViewById(R.id.telepone);
        password      = findViewById(R.id.password);
        pDialog       = new ProgressDialog(UbahAkunActivity.this);

        id_pengguna.setText(Preferences.getKeyId(UbahAkunActivity.this));
        username.setText(Preferences.getKeyUsername(UbahAkunActivity.this));
        nama_anak.setText(Preferences.getKeyNamaAnak(UbahAkunActivity.this));
        jenis_kelamin.setText(Preferences.getKeyJenisKelamin(UbahAkunActivity.this));
        tempat_lahir.setText(Preferences.getKeyTempatLahir(UbahAkunActivity.this));
        tgl_lahir.setText(Preferences.getKeyTglLahir(UbahAkunActivity.this));
        nama_ibu.setText(Preferences.getKeyNamaIbu(UbahAkunActivity.this));
        telepone.setText(Preferences.getKeyTelepone(UbahAkunActivity.this));

        ImageView backButton= findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UbahAkunActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(view -> {
            if (validateInputs()) {
                UpdateAkun();
            }
        });
    }

    private boolean validateInputs() {
        if (username.getText().toString().equals("")) {
            username.setError("Isi dulu Username");
            username.requestFocus();
            return false;
        }
        if (password.getText().toString().equals("")) {
            password.setError("Isi dulu Password");
            password.requestFocus();
            return false;
        }
        return true;
    }

    private void UpdateAkun() {
        pDialog.setMessage("Menyimpan Data");
        pDialog.setCancelable(false);
        pDialog.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest updateReq = new StringRequest(Request.Method.POST, ServerApi.URL_EDIT_AKUN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pDialog.cancel();
                        AlertDialog.Builder builder = new AlertDialog.Builder(UbahAkunActivity.this);
                        builder.setTitle("Update Profile").
                                setMessage("Profile anda berhasil diupdate");
                        builder.setPositiveButton("Login Ulang",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Preferences.clearLoggedInUser(UbahAkunActivity.this);
                                        Intent intent = new Intent(UbahAkunActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                        AlertDialog alert11 = builder.create();
                        alert11.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.cancel();
                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(UbahAkunActivity.this);
                        builder.setMessage("Terjadi kesalahan jaringan")
                                .setNegativeButton("Retry", null).create().show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("id", id_pengguna.getText().toString());
                map.put("username", username.getText().toString());
                map.put("nama_anak", nama_anak.getText().toString());
                map.put("jenis_kelamin", jenis_kelamin.getText().toString());
                map.put("tempat_lahir", tempat_lahir.getText().toString());
                map.put("tgl_lahir", tgl_lahir.getText().toString());
                map.put("nama_ibu", nama_ibu.getText().toString());
                map.put("telepone",telepone.getText().toString());
                map.put("password", password.getText().toString());
                System.out.println(map);
                return map;
            }
        };
        queue.add(updateReq);
    }

}