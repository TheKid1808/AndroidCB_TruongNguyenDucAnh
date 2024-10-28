package com.example.lab9;
public class Lop {
    private String MaLop;
    private String TenLop;
    private int SiSo;

    public Lop(String maLop, String tenLop, int siSo){
        MaLop = maLop;
        TenLop = tenLop;
        SiSo = siSo;
    }
    public Lop(String maLop, String tenLop){
        MaLop = maLop;
        TenLop = tenLop;
    }
    //get set ma lop
    public String getMaLop() {
        return MaLop;
    }
    public void setMaLop(String maLop){
        MaLop = maLop;
    }
    //get set ten lop
    public String getTenLop() {
        return TenLop;
    }
    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }
    //get set si so
    public int getSiSo() {
        return SiSo;
    }
    public void setSiSo(int siSo) {
        SiSo = siSo;
    }

    @Override
    public String toString() {
        return getMaLop() + " : " + getTenLop() + " : " + getSiSo() + "SV";
    }
}
