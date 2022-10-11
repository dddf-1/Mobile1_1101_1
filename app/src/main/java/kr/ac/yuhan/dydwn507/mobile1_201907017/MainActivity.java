package kr.ac.yuhan.dydwn507.mobile1_201907017;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// 객체생성,  root 레이아웃 설정
        
        Button btnHome = findViewById(R.id.btn_home);
        Button btnCall = findViewById(R.id.btn_call);
        Button btnGallery = findViewById(R.id.btn_gallery);
        Button btnFinish = findViewById(R.id.btn_finish);

        btnHome.setOnClickListener(btnListener);
        btnCall.setOnClickListener(btnListener);
        btnGallery.setOnClickListener(btnListener);
        btnFinish.setOnClickListener(btnListener);
    }//end oncreate()

    View.OnClickListener btnListener = new View.OnClickListener() { //객체생성 리스너의 역할: 감시자 역할
        @Override
        public void onClick(View view) { // view자리 -> 이벤트가 발생된 참조값이 입력
            Intent intent = null;
            Uri uri = null;      //참조변수 2개 선언
            switch (view.getId()){
                case R.id.btn_home:
                    uri = Uri.parse("http://m.daum.net");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    break;
                case R.id.btn_call:
                    uri = Uri.parse("tel:/010-2877-3145");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    break;
                case R.id.btn_gallery:
                    uri = Uri.parse("content://media/internal/images/media");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    break;
                case R.id.btn_finish:
                    finish();
                    break;
            }
        }
    };


}