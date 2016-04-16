package com.ctproject.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


import com.ctproject.beratidealmu.R;
import com.ctproject.dbase.DatabaseHandler;
import com.ctproject.dbase.Profil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by farhan on 10/2/15.
 */
public class ProfileInsert extends ActionBarActivity {

    private static final int SELECT_PICTURE = 1;
    ImageView img;
    String selectedImagePath;
    public ArrayList<Profil> values;
    private Button simpan;
    private String jenisKelamin, golonganDarah;
    private EditText inputNama, inputQuote;
    private RadioButton radioLaki, radioPerempuan, radioA, radioB, radioAB, radioO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile_insert);

        img = (ImageView) findViewById(R.id.ivImage);
        inputNama = (EditText) findViewById(R.id.editNama);
        inputQuote = (EditText) findViewById(R.id.editQuote);
        radioPerempuan = (RadioButton) findViewById(R.id.radioPerempuanProfil);radioPerempuan.setChecked(false);
        radioLaki = (RadioButton) findViewById(R.id.radioLakiProfil);radioLaki.setChecked(false);
        radioA = (RadioButton) findViewById(R.id.radioA);radioA.setChecked(false);
        radioB = (RadioButton) findViewById(R.id.radioB);radioB.setChecked(false);
        radioAB = (RadioButton) findViewById(R.id.radioAB);radioAB.setChecked(false);
        radioO = (RadioButton) findViewById(R.id.radioO);radioO.setChecked(false);
        simpan = (Button) findViewById(R.id.tombolSimpan);

        final DatabaseHandler db = new DatabaseHandler(this);
        final List<Profil> Profils = db.getAllProfils();


        inputNama.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        inputQuote.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        radioLaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                radioPerempuan.setChecked(false);
            }
        });

        radioPerempuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                radioLaki.setChecked(false);
            }
        });

        radioA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                radioB.setChecked(false);
                radioAB.setChecked(false);
                radioO.setChecked(false);
            }
        });

        radioB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                radioA.setChecked(false);
                radioAB.setChecked(false);
                radioO.setChecked(false);
            }
        });

        radioAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                radioA.setChecked(false);
                radioB.setChecked(false);
                radioO.setChecked(false);
            }
        });

        radioO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                radioA.setChecked(false);
                radioB.setChecked(false);
                radioAB.setChecked(false);
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if ((inputNama.getText().length() == 0) || (inputQuote.getText().length() == 0) || (radioLaki.isChecked() == false && radioPerempuan.isChecked() == false && radioA.isChecked() == false && radioB.isChecked() == false && radioAB.isChecked() == false && radioO.isChecked() == false) )
                {
                    Toast.makeText(getBaseContext(), "Silahkan isi dengan benar!", Toast.LENGTH_SHORT).show();
                    radioLaki.setChecked(false);
                    radioPerempuan.setChecked(false);
                    radioA.setChecked(false);
                    radioB.setChecked(false);
                    radioAB.setChecked(false);
                    radioO.setChecked(false);
                    return;
                } else {
                    if(radioPerempuan.isChecked()){
                        jenisKelamin = "Perempuan";
                    }
                    if(radioLaki.isChecked()){
                        jenisKelamin = "Laki-Laki";
                    }
                    if(radioA.isChecked()){
                        golonganDarah = "A";
                    }
                    if(radioB.isChecked()){
                        golonganDarah = "B";
                    }
                    if(radioAB.isChecked()){
                        golonganDarah = "AB";
                    }
                    if(radioO.isChecked()){
                        golonganDarah = "O";
                    }
                    db.hapusDBaseProfil();
                    db.addprofil(new Profil(inputNama.getText().toString(), "", "", inputQuote.getText().toString(), jenisKelamin, golonganDarah));
                    Toast.makeText(getBaseContext(), "Halo " + inputNama.getText() + " ! Profil sudah tersimpan.",
                            Toast.LENGTH_LONG).show();
                    inputNama.setText("");
                    inputQuote.setText("");
                    radioLaki.setChecked(false);
                    radioPerempuan.setChecked(false);
                    radioA.setChecked(false);
                    radioB.setChecked(false);
                    radioAB.setChecked(false);
                    radioO.setChecked(false);
                    Intent intent = new Intent(ProfileInsert.this, Profile.class);
                    startActivity(intent);
            }
            }
        });
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}