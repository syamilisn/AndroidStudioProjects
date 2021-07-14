package com.killjoy.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit1,edit2;
    Button bn1;
    String aMeaning;
    String regularExpression = "^[A-Za-z]{3,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edit1 = (EditText)findViewById(R.id.ed1);
        edit2 = (EditText)findViewById(R.id.ed2);
        bn1 = (Button)findViewById(R.id.b1);
        bn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String addWord;
        addWord = edit1.getText().toString();


        if(validWord(addWord)) {
            aMeaning = edit2.getText().toString();
            //add addWord, aMeaning to dictionary
            Toast.makeText(getBaseContext(), "Word Added", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(getBaseContext(), "Invalid Word", Toast.LENGTH_LONG).show();

    }
    public boolean validWord(String password)
    {
        Pattern pattern= Pattern.compile(regularExpression);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }


}