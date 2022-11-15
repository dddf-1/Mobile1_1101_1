package kr.ac.yuhan.jhhim99.moblie_1108_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    CalendarView calender;
    TimePicker timePick;
    Chronometer chro;
    int year ,month, day;
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
        calender = findViewById(R.id.calender);
        timePick = findViewById(R.id.time_pick);
        rg.setOnCheckedChangeListener(rgL);
        chro =findViewById(R.id.chro);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnDone = findViewById(R.id.btn_done);
        btnStart.setOnClickListener(btnL);
        btnDone.setOnClickListener(btnL);
        textResult =findViewById(R.id.text_result);

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                year = y;
                month = m+1;
                day = d;

            }
        });

    }



    View.OnClickListener btnL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_start:
                    chro.setBase(SystemClock.elapsedRealtime());
                    chro.start();
                    chro.setTextColor(Color.RED);
                    break;
                case R.id.btn_done:
                    chro.stop();
                    chro.setTextColor(Color.BLUE);
                    textResult.setText(year +"년"+month+"월" +day+ "일");
                    textResult.append(timePick.getCurrentHour()+"시"+timePick.getCurrentMinute()+"분 예약 완료함");
                    break;
            }
        }
    };
    RadioGroup.OnCheckedChangeListener rgL = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int rbId) {
            calender.setVisibility(View.INVISIBLE);
            timePick.setVisibility(View.INVISIBLE);
            switch (rbId){
                case R.id.rb_date:
                    calender.setVisibility(View.VISIBLE);
                    break;
                case R.id.rb_time:
                    timePick.setVisibility(View.VISIBLE);
                    break;
            }

        }
    };
}