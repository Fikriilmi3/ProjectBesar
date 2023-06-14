package com.example.projectbesar.perkembangan.tdd;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectbesar.R;
import com.example.projectbesar.utils.Preferences;
import com.example.projectbesar.utils.ServerApi;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TDD2 extends AppCompatActivity {

    int          counter,tidak,nosoal;
    String       umur, kategori, sstatus;
    TextView     nilaiya, nilaitidak, no_soal, namaanak, namaibu, status, saran, tvumur, tvkategori;
    ImageView ivpertanyaan, backButton;
    LinearLayout tdd, hasil;
    TextView     tvpertanyaan ;
    Button       btnya, btntidak, btnlanjutkan;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdd2);

        tdd           = findViewById(R.id.tddpertanyaan);
        hasil         = findViewById(R.id.tddhasil);
        btnya         = findViewById(R.id.btnya);
        btntidak      = findViewById(R.id.btntidak);
        btnlanjutkan  = findViewById(R.id.btnlanjutkan);
        tvpertanyaan  = findViewById(R.id.tvpertanyaan);
        nilaiya       = findViewById(R.id.ya);
        nilaitidak    = findViewById(R.id.tidak);
        no_soal       = findViewById(R.id.no_soal);
        namaanak      = findViewById(R.id.tvnamaanak);
        namaibu       = findViewById(R.id.tvnamaibu);
        status        = findViewById(R.id.tvstatus);
        saran         = findViewById(R.id.tvsaran);
        tvumur        = findViewById(R.id.tvumur);
        tvkategori    = findViewById(R.id.tvkategori);
        ivpertanyaan  = findViewById(R.id.ivpertanyaan);
        backButton    = findViewById(R.id.backButton);
        pDialog       = new ProgressDialog(TDD2.this);

        namaanak.setText(Preferences.getKeyNamaAnak(TDD2.this));
        namaibu.setText(Preferences.getKeyNamaIbu(TDD2.this));

        umur     = "7";
        kategori = "2";
        nosoal   = 1;

        nilaiya.setText("" + counter);
        nilaitidak.setText("" + tidak);
        no_soal.setText("" + nosoal);

        tvkategori.setText(kategori);
        tvumur.setText(umur);

        LoadPertanyaan(nosoal);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TDD2.this, TDDActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                nilaiya.setText("" + counter);
                nosoal++;
                no_soal.setText("" + nosoal);
                LoadPertanyaan(nosoal);
            }
        });

        btntidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tidak++;
                nilaitidak.setText("" + tidak);
                nosoal++;
                no_soal.setText("" + nosoal);
                LoadPertanyaan(nosoal);
            }
        });

        btnlanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SImpanHasil();
            }
        });
    }

    private void LoadPertanyaan(int nosoal){
        pDialog.setMessage("Loading...");
        pDialog.show();

        RequestQueue queue = Volley.newRequestQueue(TDD2.this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ServerApi.URL_PERTANYAANTDD2 + nosoal, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++){
                    pDialog.cancel();
                    try {
                        JSONObject soal = response.getJSONObject(i);

                        String strsoal     = soal.getString("soal");
                        String strjumlah   = soal.getString("jumlah");
                        String strgambar   = soal.getString("gambar");

                        if (strjumlah.equals("0")){
                            hasil.setVisibility(View.VISIBLE);
                            tdd.setVisibility(View.GONE);
                            if (counter >= 3){
                                sstatus = "S";
                                LoadHasil(sstatus);
                            } else if (counter < 1) {
                                sstatus = "P";
                                LoadHasil(sstatus);
                            } else {
                                sstatus = "M";
                                LoadHasil(sstatus);
                            }
                        }else {
                            tvpertanyaan.setText(strsoal);
                            if (strgambar.isEmpty()){
                                ivpertanyaan.setVisibility(View.GONE);
                            } else {
                                Picasso.get()
                                        .load(strgambar)
                                         .fit()
                                         .error(R.drawable.ic_launcher_background)
                                        .into(ivpertanyaan);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.cancel();
                error.printStackTrace();
            }
        });
        queue.add(request);
    }

    private void LoadHasil(String sstatus){
        pDialog.setMessage("Loading...");
        pDialog.show();

        RequestQueue queue = Volley.newRequestQueue(TDD2.this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ServerApi.URL_HASILTDD + sstatus, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++){
                    pDialog.cancel();
                    try {
                        JSONObject soal = response.getJSONObject(i);

                        String strstatus  = soal.getString("status");
                        String strsaran   = soal.getString("saran");

                        status.setText(strstatus);
                        saran.setText(strsaran);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.cancel();
                error.printStackTrace();
            }
        });
        queue.add(request);
    }

    private void SImpanHasil(){
        pDialog.setMessage("Menyimpan Hasil");
        pDialog.setCancelable(false);
        pDialog.show();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest updateReq = new StringRequest(Request.Method.POST, ServerApi.URL_SIMPAN_HASIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pDialog.cancel();
                        AlertDialog.Builder builder = new AlertDialog.Builder(TDD2.this);
                        builder.setTitle("Simpan Data").
                                setMessage("Hasil Tes anda disimpan");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent intent = new Intent(TDD2.this, TDDActivity.class);
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
                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(TDD2.this);
                        builder.setMessage("Terjadi kesalahan jaringan")
                                .setNegativeButton("Retry", null).create().show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("id_user", Preferences.getKeyId(TDD2.this));
                map.put("id_kategori", tvkategori.getText().toString());
                map.put("id_umur", tvumur.getText().toString());
                map.put("jumlah_ya", nilaiya.getText().toString());
                map.put("jumlah_tidak", nilaitidak.getText().toString());
                map.put("hasil", status.getText().toString());
                map.put("saran",saran.getText().toString());
                System.out.println(map);
                return map;
            }
        };
        queue.add(updateReq);
    }
}