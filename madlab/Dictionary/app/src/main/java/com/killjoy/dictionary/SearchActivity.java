package com.killjoy.dictionary;

import androidx.appcompat.app.AppCompatActivity;

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
    TextView text1,dummytext;
    Button bn1;
    String aWord,aMeaning;
    String regularExpression = "^[A-Za-z]{3,20}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        edit1=(EditText)findViewById(R.id.ed1);
        text1=(TextView)findViewById(R.id.txt1);
        dummytext=(TextView)findViewById(R.id.dummy);
        bn1=(Button)findViewById(R.id.b1);
        bn1.setOnClickListener(this);
        Bundle bundle=getIntent().getBundleExtra("data");
        aWord=bundle.getString("word");
        dummytext.setText(aWord);
        //dummytext.setVisibility(View.GONE);
        //edit1.setVisibility(View.VISIBLE);
        //editText.setText(edititemname);
    }

    @Override
    public void onClick(View v) {
        String searchWord;

            if (aWord.isEmpty())
                searchWord = edit1.getText().toString();
            else {
                searchWord = aWord;
                aWord = "";
            }
        if(validWord(searchWord)) {
            aMeaning = searchFunc(searchWord);
            text1.setText(searchWord);
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
    public String searchFunc(String searchWord){
        return searchWord;
    }

}