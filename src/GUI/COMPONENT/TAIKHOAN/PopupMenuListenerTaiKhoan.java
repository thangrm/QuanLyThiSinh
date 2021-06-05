/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT.TAIKHOAN;

import GUI.fHome;
import LIB.Config;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class PopupMenuListenerTaiKhoan extends MouseAdapter {

    JPopupMenu menu = new JPopupMenu("Popup");
    JMenuItem item1 = new JMenuItem("Thêm tài khoản mới");
    JMenuItem item2 = new JMenuItem("Cấp lại mật khẩu");
    JMenuItem item3 = new JMenuItem("Xóa tái khoản");

    public PopupMenuListenerTaiKhoan(fHome home) {
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.taoTaiKhoan();
            }
        });
        
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.capLaiMatKhau();
            }
        });
        
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.xoaTaiKhoan();
            }
        });
        
    }

    public void mousePressed(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
            menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
    }

    public void mouseReleased(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
            menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
    }

    public void mouseClicked(MouseEvent ev) {
    }
}
