package com.example.app_truyen_cuoi;

public class StoryCategory {
    int img_Category;
    String name_Category;

    public StoryCategory(){

    }

    public StoryCategory(String name_Category, int img_Category){
        this.img_Category = img_Category;
        this.name_Category = name_Category;
    }
    public int getImg_Category(){ return img_Category;}
    public String getName_Category(){return  name_Category;}
}
