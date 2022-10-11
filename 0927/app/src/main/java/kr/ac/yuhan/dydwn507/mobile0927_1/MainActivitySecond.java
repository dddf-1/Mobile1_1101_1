package kr.ac.yuhan.dydwn507.mobile0927_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t2);
        TextView t3 = findViewById(R.id.t3);

        t1.setTextColor(Color.rgb(255,0,0));
        t1.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
        t2.setTextSize(30);
        t2.setText("유한대학교");
        t3.setText("모바일프로그래밍컴퓨터소프트웨어공학과모바일프로그래밍컴퓨터소프트웨어공학과모바일프로그래밍컴퓨터소프트웨어공학과");
        t3.setSingleLine(true);
    }
}