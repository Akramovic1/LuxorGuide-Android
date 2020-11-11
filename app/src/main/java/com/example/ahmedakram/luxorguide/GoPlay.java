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

public class GoPlay extends Fragment implements ListView.OnItemClickListener {
    public GoPlay() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        final ArrayList<Item> Items = new ArrayList<>();
        Items.add(new Item(R.string.Valley , R.string.valleyDisc, R.drawable.valley, "https://goo.gl/maps/RYTbxqALWtsQqKu68"));
        Items.add(new Item(R.string.LuxorTemple, R.string.LuxorTempleDesc, R.drawable.luxortemple, "https://goo.gl/maps/TkKTcmjZvwZdsRee7"));
        Items.add(new Item(R.string.LuxorMuseum, R.string.LuxorMuseumDesc, R.drawable.leuxormuseum, "https://goo.gl/maps/4BS7SGxomz4pz29Q9"));
        Items.add(new Item(R.string.TempleofHatshepsut, R.string.HatshepsutDesc, R.drawable.hatshbsot, "https://goo.gl/maps/9goz8MjzUei1PhsR8"));
        Items.add(new Item(R.string.Tutankhamun, R.string.TutankhamunDesc, R.drawable.tomboftutankamun, "https://goo.gl/maps/Uwjqf6NJSLdHT8s96"));
        Items.add(new Item(R.string.Habu, R.string.HabuDesc, R.drawable.habu, "https://goo.gl/maps/ENZi2D92oECwWJek7"));
        Items.add(new Item(R.string.Nefertari, R.string.NefertariDesc, R.drawable.nefertari, "https://goo.gl/maps/YXW8AqFyPYrqDwwe7"));
        Items.add(new Item(R.string.Ramses, R.string.RamsesDesc, R.drawable.ramses, "https://goo.gl/maps/RYTbxqALWtsQqKu68"));
        Items.add(new Item(R.string.Karnak, R.string.KarnakDesc, R.drawable.karnak, "https://goo.gl/maps/d2EG9TYgRMGRtSFG6"));
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
