package com.appshop162.dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK, this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        ((SecondActivity)getActivity()).textDate.setText(buildDateString(dayOfMonth, month, year));
    }

    private String buildDateString(int dayOfMonth, int month, int year) {
        String dayS = "";
        if (dayOfMonth < 10) dayS += "0";
        dayS += dayOfMonth;
        String monthS = "";
        month++;
        if (month < 10) monthS += "0";
        monthS += month;
        String result = dayS + "." + monthS + "." + year;
        return result;
    }
}
