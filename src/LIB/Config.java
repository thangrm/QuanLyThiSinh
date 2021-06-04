/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIB;

import ENTITY.QuanLyTaiKhoan;
import ENTITY.TaiKhoan;
import java.awt.Color;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class Config {
    public static Color mainColor = new Color(52, 56, 76);
    public static Color subColor = new Color(62, 68, 91);
    public static Color textColor = Color.WHITE;
    public static Color textSubColor = Color.WHITE;
    public static Color seperateColor = new Color(42, 46, 62);
    public static String iconColor = "white";
    
    //Tài khoản
    public static QuanLyTaiKhoan qlTaiKhoan = null;
    public static TaiKhoan taiKhoan = null;
    public static boolean isLogin = false;
}
