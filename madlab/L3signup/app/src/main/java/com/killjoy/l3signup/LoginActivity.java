package com.killjoy.l3signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText usertxt, passtxt;
    Button bnlogin;
    String user,pass;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usertxt=(EditText)findViewById(R.id.ed1);
        passtxt=(EditText)findViewById(R.id.ed2);
        bnlogin=(Button)findViewById(R.id.b1);
        bnlogin.setOnClickListener(this);
        //DETAILS ENTERED EARLIER DURING SIGNUP are stored in user, pass
        //bundle fetches the DATA
        Bundle bundle=getIntent().getBundleExtra("data");
        user=bundle.getString("user");
        pass=bundle.getString("Lab@2018");
    }

    @Override
    public void onClick(View v) {
        //DETAILS ENTERED EARLIER DURING LOGIN are stored in username, password
        String username=usertxt.getText().toString();
        String password=passtxt.getText().toString();
        if(user.equals(username)&&pass.equals(password))
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();

        else {
            count++;
            if (count == 3) {
                bnlogin.setEnabled(false);
                Toast.makeText(this, "Failed Login Attempts", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Login Failed " + count, Toast.LENGTH_LONG).show();
            }
        }

    }
}