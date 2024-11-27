/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;
import java.util.*;
/**
 *
 * @author huyle
 */
public class DSLuong {
    private ArrayList<Luong> dsLuong;
    
    public DSLuong(){
        this.dsLuong = new ArrayList<>();
    }
    
    public ArrayList<Luong> getDSLuong(){
        return dsLuong;
    }
    
    public void addLuong(Luong luong){
        dsLuong.add(luong);
    }
    
    public void removeLuong(Luong luong){
        dsLuong.remove(luong);
    }
}
