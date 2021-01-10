package com.example.quanlihocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registed);
        Button btnRegisted = findViewById(R.id.btnRegisted);
        final EditText txtTaikhoan = findViewById(R.id.txtTaikhoan);
        final EditText txtMatkhau = findViewById(R.id.txtMatkhau);
        final EditText txtXacthucmatkhau = findViewById(R.id.txtXacthucmatkhau);
        btnRegisted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan, matkhau, xacthucmatkhau;
                taikhoan = txtTaikhoan.getText().toString();
                matkhau = txtMatkhau.getText().toString();
                xacthucmatkhau = txtXacthucmatkhau.getText().toString();
                if (matkhau.equals(xacthucmatkhau)){
                    Intent intent = new Intent(Registed.this, MainActivity.class);
                    intent.putExtra("taikhoan", taikhoan);
                    intent.putExtra("matkhau", matkhau);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"mat khau xac thuc khong dung",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}