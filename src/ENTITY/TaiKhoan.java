/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.io.Serializable;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class TaiKhoan implements Serializable {

    public static int ADMIN = 1;
    public static int MANAGER = 2;

    protected String username;
    protected String password;
    protected int role;

    public TaiKhoan() {
        this.username = null;
        this.password = null;
    }

    public TaiKhoan(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
