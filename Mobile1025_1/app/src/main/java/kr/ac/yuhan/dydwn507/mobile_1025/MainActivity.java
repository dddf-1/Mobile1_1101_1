package kr.ac.yuhan.dydwn507.mobile_1025;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int [] btnId = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    Button[] btns;
    EditText edit1, edit2;
    String n1, n2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);


        for (int i=0;i<btns.length; i++){
            final int index = i;
            btns[index] = findViewById(btnId[index]);
            btns[index].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){
                    InputMethodManager manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                    if(edit1.isFocused()){
                        n1 = edit1.getText().toString() + btns[index].getText().toString();
                        edit1.setText(n1);
                    }else if(edit2.isFocused()){
                        n2 = edit2.getText().toString() + btns[index].getText().toString();
                        edit2.setText(n2);
                    }else {
                        Toast.makeText(getApplicationContext(),"edit1 또는 edit2 선택하고 숫자버튼 클릭하세요!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}









