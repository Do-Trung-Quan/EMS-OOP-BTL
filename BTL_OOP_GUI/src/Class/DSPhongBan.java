package Class;

import java.util.ArrayList;
import java.util.List;

public class DSPhongBan {
    private List<PhongBan> dsPhongBan; // Danh sách phòng ban của công ty

    // Constructor khởi tạo danh sách phòng ban
    public DSPhongBan() {
        this.dsPhongBan = new ArrayList<>();
    }

    public List<PhongBan> getDSPhongBan(){
        return dsPhongBan;
    }
    
    // b.1) Thêm mới phòng ban vào danh sách phòng ban của công ty
    public void themPhongBan(String tenPhongBan) {
        PhongBan phongBanMoi = new PhongBan(tenPhongBan);
        dsPhongBan.add(phongBanMoi);
    }

    // b.2) Xóa phòng ban khỏi danh sách phòng ban của công ty
    public void xoaPhongBan(PhongBan phongBan) {
        dsPhongBan.remove(phongBan);
    }

    // Phương thức tìm phòng ban theo mã
    public PhongBan timPhongBan(String n) {
        for (PhongBan pb : dsPhongBan) {
            if (pb.getMaPhongBan().equals(n) || pb.getTenPhongBan().equals(n)) {
                return pb;
            }
        }
        return null;
    }
}
