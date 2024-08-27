package com.pakelcomedy.cobacoba;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String currentInput = "";
    private String operator = "";
    private double firstValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        // Define onClickListener for number buttons
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                currentInput += button.getText().toString();
                tvDisplay.setText(currentInput);
            }
        };

        // Define onClickListener for operator buttons
        View.OnClickListener operatorClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if (!currentInput.isEmpty()) {
                    firstValue = Double.parseDouble(currentInput);
                    operator = button.getText().toString();
                    currentInput = "";
                }
            }
        };

        // Define onClickListener for equals button
        View.OnClickListener equalsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    double secondValue = Double.parseDouble(currentInput);
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = firstValue + secondValue;
                            break;
                        case "-":
                            result = firstValue - secondValue;
                            break;
                        case "*":
                            result = firstValue * secondValue;
                            break;
                        case "/":
                            if (secondValue != 0) {
                                result = firstValue / secondValue;
                            } else {
                                tvDisplay.setText("Error");
                                return;
                            }
                            break;
                    }

                    tvDisplay.setText(String.valueOf(result));
                    currentInput = String.valueOf(result);
                    operator = "";
                }
            }
        };

        // Define onClickListener for clear button
        View.OnClickListener clearClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentInput = "";
                operator = "";
                tvDisplay.setText("0");
            }
        };

        // Define onClickListener for delete button
        View.OnClickListener deleteClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                    tvDisplay.setText(currentInput.isEmpty() ? "0" : currentInput);
                }
            }
        };

        // Assign onClickListeners to buttons
        findViewById(R.id.btn0).setOnClickListener(numberClickListener);
        findViewById(R.id.btn1).setOnClickListener(numberClickListener);
        findViewById(R.id.btn2).setOnClickListener(numberClickListener);
        findViewById(R.id.btn3).setOnClickListener(numberClickListener);
        findViewById(R.id.btn4).setOnClickListener(numberClickListener);
        findViewById(R.id.btn5).setOnClickListener(numberClickListener);
        findViewById(R.id.btn6).setOnClickListener(numberClickListener);
        findViewById(R.id.btn7).setOnClickListener(numberClickListener);
        findViewById(R.id.btn8).setOnClickListener(numberClickListener);
        findViewById(R.id.btn9).setOnClickListener(numberClickListener);
        findViewById(R.id.btnDot).setOnClickListener(numberClickListener);

        findViewById(R.id.btnAdd).setOnClickListener(operatorClickListener);
        findViewById(R.id.btnSubtract).setOnClickListener(operatorClickListener);
        findViewById(R.id.btnMultiply).setOnClickListener(operatorClickListener);
        findViewById(R.id.btnDivide).setOnClickListener(operatorClickListener);

        findViewById(R.id.btnEqual).setOnClickListener(equalsClickListener);
        findViewById(R.id.btnClear).setOnClickListener(clearClickListener);
        findViewById(R.id.btnDelete).setOnClickListener(deleteClickListener);
    }
}
