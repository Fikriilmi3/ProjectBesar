package com.example.projectbesar.mental.gpph;

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

public class GPPH extends AppCompatActivity {

    int          counter,tidak,nosoal;
    String       umur, kategori, sstatus;
    TextView     nilaiya, nilaitidak, no_soal, namaanak, namaibu, status, saran, tvumur, tvkategori;
    ImageView ivpertanyaan, backButton;
    LinearLayout gpph, hasil;
    TextView     tvpertanyaan ;
    Button       btn0, btn1, btn2, btn3, btnlanjutkan;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpph2);

        gpph          = findViewById(R.id.gpphpertanyaan);
        hasil         = findViewById(R.id.gpphhasil);
        btn0          = findViewById(R.id.btn0);
        btn1          = findViewById(R.id.btn1);
        btn2          = findViewById(R.id.btn2);
        btn3          = findViewById(R.id.btn3);
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
        pDialog       = new ProgressDialog(GPPH.this);

        namaanak.setText(Preferences.getKeyNamaAnak(GPPH.this));
        namaibu.setText(Preferences.getKeyNamaIbu(GPPH.this));

        umur     = "11";
        kategori = "6";
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
                Intent i = new Intent(GPPH.this, GPPHActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nilaiya.setText("" + counter);
                nosoal++;
                no_soal.setText("" + nosoal);
                LoadPertanyaan(nosoal);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter + 1;
                nilaiya.setText("" + counter);
                nosoal++;
                no_soal.setText("" + nosoal);
                LoadPertanyaan(nosoal);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter + 2;
                nilaiya.setText("" + counter);
                nosoal++;
                no_soal.setText("" + nosoal);
                LoadPertanyaan(nosoal);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter + 3;
                nilaiya.setText("" + counter);
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

        RequestQueue queue = Volley.newRequestQueue(GPPH.this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ServerApi.URL_PERTANYAANGPPH + nosoal, null, new Response.Listener<JSONArray>() {
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
                            gpph.setVisibility(View.GONE);
                            if (counter >= 13){
                                sstatus = "S";
                                LoadHasil(sstatus);
                            } else if (counter < 13) {
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

        RequestQueue queue = Volley.newRequestQueue(GPPH.this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ServerApi.URL_HASILGPPH + sstatus, null, new Response.Listener<JSONArray>() {
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
                        AlertDialog.Builder builder = new AlertDialog.Builder(GPPH.this);
                        builder.setTitle("Simpan Data").
                                setMessage("Hasil Tes anda disimpan");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(GPPH.this, GPPHActivity.class);
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
                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(GPPH.this);
                        builder.setMessage("Terjadi kesalahan jaringan")
                                .setNegativeButton("Retry", null).create().show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("id_user", Preferences.getKeyId(GPPH.this));
                map.put("id_kategori", tvkategori.getText().toString().trim());
                map.put("id_umur", tvumur.getText().toString().trim());
                map.put("jumlah_ya", nilaiya.getText().toString().trim());
                map.put("jumlah_tidak", nilaitidak.getText().toString().trim());
                map.put("hasil", status.getText().toString().trim());
                map.put("saran",saran.getText().toString().trim());
                System.out.println(map);
                return map;
            }
        };
        queue.add(updateReq);
    }
}