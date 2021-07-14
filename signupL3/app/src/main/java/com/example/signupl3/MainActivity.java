package com.example.signupl3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtuser, txtpass;
    Button btnsignup;
    String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtuser=(EditText)findViewById(R.id.usernameip);
        txtpass=(EditText)findViewById(R.id.passwordip);
        btnsignup=(Button)findViewById(R.id.Bsignup);
        btnsignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user=txtuser.getText().toString();
        String pass=txtpass.getText().toString();
        if(validatePassword(pass)){
            Bundle bundle= new Bundle();
            bundle.putString("User",user);
            bundle.putString("Passcode",pass);

            Intent it = new Intent(this, LoginActivity.class);
            it.putExtra("data", bundle);
            startActivity(it);
        }

    }
    public boolean validatePassword(String pass){
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();

    }
}