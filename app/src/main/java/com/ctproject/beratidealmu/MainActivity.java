package com.ctproject.beratidealmu;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ctproject.adapters.NavListAdapter;
import com.ctproject.dbase.DatabaseHandler;
import com.ctproject.dbase.Profil;
import com.ctproject.fragments.About;
import com.ctproject.fragments.Home;
import com.ctproject.fragments.Profile;
import com.ctproject.fragments.Reminder;
import com.ctproject.fragments.Settings;
import com.ctproject.models.NavItem;


public class MainActivity extends ActionBarActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView lvNav;

    List<NavItem> listNavItems;
    List<Fragment> listFragments;

    ActionBarDrawerToggle actionBarDrawerToggle;

    public ArrayList<Profil> valuesProfil;
    public TextView Quote,Nama;
    public String quote,nama,status;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Quote = (TextView) findViewById(R.id.quoteProfil);
        Nama = (TextView) findViewById(R.id.namaProfil);

        final DatabaseHandler dataSource = new DatabaseHandler(this);

        valuesProfil = (ArrayList<Profil>) dataSource.getAllProfils();
        for (Profil identitas : valuesProfil) {
            nama = identitas.getNama();
            quote = identitas.getQuote();
        }

        if (nama == null ) {
            Nama.setText("Belum memasukan Identitas!");
            Quote.setText("Klik disini");

        } else {
            Nama.setText(nama);
            Quote.setText(quote);
        }

        /*informasiStatus();
        pemilihanFragment();*/

        RelativeLayout relativeclic1 =(RelativeLayout)findViewById(R.id.profile_box);
        relativeclic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Profile.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);
        lvNav = (ListView) findViewById(R.id.nav_list);

        listNavItems = new ArrayList<NavItem>();
        listNavItems.add(new NavItem("Beranda", "Hitung berat idealmu!",
                R.drawable.ic_beranda));
        listNavItems.add(new NavItem("Pengingat", "Atur jadwal makanmu!",
                R.drawable.ic_pengingat));
        //listNavItems.add(new NavItem("Berita", "Kabar terbaru dunia kesehatan",
        //        R.drawable.ic_berita));
        listNavItems.add(new NavItem("Pengaturan", "Ubah pengaturan dasar",
                R.drawable.ic_pengaturan));
        listNavItems.add(new NavItem("Tentang Kami", "Informasi aplikasi dan tim pengembang",
                R.drawable.ic_tentang));

        NavListAdapter navListAdapter = new NavListAdapter(
                getApplicationContext(), R.layout.item_nav_list, listNavItems);

        lvNav.setAdapter(navListAdapter);

        listFragments = new ArrayList<Fragment>();
        listFragments.add(new Home());
        listFragments.add(new Reminder());
        //listFragments.add(new News());
        listFragments.add(new Settings());
        listFragments.add(new About());

        // load first fragment as default:
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_content, listFragments.get(0)).commit();

        setTitle(listNavItems.get(0).getTitle());
        lvNav.setItemChecked(0, true);
        drawerLayout.closeDrawer(drawerPane);

        // set listener for navigation items:
        lvNav.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // replace the fragment with the selection correspondingly:
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.main_content, listFragments.get(position))
                        .commit();

                setTitle(listNavItems.get(position).getTitle());
                lvNav.setItemChecked(position, true);
                drawerLayout.closeDrawer(drawerPane);

            }
        });


        // create listener for drawer layout
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_opened, R.string.drawer_closed) {

            @Override
            public void onDrawerOpened(View drawerView) {
                // TODO Auto-generated method stub
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // TODO Auto-generated method stub
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }

        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //profilebox
        /*LinearLayout linearlayout = (LinearLayout) findViewById(R.id.profile_box);
        linearlayout.setOnClickListener(new LinearLayout.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Profile.class);
                //startActivityForResult(intent, 0);
            }
        });*/

    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    /*private void informasiStatus() {
        Bundle extras= getIntent().getExtras();
        if(extras!=null)
        {
            status = extras.getString("status");
        }
    }

    private void pemilihanFragment(){
        if(status.toString().equals("hapus")) {
            Nama.setText("Belum memasukan Identitas!");
            Quote.setText("Klik disini");
        }
    }*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan lagi untuk keluar!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}