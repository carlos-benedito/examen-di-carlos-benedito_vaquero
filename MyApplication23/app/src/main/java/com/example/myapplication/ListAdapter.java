package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    // Constructor
    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Inflar el layout para cada elemento de la lista
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, parent, false);
        return new ViewHolder(view);
    }

    // Vincular los datos con cada ViewHolder
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    // Método para actualizar los datos de la lista
    public void setItems(List<ListElement> items) {
        mData = items;
    }

    // Clase ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImageView;
        TextView nameTextView, cityTextView, statusTextView;

        ViewHolder(View itemView){
            super(itemView);
            iconImageView = itemView.findViewById(R.id.iconImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            cityTextView = itemView.findViewById(R.id.cityTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(final ListElement item){
            iconImageView.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nameTextView.setText(item.getName());
            cityTextView.setText(item.getCity());
            statusTextView.setText(item.getStatus());
        }
    }
}
