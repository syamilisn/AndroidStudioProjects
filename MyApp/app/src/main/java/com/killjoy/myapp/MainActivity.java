package com.killjoy.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(EditText)findViewById(R.id.searchbox1);
        t2=(TextView)findViewById(R.id.display2);
    }


    public void searchWord(View v){
        if(t1.getText().toString().equals("apple")){
            t2.setText("Apple is a fruit.");
        }
        else
            t2.setText("Word not found");
    }
}