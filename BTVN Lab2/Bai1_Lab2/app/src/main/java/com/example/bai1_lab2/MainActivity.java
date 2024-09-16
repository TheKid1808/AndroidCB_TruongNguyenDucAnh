package com.example.bai1_lab2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageAnimal;
    TextView nameAnimal;
    FrameLayout frameLayout;
    final int ImageOfAnimals[]= {R.drawable.penguin, R.drawable.cat,
            R.drawable.dog, R.drawable.hamster};
    final String NameOfAnimals[]={"PENGUIN", "CAT", "DOG", "HAMSTER"};
    final int[] BackGround ={R.color.purple_200, R.color.purple_500,
            R.color.teal_200, R.color.black};
    private int RollRandomAnimal(){
        Random randomAnimal= new Random();
        return randomAnimal.nextInt(4);
    }
    private void ShowRandomAnimal(){
        int result=RollRandomAnimal();
        imageAnimal= findViewById(R.id.imageAnimal);
        nameAnimal= findViewById(R.id.nameAnimal);
        frameLayout= findViewById(R.id.main);

        imageAnimal.setImageResource(ImageOfAnimals[result]);
        nameAnimal.setText(NameOfAnimals[result]);
        frameLayout.setBackgroundColor(BackGround[result]);
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
        ShowRandomAnimal();
    }
}