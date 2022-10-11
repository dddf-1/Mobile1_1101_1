package kr.ac.yuhan.dydwn507.mobile1_1004_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox c1 = findViewById(R.id.c1);
        CheckBox c2 = findViewById(R.id.c2);
        CheckBox c3 = findViewById(R.id.c3);

        c1.setOnCheckedChangeListener(checkL);
        c2.setOnCheckedChangeListener(checkL);
        c3.setOnCheckedChangeListener(checkL);

        RadioGroup rg = findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                String gender = "";
                switch(id){
                    case R.id.rb1:
                        gender = "남자";
                        break;
                    case R.id.rb2:
                        gender = "여자";
                        break;
                }
                Toast.makeText(MainActivity.this, gender+"가 선택되었습니다.", Toast.LENGTH_SHORT).show();

            }
        });

    }
    CompoundButton.OnCheckedChangeListener checkL = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            String name = compoundButton.getText().toString(); //문자열로 반환시켜서
            String state = "";
            if(b)
                state = "체크되었음";
            else
                state = "해제되었음";

            Toast.makeText(MainActivity.this, name+"이 "+state, Toast.LENGTH_SHORT).show();
        }
    };
}





















