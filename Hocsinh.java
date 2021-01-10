package com.example.quanlihocsinh.model;

public class Hocsinh {
    public Hocsinh(String mTen,String mlop,String mMSSV,String mNganh, int mid){
        this.Ten = mTen;
        this.Lop = mlop;
        this.MSSV = mMSSV;
        this.Nganh = mNganh;
        this.id = mid;
    }
    private String Ten;
    private String Lop;
    private String MSSV;
    private String Nganh;
    private int id;

    public String getLop() {
        return Lop;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String nganh) {
        Nganh = nganh;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public int getId(){ return id; }

    public void setId(int id){
        this.id = id;
    }


    public Hocsinh(){

    }
}
