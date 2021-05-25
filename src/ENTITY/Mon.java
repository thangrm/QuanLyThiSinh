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
public class Mon {
    protected int maMon;
    protected String tenMon;

    public Mon(int maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    
}
