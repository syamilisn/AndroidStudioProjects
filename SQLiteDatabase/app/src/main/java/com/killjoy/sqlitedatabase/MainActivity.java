package com.killjoy.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name, clg;
    MyCoreDatabase myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.edit1);
        clg=(EditText)findViewById(R.id.edit2);
        myData= new MyCoreDatabase((this));
    }

    public void doSave(View view) {
        myData.insertData(name.getText().toString(),clg.getText().toString());
    }

    public void doLoad(View view) {
        myData.getAll();
    }
}