/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author huyle
 */
public class Luong {
    private NhanVien nv;
    private final String maNV;
    private int luongCB, ngayCong, phuCap; 

    public Luong(NhanVien nv) {
        this.nv = nv;
        this.maNV = nv.getMaNV();
        this.ngayCong = 0;
        setLuongCB();
        setPhuCap();
    }

    public int getLuongCB() {
        return luongCB;
    }
    
    public String getMaNV() {
        return maNV;
    }
    
    public void setLuongCB() {
        if (nv.getChucVu().equals("Chuyen vien")) {
            this.luongCB = 545454; 
        } else if (nv.getChucVu().equals("Truong phong")) {
            this.luongCB = 1136364;
        } else {
            this.luongCB = 1363636;
        }
    }
    
    public int getPhuCap() {
        return phuCap;
    }

    public void setPhuCap() {
        if (nv.getChucVu().equals("Chuyen vien")) {
            this.phuCap = 150000; 
        } else if (nv.getChucVu().equals("Truong phong")) {
            this.phuCap = 250000;
        } else {
            this.phuCap = 300000;
        }
    }


    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }
    
    public long tinhTongLuong() {
        return luongCB * ngayCong + phuCap;
    }
}
