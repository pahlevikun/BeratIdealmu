package com.ctproject.dbase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.ctproject.beratidealmu.R;

public class BeratAdapter extends ArrayAdapter<BeratIdeal> {

    public BeratAdapter(Context context, ArrayList<BeratIdeal> users) {
        super(context, 0, users);
    }
    //private Locale indo = new Locale("id-ID");

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        BeratIdeal beratIdeal = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_tab2_view, parent, false);
        }

        String getNomor = Integer.toString(beratIdeal.getID());
        // Lookup view for data population
        TextView tvBerat = (TextView) convertView.findViewById(R.id.tvBerat);
        TextView tvTinggi = (TextView) convertView.findViewById(R.id.tvTinggi);
        TextView tvKalkulasi = (TextView) convertView.findViewById(R.id.tvKalkulasi);
        TextView tvJenis = (TextView) convertView.findViewById(R.id.tvJenis);
        TextView tvBeratIdeal = (TextView) convertView.findViewById(R.id.tvBeratIdeal);
        TextView tvTanggal = (TextView) convertView.findViewById(R.id.tvTanggal);
        TextView tvWaktu = (TextView) convertView.findViewById(R.id.tvWaktu);
        TextView tvNomor = (TextView) convertView.findViewById(R.id.tvNo);

            tvBerat.setText(beratIdeal._berat+"kg");
            tvTinggi.setText(beratIdeal._tinggi+"cm");
            tvKalkulasi.setText("Disarankan "+beratIdeal._kalkulasi+"kg");
            tvJenis.setText(beratIdeal._jeniskelamin);
            tvBeratIdeal.setText(beratIdeal._kesimpulan);
            tvNomor.setText(getNomor+".");
            tvTanggal.setText(beratIdeal._tanggal);
            tvWaktu.setText(beratIdeal._waktu);
            // Return the completed view to render on screen

        return convertView;
    }

}