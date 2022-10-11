package kr.ac.yuhan.dydwn507.mobile0927_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculator extends AppCompatActivity {

    EditText edit1, edit2;
    TextView text_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        text_result = (TextView) findViewById(R.id.text_result);

        int[] btnIds = {R.id.btn_plus, R.id.btn_minus, R.id.btn_multi, R.id.btn_divide, R.id.btn_mod};
        Button[] btns = new Button[btnIds.length];
        for (int i = 0; i < btns.length; i++) {
            btns[i] = findViewById(btnIds[i]);
            btns[i].setOnClickListener(btnListener);
        }
    }


    View.OnClickListener btnListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            String str1 = edit1.getText().toString();
            String str2 = edit2.getText().toString();
            if(str1.equals("")||str2.equals("")){
                Toast.makeText(calculator.this, "계산을 위해 값을 입력하세요", Toast.LENGTH_SHORT).show();
                return;
            }
            double n1 = Double.parseDouble(str1);
            double n2 = Double.parseDouble(str2);
            double result = 0;
            switch (view.getId()) {
                case R.id.btn_plus:
                    result = n1 + n2;
                    break;
                case R.id.btn_minus:
                    result = n1 - n2;
                    break;
                case R.id.btn_multi:
                    result = n1 * n2;
                    break;
                case R.id.btn_divide:
                    if(n2==0)
                        Toast.makeText(calculator.this, "0으로 나누면 안됩니다.",Toast.LENGTH_SHORT).show();
                    result = n1 / n2;
                    break;
                case R.id.btn_mod:
                    result = n1 % n2;
                    break;

            }
            text_result.setText(R.string.text_result);
            text_result.append(String.format("%.2f",result));
        }
    };
}


























