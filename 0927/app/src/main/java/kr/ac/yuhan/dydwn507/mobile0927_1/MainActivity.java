package kr.ac.yuhan.dydwn507.mobile0927_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1 = findViewById(R.id.Text1);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/NanumGoDigANiGoGoDing.ttf");
        t1.setTypeface(tf);
    }
}