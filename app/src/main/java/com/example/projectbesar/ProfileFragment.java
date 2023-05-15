package com.example.projectbesar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ProfileFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView edit = view.findViewById(R.id.edit);
        ImageView profiltertaut = view.findViewById(R.id.profiltertaut);
        ImageView tentang = view.findViewById(R.id.tentang);
        ImageView keluar = view.findViewById(R.id.keluar);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UbahAkunActivity.class);
                intent.putExtra("data", "Hello from MyFragment");
                startActivity(intent);
            }
        });

        profiltertaut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfilTertautActivity.class);
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
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("data", "Hello from MyFragment");
                startActivity(intent);
            }
        });

        return view;
    }
}