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
public class TaiKhoan implements Serializable{
    protected String username;
    protected String password;
    
    public TaiKhoan(){
        this.username = null;
        this.password = null;
    }
    
    public TaiKhoan(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
