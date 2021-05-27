/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import DATABASE.SQLServer;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class TuyenSinh {

    public static String TOAN = "MON01";
    public static String LY = "MON02";
    public static String HOA = "MON03";
    public static String SINH = "MON04";
    public static String VAN = "MON05";
    public static String SU = "MON06";
    public static String DIA = "MON07";
    protected List<ThiSinh> listThiSinh;
    protected List<Khoi> listKhoiThi;
    protected List<KhuVuc> listKhuVuc;

    public TuyenSinh() {
        this.listThiSinh = SQLServer.getDSThiSinh();
        this.listKhuVuc = SQLServer.getKhuVuc();
        this.listKhoiThi = SQLServer.getKhoi();
    }

    public List<ThiSinh> getListThiSinh() {
        return listThiSinh;
    }

    public List<Khoi> getListKhoiThi() {
        return listKhoiThi;
    }

    public List<KhuVuc> getListKhuVuc() {
        return listKhuVuc;
    }

    public void setListThiSinh(List<ThiSinh> listThiSinh) {
        this.listThiSinh = listThiSinh;
    }

    public void setListKhoiThi(List<Khoi> listKhoiThi) {
        this.listKhoiThi = listKhoiThi;
    }

    public void setListKhuVuc(List<KhuVuc> listKhuVuc) {
        this.listKhuVuc = listKhuVuc;
    }

    public Vector HienThiMotThiSinh(ThiSinh thisinh) {
        Vector row = new Vector();
        row.add("");
        row.add(thisinh.getSoBaoDanh());
        row.add(thisinh.getHoTen());
        row.add(thisinh.getDiaChi());
        row.add(thisinh.getKhuVuc().getMaKhuVuc());
        row.add(thisinh.getKhuVuc().getDiemUuTien());
        row.add(thisinh.getKhoiThi().getTenKhoi());
        row.add(thisinh.getDiemTheoMon(TOAN, "-"));
        row.add(thisinh.getDiemTheoMon(LY, "-"));
        row.add(thisinh.getDiemTheoMon(HOA, "-"));
        row.add(thisinh.getDiemTheoMon(SINH, "-"));
        row.add(thisinh.getDiemTheoMon(VAN, "-"));
        row.add(thisinh.getDiemTheoMon(SU, "-"));
        row.add(thisinh.getDiemTheoMon(DIA, "-"));
        row.add(thisinh.getTongDiem());
        return row;
    }

    public Vector HienThi() {
        Vector data = new Vector();
        for (ThiSinh thiSinh : listThiSinh) {
            Vector row = this.HienThiMotThiSinh(thiSinh);
            data.add(row);
        }
        return data;
    }

    public String NhapThongTinThiSinh(ThiSinh thiSinh) {

        String messager = SQLServer.themThiSinh(thiSinh);
        if (messager.equalsIgnoreCase("OK")) {
            listThiSinh.add(thiSinh);
        }
        return messager;
    }
    
    public String SuaThongTinThiSinh(ThiSinh thiSinh) {

        String messager = SQLServer.suaThiSinh(thiSinh);
        for(int i = 0; i < listThiSinh.size(); i++)
        {
            if(listThiSinh.get(i).getSoBaoDanh().equalsIgnoreCase(thiSinh.getSoBaoDanh()))
                listThiSinh.set(i, thiSinh);
        }
        return messager;
    }
    
    public String XoaThongTinThiSinh(String soBaoDanh) {
        String messager = SQLServer.xoaThiSinh(soBaoDanh);
        for(int i = 0; i < listThiSinh.size(); i++)
        {
            if(listThiSinh.get(i).getSoBaoDanh().equalsIgnoreCase(soBaoDanh))
                listThiSinh.remove(i);
        }
        return messager;
    }

    public void TimKiemTheoSBD() {
    }

    public Vector PhanTichKhuVucThanhVector() {
        Vector data = new Vector();
        for (KhuVuc khuVuc : listKhuVuc) {
            float diemUuTien = khuVuc.diemUuTien;
            String diem;
            if ((diemUuTien * 100) % 100 == 0) {
                diem = String.format("%.0f", diemUuTien);
            } else {
                diem = String.format("%.2f", diemUuTien);
            }
            data.add(khuVuc.maKhuVuc);
        }
        return data;
    }

    public Vector PhanTichKhoiThanhVector() {
        Vector data = new Vector();
        for (Khoi khoiThi : listKhoiThi) {
            data.add(khoiThi.tenKhoi);
        }
        return data;
    }

}
