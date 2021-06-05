/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT.TAIKHOAN;

import GUI.COMPONENT.*;
import ENTITY.DiemThi;
import ENTITY.Khoi;
import ENTITY.KhuVuc;
import ENTITY.TaiKhoan;
import ENTITY.ThiSinh;
import ENTITY.TuyenSinh;
import GUI.fHome;
import GUI.fSuaThiSinh;
import LIB.Config;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class NhapThongTinTaiKhoan extends Frame {

    protected Frame frame;
    protected TuyenSinh tuyenSinh;

    protected Label lblTitle;
    protected Label lblUsername;
    protected Label lblRole;

    protected TextField txtUsername;
    protected ComboBoxUI cbbRole;

    protected Button btnSubmit;
    protected Button btnCancel;

    protected Panel wrapPanel;
    protected Panel mainPanel;
    protected Panel btnPanel;
    protected GridBagLayout layout;
    protected GridBagConstraints gbc;

    public NhapThongTinTaiKhoan() {
        this.frame = this;
        setUI();
        setEvent();
    }

    protected void setUI() {
        this.setSize(600, 300);
        this.setTitle("Tạo tải khoản");
        this.setLayout(new FlowLayout());
        this.setBackground(Config.mainColor);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        lblTitle = new Label("Thông tin tài khoản");
        lblTitle.setForeground(Config.textColor);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 28));

        lblUsername = new Label("Tên tài khoản:");
        lblUsername.setForeground(Config.textColor);
        lblUsername.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblRole = new Label("Quyền hạn:");
        lblRole.setForeground(Config.textColor);
        lblRole.setFont(new Font("Verdana", Font.PLAIN, 16));

        txtUsername = new TextField(25);
        Vector dataRole = new Vector();
        dataRole.add("Quản lý");
        dataRole.add("Admin");
        cbbRole = new ComboBoxUI(dataRole);
        //cbbRole.setPreferredSize(new Dimension(200, 25));

        btnSubmit = new Button("Xác nhận");
        btnSubmit.setPreferredSize(new Dimension(100, 35));
        btnSubmit.setForeground(Config.textColor);
        btnSubmit.setBackground(new Color(50, 174, 254));
        btnSubmit.setFont(new Font("Verdana", Font.PLAIN, 16));

        btnCancel = new Button("Hủy");
        btnCancel.setPreferredSize(new Dimension(80, 35));
        btnCancel.setForeground(Config.textColor);
        btnCancel.setBackground(new Color(255, 77, 38));
        btnCancel.setFont(new Font("Verdana", Font.PLAIN, 16));

        mainPanel = new Panel();
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);

        gbc = new GridBagConstraints();
        Insets inset = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        addComponent(mainPanel, lblUsername, 0, 1, 1, 1, inset);
        addComponent(mainPanel, lblRole, 0, 2, 1, 1, inset);

        addComponent(mainPanel, txtUsername, 1, 1, 1, 1, inset);
        addComponent(mainPanel, cbbRole, 1, 2, 1, 1, inset);

        btnPanel = new Panel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnPanel.add(btnSubmit);
        btnPanel.add(btnCancel);

        wrapPanel = new Panel();
        wrapPanel.setLayout(layout);
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(wrapPanel, lblTitle, 0, 0, 1, 1, inset);
        addComponent(wrapPanel, mainPanel, 0, 1, 1, 1, inset);
        addComponent(wrapPanel, btnPanel, 0, 2, 1, 1, inset);
        this.add(wrapPanel);
    }

    protected void setEvent() {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Sự kiện click nút hủy
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public TaiKhoan ThemTaiKhoan() {
        String username = txtUsername.getText().trim();
        String strRole = (String) cbbRole.getSelectedItem();
        int role = 0;
        if (username == null || username.equals("")) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Tên tài khoản không được để trống", true, DialogUI.ALERT);
            d.setVisible(true);
            return null;
        }

        if (username.length() < 6) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Tên tài khoản ít nhất là 6 kí tự", true, DialogUI.ALERT);
            d.setVisible(true);
            return null;
        }
        for (TaiKhoan element : Config.qlTaiKhoan.getListTaiKhoan()) {
            if (username.equals(element.getUsername())) {
                DialogUI d = new DialogUI(frame, "Thông báo", "Tên tài khoản đã tồn tại", true, DialogUI.ALERT);
                d.setVisible(true);
                return null;
            }
        }

        if (strRole.equals("Admin")) {
            role = TaiKhoan.ADMIN;
        } else if (strRole.equals("Quản lý")) {
            role = TaiKhoan.MANAGER;
        }

        Random rand = new Random();
        int ranNum = rand.nextInt(999999) + 100000;
        String pass = String.format("%s%d", username, ranNum);
        TaiKhoan tk = new TaiKhoan(username, pass, role);
        Config.qlTaiKhoan.getListTaiKhoan().add(tk);
        try {
            Config.qlTaiKhoan.saveFile(Config.qlTaiKhoan.getListTaiKhoan());
            this.dispose();
            DialogUI d = new DialogUI(frame, "Thông báo", "Tạo tài khoản thành công mật khẩu mặc định là : " + pass, true, DialogUI.OK);
            d.setSize(600, 300);
            d.setVisible(true);
            return tk;
        } catch (IOException ex) {
            System.out.println("Lưu file không thành công");
            return null;
        }
    }

    protected void addComponent(Panel panel, Component component, int column,
            int row, int width, int height, Insets inset) {
        gbc.gridx = column;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = inset;
        layout.setConstraints(component, gbc);
        panel.add(component);
    }

    public static void main(String[] args) {
        fSuaThiSinh add = new fSuaThiSinh(new fHome());
        add.setVisible(true);
    }
}
