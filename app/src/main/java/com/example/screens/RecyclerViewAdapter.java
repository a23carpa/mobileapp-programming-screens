package com.example.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            namn = itemView.findViewById(R.id.nameText);
            ålder = itemView.findViewById(R.id.ageText);
        }
        @Override
        public void onClick(View view) {
            onClickListener.onClick(itemList.get(getAdapterPosition()));
        }
    }
    public interface OnClickListener {
        void onClick(recyclerItem item);
    }
}
