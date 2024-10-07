package com.example.app_truyen_cuoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class StoryActivity extends AppCompatActivity {
    private ImageButton button;
    private TextView textView;
    private ListView listView;
    private HashMap<String, String[]> booksMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listViewBooks);
        String name = getIntent().getStringExtra("name");
        textView = findViewById(R.id.textView);
        textView.setText(name);

        // Khởi tạo danh sách truyện theo thể loại
        booksMap = new HashMap<>();
        booksMap.put("Con trai", new String[]{"Việc học", "Đã hai lần rồi"});
        booksMap.put("Con gái", new String[]{"Cũng như nhau", "Rất lạnh"});
        booksMap.put("Gia đình", new String[]{"Im lặng là vàng", "Di tích hóa thạch"});
        booksMap.put("Học sinh", new String[]{"Nhầm lẫn tai hại", "Cảnh giác"});

        String[] books = booksMap.get(name);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, books);
        listView.setAdapter(adapter);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedBook = books[position];
                Intent intent = new Intent(StoryActivity.this, BookContent.class);
                intent.putExtra("bookTitle", selectedBook);
                intent.putExtra("bookContent", getBookContent(selectedBook));
                startActivity(intent);
            }
        });
    }

    private String getBookContent(String bookTitle) {
        // Đây là nội dung truyện
        switch (bookTitle) {
            case "Việc học":
                return "Nội dung của Việc học...";
            case "Đã hai lần rồi":
                return "Nội dung của Đã hai lần rồi...";
            case "Im lặng là vàng":
                return "Nội dung của Im lặng là vàng...";
            case "Di tích hóa thạch":
                return "Nội dung của Di tích hóa thạch...";
            case "Nhầm lẫn tai hại":
                return "Nội dung của Nhầm lẫn tai hại...";
            case "Cảnh giác":
                return "Nội dung của Cảnh giác...";
            case "Cũng như nhau":
                return "Nội dung của Cũng như nhau...";
            case "Rất lạnh":
                return "Nội dung của Rất lạnh...";
            default:
                return "Nội dung không tìm thấy.";
        }
    }
}
