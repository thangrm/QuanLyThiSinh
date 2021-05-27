/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class DSTaiKhoan implements Serializable{

    private List<TaiKhoan> listTaiKhoan;

    public DSTaiKhoan() {
    }

    public DSTaiKhoan(List<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

    public List<TaiKhoan> getListTaiKhoan() {
        return listTaiKhoan;
    }

    public void setListTaiKhoan(List<TaiKhoan> listTaiKhoan) {
        this.listTaiKhoan = listTaiKhoan;
    }

}
