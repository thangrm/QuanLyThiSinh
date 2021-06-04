package GUI.COMPONENT;

import LIB.Config;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class ToolBar extends JToolBar {

    public JButton addBtn;
    public JButton updateBtn;
    public JButton deleteBtn;
    public JButton searchBtn;

    public ToolBar() {
        setUI();
    }

    @Override
    protected void addImpl(Component comp, Object constraints, int index) {
        super.addImpl(comp, constraints, index);
        if (comp instanceof JButton) {
            int thick = 8;
            ((JButton) comp).setBorder(new LineBorder(Config.subColor, thick));
            ((JButton) comp).setBackground(Config.subColor);
            ((JButton) comp).addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    ((JButton) comp).setBorder(new LineBorder(Config.mainColor, thick));
                    ((JButton) comp).setBackground(Config.mainColor);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    ((JButton) comp).setBorder(new LineBorder(Config.subColor, thick));
                    ((JButton) comp).setBackground(Config.subColor);
                }
            });
        }
    }

    private void setUI() {
        this.setBackground(Config.subColor);
        this.setBorder(new MatteBorder(1, 0, 1, 0, Config.seperateColor));

        String pathFolder = System.getProperty("user.dir") + "\\src\\IMAGE\\" + Config.iconColor + "-";
        String pathAdd = pathFolder + "add.png";
        String pathUpdate = pathFolder + "update.png";
        String pathDelete = pathFolder + "delete.png";
        String pathLoupe = pathFolder + "loupe.png";

        ImageIcon iconAdd = new ImageIcon(pathAdd);
        ImageIcon iconUpdate = new ImageIcon(pathUpdate);
        ImageIcon iconDelete = new ImageIcon(pathDelete);
        ImageIcon iconLoupe = new ImageIcon(pathLoupe);

        addBtn = new JButton(iconAdd);
        updateBtn = new JButton(iconUpdate);
        deleteBtn = new JButton(iconDelete);
        searchBtn = new JButton(iconLoupe);
        if (!Config.isLogin) {
            addBtn.setEnabled(false);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        }

        this.add(addBtn);
        this.add(updateBtn);
        this.add(deleteBtn);
        this.add(searchBtn);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                ToolBar ex = new ToolBar();
                ex.setVisible(true);
            }
        });
    }
}
