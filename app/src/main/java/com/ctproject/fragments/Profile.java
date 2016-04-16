package com.ctproject.fragments;

/**
 * Created by farhan on 9/10/15.
 */
import com.ctproject.beratidealmu.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.ctproject.dbase.DatabaseHandler;
import com.ctproject.dbase.Profil;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

public class Profile extends ActionBarActivity {

    private TextView Nama,Quote,jenisKelamin,golonganDarah;
    private String nama,quote,jeniskelamin,golongandarah;
    private FloatingActionButton fab;
    public ArrayList<Profil> valuesProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        Nama = (TextView) findViewById(R.id.nama_ktp);
        jenisKelamin = (TextView) findViewById(R.id.jenis_ktp);
        golonganDarah = (TextView) findViewById(R.id.golongandarah_ktp);

        final DatabaseHandler dataSource = new DatabaseHandler(this);

        valuesProfil = (ArrayList<Profil>) dataSource.getAllProfils();
        for (Profil identitas : valuesProfil) {
            nama = identitas.getNama();
            jeniskelamin = identitas.getJeniskelamin();
            golongandarah = identitas.getGolongandarah();
        }

        if (nama == null ) {
            Nama.setText("Belum memasukan Identitas");
            jenisKelamin.setText("Tidak terdaftar");
            golonganDarah.setText("Tidak terdaftar");

        } else {
            Nama.setText(nama);
            jenisKelamin.setText(jeniskelamin);
            golonganDarah.setText(golongandarah);
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, ProfileInsert.class);
                startActivity(intent);
            }

        });
    }
}




