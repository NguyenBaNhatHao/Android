package com.example.quanlihocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlihocsinh.model.Hocsinh;

import java.util.List;

public class AddInfoHocSinh extends AppCompatActivity {
    SQLlite sqLlite;
    Hocsinh hocsinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqLlite = new SQLlite(this);
        sqLlite.OpenDB();
        setContentView(R.layout.activity_add_info_hoc_sinh);
        final EditText txtTen =findViewById(R.id.txtTen);
        final EditText txtLop = findViewById(R.id.txtlop);
        final EditText txtMSSV = findViewById(R.id.txtMSSV);
        final EditText txtNganh = findViewById(R.id.txtNganh);
        Button btnAddinfo = findViewById(R.id.btnAddinfo);
        Intent intent = this.getIntent();
        final int id = intent.getIntExtra("id",-1);
        btnAddinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mName, mLop, mMSSV, mNganh;
                int ID;
                mName = txtTen.getText().toString();
                mLop=txtLop.getText().toString();
                mMSSV = txtMSSV.getText().toString();
                mNganh = txtNganh.getText().toString();
                ID = hocsinh.getId();
                sqLlite.addItem(new Hocsinh(mName, mLop , mMSSV, mNganh,id));
                Intent intent = new Intent(AddInfoHocSinh.this, QuanLiHocSinh.class);
                startActivity(intent);
            }
        });
    }
}