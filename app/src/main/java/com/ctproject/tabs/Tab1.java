package com.ctproject.tabs;

/**
 * Created by farhan on 9/10/15.
 */
import com.ctproject.beratidealmu.R;
import com.ctproject.dbase.BeratIdeal;
import com.ctproject.dbase.DatabaseHandler;
import com.ctproject.dbase.Profil;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Tab1 extends Fragment {

    private String checkDB, Jeniskelamin, Kesimpulan;
    private double ideal, IMT;
    private int Tinggi, Berat;
    private Locale indo = new Locale("id-ID");

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_tab1, container, false);

        // Set the Text to try this out
        final EditText EditBerat = (EditText) v.findViewById(R.id.editBerat);
        final EditText EditTinggi = (EditText) v.findViewById(R.id.editTinggi);
        final Button TombolHitung = (Button) v.findViewById(R.id.tombolHitung);
        final Button TombolHapus = (Button) v.findViewById(R.id.tombolHapus);
        final TextView TxtHasilBerat = (TextView) v.findViewById(R.id.textHasilBerat);
        final TextView TxtHasilIdeal = (TextView) v.findViewById(R.id.textHasilIdeal);
        final RadioButton RadioPria = (RadioButton) v.findViewById(R.id.radioLaki);RadioPria.setChecked(false);
        final RadioButton RadioWanita = (RadioButton) v.findViewById(R.id.radioPerempuan);RadioWanita.setChecked(false);
        final DatabaseHandler db = new DatabaseHandler(getActivity());
        final Date date = new Date();
        final DateFormat tanggal = DateFormat.getDateInstance(DateFormat.MEDIUM, indo);
        final DateFormat waktu = DateFormat.getTimeInstance(DateFormat.SHORT, indo);
        final List<BeratIdeal> BeratIdeals = db.getAllBerats();

        TombolHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if ((EditTinggi.getText().length() == 0) || (EditBerat.getText().length() == 0) || (RadioPria.isChecked() == false && RadioWanita.isChecked() == false)) {
                    Toast.makeText(getActivity(), "Silahkan isi dengan benar!", Toast.LENGTH_SHORT).show();
                    RadioWanita.setChecked(false);
                    RadioPria.setChecked(false);
                    return;
                } else {
                    Berat = Integer.parseInt(EditBerat.getText().toString());
                    Tinggi = Integer.parseInt(EditTinggi.getText().toString());

                    if (RadioPria.isChecked()) {
                        ideal = (Tinggi - 100) - ((Tinggi - 100) * 0.10);
                        TxtHasilBerat.setText("Berat ideal yang disarankan untuk Anda adalah " + ideal + "Kg");
                        IMT = ((Berat / ((Tinggi * 0.10) * (Tinggi * 0.10))) * 100);
                        if (IMT >= 30) {
                            TxtHasilIdeal.setText("Anda obesitas, berbagai penyakit siap menghampiri Anda");
                            Kesimpulan = "Anda obesitas!";
                        } else if (IMT >= 25) {
                            TxtHasilIdeal.setText("Memasuki batas obesitas, segera lakukan program diet");
                            Kesimpulan = "Memasuki obesitas!";
                        } else if (IMT >= 23) {
                            TxtHasilIdeal.setText("Masuk kategori ideal, tetapi harus menjaga pola makan");
                            Kesimpulan = "Berat Anda relatif Ideal";
                        } else if (IMT >= 18.5) {
                            TxtHasilIdeal.setText("Berat badan ideal, sangat bagus");
                            Kesimpulan = "Berat Anda sudah Ideal";
                        } else {
                            TxtHasilIdeal.setText("Anda underweight, perlu meningkatkan olahraga dan makan padat kalori");
                            Kesimpulan = "Anda underweight";
                        }
                        Jeniskelamin = "Pria";
                    }
                    if (RadioWanita.isChecked()) {
                        ideal = (Tinggi - 100) - ((Tinggi - 100) * 0.15);
                        TxtHasilBerat.setText("Berat ideal yang disarankan untuk Anda adalah " + ideal + "Kg");
                        IMT = ((Berat / ((Tinggi * 0.10) * (Tinggi * 0.10))) * 100);
                        if (IMT >= 30) {
                            TxtHasilIdeal.setText("Anda obesitas, berbagai penyakit siap menghampiri Anda");
                            Kesimpulan = "Anda obesitas!";
                        } else if (IMT >= 25) {
                            TxtHasilIdeal.setText("Memasuki batas obesitas, segera lakukan program diet");
                            Kesimpulan = "Memasuki obesitas!";
                        } else if (IMT >= 23) {
                            TxtHasilIdeal.setText("Masuk kategori ideal, tetapi harus menjaga pola makan");
                            Kesimpulan = "Berat Anda relatif Ideal";
                        } else if (IMT >= 18.5) {
                            TxtHasilIdeal.setText("Berat badan ideal, sangat bagus");
                            Kesimpulan = "Berat Anda sudah Ideal";
                        } else {
                            TxtHasilIdeal.setText("Anda underweight, perlu meningkatkan olahraga dan makan padat kalori");
                            Kesimpulan = "Anda underweight";
                        }
                        Jeniskelamin = "Wanita";
                    }
                    db.addberatIdeal(new BeratIdeal(EditBerat.getText().toString(), EditTinggi.getText().toString(), Double.toString(ideal), Jeniskelamin, Kesimpulan, tanggal.format(date), waktu.format(date)));
                    EditBerat.clearFocus();
                    EditTinggi.clearFocus();
                    EditBerat.setText("");
                    EditTinggi.setText("");

                }

            }
        });

        RadioPria.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                RadioWanita.setChecked(false);
            }
        });

        RadioWanita.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                RadioPria.setChecked(false);
            }
        });

        TombolHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                EditBerat.setText("");
                EditTinggi.setText("");
                TxtHasilBerat.setText("");
                TxtHasilIdeal.setText("");
                RadioWanita.setChecked(false);
                RadioPria.setChecked(false);
            }
        });
    return v;
    }
}