package com.example.lab9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db = null;
    ArrayAdapter<Lop> arrayAdapter;
    ArrayList<Lop> listLop;

    EditText edtMaLop, edtTenLop, edtSiSo;
    Button btnThem, btnXoa, btnSua, btnTim;
    ListView lvDSLop;


    private void CreateDatabase() {
        db = openOrCreateDatabase("QLSV.db", MODE_PRIVATE, null);
    }
    public void CloseDatabase() {
        if(db.isOpen()){
            db.close();
        }
    }
    public void DeleteDatabase(){
        String thongbao = "";
        if(deleteDatabase("QLSV.db")){
            thongbao = "Xóa thành công";
        }else{
            thongbao = "Xóa thất bại";
        }
        Toast.makeText(this, thongbao, Toast.LENGTH_SHORT).show();
    }
    //Tao bang Lop
    public void CreateTableLop(){
        String sql = "CREATE TABLE IF NOT EXISTS Lop(MaLop TEXT PRIMARY KEY, TenLop TEXT, SiSo INTEGER)";
        db.execSQL(sql);
    }
    //Them lop
    public void InsertLop(Lop lop){
        ContentValues values = new ContentValues();
        try{
            values.put("MaLop", lop.getMaLop());
            values.put("TenLop", lop.getTenLop());
            values.put("SiSo", lop.getSiSo());
        }catch (Exception e){
            Toast.makeText(this, "Lỗi nhập dữ liệu", Toast.LENGTH_SHORT).show();
        }
        if(db.insert("Lop", null, values) == -1){
            Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
        }
    }
    //Cap nhat lop
    public void UpdateLop(Lop lop){
        ContentValues values = new ContentValues();
        values.put("TenLop", lop.getTenLop());
        values.put("SiSo", lop.getSiSo());

        db.update("Lop", values, "MaLop = ?", new String[]{lop.getMaLop()});
    }
    //Xoa lop
    public void XoaLop(String maLop){
        if(maLop == null){
            //xoa tat ca lop
            db.delete("Lop", null, null);
        }
        else{
            //xoa lop theo ma lop
            db.delete("Lop", "MaLop = ?", new String[]{maLop});
        }
    }
    //Load database to list view
    public void LoadDTBtoLV(){
        listLop.clear();
        Cursor cursor = db.query("Lop", null, null, null, null, null, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            listLop.add(new Lop(cursor.getString(0).toString(),
                    cursor.getString(1).toString(),
                    cursor.getInt(2)));
            cursor.moveToNext();
        }
        cursor.close();
        arrayAdapter.notifyDataSetChanged();
    }
    //Xu ly su kien khi an vao 1 list item
    private void ItemClick(){
        lvDSLop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lop item = (Lop)arrayAdapter.getItem(position);
                edtMaLop.setText(item.getMaLop());
                edtTenLop.setText(item.getTenLop());
                edtSiSo.setText(item.getSiSo() + "");
            }
        });
    }
    //Su kien nhan nut them thi THEM MOI 1 LOP VAO DATABASE
    private void ThemLop(){
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lop lop = new Lop(edtMaLop.getText().toString(),
                        edtTenLop.getText().toString(),
                        Integer.parseInt(edtSiSo.getText().toString()));

                Toast.makeText(MainActivity.this, lop.toString(), Toast.LENGTH_SHORT).show();
                listLop.add(lop);
                InsertLop(lop);
                LoadDTBtoLV();
            }
        });
    }
    //Su kien nhan nut xoa thi XOA 1 LOP HOAC TAT CA LOP VAO DATABASE
    private void XoaLop(){
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaLop(edtMaLop.getText().toString());
                LoadDTBtoLV();
            }
        });
    }
    //Su kien nhan nut sua thi SUA 1 LOP VAO DATABASE
    private void SuaLop(){
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lop updateLop = new Lop(edtMaLop.getText().toString(),
                        edtTenLop.getText().toString(),
                        Integer.parseInt(edtSiSo.getText().toString()));
                UpdateLop(updateLop);
                LoadDTBtoLV();
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

        edtMaLop = findViewById(R.id.edtMaLop);
        edtTenLop = findViewById(R.id.edtTenLop);
        edtSiSo = findViewById(R.id.edtSiSo);

        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnTim = findViewById(R.id.btnTim);

        lvDSLop = findViewById(R.id.lvDSLop);
        listLop = new ArrayList<>();

        CreateDatabase();
        //CreateTableLop();
        /*listLop.add(new Lop("10A1", "Mười A 1", 22));
        listLop.add(new Lop("10A2", "Mười A 2", 32));
        listLop.add(new Lop("10A3", "Mười A 3", 25));*/

        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,listLop);
        lvDSLop.setAdapter(arrayAdapter);
        LoadDTBtoLV();
        ItemClick();
        ThemLop();
        XoaLop();
        SuaLop();
    }
}