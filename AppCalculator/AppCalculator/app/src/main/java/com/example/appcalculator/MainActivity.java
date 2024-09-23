package com.example.appcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

//
    Expression result;
    String expression = "";
//Screen
    TextView screen;
//Numbers
    Button btnNum1;
    Button btnNum2;
    Button btnNum3;
    Button btnNum4;
    Button btnNum5;
    Button btnNum6;
    Button btnNum7;
    Button btnNum8;
    Button btnNum9;
    Button btnNum0;
//Math Operations
    Button btnCALC;
    Button btnPlus;
    Button btnMinus;
    Button btnMulti;
    Button btnDivide;
    Button btnDecimal;
    Button btnPercent;
//Other Functions
    Button btnBrackets;
    Button btnAC;
    Button btnDEL;

//Add Number and Operations
    private void AddNumAndOP(){
        Button NumAndOp[]={
                btnNum0 = findViewById(R.id.btnNum0),
                btnNum1 = findViewById(R.id.btnNum1),
                btnNum2 = findViewById(R.id.btnNum2),
                btnNum3 = findViewById(R.id.btnNum3),
                btnNum4 = findViewById(R.id.btnNum4),
                btnNum5 = findViewById(R.id.btnNum5),
                btnNum6 = findViewById(R.id.btnNum6),
                btnNum7 = findViewById(R.id.btnNum7),
                btnNum8 = findViewById(R.id.btnNum8),
                btnNum9 = findViewById(R.id.btnNum9),

                btnPlus = findViewById(R.id.btnPlus),
                btnMinus = findViewById(R.id.btnMinus),
                btnMulti = findViewById(R.id.btnMulti),
                btnDivide = findViewById(R.id.btnDivide),
                btnDecimal = findViewById(R.id.btnDecimal),
                btnPercent = findViewById(R.id.btnPercent)};

        for (Button button: NumAndOp){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expression = expression + button.getText().toString();
                    screen.setText(expression);
                }
            });
        }
    }
//Calculate
    private void Calculate(){
        btnCALC = findViewById(R.id.btnCALC);
        btnCALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    expression = expression.replace("%", "/100");
                    expression = expression.replace("x", "*");
                    result = new ExpressionBuilder(expression).build();
                    screen.setText(String.valueOf(result.evaluate()));
                    expression = "";
                }
                catch (Exception e){
                    screen.setText("Error");
                    expression= "";
                }
            }
        });
    }
//AC and DEL on click
    private void ClearAndDel(){
        btnAC = findViewById(R.id.btnAC);
        btnDEL = findViewById(R.id.btnDEL);
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = "";
                screen.setText("0");
            }
        });
        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!expression.isEmpty()) {
                    expression = expression.substring(0, expression.length() - 1);
                    screen.setText(expression);
                }
                if (expression.isEmpty()) {
                    screen.setText("0");
                }
            }
        });
    }
    private void Brackets(){
        btnBrackets = findViewById(R.id.btnBrackets);
        btnBrackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = "(" + expression + ")";
                screen.setText(expression);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        screen = findViewById(R.id.Screen);
        AddNumAndOP();
        Brackets();
        Calculate();
        ClearAndDel();
    }
}