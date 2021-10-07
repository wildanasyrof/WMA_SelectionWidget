package com.my.animekutv;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.rvVIewHolder> {

    ArrayList<animelist> animeList;

    public rvAdapter(ArrayList<animelist> animelistArrayList) {
        this.animeList = animelistArrayList;
    }

    @NonNull
    @Override
    public rvVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false); //call/menguhungkan dgn list item xml
        return new rvVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvVIewHolder holder, int position) {
        //get data/value dari array linklist
        final animelist anime = animeList.get(position);
        //set text/value dalam item dari array
        holder.txtJudul.setText(anime.getJudul());
        holder.txtEps.setText(String.valueOf(anime.getEps()));
        holder.txtRate.setText(String.valueOf(anime.getRating()));
        holder.txtGenre.setText(anime.getGenre());

        //on click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), anime_detail.class); //membuat intent/penghubung ke animedetail activity
                intent.putExtra("ANIME", anime); //membuat kode untuk detail anime yang di tampilkan
                holder.itemView.getContext().startActivity(intent); //start new activity
            }
        });
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    } //panjang array linkkist

    public class rvVIewHolder extends RecyclerView.ViewHolder{
        TextView txtJudul, txtEps, txtRate, txtGenre; //deklarasi item dari list_item

        public rvVIewHolder(@NonNull View itemView){
            super(itemView);
            txtJudul = itemView.findViewById(R.id.judul);
            txtEps = itemView.findViewById(R.id.episode);
            txtRate = itemView.findViewById(R.id.rating);
            txtGenre = itemView.findViewById(R.id.genre);
        }
    }
}
