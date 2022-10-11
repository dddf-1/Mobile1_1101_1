package kr.ac.yuhan.dydwn507.mobile1011_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    CheckBox checkStart;
    RadioGroup rg;
    ImageView imgv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linear = findViewById(R.id.linear); //findViewById 이거 시험에 나옴
        rg = findViewById(R.id.rg);
        imgv = findViewById(R.id.imgV);
        checkStart = findViewById(R.id.check_start);
        checkStart.setOnCheckedChangeListener(checkL);
        Button btnDone = findViewById(R.id.btn_done);
        btnDone.setOnClickListener(btnL);


    }
    View.OnClickListener btnL = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch(rg.getCheckedRadioButtonId()){
                case R.id.rd1:
                    imgv.setImageResource(R.drawable.dog);
                    break;
                case R.id.rd2:
                    imgv.setImageResource(R.drawable.cat);
                    break;
                case R.id.rd3:
                    imgv.setImageResource(R.drawable.rabbit);
                    break;
            }
        }
    };



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