package com.example.quanlihocsinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.pm.ShortcutInfoCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quanlihocsinh.model.Hocsinh;

import java.util.List;

public class EditInfoHocSinh extends AppCompatActivity {
    SQLlite sqLlite;
    Hocsinh hocsinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqLlite = new SQLlite(this);
        sqLlite.OpenDB();
        setContentView(R.layout.activity_edit_info_hoc_sinh);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnCancel = findViewById(R.id.btnCancel);
        final EditText editTen = findViewById(R.id.editTen);
        final EditText editLop = findViewById(R.id.editLop);
        final EditText editMSSV = findViewById(R.id.editMSSV);
        final EditText editNganh = findViewById(R.id.editNganh);
        Intent intent = this.getIntent();
        final int id = intent.getIntExtra("id",-1);
        final String Tenvalue = intent.getStringExtra("ten");
        final String Lopvalue = intent.getStringExtra("lop");
        final String MSSVvalue = intent.getStringExtra("mssv");
        final String Nganhvalue = intent.getStringExtra("nganh");
        editTen.setText(Tenvalue);
        editLop.setText(Lopvalue);
        editMSSV.setText(MSSVvalue);
        editNganh.setText(Nganhvalue);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mName, mLop, mMSSV, mNganh;
                mName = editTen.getText().toString();
                mLop = editLop.getText().toString();
                mMSSV = editMSSV.getText().toString();
                mNganh = editNganh.getText().toString();
                sqLlite.EditItem(new Hocsinh(mName,mLop,mMSSV,mNganh,id));
                Intent intent = new Intent(EditInfoHocSinh.this, QuanLiHocSinh.class);
                startActivity(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}