package Class;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSDuAn {
    private ArrayList<DuAn> dsDuAn; // Danh sách các dự án của công ty

    // Constructor khởi tạo danh sách dự án và danh sách nhân viên
    public DSDuAn() {
        this.dsDuAn = new ArrayList<>();
    }

    public void readFile(){
        try {
            Scanner in = new Scanner(new File("DA.txt"));
            while(in.hasNextLine()){
                String[] line = in.nextLine().trim().split("\\|");
                String tenDA = line[0];
                String ngayThucHien = line[1];
                dsDuAn.add(new DuAn(tenDA, ngayThucHien));
            }
        } catch (FileNotFoundException e) {
        }
    }
    
    // c.1) Thêm mới dự án vào danh sách dự án của công ty
    public void addDuAn(DuAn da) {
        dsDuAn.add(da);
    }

    // c.2) Xóa dự án khỏi danh sách dự án của công ty
    public void removeDuAn(String maDA) {
        DuAn duAnXoa = timDuAn(maDA);
        if (duAnXoa != null) {
            dsDuAn.remove(duAnXoa);
        }
    }

    // c.3) Chỉnh sửa thông tin dự án trong danh sách dự án của công ty
    public void updateThongTinDuAn(String maDA, String tenDAMoi, String ngayThucHienMoi) {
        DuAn duAnSua = timDuAn(maDA);
        if (duAnSua != null) {
            duAnSua.setTenDA(tenDAMoi);
            duAnSua.setNgayThucHien(ngayThucHienMoi);
        }
    }

    // Phương thức tìm dự án theo mã
    private DuAn timDuAn(String maDA) {
        for (DuAn duAn : dsDuAn) {
            if (duAn.getMaDA().equals(maDA)) {
                return duAn;
            }
        }
        return null;
    }

    // Hiển thị danh sách các dự án hiện có
    public ArrayList<DuAn> getDSDuAn() {
        return dsDuAn;
    }
}
