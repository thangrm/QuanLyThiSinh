/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT;

import GUI.fHome;
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
public class PopupMenuListener extends MouseAdapter {

    JPopupMenu menu = new JPopupMenu("Popup");
    JMenuItem item1 = new JMenuItem("Thêm mới thí sinh");
    JMenuItem item2 = new JMenuItem("Sửa thí sinh");
    JMenuItem item3 = new JMenuItem("Xóa thí sinh");
    JMenuItem item4 = new JMenuItem("Tìm kiếm thí sinh");

    public PopupMenuListener(fHome home) {
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.themThiSinh();
            }
        });
        
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.suaThongTinThiSinh();
            }
        });
        
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.xoaThongTinThiSinh();
            }
        });
        
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.timKiemThiSinh();
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
