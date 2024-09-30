package com.example.lab3_bai5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TinhTong extends AppCompatActivity {
    EditText edtSoA, edtSoB;
    Button btnTinhTong, btnThoat, btnTrove;
    TextView txtTong;

    private void TinhTong() {
        btnTinhTong = findViewById(R.id.btnTinhTong);
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        txtTong = findViewById(R.id.txtTong);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int A = Integer.parseInt(edtSoA.getText().toString());
                int B = Integer.parseInt(edtSoB.getText().toString());
                int Tong = A + B;
                txtTong.setText(String.valueOf(Tong).toString());
            }
        });
    }
    private void TroVe(){
        btnTrove = findViewById(R.id.btnTrove);
        btnTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Thoat(){
        btnThoat = findViewById(R.id.btnThoat);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tinh_tong);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TinhTong();
        TroVe();
        Thoat();
    }
}