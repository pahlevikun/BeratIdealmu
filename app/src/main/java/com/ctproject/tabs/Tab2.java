package com.ctproject.tabs;

/**
 * Created by farhan on 9/10/15.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ctproject.beratidealmu.R;
import com.ctproject.dbase.BeratAdapter;
import com.ctproject.dbase.BeratIdeal;
import com.ctproject.dbase.DatabaseHandler;

import java.util.ArrayList;

public class Tab2 extends Fragment {

    public ArrayList<BeratIdeal> values;
    TextView hasil;
    String check_beratideal;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_tab2, container, false);
        ListView lv = (ListView)v.findViewById(R.id.list);

        hasil = (TextView) v.findViewById(R.id.data_riwayat);
        final DatabaseHandler dataSource = new DatabaseHandler(getActivity());
        values = (ArrayList<BeratIdeal>) dataSource.getAllBerats();

        for (BeratIdeal dp : values) {
            check_beratideal = dp.getBerat();
        }
        if (check_beratideal == null) {
            hasil.setVisibility(View.VISIBLE);
        } else {
            hasil.setVisibility(View.INVISIBLE);
        }


        BeratAdapter adapter = new BeratAdapter(getActivity(), values);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return v;
    }



}
