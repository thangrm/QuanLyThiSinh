    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import LIB.Config;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class QuanLyTaiKhoan implements Serializable{

    private List<TaiKhoan> listTaiKhoan;

    public QuanLyTaiKhoan() {
        try {
            listTaiKhoan = readFile();
        } catch (IOException ex) {
            listTaiKhoan = null;
            System.out.println("Không đọc được file");
        } catch (ClassNotFoundException ex) {
            listTaiKhoan = null;
            System.out.println("Định dạng file không đúng");;
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
            ex.printStackTrace();
        } finally {
            os.close();
        }
    }

    public List<TaiKhoan> readFile() throws IOException, ClassNotFoundException {
        String path = System.getProperty("user.dir") + "\\src\\DATABASE\\account.dat";
        List<TaiKhoan> listTaiKhoan;
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream(path));
            listTaiKhoan = (List<TaiKhoan>) os.readObject();
            return listTaiKhoan;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            os.close();
        }
    }

    public TaiKhoan login(String user, String pass){
        if(user == null || pass == null)
            return null;
        for(TaiKhoan tk : listTaiKhoan)
        {
            if(user.equals(tk.username) && pass.equals(tk.password))
                return tk;
        }
        return null;
    }
    
     public void DoiMatKhau(){
        if(Config.taiKhoan == null)
            return;
        for(TaiKhoan tk : listTaiKhoan)
        {
            if(Config.taiKhoan.getUsername().equals(tk.getUsername()))
            {
                try {
                    tk.setPassword(Config.taiKhoan.getPassword());
                    saveFile(listTaiKhoan);
                } catch (IOException ex) {
                    Logger.getLogger(QuanLyTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        }
    }
}
