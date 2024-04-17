package com.example.screens;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<recyclerItem> itemList;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;
    RecyclerViewAdapter(Context context, List<recyclerItem> listOfItems, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.itemList = listOfItems;
        this.onClickListener = onClickListener;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.namn.setText("Namn: " + itemList.get(position).getName() + " ");
        holder.ålder.setText("Ålder: " + itemList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView namn;
        TextView ålder;
        LinearLayout layout;
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            namn = itemView.findViewById(R.id.nameText);
            ålder = itemView.findViewById(R.id.ageText);

            layout = itemView.findViewById(R.id.recyclerLayout);
            setBackground(layout);

        }
        @Override
        public void onClick(View view) {
            onClickListener.onClick(itemList.get(getAdapterPosition()));
        }
    }
    public interface OnClickListener {
        void onClick(recyclerItem item);
    }

    public void setBackground(LinearLayout layout){
        // Ändrar färg varje gång, behöver spara på något sätt + går man tillbaka är det ny färg
        Random r = new Random();
        int red=r.nextInt(240 - 0 + 1)+0;
        int green=r.nextInt(240 - 0 + 1)+0;
        int blue=r.nextInt(240 - 0 + 1)+0;

        GradientDrawable draw = new GradientDrawable();
        draw.setColor(Color.rgb(red,green,blue));
        layout.setBackground(draw);
    }

}
