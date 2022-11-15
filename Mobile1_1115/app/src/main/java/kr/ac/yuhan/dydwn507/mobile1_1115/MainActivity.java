package kr.ac.yuhan.dydwn507.mobile1_1115;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import kr.ac.yuhan.dydwn507.mobile1_1115.R;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    DatePicker calendar;
    TimePicker timePick;
    Chronometer Chrono;
    int year,month,day;
    TextView textResult;
    FrameLayout frame;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        calendar = findViewById(R.id.calender);
        timePick = findViewById(R.id.timepick);
        Chrono = findViewById(R.id.chrono);
        textResult = findViewById(R.id.text_result);
        frame = findViewById(R.id.fram1);

        Chrono.setOnClickListener(chronoL);

        rg.setOnCheckedChangeListener(rgL);
        /*
        Button btnStart = findViewById(R.id.btn_start);
        Button btnDone = findViewById(R.id.btn_done);

        btnStart.setOnClickListener(btnL);
        btnDone.setOnClickListener(btnL);
        */
        calendar.setOnDateChangedListener(calendarL);

        textResult.setOnLongClickListener(textL);

        /*
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                year = y;
                month = m+1;
                day = d;

            }
        });*/

    }

    View.OnClickListener chronoL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Chrono.setBase(SystemClock.elapsedRealtime());
            Chrono.start();
            Chrono.setTextColor(Color.RED);
            rg.setVisibility(View.VISIBLE);
            frame.setVisibility(View.VISIBLE);
            calendar.setVisibility(View.INVISIBLE);
            timePick.setVisibility(View.INVISIBLE);
        }
    };


    View.OnLongClickListener textL = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            Chrono.stop();
            Chrono.setTextColor(Color.BLUE);
            textResult.setText(year+"년 "+month+"월 "+day+"일 ");
            textResult.append(timePick.getCurrentHour()+"시 ");
            textResult.append(timePick.getCurrentMinute()+"분 ");
            textResult.append("예약 완료됨");
            return false;
        }
    };

    DatePicker.OnDateChangedListener calendarL = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
            MainActivity.this.year = year;
            MainActivity.this.month = month + 1;
            MainActivity.this.day = day;


        }
    };


/*
    View.OnClickListener btnL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_start:
                    Chrono.setBase(SystemClock.elapsedRealtime());
                    Chrono.start();
                    Chrono.setTextColor(Color.RED);
                    break;
                case R.id.btn_done:
                    Chrono.stop();
                    Chrono.setTextColor(Color.BLUE);
                    textResult.setText(year +"년"+month+"월" +day+ "일");
                    textResult.append(timePick.getCurrentHour()+"시"+timePick.getCurrentMinute()+"분 예약 완료함");
                    break;
            }
        }
    };
 */
    RadioGroup.OnCheckedChangeListener rgL = new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedRadioId) {
        calendar.setVisibility(View.INVISIBLE);
        timePick.setVisibility(View.INVISIBLE);
        switch (checkedRadioId){
            case R.id.radio_date:
                calendar.setVisibility(View.VISIBLE);
                break;
            case R.id.radio_time:
                timePick.setVisibility(View.VISIBLE);
                break;
        }

    }
};
}