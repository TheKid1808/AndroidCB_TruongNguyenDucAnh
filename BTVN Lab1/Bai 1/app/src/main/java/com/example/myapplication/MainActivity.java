package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText textX, textY;
    TextView textResult;
    Button buttonPlus, buttonMinus, buttonMulti, buttonDivide, buttonRemain;

    private void initControl(){
        textX = findViewById(R.id.textX);
        textY = findViewById(R.id.textY);
        textResult = findViewById(R.id.textResult);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonRemain = findViewById(R.id.buttonRemain);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(textX.getText().toString());
                int y = Integer.parseInt(textY.getText().toString());
                int result = x + y;
                textResult.setText(String.valueOf(result));
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(textX.getText().toString());
                int y = Integer.parseInt(textY.getText().toString());
                int result = x - y;
                textResult.setText(String.valueOf(result));
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(textX.getText().toString());
                int y = Integer.parseInt(textY.getText().toString());
                int result = x * y;
                textResult.setText(String.valueOf(result));
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(textX.getText().toString());
                int y = Integer.parseInt(textY.getText().toString());
                int result = x / y;
                textResult.setText(String.valueOf(result));
            }
        });

        buttonRemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(textX.getText().toString());
                int y = Integer.parseInt(textY.getText().toString());
                int result = x % y;
                textResult.setText(String.valueOf(result));
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

        initControl();
    }
}