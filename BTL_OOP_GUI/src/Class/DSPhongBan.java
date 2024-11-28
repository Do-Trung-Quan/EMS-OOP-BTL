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
    public void addPhongBan(PhongBan pb) {
        dsPhongBan.add(pb);
    }

    // b.2) Xóa phòng ban khỏi danh sách phòng ban của công ty
    public void removePhongBan(PhongBan pb) {
        dsPhongBan.remove(pb);
    }

    // Phương thức tìm phòng ban theo mã
    public PhongBan SearchPhongBan(String n) {
        for (PhongBan pb : dsPhongBan) {
            if (pb.getMaPhongBan().equals(n) || pb.getTenPhongBan().equals(n)) {
                return pb;
            }
        }
        return null;
    }
}
