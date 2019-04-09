package com.appshop162.dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimeFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK, this, hours, minutes, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        ((SecondActivity)getActivity()).textTime.setText(buildTimeString(hourOfDay, minute));
    }

    private String buildTimeString(int hourOfDay, int minute) {
        String hoursS = "";
        if (hourOfDay < 10) hoursS += "0";
        hoursS += hourOfDay;
        String minuteS = "";
        if (minute < 10) minuteS += "0";
        minuteS += minute;
        String result = hoursS + ":" + minuteS;
        return result;
    }
}
