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
public class DiemThi {
    protected String maMon;
    protected Float diem;

    public DiemThi(String maMon, Float diem) {
        this.maMon = maMon;
        this.diem = diem;
    }

    public String getMaMon() {
        return maMon;
    }

    public Float getDiem() {
        return diem;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }
    
}
