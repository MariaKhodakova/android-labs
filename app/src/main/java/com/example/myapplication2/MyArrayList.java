package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.*;

public class MyArrayList extends AppCompatActivity {

    EditText edittext1;
    Button Button,delete;
    ListView textList;
    ArrayList<String> myStringArray;
    ArrayAdapter<String> TextAdapter;
    String item;
    Integer indecxVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_list_activity);

        Button = findViewById(R.id.button1);
        delete=findViewById(R.id.button);
        edittext1 = findViewById(R.id.editTextTextPersonName);
        textList = findViewById(R.id.textList);
        myStringArray = new ArrayList<String>();
        TextAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = edittext1.getText().toString();
                myStringArray.add(e);
                textList.setAdapter(TextAdapter);
                TextAdapter.notifyDataSetChanged();
            }
         });

        //select item
        textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString()+"has been selected";
                indecxVal = i;
                Toast.makeText(MyArrayList.this, item, Toast.LENGTH_LONG).show();
            }
        });
        //кнопка очистить
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = edittext1.getText().toString();
                myStringArray.clear();
                textList.setAdapter(TextAdapter);
                TextAdapter.notifyDataSetChanged();
                myStringArray.remove(indecxVal);
                textList.setAdapter(TextAdapter);
                TextAdapter.notifyDataSetChanged();
            }
        });

    }

}