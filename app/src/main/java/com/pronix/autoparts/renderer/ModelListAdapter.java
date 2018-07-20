package com.pronix.autoparts.renderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pronix.autoparts.ProductsActivity;
import com.pronix.autoparts.R;
import com.pronix.autoparts.SampleActivity;
import com.pronix.autoparts.ShopByCategoryActivity;

import java.util.HashMap;
import java.util.List;

public class ModelListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listMake;
    private HashMap<String, List<String>> listModel;
    private Integer[] mThumbIds = {
            R.drawable.hero,R.drawable.rsz_audi, R.drawable.rsz_bmw,
            R.drawable.rsz_datsun, R.drawable.rsz_honda,
            R.drawable.rsz_honda_bike, R.drawable.rsz_hyundai,
            R.drawable.rsz_jeep, R.drawable.rsz_nissan,
            R.drawable.rsz_toyota
    };

    public ModelListAdapter(ShopByCategoryActivity shopByCategoryActivity, List<String> listMake, HashMap<String, List<String>> listModel) {
        this.context = shopByCategoryActivity;
        this.listMake = listMake;
        this.listModel = listModel;
    }
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_model, null);
        }

        LinearLayout modelLayout = convertView.findViewById(R.id.modelLayout);
        TextView modelName = convertView.findViewById(R.id.modelName);
        modelName.setTypeface(null, Typeface.BOLD);
        modelName.setText(childText);
        modelLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context,SampleActivity.class);
                in.putExtra("MODEL", childText);
                context.startActivity(in);
            }
        });
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listModel.get(this.listMake.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listMake.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listModel.get(this.listMake.get(groupPosition)).get(childPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listMake.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_make, null);
        }

        ImageView imgMake = convertView.findViewById(R.id.imgMake);
        TextView makeName = convertView.findViewById(R.id.makeName);
        makeName.setTypeface(null, Typeface.BOLD);
        makeName.setText(headerTitle);
        imgMake.setImageResource(mThumbIds[groupPosition]);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
