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
public class Khoi {
    protected String maKhoi;
    protected String tenKhoi;

    public Khoi(String maKhoi, String tenKhoi) {
        this.maKhoi = maKhoi;
        this.tenKhoi = tenKhoi;
    }

    public String getMaKhoi() {
        return maKhoi;
    }

    public String getTenKhoi() {
        return tenKhoi;
    }

    public void setMaKhoi(String maKhoi) {
        this.maKhoi = maKhoi;
    }

    public void setTenKhoi(String tenKhoi) {
        this.tenKhoi = tenKhoi;
    }
    
}
