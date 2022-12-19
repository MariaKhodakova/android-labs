package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyArrayList extends AppCompatActivity implements View.OnClickListener{

    EditText edittext1;
    TextView textView1;
    Button Button, exite;
    ListView textList;
    ArrayList<String> myStringArray;
    ArrayAdapter<String> TextAdapter;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_list_activity);

        Button = findViewById(R.id.button1);
        edittext1 = findViewById(R.id.editTextTextPersonName);
        textView1 = (TextView)findViewById(R.id.textView);
        textList = findViewById(R.id.textList);
        myStringArray = new ArrayList<String>();
        TextAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);

        exite = findViewById(R.id.button);
        exite.setOnClickListener(this);

        String email = getIntent().getStringExtra("e");
        textView1.setText(textView1.getText().toString() + " " + email);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = edittext1.getText().toString();
                myStringArray.add(e);
                textList.setAdapter(TextAdapter);
                TextAdapter.notifyDataSetChanged();
                edittext1.setText("");
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }

}