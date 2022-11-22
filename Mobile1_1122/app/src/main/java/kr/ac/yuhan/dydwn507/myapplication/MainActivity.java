package kr.ac.yuhan.dydwn507.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoText = findViewById(R.id.auto_text);
        MultiAutoCompleteTextView multiText = findViewById(R.id.multi_text);

        String[] items = {"app", "apple","apartment", "bullet","burn","band","corruption","conserve","capture","drop","duration","deposit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        autoText.setAdapter(adapter);

        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multiText.setTokenizer(token);
        multiText.setAdapter(adapter);
    }
}