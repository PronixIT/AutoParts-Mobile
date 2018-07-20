package com.pronix.autoparts.renderer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pronix.autoparts.ModelActivity;
import com.pronix.autoparts.R;
import com.pronix.autoparts.SampleActivity;
import com.pronix.autoparts.common.CustomItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {
    Context context;
    List<String> list;
    CustomItemClickListener listener;

    public SearchAdapter(Context context, List<String> list, CustomItemClickListener listener)
    {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView, mtextView1;

        public MyViewHolder(final View view) {
            super(view);
             mTextView = (TextView) view.findViewById(R.id.textView);
//            mtextView1 = (TextView) view.findViewById(R.id.textView1);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v,list.get(getAdapterPosition()).toString(), getAdapterPosition());

                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adaptor_cardview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextView.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateList(List<String> list){
        this.list = list;
        notifyDataSetChanged();
    }


}
