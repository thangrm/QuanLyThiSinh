/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class KhuVuc {
    protected String maKhuVuc;
    protected Float diemUuTien;

    public KhuVuc(String maKhuVuc, Float diemUuTien) {
        this.maKhuVuc = maKhuVuc;
        this.diemUuTien = diemUuTien;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public Float getDiemUuTien() {
        return diemUuTien;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public void setDiemUuTien(Float diemUuTien) {
        this.diemUuTien = diemUuTien;
    }
    
}
