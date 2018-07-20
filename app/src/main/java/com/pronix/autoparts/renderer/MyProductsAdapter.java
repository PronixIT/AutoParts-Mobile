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
import android.widget.Toast;

import com.pronix.autoparts.AddressActivity;
import com.pronix.autoparts.CheckoutActivity;
import com.pronix.autoparts.ProductsActivity;
import com.pronix.autoparts.R;

public class MyProductsAdapter extends RecyclerView.Adapter<MyProductsAdapter.ViewHolder> {

    private String[] data = {"TOOLSCENTRE Tools Centre New 46Pcs 1/4\"Taparia Socket " +
            "Set For Car,Motorbike, Bicycle Repair Tool Kit","Ceat 102815 FI Steel BT " +
            "215/75 R15 115S/113S Tubeless SUV Tyre"};
    private String[] price = {"Rs. 2999","Rs.4999"};
    private int[] products = {R.drawable.tool_kit,R.drawable.tyres};
    private LayoutInflater inflater;
    private Context context;

    public MyProductsAdapter(ProductsActivity productsActivity) {
        context = productsActivity;
        this.inflater = LayoutInflater.from(productsActivity);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.product_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(data[position]);
        holder.price.setText(price[position]);
        holder.item.setBackgroundResource(products[position]);
    }

    @Override
    public int getItemCount() {
        return products.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price;
        ImageView item;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            item = itemView.findViewById(R.id.logo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CheckoutActivity.class));
                }
            });
        }
    }
}
