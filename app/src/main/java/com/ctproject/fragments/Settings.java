package com.ctproject.fragments;

/**
 * Created by farhan on 9/9/15.
 */
import com.ctproject.beratidealmu.MainActivity;
import com.ctproject.beratidealmu.R;
import com.ctproject.dbase.DatabaseHandler;
import com.rey.material.app.Dialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.app.SimpleDialog;
import com.rey.material.app.ThemeManager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class Settings extends Fragment implements View.OnClickListener {

    public Settings() {
        // Required empty public constructor
    }

    public LinearLayout hapusRiwayat,hapusProfil,eksporAktivitas,rating,kritikSaran,bantuan,tentang;
    private MainActivity mainActivity;

    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        hapusRiwayat = (LinearLayout) v.findViewById(R.id.hapus_riwayat);
        hapusProfil = (LinearLayout) v.findViewById(R.id.hapus_profil);
        eksporAktivitas = (LinearLayout) v.findViewById(R.id.ekspor_aktivitas);
        kritikSaran = (LinearLayout) v.findViewById(R.id.kritik_saran);
        rating = (LinearLayout) v.findViewById(R.id.beri_rating);
        bantuan = (LinearLayout) v.findViewById(R.id.bantuan);
        tentang = (LinearLayout) v.findViewById(R.id.tentang);
        mainActivity = (MainActivity)getActivity();
        hapusRiwayat.setOnClickListener(this);
        hapusProfil.setOnClickListener(this);
        eksporAktivitas.setOnClickListener(this);
        kritikSaran.setOnClickListener(this);
        rating.setOnClickListener(this);
        bantuan.setOnClickListener(this);
        tentang.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        final DatabaseHandler dbase = new DatabaseHandler(getActivity());
        Dialog.Builder builder = null;
        boolean isLightTheme = ThemeManager.getInstance().getCurrentTheme() == 0;

        switch (v.getId()){
            case R.id.hapus_riwayat:
                builder = new SimpleDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_Simple_Light : R.style.Material_App_Dialog_Simple){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        dbase.hapusDBaseBeratIdeal();
                        Toast.makeText(getActivity(), "Riwayat berat behasil dihapus!",
                                Toast.LENGTH_LONG).show();
                        super.onPositiveActionClicked(fragment);
                    }

                    @Override
                    public void onNegativeActionClicked(DialogFragment fragment) {
                        super.onNegativeActionClicked(fragment);
                    }
                };

                ((SimpleDialog.Builder)builder).message("Apa kamu yakin ingin menghapus riwayat berat?")
                        .positiveAction("Ya")
                        .negativeAction("Batal");
                DialogFragment fragmentResetDompet = DialogFragment.newInstance(builder);
                fragmentResetDompet.show(getFragmentManager(), null);
                break;
            case R.id.hapus_profil:
                builder = new SimpleDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_Simple_Light : R.style.Material_App_Dialog_Simple){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        dbase.hapusDBaseProfil();
                        Toast.makeText(getActivity(), "Profil berhasil dihapus, silahkan isi profil Anda kembali!",
                                Toast.LENGTH_LONG).show();
                        //getActivity().overridePendingTransition(0, 0);
                        //getActivity().recreate();
                        /*Intent intentBantuan = new Intent(getActivity(), MainActivity.class);
                        intentBantuan.putExtra("status", "hapus");
                        startActivity(intentBantuan);*/
                        super.onPositiveActionClicked(fragment);
                    }

                    @Override
                    public void onNegativeActionClicked(DialogFragment fragment) {
                        super.onNegativeActionClicked(fragment);
                    }
                };


                ((SimpleDialog.Builder)builder).message("Apa kamu yakin ingin menghapus profil?")
                        .positiveAction("Ya")
                        .negativeAction("Batal");
                DialogFragment fragmentProfil = DialogFragment.newInstance(builder);
                fragmentProfil.show(getFragmentManager(), null);
                break;
            case R.id.ekspor_aktivitas:
                builder = new SimpleDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_Simple_Light : R.style.Material_App_Dialog_Simple){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        super.onPositiveActionClicked(fragment);
                    }
                };
                ((SimpleDialog.Builder)builder).message("Mohon maaf, fitur ini belum terimplementasi. Mohon tunggu untuk update selanjutnya. Terimakasih")
                        .positiveAction("Ya");
                DialogFragment fragmentEkspor = DialogFragment.newInstance(builder);
                fragmentEkspor.show(getFragmentManager(), null);
                break;
            case R.id.beri_rating:
                builder = new SimpleDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_Simple_Light : R.style.Material_App_Dialog_Simple){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        super.onPositiveActionClicked(fragment);
                    }
                };
                ((SimpleDialog.Builder)builder).message("Mohon maaf, fitur ini belum terimplementasi. Mohon tunggu untuk update selanjutnya. Terimakasih")
                        .positiveAction("Ya");
                DialogFragment fragmentRating = DialogFragment.newInstance(builder);
                fragmentRating.show(getFragmentManager(), null);
                break;
            case R.id.kritik_saran:
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "ctproject.developers@gmail.com" });
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback Berat Idealmu");
                Email.putExtra(Intent.EXTRA_TEXT, "[Pesan & Saran] ");
                startActivity(Intent.createChooser(Email, "Kirim Saran:"));
                break;
            case R.id.bantuan:
                /*Intent intentBantuan = new Intent(getActivity(), DompetIntentActivity.class);
                intentBantuan.putExtra("status", "bantuan");
                startActivity(intentBantuan);*/
                builder = new SimpleDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_Simple_Light : R.style.Material_App_Dialog_Simple){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        super.onPositiveActionClicked(fragment);
                    }
                };
                ((SimpleDialog.Builder)builder).message("Berat Idealmu adalah aplikasi untuk mengukur berat ideal dan juga mendukung program diet sehat.")
                        .positiveAction("Ya");
                DialogFragment fragmentBantuan = DialogFragment.newInstance(builder);
                fragmentBantuan.show(getFragmentManager(), null);
                break;
            case R.id.tentang:
                builder = new SimpleDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_Simple_Light : R.style.Material_App_Dialog_Simple){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        super.onPositiveActionClicked(fragment);
                    }
                };
                ((SimpleDialog.Builder)builder).message("Aplikasi ini dibuat oleh Farhan Yuda Pahlevi, seorang programmer di <CTProject/>. Terima kasih dikhususkan kepada seseorang yang spesial, AAR13")
                        .positiveAction("Ya");
                DialogFragment fragmentTentang = DialogFragment.newInstance(builder);
                fragmentTentang.show(getFragmentManager(), null);
                break;
        }
    }

}
