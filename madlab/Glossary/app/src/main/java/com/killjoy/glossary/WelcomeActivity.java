package com.killjoy.glossary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button bn1,bn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        bn1=(Button)findViewById(R.id.b1);
        bn2=(Button)findViewById(R.id.b2);
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it;
        if(v.getId() == R.id.b1) {
            it = new Intent(this, SearchActivity.class);
            startActivity(it);
        }
        else if(v.getId() == R.id.b2){
            it = new Intent(this, AddActivity.class);
            startActivity(it);
        }
        else{
            Toast.makeText(getBaseContext(),"Error loading page",Toast.LENGTH_LONG).show();
        }
    }
}