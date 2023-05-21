package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.projectbesar.perkembangan.KPSPActivity;
import com.example.projectbesar.perkembangan.PerkembanganActivity;
import com.example.projectbesar.utils.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UbahAkunActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private EditText username, nama_anak, jenis_kelamin, tempat_lahir, tgl_lahir, nama_ibu, telepone, password, id_pengguna;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_akun);

        username = findViewById(R.id.username);
        nama_anak = findViewById(R.id.nama_anak);
        jenis_kelamin = findViewById(R.id.jenis_kelamin);
        tempat_lahir = findViewById(R.id.tempat_lahir);
        tgl_lahir = findViewById(R.id.tgl_lahir);
        nama_ibu = findViewById(R.id.tgl_lahir);
        telepone = findViewById(R.id.telepone);
        //password = findViewById(R.id.password);

        id_pengguna = findViewById(R.id.id_pengguna);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getString("ID");
        }

        ImageView backButton= findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UbahAkunActivity.this, ProfileFragment.class);
                startActivity(i);
                finish();
            }
        });

        Button btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(view -> {
            if (validateInputs()) {
                postData();
            }
        });

        getData();
    }

    private void getData() {
        displayLoader();
        StringRequest smr = new StringRequest(Request.Method.GET, "http://192.168.43.41/web-services/Api/data?id=" + id,
                response -> {
                    pDialog.dismiss();
                    try {
                        JSONObject jObj = new JSONObject(response);
                        if (jObj.getString("status").equals("true")) {
                            JSONObject result = jObj.getJSONObject("data");
                            id_pengguna.setText(result.getString("id"));
                            username.setText(result.getString("username"));
                            nama_anak.setText(result.getString("nama_anak"));
                            jenis_kelamin.setText(result.getString("jenis_kelamin"));
                            tempat_lahir.setText(result.getString("tempat_lahir"));
                            tgl_lahir.setText(result.getString("tgl_lahir"));
                            nama_ibu.setText(result.getString("nama_ibu"));
                            telepone.setText(result.getString("telepone"));
                            //password.setText(result.getString("password"));

                        } else {
                            Toast.makeText(getApplicationContext(), jObj.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }, error -> {
            pDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
        });

        smr.setShouldCache(false);
        VolleySingleton.getInstance(this).addToRequestQueue(smr);
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(UbahAkunActivity.this);
        pDialog.setMessage("Sedang diproses...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
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

    private void postData() {
        displayLoader();
        StringRequest smr = new StringRequest(Request.Method.POST, "http://192.168.43.41/web-services/Api/update",
                response -> {
                    pDialog.dismiss();
                    try {
                        JSONObject jObj = new JSONObject(response);
                        String message = jObj.getString("message");
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        if (jObj.getString("status").equals("true")) {
                            Intent intent = new Intent(UbahAkunActivity.this, ProfileFragment.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }, error -> {
            pDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id_pengguna.getText().toString());
                params.put("username", username.getText().toString());
                params.put("nama_anak", nama_anak.getText().toString());
                params.put("jenis_kelamin", jenis_kelamin.getText().toString());
                params.put("tempat_lahir", tempat_lahir.getText().toString());
                params.put("tgl_lahir", tgl_lahir.getText().toString());
                params.put("nama-ibu", nama_ibu.getText().toString());
                params.put("telepone", telepone.getText().toString());
 //               params.put("password", password.getText().toString());
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(smr);
    }
}