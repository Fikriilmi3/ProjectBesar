package com.example.projectbesar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.projectbesar.models.User;
import com.example.projectbesar.utils.Preferences;
import com.example.projectbesar.utils.SessionHandler;
import com.example.projectbesar.utils.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileFragment extends Fragment {

    private ProgressDialog pDialog;
    private User user;
    private TextView username, tgl_lahir, nama_ibu;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle("Data");

        ImageView edit = view.findViewById(R.id.edit);
        ImageView edukasi= view.findViewById(R.id.edukasi);
        ImageView tentang = view.findViewById(R.id.tentang);
        ImageView keluar = view.findViewById(R.id.keluar);

        username = view.findViewById(R.id.username);
        tgl_lahir = view.findViewById(R.id.tgl_lahir);
        nama_ibu = view.findViewById(R.id.nama_ibu);

        username.setText(Preferences.getKeyUsername(getActivity()));
        tgl_lahir.setText(Preferences.getKeyTglLahir(getActivity()));
        nama_ibu.setText(Preferences.getKeyNamaIbu(getActivity()));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UbahAkunActivity.class);
                intent.putExtra("data", "Hello from MyFragment");
                startActivity(intent);
            }
        });

        edukasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EdukasiActivity.class);
                intent.putExtra("data", "Hello from MyFragment");
                startActivity(intent);
            }
        });

        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TentangActivity.class);
                intent.putExtra("data", "Hello from MyFragment");
                startActivity(intent);
            }
        });

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keluar();
            }
        });

//        getData();
        return view;
    }

    private void keluar() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(requireContext());
        dialog.setTitle("Konfirmasi");
        dialog.setMessage("Anda yakin ingin keluar?");
        dialog.setNegativeButton("Batal", null);
        dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Preferences.clearLoggedInUser(getActivity());
                Intent intent = new Intent(requireContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                requireActivity().finish();
                startActivity(intent);
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    private void displayLoader() {
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Sedang diproses...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

//    private void getData() {
//        displayLoader();
//        StringRequest smr = new StringRequest(Request.Method.GET, "http://192.168.43.41/web-services/Api/data?id=" + user.getIdPengguna(),
//                response -> {
//                    pDialog.dismiss();
//                    try {
//                        JSONObject jObj = new JSONObject(response);
//                        if (jObj.getString("status").equals("true")) {
//                            JSONObject result = jObj.getJSONObject("data");
//                            username.setText(result.getString("username"));
//                            tgl_lahir.setText(result.getString("tgl_lahir"));
//                            nama_ibu.setText(result.getString("nama_ibu"));
//
//                        } else {
//                            Toast.makeText(getActivity(), jObj.getString("message"), Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                        Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                }, error -> {
//            pDialog.dismiss();
//            Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
//        });
//
//        smr.setShouldCache(false);
//        VolleySingleton.getInstance(getActivity()).addToRequestQueue(smr);
//    }
}