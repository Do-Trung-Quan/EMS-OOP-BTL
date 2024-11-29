package Class;

// Nguyễn Quang Trung - B22DCDT321

import java.util.Scanner;

public class NhanVien implements Comparable<NhanVien>{
    public static Scanner scanner = new Scanner(System.in);
    public static int COUNT = 1;

    private final String maNV;
    private String tenNV;
    private String gioiTinh;
    private String email;
    private String soDT;
    private String ngaySinh;
    private String ngayBatDau;
    private String chucVu;

    public NhanVien() {
        this.maNV = null;
        this.tenNV = null;
        this.gioiTinh = null;
        this.email = null;
        this.soDT = null;
        this.ngaySinh = null;
        this.ngayBatDau = null;
        this.chucVu = null;
    }

    public NhanVien( String tenNV, String chucVu, String gioiTinh, String email, String soDT, String ngaySinh, String ngayBatDau) {
        this.maNV = "NV" + String.format("%02d",COUNT++); // Mã nhân viên tự động tăng.
        this.tenNV = tenNV;
        this.chucVu = chucVu;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.soDT = soDT;
        this.ngaySinh = ngaySinh;
        this.ngayBatDau = ngayBatDau;
    }

    // setter và getter cho các thuộc tính
    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }
    
    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }
    
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }
    
    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    
    public String[] getData(){
        String[] res = new String[8];
        res[0] = getMaNV();
        res[1] = getTenNV();
        res[2] = getChucVu();
        res[3] = getGioiTinh();
        res[4] = getEmail();
        res[5] = getSoDT();
        res[6] = getNgaySinh();
        res[7] = getNgayBatDau();
        return res;
    }
    
    @Override
    public int compareTo(NhanVien b){
        if(b.chucVu.equals(this.chucVu)) return this.maNV.compareTo(b.maNV);
        return b.chucVu.compareTo(this.chucVu);
    }
}