package com.example.projectbesar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectbesar.adapter.AdapterRiwayat;
import com.example.projectbesar.models.ModelRiwayat;
import com.example.projectbesar.utils.Preferences;
import com.example.projectbesar.utils.ServerApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RiwayatKeseluruhan extends AppCompatActivity {

    ImageView backButton;
    SwipeRefreshLayout refreshLayout;
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelRiwayat> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_keseluruhan);
        backButton    = findViewById(R.id.backButton);
        refreshLayout = findViewById(R.id.swiperefresh);

        mRecyclerview = findViewById(R.id.recyclerviewriwayat);
        mItems        = new ArrayList<>();

        mManager      = new LinearLayoutManager(RiwayatKeseluruhan.this,LinearLayoutManager.VERTICAL,false);
        mAdapter      = new AdapterRiwayat(RiwayatKeseluruhan.this,mItems);

        mRecyclerview.setLayoutManager(mManager);
        mRecyclerview.setAdapter(mAdapter);

        loadRiwayat(true);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadRiwayat(false);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RiwayatKeseluruhan.this, RiwayatActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void loadRiwayat(boolean showProgressDialog) {
        final ProgressDialog progressDialog = new ProgressDialog(RiwayatKeseluruhan.this);
        progressDialog.setMessage("Memuat...");
        progressDialog.show();
        if (showProgressDialog) progressDialog.show();
        else progressDialog.cancel();

        RequestQueue queue = Volley.newRequestQueue(RiwayatKeseluruhan.this);
        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.GET, ServerApi.URL_RIWAYATALL +  Preferences.getKeyId(RiwayatKeseluruhan.this),null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (showProgressDialog) progressDialog.cancel();
                        else refreshLayout.setRefreshing(false);
                        mItems.clear();
                        for(int i = 0 ; i < response.length(); i++)
                        {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelRiwayat md = new ModelRiwayat();
                                md.setId_user(data.getString("id_user"));
                                md.setId_kategori(data.getString("id_kategori"));
                                md.setId_umur(data.getString("id_umur"));
                                md.setJumlah_ya(data.getString("jumlah_ya"));
                                md.setJumlah_tidak(data.getString("jumlah_tidak"));
                                md.setHasil(data.getString("hasil"));
                                md.setSaran(data.getString("saran"));
                                md.setNama_kategori(data.getString("nama_kategori"));
                                md.setUmur(data.getString("umur"));
                                mItems.add(md);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                AlertDialog.Builder builder = new AlertDialog.Builder(RiwayatKeseluruhan.this);
                                builder.setTitle("Kesalahan Memuat").
                                        setMessage("Terdapat Kesalahan saat memuat data");
                                builder.setPositiveButton("OK",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog alert11 = builder.create();
                                alert11.show();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        AlertDialog.Builder builder = new AlertDialog.Builder(RiwayatKeseluruhan.this);
                        builder.setTitle("Kesalahan Jaringan").
                                setMessage("Terdapat Kesalahan jaringan saat memuat data");
                        builder.setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert11 = builder.create();
                        alert11.show();
                    }
                });
        queue.add(reqData);
    }
}