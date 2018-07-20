package com.pronix.autoparts.renderer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pronix.autoparts.ProductsActivity;
import com.pronix.autoparts.R;
import com.pronix.autoparts.SampleActivity;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private String[] data = new String[0];
    private LayoutInflater inflater;
    private Context context;
    private int[] data1={R.drawable.engine,R.drawable.outer_parts,R.drawable.accessories,R.drawable.car_seats,
            R.drawable.inner_parts,R.drawable.brakes,R.drawable.tool_kit};

    public MyRecyclerViewAdapter(SampleActivity sampleActivity, String[]  data) {
        this.inflater = LayoutInflater.from(sampleActivity);
        this.data = data;
        this.context = sampleActivity;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        String animal = data[position];
        holder.myTextView.setText(animal);
        holder.myImageView.setBackgroundResource(data1[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ImageView myImageView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.name);
            myImageView = itemView.findViewById(R.id.logo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(context,ProductsActivity.class);
                    in.putExtra("PARTS", data[getAdapterPosition()]);
                    context.startActivity(in);
                }
            });
        }
    }
}
