package kr.ac.yuhan.dydwn507.mobile1011_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    CheckBox checkStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = findViewById(R.id.linear); //findViewById 이거 시험에 나옴
        checkStart = findViewById(R.id.check_start);
        checkStart.setOnCheckedChangeListener(checkL);

    }
    CompoundButton.OnCheckedChangeListener checkL = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) { //boolean b 체크된 상태
            if(isCheck)
                linear.setVisibility(View.VISIBLE);
            else
                linear.setVisibility(View.INVISIBLE);

        }
    };
}