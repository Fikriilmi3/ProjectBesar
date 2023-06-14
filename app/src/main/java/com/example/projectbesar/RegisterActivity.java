package com.example.projectbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.projectbesar.utils.ServerApi;

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
    private TextView tvlogin;
    private Button btn_register;

    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Register");

        username      = findViewById(R.id.username);
        nama_anak     = findViewById(R.id.nama_anak);
        jenis_kelamin = findViewById(R.id.jenis_kelamin);
        tempat_lahir  = findViewById(R.id.tempat_lahir);
        tgl_lahir     = findViewById(R.id.tgl_lahir);
        btnDate       = findViewById(R.id.btnDate);
        nama_ibu      = findViewById(R.id.nama_ibu);
        telepone      = findViewById(R.id.telepone);
        password      = findViewById(R.id.password);
        tvlogin       = findViewById(R.id.tvlogin) ;
        btn_register  = findViewById(R.id.btn_register);
        pDialog       = new ProgressDialog(RegisterActivity.this);

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
                Register();
            }
        });
    }

    private void Register(){
        pDialog.setMessage("Menyimpan Data");
        pDialog.setCancelable(false);
        pDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ServerApi.URL_REGISTRASI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pDialog.cancel();
//                try {
//                    JSONObject jsonObject = new JSONObject(response);

                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle("Registrasi Berhasil").
                        setMessage("Registrasi akun anda telah berhasil");
                builder.setPositiveButton("Login",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                                finish();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();

//                }
//                catch (JSONException e) {
//                    e.printStackTrace();
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                    builder.setTitle("Registrasi Gagal").
//                            setMessage("Terdapat kesalahan saat melakukan registrasi");
//                    builder.setPositiveButton("Coba Lagi",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                }
//                            });
//                    AlertDialog alert11 = builder.create();
//                    alert11.show();
//
//                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.cancel();
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setTitle("Kesalahan Jaringan").
                        setMessage("Terdapat kesalahan jaringan saat memuat data");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
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

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
//    private void Register() {
//        pDialog.setMessage("Menyimpan Data");
//        pDialog.setCancelable(false);
//        pDialog.show();
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        StringRequest updateReq = new StringRequest(Request.Method.POST, ServerApi.URL_REGISTRASI,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        pDialog.cancel();
//                        try {
//                            JSONObject res = new JSONObject(response);
//                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                            builder.setTitle("Registrasi").
//                                    setMessage("Registrasi Berhasil");
//                            builder.setPositiveButton("LOGIN",
//                                    new DialogInterface.OnClickListener() {
//                                        public void onClick(DialogInterface dialog, int id) {
//                                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                                            startActivity(intent);
//                                            finish();
//                                        }
//                                    });
//                            AlertDialog alert11 = builder.create();
//                            alert11.show();
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        pDialog.cancel();
//                        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(RegisterActivity.this);
//                        builder.setMessage("Terjadi kesalahan jaringan")
//                                .setNegativeButton("Retry", null).create().show();
//                    }
//                }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> map = new HashMap<>();
//                map.put("username", username.getText().toString());
//                map.put("nama_anak", nama_anak.getText().toString());
//                map.put("jenis_kelamin", jenis_kelamin.getText().toString());
//                map.put("tempat_lahir", tempat_lahir.getText().toString());
//                map.put("tgl_lahir", tgl_lahir.getText().toString());
//                map.put("nama_ibu", nama_ibu.getText().toString());
//                map.put("telepone",telepone.getText().toString());
//                map.put("password", password.getText().toString());
//                System.out.println(map);
//                return map;
//            }
//        };
//        queue.add(updateReq);
//    }

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