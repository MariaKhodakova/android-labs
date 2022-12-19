package com.example.myapplication2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int j = 0;
    int jz = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final TextView text = findViewById(R.id.text1);
        final TextView text2 = findViewById(R.id.text2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            j++;
            button1.setText("НАЖАТА");
            text.setText(Integer.toString(j));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jz++;
                button2.setText("PRESSED");
                text2.setText(Integer.toString(jz));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jz=0;
                j=0;
                text.setText(Integer.toString(j));
                text2.setText(Integer.toString(jz));
            }
        });

    }
}