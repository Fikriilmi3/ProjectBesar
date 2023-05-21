package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.projectbesar.utils.SessionHandler;
import com.example.projectbesar.utils.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private TextView username;
    private TextView password;

    private SessionHandler sessionHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        sessionHandler = new SessionHandler(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        TextView tvreg = findViewById(R.id.tvreg);
        Button btn_login = findViewById(R.id.btn_login);

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
                postData();
            }
        });
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Sedang diproses...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void postData() {
        displayLoader();
        StringRequest smr = new StringRequest(Request.Method.POST, "http://192.168.43.41/web-services/Api/login",
                response -> {
                    pDialog.dismiss();
                    try {
                        JSONObject jObj = new JSONObject(response);
                        if (jObj.getString("status").equals("true")) {
                            JSONObject result = jObj.getJSONObject("data");
                            sessionHandler.loginUser(result.getString("id"), result.getString("username"), result.getString("nama_anak"), result.getString("jenis_kelamin"), result.getString("tempat_lahir"), result.getString("tgl_lahir"), result.getString("nama_ibu"), result.getString("telepone"));
                            Intent intent = new Intent(LoginActivity.this, UbahAkunActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
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
        }) {


            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username.getText().toString());
                params.put("password", password.getText().toString());
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(smr);
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