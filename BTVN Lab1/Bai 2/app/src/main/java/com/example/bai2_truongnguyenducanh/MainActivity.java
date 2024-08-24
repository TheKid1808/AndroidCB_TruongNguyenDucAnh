package com.example.bai2_truongnguyenducanh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonRoll;
    ImageView imageDice;
    int ImageOfDice[] =  {R.drawable.one_12375789, R.drawable.two_12375881, R.drawable.three_12375879,
                    R.drawable.four_12375847, R.drawable.five_12375869, R.drawable.six_12375875};
    private int RollNumber(){
        Random randomNumber = new Random();
        return randomNumber.nextInt(6);
    }

    private void GenerateRandomNumber(){
        buttonRoll = findViewById(R.id.buttonRoll);
        imageDice = findViewById(R.id.imageDice);

        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = RollNumber();
                imageDice.setImageResource(ImageOfDice[randomNumber]);
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

        GenerateRandomNumber();
    }
}