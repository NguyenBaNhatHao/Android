package com.example.quanlihocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quanlihocsinh.model.Hocsinh;

import java.util.ArrayList;
import java.util.List;

public class QuanLiHocSinh extends AppCompatActivity {
    ListView Lv_manager;
    static List<Hocsinh> modelList;
    ManageApdapter adapter;
    SQLlite sqLlite;
    TextView txtInfo;
    public static Hocsinh hocsinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqLlite = new SQLlite(this);
        sqLlite.OpenDB();
        setContentView(R.layout.activity_quan_li_hoc_sinh);
        onInit();
        if(modelList == null) {
            setOnData();
        }
        showDB();
        adapter = new ManageApdapter(QuanLiHocSinh.this,R.layout.customlayout,modelList);
        Lv_manager.setAdapter(adapter);

    }
    private void setOnData(){
        modelList = new ArrayList();
        modelList.add(new Hocsinh("","","","",1));
    }

    public void onInit()
    {
        Lv_manager = findViewById(R.id.Lv_manager);
    }
    public void showDB(){
        modelList=sqLlite.Query();
    }

    }
