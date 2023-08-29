package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.dataET);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();

                SharedPreferences shrd = getSharedPreferences("allData",MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();
                editor.putString("name",data);
                editor.apply();
                textView.setText(data);
            }
        });

        SharedPreferences getshrd = getSharedPreferences("allData",MODE_PRIVATE);
        String mydata = getshrd.getString("name","No Previous Value");
        textView.setText(mydata);
    }
}