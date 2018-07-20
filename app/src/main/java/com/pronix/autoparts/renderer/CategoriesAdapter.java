package com.pronix.autoparts.renderer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pronix.autoparts.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private String[] mData = new String[0];

    public CategoriesAdapter(Context context, String[] data) {
        this.mData = data;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = (TextView) itemView.findViewById(R.id.name);
            imageView = (ImageView) itemView.findViewById(R.id.image);

        }


    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        holder.myTextView.setText(mData[position]);
        if(mData[position].equals("Tyres"))
        {
            holder.imageView.setImageResource(R.mipmap.tyres);
        }
        else if(mData[position].equals("Headlights"))
        {
            holder.imageView.setImageResource(R.mipmap.headlight);
        }
        else
            holder.imageView.setImageResource(R.mipmap.engine);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
}
