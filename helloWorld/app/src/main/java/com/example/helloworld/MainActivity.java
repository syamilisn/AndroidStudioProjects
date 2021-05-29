package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button b0, b1, b2, b3, b4, b5, b6,
            b7, b8, b9, bAdd, bSub, bDiv,
            bMul, bDot, bC, bEqu;
    EditText resultBox;
    float num1, num2;
    boolean boolAdd, boolSub, boolMul, boolDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        bDot = (Button) findViewById(R.id.bDot);
        bAdd = (Button) findViewById(R.id.bAdd);
        bSub = (Button) findViewById(R.id.bSub);
        bMul = (Button) findViewById(R.id.bMul);
        bDiv = (Button) findViewById(R.id.bDiv);
        bC = (Button) findViewById(R.id.bC);
        bEqu = (Button) findViewById(R.id.bEqu);
        resultBox = (EditText) findViewById(R.id.resultBox);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resultBox.setText(resultBox.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + "0");
            }
        });

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (resultBox == null) {
                    resultBox.setText("");
                }
                else {
                    num1 = Float.parseFloat(resultBox.getText() + "");
                    boolAdd = true;
                    resultBox.setText(null);
                }
            }
        });

        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(resultBox.getText() + "");
                boolSub = true;
                resultBox.setText(null);
            }
        });

        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(resultBox.getText() + "");
                boolMul = true;
                resultBox.setText(null);
            }
        });

        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(resultBox.getText() + "");
                boolDiv = true;
                resultBox.setText(null);
            }
        });

        bEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Float.parseFloat(resultBox.getText() + "");

                if (boolAdd == true) {
                    resultBox.setText(num1 + num2 + "");
                    boolAdd = false;
                }

                if (boolSub == true) {
                    resultBox.setText(num1 - num2 + "");
                    boolSub = false;
                }

                if (boolMul == true) {
                    resultBox.setText(num1 * num2 + "");
                    boolMul = false;
                }

                if (boolDiv == true) {
                    resultBox.setText(num1 / num2 + "");
                    boolDiv = false;
                }
            }
        });

        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText("");
            }
        });

        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultBox.setText(resultBox.getText() + ".");
            }
        });


    }
}