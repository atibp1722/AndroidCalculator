package com.first.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
                    btnDc, btnEx, btnAC, btnDel,
                    btnDv, btnSu, btnRm, btnAd, btnEql, btnMl;
    private TextView textResult, textHistory;
    private String number = null;
    private double fNum=0;
    private double lNum=0;
    String status = null;
    boolean ops = false;
    DecimalFormat formatter =  new DecimalFormat("######.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting numbers
        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        //Getting Clear and Delete
        btnAC = findViewById(R.id.btnAc);
        btnDel = findViewById(R.id.btnDel);
        btnDc = findViewById(R.id.btnDec);
        btnEx = findViewById(R.id.btnExp);
        //Getting Arithmetic Operators
        btnDv = findViewById(R.id.btnDiv);
        btnMl = findViewById(R.id.btnMul);
        btnAd = findViewById(R.id.btnPlus);
        btnSu = findViewById(R.id.btnSub);
        btnRm = findViewById(R.id.btnRem);
        btnEql = findViewById(R.id.btnEquals);
        //Getting from text view
        textResult = findViewById(R.id.textViewResult);
        textHistory = findViewById(R.id.textViewHistory);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("9");
            }
        });

        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected("2.71828182845");
            }
        });

        btnDc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberSelected(".");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=null;
                status=null;
                textResult.setText("0");
                textHistory.setText("");
                textResult.requestFocus();
                fNum=0;
                lNum=0;
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = number.substring(0, number.length()-1);
                textResult.setText(number);
            }
        });

        btnAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ops){
                    if(status=="multiplication"){
                        multiply();
                    }else if(status=="division"){
                        division();
                    }else if(status=="subtraction"){
                        subtract();
                    }else if(status=="remainders"){
                        remainder();
                    }else{
                        add();
                    }
                }
                status="sum";
                ops=false;
                number=null;
            }
        });

        btnSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ops){
                    if(status=="multiplication"){
                        multiply();
                    }else if(status=="division"){
                        division();
                    }else if(status=="sum"){
                        add();
                    }else if(status=="remainders"){
                        remainder();
                    }else{
                        subtract();
                    }
                }
                status="subtraction";
                ops=false;
                number=null;
            }
        });

        btnMl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ops){
                    if(status=="sum"){
                        add();
                    }else if(status=="division"){
                        division();
                    }else if(status=="subtraction"){
                        subtract();
                    }else if(status=="remainders"){
                        remainder();
                    }else{
                        multiply();
                    }
                }
                status="multiplication";
                ops=false;
                number=null;
            }
        });

        btnDv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ops){
                    if(status=="sum"){
                        add();
                    }else if(status=="multiplication"){
                        multiply();
                    }else if(status=="subtraction"){
                        subtract();
                    }else if(status=="remainders"){
                        remainder();
                    }else{
                        multiply();
                    }
                }
                status="division";
                ops=false;
                number=null;
            }
        });

        btnRm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ops){
                    if(status=="sum"){
                        add();
                    }else if(status=="multiplication"){
                        multiply();
                    }else if(status=="subtraction"){
                        subtract();
                    }else if(status=="division"){
                        division();
                    }else{
                        remainder();
                    }
                }
                status="remainders";
                ops=false;
                number=null;
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ops){
                    if(status=="sum"){
                        add();
                    }else if(status=="subtraction"){
                        subtract();
                    }else if(status=="multiplication"){
                        multiply();
                    }else if(status=="division"){
                        division();
                    }else if(status=="remainders"){
                        remainder();
                    }else{
                        fNum = Double.parseDouble(textResult.getText().toString());
                    }
                }
                ops=false;
            }
        });

    }

    //Method to get number from buttons
    public void numberSelected(String view){
        if(number==null){
            number=view;
        }else{
            number = number+view;
        }
        textResult.setText(number);
        ops=true;
    }

    //Method for Arithmetic Operations
    public void add(){
        lNum = Double.parseDouble(textResult.getText().toString());
        fNum += lNum;
        textResult.setText(formatter.format(fNum));
    }

    public void subtract(){
        if(fNum==0){
            fNum = Double.parseDouble(textResult.getText().toString());
        }else{
            lNum = Double.parseDouble(textResult.getText().toString());
            fNum -= lNum;
        }
        textResult.setText(formatter.format(fNum));
    }

    public void multiply(){
        if(fNum==0){
            fNum = 1;
            lNum = Double.parseDouble(textResult.getText().toString());
            fNum *= lNum;
        }
        else{
            lNum = Double.parseDouble(textResult.getText().toString());
            fNum *= lNum;
        }
        textResult.setText(formatter.format(fNum));
    }

    public void division(){
        if(fNum==0){
            lNum = Double.parseDouble(textResult.getText().toString());
            fNum = lNum/1;
        }else{
            lNum = Double.parseDouble(textResult.getText().toString());
            fNum /= lNum;
        }
        textResult.setText(formatter.format(fNum));
    }

    public void remainder(){
        if(fNum==0){
           Toast.makeText(getApplicationContext(), "Can't do with 0", Toast.LENGTH_SHORT).show();
        }else{
            lNum = Double.parseDouble(textResult.getText().toString());
            fNum = fNum%lNum;
        }
        textResult.setText(formatter.format(fNum));
    }
}