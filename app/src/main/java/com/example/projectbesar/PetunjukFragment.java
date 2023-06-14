package com.example.projectbesar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class PetunjukFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_petunjuk, container, false);

        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.petunjuk, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.petunjuk1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.petunjuk2, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.img4, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        return view;
    }
}