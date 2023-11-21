package com.example.logbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity  {
    private TextView inputField;
    private MaterialButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    private MaterialButton button_ac, button_equal, button_plus, button_minus, button_multiply, button_divide;
    private double a = 0, h = 0;
    private String operator = "";
    private String expression ="";
    private String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputField = (TextView) findViewById(R.id.inputField);
        inputField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text.equals("AC")) {
                    expression = "";
                    inputField.setText("");
                } else if (text.equals("=")) {
                    a = Double.parseDouble(inputField.getText().toString());
                    h = Double.parseDouble(inputField.getText().toString());
                    double result = calculateResult(a, h, operator);
                    expression += " " + operator + " " + String.valueOf(a) + " " + String.valueOf(h) + " = " + String.valueOf(result);
                    inputField.setText(expression);
                } else {
                    if (!operator.isEmpty()) {
                        a = Double.parseDouble(inputField.getText().toString());
                        h = Double.parseDouble(inputField.getText().toString());
                        expression += " " + operator + " " + String.valueOf(a) + " " + String.valueOf(h);
                        double result = calculateResult(a, h, operator);
                        inputField.setText(String.valueOf(result));
                        operator = text;
                    } else {
                        expression += text;
                        operator = text;
                    }
                }
            }
        });
        button_ac = (MaterialButton) findViewById(R.id.button_ac);

        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.setText("");
                a = 0;
                h = 0;
                operator = "";
            }
        });
        button_plus = (MaterialButton) findViewById(R.id.button_plus);

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator ="+";
                a = Double.parseDouble(inputField.getText().toString());
                h = Double.parseDouble(inputField.getText().toString());
                inputField.setText("");
                text = "+";
            }
        });
        button_minus = (MaterialButton) findViewById(R.id.button_minus);

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator ="-";
                a = Double.parseDouble(inputField.getText().toString());
                h = Double.parseDouble(inputField.getText().toString());
                inputField.setText("");
                text = "-";
            }
        });
        button_multiply = (MaterialButton) findViewById(R.id.button_multiply);

        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator ="*";
                a = Double.parseDouble(inputField.getText().toString());
                h = Double.parseDouble(inputField.getText().toString());
                inputField.setText("");
                text = "x";
            }
        });
        button_divide = (MaterialButton) findViewById(R.id.button_divide);

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator ="/";
                a = Double.parseDouble(inputField.getText().toString());
                h = Double.parseDouble(inputField.getText().toString());
                inputField.setText("");
                text = ":";
            }
        });

        button1 = (MaterialButton) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("1");
                text = "1";
            }
        });

        button2 = (MaterialButton) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("2");
                text = "2";
            }
        });
        button3 = (MaterialButton) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("3");
                text = "3";
            }
        });
        button4 = (MaterialButton) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("4");
                text = "4";
            }
        });
        button5 = (MaterialButton) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("5");
                text = "5";
            }
        });
        button6 = (MaterialButton) findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("6");
                text = "6";
            }
        });
        button7 = (MaterialButton) findViewById(R.id.button7);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("7");
                text = "7";
            }
        });
        button8 = (MaterialButton) findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("8");
                text = "8";
            }
        });
        button9 = (MaterialButton) findViewById(R.id.button9);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("9");
                text = "9";
            }
        });
        button0 = (MaterialButton) findViewById(R.id.button0);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputField.append("0");
                text = "0";
            }
        });
        button_equal = (MaterialButton) findViewById(R.id.button_equal);

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!operator.isEmpty()){
                    h = Double.parseDouble(inputField.getText().toString());
                    double result = calculateResult(a, h, operator);
                    inputField.setText(String.valueOf(result));
                    operator = "";
                }
            }
        });
    }

    private double calculateResult(double a, double h, String operator) {
        switch (operator) {
            case "+":
                return a + h;
            case "-":
                return a - h;
            case "*":
                return a * h;
            case "/":
                if (h == 0) {
                    return Double.NaN;
                }
                return a / h;
            default:
                return Double.NaN;
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        expression ="";
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        inputField.setText(expression);
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void  onDestroy(){
        super.onDestroy();
    }


}