package com.example.bai4_lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RandomAnimal extends AppCompatActivity {
    ImageView imageAnimal;
    TextView nameAnimal;
    Button btnBackToMain;
    LinearLayout linearLayout;
    Random random = new Random();

    int ImageOfAnimals[]={R.drawable.cat, R.drawable.dog, R.drawable.hamster, R.drawable.penguin};
    String NameOfAnimals[]={"Cat", "Dog", "Hamster", "Penguin"};
    int BackGround[]={R.color.yellow, R.color.green, R.color.brown, R.color.blue};

    private void ShowRandomAnimal(){
        int result = random.nextInt(4);

        imageAnimal = findViewById(R.id.imageOfAnimal);
        nameAnimal = findViewById(R.id.textAnimal);
        linearLayout = findViewById(R.id.random_animal);

        imageAnimal.setImageResource(ImageOfAnimals[result]);
        nameAnimal.setText(NameOfAnimals[result]);
        linearLayout.setBackgroundColor((ContextCompat.getColor(this,BackGround[result])));
    }
    private void BackToMain(){
        btnBackToMain = findViewById(R.id.btnBackToMain);
        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_random_animal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.random_animal), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ShowRandomAnimal();
        BackToMain();
    }
}