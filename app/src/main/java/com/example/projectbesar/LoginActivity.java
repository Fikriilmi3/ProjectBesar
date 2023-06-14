package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectbesar.utils.Preferences;
import com.example.projectbesar.utils.ServerApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private TextView username, password, tvreg;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        username  = findViewById(R.id.username);
        password  = findViewById(R.id.password);
        tvreg     = findViewById(R.id.tvreg);
        btn_login = findViewById(R.id.btn_login);
        pDialog   = new ProgressDialog(LoginActivity.this);

        tvreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn_login.setOnClickListener(view -> {
            if (validateInputs()) {
                Login();
            }
        });
    }

    private void Login() {
        pDialog.setMessage("Sedang diproses...");
        pDialog.setCancelable(false);
        pDialog.show();

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest updateReq = new StringRequest(Request.Method.POST, ServerApi.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pDialog.cancel();
                        try {
                            JSONObject res = new JSONObject(response);
                            if (res.getBoolean("status_login")){
                                Preferences.setKeyId(getBaseContext(), res.getString("id"));
                                Preferences.setKeyUsername(getBaseContext(), res.getString("username"));
                                Preferences.setKeyNamaAnak(getBaseContext(), res.getString("nama_anak"));
                                Preferences.setKeyJenisKelamin(getBaseContext(), res.getString("jenis_kelamin"));
                                Preferences.setKeyTglLahir(getBaseContext(), res.getString("tgl_lahir"));
                                Preferences.setKeyTempatLahir(getBaseContext(), res.getString("tempat_lahir"));
                                Preferences.setKeyNamaIbu(getBaseContext(), res.getString("nama_ibu"));
                                Preferences.setKeyTelepone(getBaseContext(), res.getString("telepone"));
                                Preferences.setKeyPassword(getBaseContext(), res.getString("password"));

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }else {
                                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Username atau Password Anda salah!")
                                        .setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this);
                            builder.setMessage("Terdapat Kesalahan Jaringan")
                                    .setNegativeButton("Retry", null).create().show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pDialog.cancel();
                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(LoginActivity.this);
                        builder.setMessage("Terdapat Kesalahan Jaringan")
                                .setNegativeButton("Retry", null).create().show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("username",username.getText().toString());
                map.put("password",password.getText().toString());

                return map;
            }
        };

        queue.add(updateReq);
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
}