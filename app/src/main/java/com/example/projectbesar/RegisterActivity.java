package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.projectbesar.utils.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private ProgressDialog pDialog;
    private TextView username;
    private TextView nama_anak;
    private TextView jenis_kelamin;
    private TextView tempat_lahir;
    private TextView tgl_lahir;
    private ImageButton btnDate;
    private int tahun, bulan, tanggal;
    private int tahun2, bulan2, tanggal2;
    private TextView nama_ibu;
    private TextView telepone;
    private TextView password;

    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        username = findViewById(R.id.username);
        nama_anak = findViewById(R.id.nama_anak);
        jenis_kelamin = findViewById(R.id.jenis_kelamin);
        tempat_lahir = findViewById(R.id.tempat_lahir);
        tgl_lahir = findViewById(R.id.tgl_lahir);
        btnDate = findViewById(R.id.btnDate);
        nama_ibu = findViewById(R.id.nama_ibu);
        telepone = findViewById(R.id.telepone);
        password = findViewById(R.id.password);

        TextView tvlogin = findViewById(R.id.tvlogin) ;
        Button btn_register = findViewById(R.id.btn_register);

        tgl_lahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                tahun2 = calendar.get(Calendar.YEAR);
                bulan2 = calendar.get(Calendar.MONTH);
                tanggal2 = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tahun2 = i;
                        bulan2 = i1;
                        tanggal2 = i2;

                        tgl_lahir.setText(tahun2 + " - " + bulan2 + " - " + tanggal2);
                    }
                }, tahun2, bulan2, tanggal2);
                dialog.show();
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                tahun = calendar.get(Calendar.YEAR);
                bulan = calendar.get(Calendar.MONTH);
                tanggal = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(RegisterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tahun = i;
                        bulan = i1;
                        tanggal = i2;

                        tgl_lahir.setText(tahun + "-" + bulan + "-" + tanggal);
                    }
                }, tahun, bulan, tanggal);
                dialog.show();
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn_register.setOnClickListener(view -> {
            if (validateInputs()) {
                postData();
            }
        });
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(RegisterActivity.this);
        pDialog.setMessage("Sedang diproses...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void postData() {
        displayLoader();
        StringRequest smr = new StringRequest(Request.Method.POST, "http://192.168.43.41/web-services/Api/register",
                response -> {
                    pDialog.dismiss();
                    try {
                        JSONObject jObj = new JSONObject(response);
                        String message = jObj.getString("message");
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        if (jObj.getString("status").equals("true")) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
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
                params.put("username", username.getText().toString());
                params.put("nama_anak", nama_anak.getText().toString());
                params.put("jenis_kelamin", jenis_kelamin.getText().toString());
                params.put("tempat_lahir", tempat_lahir.getText().toString());
                params.put("tgl_lahir", tgl_lahir.getText().toString());
                params.put("nama_ibu", nama_ibu.getText().toString());
                params.put("telepone",telepone.getText().toString());
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
        if (nama_anak.getText().toString().equals("")) {
            nama_anak.setError("Isi Nama Lengkap Anak");
            nama_anak.requestFocus();
            return false;
        }
        if (jenis_kelamin.getText().toString().equals("")) {
            jenis_kelamin.setError("Isi Jenis Kelamin");
            jenis_kelamin.requestFocus();
            return false;
        }
        if (tempat_lahir.getText().toString().equals("")) {
            tempat_lahir.setError("Isi Tempat Lahir");
            tempat_lahir.requestFocus();
            return false;
        }
        if (tgl_lahir.getText().toString().equals("")) {
            tgl_lahir.setError("Isi Tanggal Lahir");
            tgl_lahir.requestFocus();
            return false;
        }
        if (nama_ibu.getText().toString().equals("")) {
            nama_ibu.setError("Isi Nama Ibu");
            nama_ibu.requestFocus();
            return false;
        }
        if (telepone.getText().toString().equals("")) {
            telepone.setError("Isi Nomor Telepone");
            telepone.requestFocus();
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