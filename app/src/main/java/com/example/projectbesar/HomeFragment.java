package com.example.projectbesar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.projectbesar.mental.chat.CHATActivity;
import com.example.projectbesar.mental.gpph.GPPHActivity;
import com.example.projectbesar.mental.kmme.KMMEActivity;
import com.example.projectbesar.mental.MentalActivity;
import com.example.projectbesar.perkembangan.kpsp.KPSPActivity;
import com.example.projectbesar.perkembangan.PerkembanganActivity;
import com.example.projectbesar.perkembangan.tdd.TDDActivity;
import com.example.projectbesar.perkembangan.tdl.TDLActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CardView perkembangan = view.findViewById(R.id.perkembangan);
        CardView mental = view.findViewById(R.id.mental);
//        AppCompatButton btn_kpsp = view.findViewById(R.id.btn_kpsp);
//        AppCompatButton btn_tdd = view.findViewById(R.id.btn_tdd);
//        AppCompatButton btn_tdl = view.findViewById(R.id.btn_tdl);
//        AppCompatButton btn_kmme = view.findViewById(R.id.btn_kmme);
//        AppCompatButton btn_chat = view.findViewById(R.id.btn_chat);
//        AppCompatButton btn_gpph = view.findViewById(R.id.btn_gpph);
        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);

        perkembangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PerkembanganActivity.class);
                intent.putExtra("data", "Hello from MyFragment");
                startActivity(intent);
            }
        });

        mental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MentalActivity.class);
                intent.putExtra("data", "Hello from MyFragment");
                startActivity(intent);
            }
        });

//        btn_kpsp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), KPSPActivity.class);
//                intent.putExtra("data", "Hello from MyFragment");
//                startActivity(intent);
//            }
//        });
//
//        btn_tdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), TDDActivity.class);
//                intent.putExtra("data", "Hello from MyFragment");
//                startActivity(intent);
//            }
//        });
//
//        btn_tdl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), TDLActivity.class);
//                intent.putExtra("data", "Hello from MyFragment");
//                startActivity(intent);
//            }
//        });
//
//        btn_kmme.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), KMMEActivity.class);
//                intent.putExtra("data", "Hello from MyFragment");
//                startActivity(intent);
//            }
//        });
//
//        btn_chat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), CHATActivity.class);
//                intent.putExtra("data", "Hello from MyFragment");
//                startActivity(intent);
//            }
//        });
//
//        btn_gpph.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), GPPHActivity.class);
//                intent.putExtra("data", "Hello from MyFragment");
//                startActivity(intent);
//            }
//        });

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.img1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img4, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        return view;

    }
}