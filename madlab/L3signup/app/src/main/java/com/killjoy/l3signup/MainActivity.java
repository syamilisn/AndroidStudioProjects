package com.killjoy.l3signup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText usertxt, passtxt;
    Button bnsignup;
    String regularExpression="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usertxt=(EditText)findViewById(R.id.ed1);
        passtxt=(EditText)findViewById(R.id.ed2);
        bnsignup=(Button)findViewById(R.id.b1);
        bnsignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username=usertxt.getText().toString();
        String password=passtxt.getText().toString();
        //Bundle is like small storage.
        if(validatePassword(password)) {
            Bundle bundle = new Bundle();
            bundle.putString("user", username);
            bundle.putString("Lab@2018", password);
            //Intent: passive data structure that carries information from one Activity to another
            Intent it = new Intent(this, LoginActivity.class);
            it.putExtra("data", bundle);
            startActivity(it);
        }
        else
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
    }

    public boolean validatePassword(String password)
    {
        Pattern pattern= Pattern.compile(regularExpression);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}
