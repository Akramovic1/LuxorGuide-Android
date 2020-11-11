package com.example.ahmedakram.luxorguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter {
    public ItemAdapter(Context context, ArrayList<Item> aItem) {
        super(context, 0, aItem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list, parent, false);
        }
        Item currentItem = (Item) getItem(position);
        TextView name = listItemView.findViewById(R.id.name);
        name.setText(currentItem.getName());

        TextView desc = listItemView.findViewById(R.id.desc);
        desc.setText(currentItem.getDes());

        ImageView image = listItemView.findViewById(R.id.imageOfPlace);
        if (currentItem.hasImage()) {
            image.setImageResource(currentItem.getImageID());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
