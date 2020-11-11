package com.example.ahmedakram.luxorguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class GoEat extends Fragment implements ListView.OnItemClickListener {

    public GoEat() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        final ArrayList<Item> Items = new ArrayList<>();
        Items.add(new Item(R.string.Sahaby, R.string.SahabyDesc, R.drawable.alsahaby, "https://goo.gl/maps/iJ1dALzA6stEsYFG7"));
        Items.add(new Item(R.string.Aisha, R.string.AishaDesc, R.drawable.aisharestaurant, "https://goo.gl/maps/pWoSShGb1fsCu9e26"));
        Items.add(new Item(R.string.Lantern, R.string.LanternDesc, R.drawable.thelantern, "https://goo.gl/maps/ih1EcfGbyMyd1sLL7"));
        Items.add(new Item(R.string.Sofra, R.string.SofraDesc, R.drawable.sofra, "https://goo.gl/maps/THzRYRcsuLqFsR1e8"));
        Items.add(new Item(R.string.Roma, R.string.RomaDesc, R.drawable.pizzaromait, "https://goo.gl/maps/iqx1y8G6s3T7fTiF9"));
        Items.add(new Item(R.string.Jewel, R.string.JewelDesc, R.drawable.jewelofthenile, "https://goo.gl/maps/BMondaffrpXuhqxi6"));
        Items.add(new Item(R.string.Steigenberger, R.string.SteigenbergerDesc, R.drawable.nileplaceres, "https://goo.gl/maps/WvZ1gMT8AUdkh2AB9"));
        ItemAdapter adapter = new ItemAdapter(getActivity(), Items);
        ListView listView = view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Item currentItem = (Item) adapterView.getItemAtPosition(i);
        String url = currentItem.getLink();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}
