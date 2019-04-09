package com.appshop162.dialogs;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView seekBarValue;
    int min = 0, max = 100, current = 50;
    public TextView textTime, textDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBarValue = (TextView) findViewById(R.id.seekBar_value);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar.setMin(min);
            seekBar.setMax(max);
            seekBar.setProgress(current);
            seekBarValue.setText(String.valueOf(current));
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    current = progress;
                    seekBarValue.setText(String.valueOf(current));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }

        textDate = (TextView) findViewById(R.id.text_date);
        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFragment dateFragment = new DateFragment();
                dateFragment.show(getSupportFragmentManager(), "DateFragment");
            }
        });

        textTime = (TextView) findViewById(R.id.text_time);
        textTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeFragment timeFragment = new TimeFragment();
                timeFragment.show(getSupportFragmentManager(), "TimeFragment");
            }
        });
    }
}
