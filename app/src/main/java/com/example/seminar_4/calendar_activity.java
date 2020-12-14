package com.example.seminar_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calendar_activity extends AppCompatActivity {

    private CalendarView calendar;
    private  String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_activity);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String param7 = extras.getString("param7");

        calendar = (CalendarView)findViewById(R.id.cv_calendar);
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Calendar.getInstance().getTime().setMonth(Calendar.getInstance().getTime().getMonth() +1);
        date = df.format(Calendar.getInstance().getTime()).toString();
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = dayOfMonth + "-"+ (month+1) + '-' + year;
            }
        });

        Toast.makeText(this, param7, Toast.LENGTH_LONG).show();

    }


    public void returnToMainActivityFromCalendar(View view)
    {

        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("param7", "Data coming from the calendar!");
        bundle.putString("param8", date);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}