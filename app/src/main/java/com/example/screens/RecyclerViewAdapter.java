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
    private List<recyclerItem> items;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;
    RecyclerViewAdapter(Context context, List<recyclerItem> items, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
        this.onClickListener = onClickListener;

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.namn.setText("Namn: " + items.get(position).getName() + " ");
        holder.ålder.setText("Ålder: " + items.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
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
            onClickListener.onClick(items.get(getAdapterPosition()));
        }
    }
    public interface OnClickListener {
        void onClick(recyclerItem item);
    }
}
