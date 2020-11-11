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

public class ThingsToDo extends Fragment implements ListView.OnItemClickListener {
    public ThingsToDo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        final ArrayList<Item> Items = new ArrayList<>();
        Items.add(new Item(R.string.DayTrips , R.string.Empty, R.drawable.luxordaytour, "https://www.tripadvisor.com/Attraction_Products-g294205-zfc11889-zfg11867-Luxor_Nile_River_Valley.html"));
        Items.add(new Item(R.string.AncientRuins, R.string.Empty, R.drawable.ancient, "https://www.tripadvisor.com/Attractions-g294205-Activities-c47-t2-Luxor_Nile_River_Valley.html"));
        Items.add(new Item(R.string.Architecture, R.string.Empty, R.drawable.architecture, "https://www.tripadvisor.com/Attraction_Products-g294205-zfc12013-zfg11866-Luxor_Nile_River_Valley.html"));
        Items.add(new Item(R.string.Balloon, R.string.Empty, R.drawable.ballon, "https://www.tripadvisor.com/Attraction_Products-g294205-zfc12027-zfg11864-Luxor_Nile_River_Valley.html"));
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
        intent.setPackage("com.android.chrome");
        startActivity(intent);
    }

}
