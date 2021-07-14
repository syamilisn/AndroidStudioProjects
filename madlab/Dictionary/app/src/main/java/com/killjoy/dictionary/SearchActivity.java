package com.killjoy.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    EditText edit1;
    Button bn1;
    String searchWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        edit1=(EditText)findViewById(R.id.ed1);
        bn1=(Button)findViewById(R.id.b1);
    }
}