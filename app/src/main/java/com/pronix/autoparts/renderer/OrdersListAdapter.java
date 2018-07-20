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

import com.pronix.autoparts.OrderDetails;
import com.pronix.autoparts.OrdersActivity;
import com.pronix.autoparts.R;

import java.util.ArrayList;

public class OrdersListAdapter extends RecyclerView.Adapter<OrdersListAdapter.MyViewHolder> {
    String[] productName = {"CEAT 102815 FI Steel BT 215/75 R15", "Tools kit 25 items box", "Coverking custom Seatcover (1 Row)", "Putco 230100B Dome Light - Cool white, LED"};
    String[] status = {"Shipped EST Delivery : 26/05/2018", "Delivered : 2/3/2018", "Delivered : 21/1/2018", "Delivered : 15/10/2017"};
    int images[] = {R.drawable.tyres, R.drawable.toolkit, R.drawable.seatcover, R.drawable.domelight};
    Context context;

    public OrdersListAdapter(Context context) {
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView, mtextView1;
        ImageView iv_Product;

        public MyViewHolder(final View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv_ProductName);
            mtextView1 = (TextView) view.findViewById(R.id.tv_ShippingStatus);
            iv_Product = (ImageView) view.findViewById(R.id.iv_Product);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, OrderDetails.class));

                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.orderslist_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextView.setText(productName[position]);
        holder.mtextView1.setText(status[position]);
        holder.iv_Product.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return productName.length;
    }


}
