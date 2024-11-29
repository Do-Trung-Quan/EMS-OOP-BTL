/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Class.DSLuong;
import Class.DSAccount;
import Class.DSNhanVien;
import gui.Login;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author huyle
 */
public class main{
    public static void main(String[] args) throws FileNotFoundException{
        DSPhongBan dsPB = new DSPhongBan();
        DSLuong dsL = new DSLuong();
        DSAccount dsA = new DSAccount();
        Scanner in = new Scanner(new File("E:\\NV1.txt"));
        DSNhanVien dSNhanVien = new DSNhanVien(dsA, dsL);
        while(in.hasNextLine()){
            String[] line = in.nextLine().trim().split("\\|");
            String tenNV = line[0];
            String chucVu = line[1];
            String GioiTinh = line[2];
            String email = line[3];
            String SoDT = line[4];
            String NgaySinh = line[5];
            String NgayBatDau = line[6];
            NhanVien nv = new NhanVien(tenNV, chucVu, GioiTinh, email, SoDT, NgaySinh, NgayBatDau);
            System.out.println(tenNV+" "+chucVu+" "+GioiTinh+" "+email+" "+SoDT+" "+NgaySinh+" "+NgayBatDau);
            dSNhanVien.addDSNhanVien(nv);
        }
        

        
        new Login(dSNhanVien, dsA, dsL).setVisible(true);
        
    }
    
}
