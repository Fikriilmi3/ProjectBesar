package com.example.projectbesar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.projectbesar.R;
import com.example.projectbesar.models.ModelRiwayat;

import java.util.List;

public class AdapterRiwayat extends RecyclerView.Adapter<AdapterRiwayat.HolderData> {
    private List<ModelRiwayat> mItems;
    private Context context;

    public AdapterRiwayat(Context context, List<ModelRiwayat> items){
        this.mItems  = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.riwayat,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelRiwayat md  = mItems.get(position);
        holder.tviduser.setText(md.getId_user());
        holder.tvidkategori.setText(md.getNama_kategori());
        holder.tvidumur.setText(md.getUmur());
        holder.tvya.setText(md.getJumlah_ya());
        holder.tvtidak.setText(md.getJumlah_tidak());
        holder.tvhasil.setText(md.getHasil());
        holder.tvsaran.setText(md.getSaran());

        holder.md = md;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tviduser, tvidkategori, tvidumur, tvya, tvtidak,tvhasil,tvsaran;
        ModelRiwayat md;

        public  HolderData (View view)
        {
            super(view);

            tviduser     = (TextView) view.findViewById(R.id.tviduser);
            tvidkategori = (TextView) view.findViewById(R.id.tvidkategori);
            tvidumur     = (TextView) view.findViewById(R.id.tvidumur);
            tvya         = (TextView) view.findViewById(R.id.tvya);
            tvtidak      = (TextView) view.findViewById(R.id.tvtidak);
            tvhasil      = (TextView) view.findViewById(R.id.tvhasil);
            tvsaran      = (TextView) view.findViewById(R.id.tvsaran);
        }
    }
}
