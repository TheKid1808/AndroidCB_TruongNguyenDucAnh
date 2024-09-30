package com.example.lab3_bai2;

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
    int ImageGame[]= {R.drawable.chicken, R.drawable.crab, R.drawable.deer, R.drawable.fish,
    R.drawable.gourd, R.drawable.shrimp};
    Random random = new Random();
    Button btnPlay;
    ImageView image1, image2, image3;

    private void rollImage(){
        image1.setImageResource(ImageGame[random.nextInt(6)]);
        image2.setImageResource(ImageGame[random.nextInt(6)]);
        image3.setImageResource(ImageGame[random.nextInt(6)]);
    }

    private void getImage(){
        btnPlay = findViewById(R.id.btnPlay);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollImage();
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
        getImage();
    }
}