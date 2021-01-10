package com.example.quanlihocsinh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quanlihocsinh.model.Hocsinh;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class SQLlite extends SQLiteOpenHelper {
    public static final String databaseName = "ManagerStudent";
    public static final String Table_Hocsinh ="HocSinh";
    public static final String Name_id = "id";
    public static final String CL_Tenhs = "TenHS";
    public static final String CL_MSSV ="mssv";
    public static final String CL_Lop = "Lop";
    public static final String CL_Nganh = "Nganh";
    public static final int version = 1;
    public SQLiteDatabase mDB;

    public SQLlite(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String mQuery = String.format("create table %s ("+
                        "%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                        "%s TEXT,"+
                        "%s TEXT,"+
                        "%s TEXT,"+
                        "%s TEXT);",
                        Table_Hocsinh, Name_id, CL_Tenhs, CL_MSSV, CL_Lop, CL_Nganh);
        db.execSQL(mQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Hocsinh);
        onCreate(db);
    }
    public void OpenDB(){
        mDB = this.getWritableDatabase();
    }
public List<Hocsinh> Query(){
    List<Hocsinh> hocsinhArrayList = new ArrayList<>();
    mDB = this.getReadableDatabase();
    String mQuery = String.format("SELECT * FROM %s",Table_Hocsinh);
    Cursor cursor = mDB.rawQuery(mQuery, null);
    if (cursor.getCount()>0){
        while (cursor.moveToNext()){
            Hocsinh hocsinh = new Hocsinh(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(0));
            hocsinhArrayList.add(hocsinh);
        }
    }
    return hocsinhArrayList;
}
    public void addItem(Hocsinh hocsinh){
            String mName, mLop, mMSSV, mNganh;
            mName = hocsinh.getTen();
            mLop = hocsinh.getLop();
            mMSSV = hocsinh.getMSSV();
            mNganh = hocsinh.getNganh();
            String mQuery = "INSERT INTO "+Table_Hocsinh+" ( "+CL_Tenhs+", "+CL_Lop+", "+CL_MSSV+", "+CL_Nganh+") VALUES (?,?,?,?)";
            mDB.execSQL(mQuery,new String[]{mName,mLop,mMSSV,mNganh});
        }
    public void EditItem(Hocsinh hocsinh){
            String mName, mLop, mMSSV, mNganh;
            int mId;
            mName = hocsinh.getTen();
            mLop = hocsinh.getLop();
            mMSSV = hocsinh.getMSSV();
            mNganh = hocsinh.getNganh();
            mId = hocsinh.getId();
            String mQuery = "UPDATE "+ Table_Hocsinh +" SET "+ CL_Tenhs +" = ?, "+CL_Lop+"= ?, "+CL_MSSV+"= ?, "+CL_Nganh+"= ? WHERE "+Name_id+"= ?+1";
            mDB.execSQL(mQuery, new String[]{mName,mLop,mMSSV,mNganh,String.valueOf(mId)});
    }
    public boolean DeleteItem(Hocsinh hocsinh){
        String mid = String.valueOf(hocsinh.getId());
        int result = mDB.delete(Table_Hocsinh, String.format("%s = ?", Name_id), new String[]{mid});
        if (result == 0){
            return false;
        }else {
            return true;
        }
    }
}

