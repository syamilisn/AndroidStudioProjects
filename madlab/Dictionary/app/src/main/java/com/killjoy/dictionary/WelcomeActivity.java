package com.killjoy.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{

    EditText edit1;
    Button bn1,bn2;
    String regularExpression = "^[A-Za-z]{3,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        edit1=(EditText)findViewById(R.id.ed1);
        bn1=(Button)findViewById(R.id.b1);
        bn2=(Button)findViewById(R.id.b2);
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String word = edit1.getText().toString();
        if(validWord(word)) {
            Bundle bundle = new Bundle();
            bundle.putString("word", word);
            if(v.getId()==R.id.b1)
                doSearch(v);
            else if(v.getId()==R.id.b2)
                doAdd(v);
            //Intent it = new Intent(this, SearchActivity.class);
            //it.putExtra("data", bundle);
            //startActivity(it);
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
    public void doSearch(View view){
        Intent it = new Intent(this, SearchActivity.class);
        startActivity(it);
    }
    public void doAdd(View view){
        Intent it = new Intent(this, AddActivity.class);
        startActivity(it);

    }
}