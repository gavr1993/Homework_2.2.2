package com.example.homework_222;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.GregorianCalendar;

public class PlanActivity extends AppCompatActivity {

    private Button ChooseStartDate;
    private Button ChooseEndDate;
    private CalendarView StartDateCalendar;
    private CalendarView EndDateCalendar;
    private Button okBtn;
    private long StartDate;
    private String StartDateTxt;
    private long EndDate;
    private String EndDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        init();
        calendarsShow();
        saveDates();
        okListen();
    }

    private void init() {
        ChooseStartDate = findViewById(R.id.chooseStartDate);
        ChooseEndDate = findViewById(R.id.chooseEndDate);
        StartDateCalendar = findViewById(R.id.startDateCalendar);
        EndDateCalendar = findViewById(R.id.endtDateCalendar);
        okBtn = findViewById(R.id.okBtn);
        StartDateCalendar.setVisibility(View.GONE);
        EndDateCalendar.setVisibility(View.GONE);
    }

    private void calendarsShow() {
        ChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartDateCalendar.setVisibility(View.VISIBLE);
                EndDateCalendar.setVisibility(View.GONE);
            }
        });

        ChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EndDateCalendar.setVisibility(View.VISIBLE);
                StartDateCalendar.setVisibility(View.GONE);
            }
        });
    }

    private void saveDates() {
        StartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                StartDateTxt = i + "-" + i1+  "-" + i2;
                ChooseStartDate.setText(getString(R.string.startTime) + StartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i2, i1+1, i);
                StartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        EndDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                EndDateTxt = i + "-" + i1 + "-" + i2;
                ChooseEndDate.setText(getString(R.string.endTime) + EndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i2, i1+1, i);
                EndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });
    }

    private void okListen() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (StartDate > EndDate) {
                    Toast.makeText(com.example.homework_222.PlanActivity.this, R.string.Error, Toast.LENGTH_LONG).show();
                    ChooseStartDate.setText(R.string.startTime);
                    ChooseEndDate.setText(R.string.endTime);
                } else {
                    Toast.makeText(com.example.homework_222.PlanActivity.this, getString(R.string.start) + StartDateTxt + ", " +  getString(R.string.finish) + EndDateTxt, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
