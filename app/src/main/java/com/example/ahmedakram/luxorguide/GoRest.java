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

public class GoRest extends Fragment implements ListView.OnItemClickListener {

    public GoRest() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        final ArrayList<Item> Items = new ArrayList<>();
        Items.add(new Item(R.string.Mara, R.string.MaraAddress, R.drawable.mara, "https://g.page/marahouseluxor?share"));
        Items.add(new Item(R.string.NilePalace, R.string.NilePalaceAddress, R.drawable.nileplace, "https://goo.gl/maps/tP9QSbzLp7Nkc6cN9"));
        Items.add(new Item(R.string.Hilton, R.string.HiltonAddress, R.drawable.hilton, "https://g.page/HiltonLuxor?share"));
        Items.add(new Item(R.string.NefertitiHotel, R.string.NefertitiHotelAddress, R.drawable.nefertitihotel, "https://goo.gl/maps/ZfWwMzCpbPNwtXms6"));
        Items.add(new Item(R.string.Sonesta, R.string.SonestaAddress, R.drawable.sonesta, "https://goo.gl/maps/XAUYbDLibth8EbLc7"));
        Items.add(new Item(R.string.Moudira, R.string.MoudiraAddress, R.drawable.almoudira, "https://goo.gl/maps/Xw2U8U3xhtFgEkhh9"));
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
