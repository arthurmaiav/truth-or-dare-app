package com.example.dicerollerapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuViewHolder extends RecyclerView.ViewHolder {

    TextView tvItem;
    ImageButton imgItem;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        tvItem = itemView.findViewById(R.id.tvItem);
        imgItem = itemView.findViewById(R.id.imgItem);
    }
}
