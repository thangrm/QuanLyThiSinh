/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
import DATABASE.SQLServer;
import ENTITY.ThiSinh;
import ENTITY.TuyenSinh;
import GUI.fThemThiSinh;
import LIB.Config;
import java.awt.*;
import java.awt.MenuBar;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class MenuBarUI extends JFrame {

    protected fThemThiSinh formThemThiSinh;
    protected JMenuBar menuBar = new JMenuBar();
    protected JMenu menuHeThong = new JMenu("Hệ thống");
    protected JMenu menuTraCuu = new JMenu("Tra cứu");
    protected JMenu menuThongTin = new JMenu("Thông tin");
    protected JMenuItem menuItemHeThong1 = new JMenuItem("Thêm thí sinh");
    protected JMenuItem menuItemHeThong2 = new JMenuItem("Đăng xuất");
    protected JMenuItem menuItemHeThong3 = new JMenuItem("Thoát");
    protected JMenuItem menuItemTraCuu1 = new JMenuItem("Theo SBD");
    protected JMenuItem menuItemThongTin1 = new JMenuItem("Phiên bản");

    public MenuBarUI() {
        setUI();
    }

    private void setUI() {
        this.setSize(1200, 600);
        this.getContentPane().setBackground(Config.mainColor);
        menuBar.setBackground(Config.subColor);
        //Menu bar
        menuHeThong.setMnemonic('H');
        menuHeThong.setForeground(Config.textSubColor);
        menuItemHeThong1.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItemHeThong2.setAccelerator(KeyStroke.getKeyStroke('L', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItemHeThong3.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuHeThong.add(menuItemHeThong1);
        menuHeThong.add(menuItemHeThong2);
        menuHeThong.add(menuItemHeThong3);

        menuTraCuu.setMnemonic('T');
        menuTraCuu.setForeground(Config.textSubColor);
        menuItemTraCuu1.setAccelerator(KeyStroke.getKeyStroke('F', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuTraCuu.add(menuItemTraCuu1);

        menuThongTin.setMnemonic('A');
        menuThongTin.setForeground(Config.textSubColor);
        menuThongTin.add(menuItemThongTin1);

        menuBar.add(menuHeThong);
        menuBar.add(menuTraCuu);
        menuBar.add(menuThongTin);

        this.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        MenuBarUI home = new MenuBarUI();
        home.setVisible(true);
    }
}
