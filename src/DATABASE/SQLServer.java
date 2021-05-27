/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATABASE;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
import ENTITY.DiemThi;
import ENTITY.Khoi;
import ENTITY.KhuVuc;
import ENTITY.ThiSinh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLServer {

    private static String DB_URL = "jdbc:mysql://localhost:3306/quanlytuyensinh";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection(String dbURL, String userName,
            String password) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static ThiSinh getThiSinh(String soBaoDanh) {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            PreparedStatement ps = conn.prepareStatement("select thisinh.*, khuvuc.DiemUuTien, khoi.tenKhoi "
                    + "from thisinh INNER JOIN khoi ON thisinh.maKhoi = khoi.maKhoi "
                    + "INNER JOIN khuvuc ON thisinh.maKhuVuc = khuvuc.maKhuVuc "
                    + " where soBaoDanh = ?");
            ps.setString(1, soBaoDanh);
            ResultSet rs = ps.executeQuery();
            ThiSinh thiSinh = null;
            while (rs.next()) {
                String maKhuVuc = rs.getString(2);
                String maKhoi = rs.getString(3);
                String hoTen = rs.getString(4);
                String diaChi = rs.getString(5);
                Float diemUuTien = rs.getFloat(6);
                String tenKhoi = rs.getString(7);

                KhuVuc khuVuc = new KhuVuc(maKhuVuc, diemUuTien);
                Khoi khoiThi = new Khoi(maKhoi, tenKhoi);
                List<DiemThi> listDiem = SQLServer.getDiem(soBaoDanh);

                thiSinh = new ThiSinh(soBaoDanh, khuVuc, khoiThi, hoTen, diaChi, listDiem);
                conn.close();
                return thiSinh;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<ThiSinh> getDSThiSinh() {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select thisinh.*, khuvuc.DiemUuTien, khoi.tenKhoi "
                    + "from thisinh INNER JOIN khoi ON thisinh.maKhoi = khoi.maKhoi "
                    + "INNER JOIN khuvuc ON thisinh.maKhuVuc = khuvuc.maKhuVuc "
                    + "order by soBaoDanh desc");
            List<ThiSinh> listThiSinh = new ArrayList<>();
            while (rs.next()) {
                String soBaoDanh = rs.getString(1);
                String maKhuVuc = rs.getString(2);
                String maKhoi = rs.getString(3);
                String hoTen = rs.getString(4);
                String diaChi = rs.getString(5);
                Float diemUuTien = rs.getFloat(6);
                String tenKhoi = rs.getString(7);

                KhuVuc khuVuc = new KhuVuc(maKhuVuc, diemUuTien);
                Khoi khoiThi = new Khoi(maKhoi, tenKhoi);
                List<DiemThi> listDiem = SQLServer.getDiem(soBaoDanh);

                ThiSinh thiSinh = new ThiSinh(soBaoDanh, khuVuc, khoiThi, hoTen, diaChi, listDiem);
                listThiSinh.add(thiSinh);
            }

            conn.close();
            return listThiSinh;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<DiemThi> getDiem(String soBaoDanh) {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            PreparedStatement ps = conn.prepareStatement("select maMon,diem from diemthi where soBaoDanh = ?");
            ps.setString(1, soBaoDanh);
            ResultSet rs = ps.executeQuery();
            List<DiemThi> listDiem = new ArrayList<>();
            while (rs.next()) {
                String maMon = rs.getString(1);
                Float diem = rs.getFloat(2);
                DiemThi diemThi = new DiemThi(maMon, diem);
                listDiem.add(diemThi);
            }

            conn.close();
            return listDiem;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<Khoi> getKhoi() {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from khoi");
            List<Khoi> listKhoi = new ArrayList<>();
            while (rs.next()) {
                String maKhoi = rs.getString(1);
                String tenKhoi = rs.getString(2);
                Khoi khoiThi = new Khoi(maKhoi, tenKhoi);
                listKhoi.add(khoiThi);
            }

            conn.close();
            return listKhoi;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<KhuVuc> getKhuVuc() {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select * from khuvuc");
            List<KhuVuc> listKhuVuc = new ArrayList<>();
            while (rs.next()) {
                String maKhuVuc = rs.getString(1);
                Float diemUuTien = rs.getFloat(2);
                KhuVuc khuVuc = new KhuVuc(maKhuVuc, diemUuTien);
                listKhuVuc.add(khuVuc);
            }

            conn.close();
            return listKhuVuc;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String themThiSinh(ThiSinh thisinh) {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            PreparedStatement ps = conn.prepareStatement("INSERT INTO thisinh (`soBaoDanh`, `maKhuVuc`, `maKhoi`, `hoTen`, `diaChi`) "
                    + "VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, thisinh.getSoBaoDanh());
            ps.setString(2, thisinh.getKhuVuc().getMaKhuVuc());
            ps.setString(3, thisinh.getKhoiThi().getMaKhoi());
            ps.setString(4, thisinh.getHoTen());
            ps.setString(5, thisinh.getDiaChi());
            ps.execute();

            for (DiemThi diem : thisinh.getListDiem()) {
                ps = conn.prepareStatement("INSERT INTO diemthi (`soBaoDanh`, `maMon`, `diem`) "
                        + "VALUES (?, ?, ?)");
                ps.setString(1, thisinh.getSoBaoDanh());
                ps.setString(2, diem.getMaMon());
                ps.setString(3, diem.getDiem().toString());
                ps.execute();
            }

            conn.close();
            return "OK";

        } catch (Exception ex) {
            //ex.printStackTrace();
            if (ex.getMessage().indexOf("Duplicate entry") >= 0) {
                return "Duplicate entry";
            }
            return "Error";
        }
    }

    public static String suaThiSinh(ThiSinh thisinh) {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            
            // Xóa điểm thi của thi sinh ở khối cũ
            PreparedStatement ps = conn.prepareStatement("DELETE FROM `diemthi` WHERE soBaoDanh = ?");
            ps.setString(1, thisinh.getSoBaoDanh());
            ps.execute();
            
            // Cập nhật lại thông tin thí sinh
            ps = conn.prepareStatement("UPDATE thisinh "
                    + "SET maKhuVuc = ?, "
                    + "maKhoi = ?, "
                    + "hoTen = ?,"
                    + "diaChi = ? "
                    + "WHERE soBaoDanh = ?");
            ps.setString(1, thisinh.getKhuVuc().getMaKhuVuc());
            ps.setString(2, thisinh.getKhoiThi().getMaKhoi());
            ps.setString(3, thisinh.getHoTen());
            ps.setString(4, thisinh.getDiaChi());
            ps.setString(5, thisinh.getSoBaoDanh());
            ps.execute();
            
            // Cập nhật lại điểm của thí sinh
            for (DiemThi diem : thisinh.getListDiem()) {
                ps = conn.prepareStatement("INSERT INTO diemthi (`soBaoDanh`, `maMon`, `diem`) "
                        + "VALUES (?, ?, ?)");
                ps.setString(1, thisinh.getSoBaoDanh());
                ps.setString(2, diem.getMaMon());
                ps.setString(3, diem.getDiem().toString());
                ps.execute();
            }

            conn.close();
            return "OK";
        } catch (Exception ex) {
            ex.printStackTrace();
//            if (ex.getMessage().indexOf("Duplicate entry") >= 0) {
//                return "Duplicate entry";
//            }
            return "Error";
        }
    }
    
    public static String xoaThiSinh(String soBaoDanh) {
        try {
            // connnect to database
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            
            // Xóa điểm thi của thi sinh
            PreparedStatement ps = conn.prepareStatement("DELETE FROM diemthi WHERE soBaoDanh = ?");
            ps.setString(1, soBaoDanh);
            ps.execute();
            
            // Xóa thông tin của thí sinh
            ps = conn.prepareStatement("DELETE FROM thisinh WHERE soBaoDanh = ?");
            ps.setString(1, soBaoDanh);
            ps.execute();

            conn.close();
            return "OK";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Error";
        }
    }
}
