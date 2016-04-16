package com.ctproject.fragments;

/**
 * Created by farhan on 9/10/15.
 */
import com.ctproject.beratidealmu.R;

import com.rey.material.app.Dialog;
import com.rey.material.app.DialogFragment;
import com.rey.material.app.SimpleDialog;
import com.rey.material.app.ThemeManager;
import com.rey.material.app.TimePickerDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Reminder extends Fragment implements View.OnClickListener {

    public LinearLayout makanPagi, makanSiang, makanMalam;
    public TextView statusPagi, statusSiang, statusMalam, textPagi, textSiang, textMalam;
    private Locale indo = new Locale("id-ID");

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_reminder, container, false);
        setHasOptionsMenu(true);

        final Date date = new Date();

        makanPagi = (LinearLayout) v.findViewById(R.id.alarmPagi);
        makanSiang = (LinearLayout) v.findViewById(R.id.alarmSiang);
        makanMalam = (LinearLayout) v.findViewById(R.id.alarmMalam);
        statusPagi = (TextView) v.findViewById(R.id.statusPagi);
        statusSiang = (TextView) v.findViewById(R.id.statusSiang);
        statusMalam = (TextView) v.findViewById(R.id.statusMalam);
        textPagi = (TextView) v.findViewById(R.id.textPagi);
        textSiang = (TextView) v.findViewById(R.id.textSiang);
        textMalam = (TextView) v.findViewById(R.id.textMalam);
        makanPagi.setOnClickListener(this);
        makanSiang.setOnClickListener(this);
        makanMalam.setOnClickListener(this);
        statusPagi.setText("Non Aktif");
        statusSiang.setText("Non Aktif");
        statusMalam.setText("Non Aktif");

        return v;
    }

    @Override
    public void onClick(View v) {
        Dialog.Builder builder = null;
        boolean isLightTheme = ThemeManager.getInstance().getCurrentTheme() == 0;

        switch (v.getId()){
            case R.id.alarmPagi:
                builder = new TimePickerDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_TimePicker_Light : R.style.Material_App_Dialog_TimePicker, 24, 00){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        TimePickerDialog dialog = (TimePickerDialog)fragment.getDialog();
                        textPagi.setText(dialog.getFormattedTime(DateFormat.getTimeInstance(DateFormat.SHORT, indo)) + " WIB");
                        super.onPositiveActionClicked(fragment);
                    }

                    @Override
                    public void onNegativeActionClicked(DialogFragment fragment) {
                        super.onNegativeActionClicked(fragment);
                    }
                };

                builder.positiveAction("Ya")
                        .negativeAction("Batal");
                break;
            case R.id.alarmSiang:
                builder = new TimePickerDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_TimePicker_Light : R.style.Material_App_Dialog_TimePicker, 24, 00){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        TimePickerDialog dialog = (TimePickerDialog)fragment.getDialog();
                        textSiang.setText(dialog.getFormattedTime(DateFormat.getTimeInstance(DateFormat.SHORT, indo)) + " WIB");
                        super.onPositiveActionClicked(fragment);
                    }

                    @Override
                    public void onNegativeActionClicked(DialogFragment fragment) {
                        super.onNegativeActionClicked(fragment);
                    }
                };

                builder.positiveAction("Ya")
                        .negativeAction("Batal");
                break;
            case R.id.alarmMalam:
                builder = new TimePickerDialog.Builder(isLightTheme ? R.style.Material_App_Dialog_TimePicker_Light : R.style.Material_App_Dialog_TimePicker, 24, 00){
                    @Override
                    public void onPositiveActionClicked(DialogFragment fragment) {
                        TimePickerDialog dialog = (TimePickerDialog)fragment.getDialog();
                        textMalam.setText(dialog.getFormattedTime(DateFormat.getTimeInstance(DateFormat.SHORT, indo)) + " WIB");
                        super.onPositiveActionClicked(fragment);
                    }

                    @Override
                    public void onNegativeActionClicked(DialogFragment fragment) {
                        super.onNegativeActionClicked(fragment);
                    }
                };

                builder.positiveAction("Ya")
                        .negativeAction("Batal");
                break;
        }
        DialogFragment fragment = DialogFragment.newInstance(builder);
        fragment.show(getFragmentManager(), null);

    }


}