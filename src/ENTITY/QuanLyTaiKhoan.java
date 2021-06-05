/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import static ENTITY.TuyenSinh.DIA;
import static ENTITY.TuyenSinh.HOA;
import static ENTITY.TuyenSinh.LY;
import static ENTITY.TuyenSinh.SINH;
import static ENTITY.TuyenSinh.SU;
import static ENTITY.TuyenSinh.TOAN;
import static ENTITY.TuyenSinh.VAN;
import LIB.Config;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class QuanLyTaiKhoan implements Serializable {

    private List<TaiKhoan> listTaiKhoan;

    public QuanLyTaiKhoan() {
        try {
            listTaiKhoan = readFile();
        } catch (IOException ex) {
            System.out.println("Đóng file không thành công");
        }
    }

    public QuanLyTaiKhoan(List<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    public List<TaiKhoan> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public void setListTaiKhoan(List<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    public void saveFile(List<TaiKhoan> listTaiKhoan) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\DATABASE\\account.dat";

        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(path));
            os.writeObject(listTaiKhoan);
            System.out.println("Success...");
        } catch (IOException ex) {
            System.out.println("Không lưu được file");
        } finally {
            os.close();
        }
    }

    public List<TaiKhoan> readFile() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\DATABASE\\account.dat";
        List<TaiKhoan> listTaiKhoan;
        ObjectInputStream os = null;
        try {
//            TaiKhoan tk1 = new TaiKhoan("admin","admin",TaiKhoan.ADMIN);
//            TaiKhoan tk2 = new TaiKhoan("thang","1811",TaiKhoan.MANAGER);
//            listTaiKhoan = new ArrayList<>();
//            listTaiKhoan.add(tk1);
//            listTaiKhoan.add(tk2);
//            saveFile(listTaiKhoan);     
            os = new ObjectInputStream(new FileInputStream(path));
            listTaiKhoan = (List<TaiKhoan>) os.readObject();
            return listTaiKhoan;
        } catch (IOException ex) {
            listTaiKhoan = null;
            System.out.println("Không đọc được file");
        } catch (ClassNotFoundException ex) {
            listTaiKhoan = null;
            System.out.println("Định dạng file không đúng");;
        } finally {
            os.close();
        }
        return null;
    }

    public TaiKhoan login(String user, String pass) {
        if (user == null || pass == null || listTaiKhoan == null) {
            return null;
        }
        for (TaiKhoan tk : listTaiKhoan) {
            if (user.equals(tk.username) && pass.equals(tk.password)) {
                return tk;
            }
        }
        return null;
    }

    public void DoiMatKhau() {
        if (Config.taiKhoan == null) {
            return;
        }
        for (TaiKhoan tk : listTaiKhoan) {
            if (Config.taiKhoan.getUsername().equals(tk.getUsername())) {
                try {
                    tk.setPassword(Config.taiKhoan.getPassword());
                    saveFile(listTaiKhoan);

                } catch (IOException ex) {
                    Logger.getLogger(QuanLyTaiKhoan.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public Vector HienThiMotTaiKhoan(TaiKhoan taiKhoan) {
        Vector row = new Vector();
        row.add("");
        row.add(taiKhoan.getUsername());
        String role = "";
        if(taiKhoan.getRole() == TaiKhoan.ADMIN)
            role = "Admin";
        else if(taiKhoan.getRole() == TaiKhoan.MANAGER)
            role = "Quản lý";
        else
            role = "None";
        row.add(role);
        return row;
    }

    public Vector HienThi() {
        Vector data = new Vector();
        if (listTaiKhoan == null) {
            return data;
        }
        for (TaiKhoan taiKhoan : listTaiKhoan) {
            Vector row = this.HienThiMotTaiKhoan(taiKhoan);
            data.add(row);
        }
        return data;
    }
}
