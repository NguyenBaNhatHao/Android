package com.example.quanlihocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quanlihocsinh.model.Hocsinh;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLlite sqLlite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqLlite = new SQLlite(this);
        sqLlite.OpenDB();
        setContentView(R.layout.activity_main);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegisted = findViewById(R.id.btnRegisted);
        final EditText txtTaikhoan = findViewById(R.id.txtTaikhoan);
        final EditText txtMatkhau = findViewById(R.id.txtMatkhau);
        Intent intent = this.getIntent();
        String stringvalue1 = intent.getStringExtra("taikhoan");
        final String stringvalue2 = intent.getStringExtra("matkhau");
        txtTaikhoan.setText(stringvalue1);
        txtMatkhau.setText(stringvalue2);
        btnRegisted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegistedIntent = new Intent(MainActivity.this, Registed.class);
                startActivity(RegistedIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan, matkhau;
                taikhoan = txtTaikhoan.getText().toString();
                matkhau = txtMatkhau.getText().toString();
                if (matkhau.equals(stringvalue2)) {
                    Intent LoginIntent = new Intent(MainActivity.this, QuanLiHocSinh.class);
                    startActivity(LoginIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "dang nhap that bai", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
