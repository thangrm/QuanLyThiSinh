/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.util.List;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class ThiSinh {

    protected String soBaoDanh;
    protected KhuVuc khuVuc;
    protected Khoi khoiThi;
    protected String hoTen;
    protected String diaChi;
    protected List<DiemThi> listDiem;

    public ThiSinh(String soBaoDanh, KhuVuc khuVuc, Khoi khoiThi, String hoTen, String diaChi, List<DiemThi> listDiem) {
        this.soBaoDanh = soBaoDanh;
        this.khuVuc = khuVuc;
        this.khoiThi = khoiThi;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.listDiem = listDiem;
    }

    public String getSoBaoDanh() {
        return soBaoDanh;
    }

    public KhuVuc getKhuVuc() {
        return khuVuc;
    }

    public Khoi getKhoiThi() {
        return khoiThi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public List<DiemThi> getListDiem() {
        return listDiem;
    }

    public void setSoBaoDanh(String soBaoDanh) {
        this.soBaoDanh = soBaoDanh;
    }

    public void setKhuVuc(KhuVuc khuVuc) {
        this.khuVuc = khuVuc;
    }

    public void setKhoiThi(Khoi khoiThi) {
        this.khoiThi = khoiThi;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setListDiem(List<DiemThi> listDiem) {
        this.listDiem = listDiem;
    }
    
    public String getDiemTheoMon(String maMon) {
        return this.getDiemTheoMon(maMon, "");
    }
    
    public String getDiemTheoMon(String maMon, String str) {
        for (DiemThi diemThi : listDiem) {
            Float diem = diemThi.getDiem();
            if (diemThi.getMaMon().equalsIgnoreCase(maMon)) {
                if((diem * 100) % 100 == 0)
                    str =  String.format("%.0f",diem);
                else
                    str = String.format("%.2f", diem);
            }
        }
        return str;
    }

    public Float getTongDiem() {
        Float tongDiem = 0f;
        for (DiemThi diemThi : listDiem) {
            tongDiem += diemThi.diem;
        }
        tongDiem += this.khuVuc.getDiemUuTien();
        return tongDiem;
    }
    
    public void show(){
        System.out.println("SBD: "+ soBaoDanh);
        System.out.println("Họ tên: "+ hoTen);
        System.out.println("Địa chỉ: "+ diaChi);
        System.out.println("Mã khu vực: "+ khuVuc.maKhuVuc);
        System.out.println("Điểm ưu tiên: "+ khuVuc.maKhuVuc);
        System.out.println("Mã khối thi: "+ khoiThi.maKhoi);
        System.out.println("Tên khối: "+ khoiThi.tenKhoi);
        for(DiemThi diem : listDiem){
            System.out.println("Điểm môn " + diem.maMon + " : " + diem.diem);    
        }
    }
}
