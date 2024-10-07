package com.example.app_truyen_cuoi;

import android.content.Context;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CategoryAdapter extends ArrayAdapter<StoryCategory> {
    Context context;
    int layout;
    ArrayList<StoryCategory> categoriesList;
    public CategoryAdapter(Context context, int layout, ArrayList<StoryCategory> categoriesList) {
        super(context, layout, categoriesList);
        this.context = context;
        this.layout = layout;
        this.categoriesList = categoriesList;
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }

    @Override
    public StoryCategory getItem(int position) {
        return categoriesList.get(position);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View CurrentView = convertView;
        if (CurrentView == null) {
            CurrentView = LayoutInflater.from(context).inflate(layout, parent, false);
        }

        StoryCategory category = getItem(position);
        ImageView imageView = CurrentView.findViewById(R.id.ivImage_Category);
        TextView textView = CurrentView.findViewById(R.id.tvName_Category);

        assert category != null;
        imageView.setImageResource(category.getImg_Category());
        textView.setText(category.getName_Category());

        return CurrentView;
    }
}
