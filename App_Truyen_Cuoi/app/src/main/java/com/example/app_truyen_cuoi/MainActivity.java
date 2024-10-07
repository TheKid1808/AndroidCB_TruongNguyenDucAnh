package com.example.app_truyen_cuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    StoryCategory storyCategory;
    CategoryAdapter storyAdapter;
    ArrayList<StoryCategory> categoriesList;

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
        listView = findViewById(R.id.listViewCategories);
        initData();
        storyAdapter = new CategoryAdapter(this, R.layout.story_category_list, categoriesList);
        listView.setAdapter(storyAdapter);
        select_Category();
    }
    private void initData(){
        categoriesList = new ArrayList<>();
        categoriesList.add(new StoryCategory("Con gái", R.drawable.girl));
        categoriesList.add(new StoryCategory("Con trai", R.drawable.boy));
        categoriesList.add(new StoryCategory("Gia đình", R.drawable.family));
        categoriesList.add(new StoryCategory("Học sinh", R.drawable.student));
    }
    private void select_Category(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = categoriesList.get(position).getName_Category();
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}