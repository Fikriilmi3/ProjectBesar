package com.example.projectbesar.perkembangan.pertanyaan.kpsp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectbesar.R;
import com.example.projectbesar.utils.Preferences;
import com.example.projectbesar.utils.ServerApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KPSP24 extends AppCompatActivity {

    int counter,tidak,nosoal;
    TextView     nilaiya, nilaitidak, no_soal, namaanak, namaibu, status, saran;
    LinearLayout kpsp2401, hasil;
    TextView     tvpertanyaan ;
    Button       btnya, btntidak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpsp24);

        kpsp2401      = findViewById(R.id.kpsp24pertanyaan);
        hasil         = findViewById(R.id.kpsp24hasil);
        btnya         = findViewById(R.id.btnya);
        btntidak      = findViewById(R.id.btntidak);
        tvpertanyaan  = findViewById(R.id.tvpertanyaan);
        nilaiya       = findViewById(R.id.ya);
        nilaitidak    = findViewById(R.id.tidak);
        no_soal       = findViewById(R.id.no_soal);
        namaanak      = findViewById(R.id.tvnamaanak);
        namaibu       = findViewById(R.id.tvnamaibu);
        status        = findViewById(R.id.tvstatus);
        saran         = findViewById(R.id.tvsaran);

        namaanak.setText(Preferences.getKeyNamaAnak(KPSP24.this));
        namaibu.setText(Preferences.getKeyNamaIbu(KPSP24.this));


        nosoal = 1;
        nilaiya.setText("" + counter);
        nilaitidak.setText("" + tidak);
        no_soal.setText("" + nosoal);
        LoadPertanyaan(nosoal);

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
    }

    private void LoadPertanyaan(int nosoal){
        final ProgressDialog progressDialog = new ProgressDialog(KPSP24.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        RequestQueue queue = Volley.newRequestQueue(KPSP24.this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ServerApi.URL_PERTANYAANKPSP24 + nosoal, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++){
                    progressDialog.cancel();
                    try {
                        JSONObject soal = response.getJSONObject(i);

                        String strsoal   = soal.getString("soal");
                        String strjumlah = soal.getString("jumlah");

                        if (strjumlah.equals("0")){
                            hasil.setVisibility(View.VISIBLE);
                            kpsp2401.setVisibility(View.GONE);
                        }else {
                            tvpertanyaan.setText(strsoal);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                error.printStackTrace();
            }
        });
        queue.add(request);
    }

    private void LoadHasil(String status){
        final ProgressDialog progressDialog = new ProgressDialog(KPSP24.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        RequestQueue queue = Volley.newRequestQueue(KPSP24.this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, ServerApi.URL_PERTANYAANKPSP24 + nosoal, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++){
                    progressDialog.cancel();
                    try {
                        JSONObject soal = response.getJSONObject(i);

                        String strsoal   = soal.getString("soal");
                        String strjumlah = soal.getString("jumlah");

                        if (strjumlah.equals("0")){
                            hasil.setVisibility(View.VISIBLE);
                            kpsp2401.setVisibility(View.GONE);
                        }else {
                            tvpertanyaan.setText(strsoal);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                error.printStackTrace();
            }
        });
        queue.add(request);
    }
}