package com.killjoy.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit1;
    TextView text1;
    Button bn1;
    String aMeaning;
    String regularExpression = "[A-Za-z]+";
    Database myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        edit1=(EditText)findViewById(R.id.ed1);
        text1=(TextView)findViewById(R.id.txt1);
        bn1=(Button)findViewById(R.id.b1);
        bn1.setOnClickListener(this);
        myData = new Database(this);
    }

    @Override
    public void onClick(View v) {
        String searchWord;
        searchWord = edit1.getText().toString();


        if(validWord(searchWord)) {
            aMeaning = doLoad(v,searchWord);
            text1.setText(aMeaning);
        }
        else
            Toast.makeText(getBaseContext(), "Invalid Word", Toast.LENGTH_LONG).show();

    }
    public boolean validWord(String correctWord)
    {
        Pattern pattern= Pattern.compile(regularExpression);
        Matcher matcher=pattern.matcher(correctWord);
        return matcher.matches();
    }

    public String searchFunc(String searchWord){
        /*
        String arr[] = getResources().getStringArray(R.array.planet);
        for (int i = 0; i < arr.length; i++) {
            Toast.makeText(getBaseContext(),arr[i], Toast.LENGTH_LONG).show();
        }
        */
        String meaning = myData.getMeaning(searchWord);
        return meaning;
    }
    /*
    public void doLoad(View view) {
        myData.getAll();
        */

    public String doLoad(View view, String searchWord){
        String meaning = myData.getMeaning(searchWord);
        return meaning;
    }
}