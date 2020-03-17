package com.example.dicerollerapp.MenuItem;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicerollerapp.MainMenu;
import com.example.dicerollerapp.R;

import java.util.List;

public class RVItemMenuAdapter extends RecyclerView.Adapter<RVItemMenuAdapter.ItemMenuViewHolder> {

    private List<ItemMenu> itens;

    public RVItemMenuAdapter(List<ItemMenu> itens) {
        this.itens = itens;
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    @NonNull
    @Override
    public ItemMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ItemMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemMenuViewHolder holder, final int position) {
        holder.itemTitle.setText(itens.get(position).titulo);
        holder.imageItem.setImageResource(itens.get(position).imagem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), itens.get(position).activityDestination);
                if(itens.get(position).activityDestination.equals(MainMenu.class)){
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    static class ItemMenuViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView itemTitle;
        ImageView imageItem;

        ItemMenuViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            itemTitle = itemView.findViewById(R.id.tituloItem);
            imageItem = itemView.findViewById(R.id.imagemItem);
        }
    }

}
