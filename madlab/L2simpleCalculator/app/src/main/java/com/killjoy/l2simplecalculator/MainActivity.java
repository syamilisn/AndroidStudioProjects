package com.killjoy.l2simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button bn1,bn2,bn3,bn4,bn5,bn6,bn7,bn8,bn9,bn0;
    Button bnadd,bnsub,bnmul,bndiv,bnequ,bnclr,bndot;
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn0=(Button)findViewById(R.id.b0);
        bn0.setOnClickListener(this);

        bn1=(Button)findViewById(R.id.b1);
        bn1.setOnClickListener(this);

        bn2=(Button)findViewById(R.id.b2);
        bn2.setOnClickListener(this);

        bn3=(Button)findViewById(R.id.b3);
        bn3.setOnClickListener(this);

        bn4=(Button)findViewById(R.id.b4);
        bn4.setOnClickListener((this));

        bn5=(Button)findViewById(R.id.b5);
        bn5.setOnClickListener(this);

        bn6=(Button)findViewById(R.id.b6);
        bn6.setOnClickListener(this);

        bn7=(Button)findViewById(R.id.b7);
        bn7.setOnClickListener(this);

        bn8=(Button)findViewById(R.id.b8);
        bn8.setOnClickListener(this);

        bn9=(Button)findViewById(R.id.b9);
        bn9.setOnClickListener((this));

        bnadd=(Button)findViewById(R.id.badd);
        bnadd.setOnClickListener(this);

        bnsub=(Button)findViewById(R.id.bsub);
        bnsub.setOnClickListener(this);

        bnmul=(Button)findViewById(R.id.bmul);
        bnmul.setOnClickListener(this);

        bndiv=(Button)findViewById(R.id.bdiv);
        bndiv.setOnClickListener(this);

        bnequ=(Button)findViewById(R.id.bequ);
        bnequ.setOnClickListener((this));

        bndot=(Button)findViewById(R.id.bdot);
        bndot.setOnClickListener((this));

        bnclr=(Button)findViewById(R.id.bclr);
        bnclr.setOnClickListener((this));

        result=(EditText)findViewById(R.id.ed1);
        result.setText("");
    }

    @Override
    public void onClick(View v) {
        if(v.equals(bn0)) result.append("0");
        if(v.equals(bn1)) result.append("1");
        if(v.equals(bn2)) result.append("2");
        if(v.equals(bn3)) result.append("3");
        if(v.equals(bn4)) result.append("4");
        if(v.equals(bn5)) result.append("5");
        if(v.equals(bn6)) result.append("6");
        if(v.equals(bn7)) result.append("7");
        if(v.equals(bn8)) result.append("8");
        if(v.equals(bn9)) result.append("9");
        if(v.equals(bndot)) result.append(".");
        if(v.equals(bnclr)) result.setText("");

        if(v.equals(bnequ)){
            try{
                String data = result.getText().toString();
                if(data.contains("/")){
                    String[] operands = data.split("/");
                    if(operands.length==2){
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double finResult = operand1/operand2;
                        result.setText((String.valueOf(finResult)));
                    }
                    else
                        //3 params: context, string, integer value
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();

                }
                else if(data.contains("*")){
                    String[] operands = data.split(Pattern.quote("*"));
                    if(operands.length==2){
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double finResult = operand1*operand2;
                        result.setText((String.valueOf(finResult)));
                    }
                    else
                        //3 params: context, string, integer value
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();

                }
                else if(data.contains("+")){
                    String[] operands = data.split(Pattern.quote("+"));
                    if(operands.length==2){
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double finResult = operand1+operand2;
                        result.setText((String.valueOf(finResult)));
                    }
                    else
                        //3 params: context, string, integer value
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();

                }
                else if(data.contains("-")){
                    String[] operands = data.split(Pattern.quote("-"));
                    if(operands.length==2){
                        double operand1 = Double.parseDouble(operands[0]);
                        double operand2 = Double.parseDouble(operands[1]);
                        double finResult = operand1-operand2;
                        result.setText((String.valueOf(finResult)));
                    }
                    else
                        //3 params: context, string, integer value
                        Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();

                }
            } catch (Exception e) {
                Toast.makeText(getBaseContext(),"Invalid Input", Toast.LENGTH_LONG).show();
            }
        }

        if(v.equals(bnadd)) result.append("+");
        if(v.equals(bnsub)) result.append("-");
        if(v.equals(bnmul)) result.append("*");
        if(v.equals(bndiv)) result.append("/");
    }
}