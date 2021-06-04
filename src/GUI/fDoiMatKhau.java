/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DATABASE.SQLServer;
import ENTITY.ThiSinh;
import GUI.COMPONENT.DialogUI;
import LIB.Config;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
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

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class fDoiMatKhau extends Dialog {

    protected fHome home;
    protected fDoiMatKhau formDoiMatKhau;

    protected Label lblOldPass;
    protected Label lblNewPass;
    protected Label lblReNewPass;

    protected TextField txtOldPass;
    protected TextField txtNewPass;
    protected TextField txtReNewPass;

    protected Panel panel;
    protected Panel panelBtn;
    protected Button btnSubmit;
    protected Button btnCancel;
    protected GridBagLayout layout;
    protected GridBagConstraints gbc;

    public fDoiMatKhau(fHome owner) {
        super(owner, "Tìm kiếm", true);
        this.home = owner;
        this.formDoiMatKhau = this;
        setUI();
        setEvent();
    }

    private void setUI() {
        this.setBackground(Config.mainColor);
        this.setSize(460, 300);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        lblOldPass = new Label("Mật khẩu cũ: ");
        lblOldPass.setForeground(Config.textColor);
        lblOldPass.setFont(new Font("Verdana", Font.PLAIN, 16));
        txtOldPass = new TextField(25);
        txtOldPass.setEchoChar('*');

        lblNewPass = new Label("Mật khẩu mới: ");
        lblNewPass.setForeground(Config.textColor);
        lblNewPass.setFont(new Font("Verdana", Font.PLAIN, 16));
        txtNewPass = new TextField(25);
        txtNewPass.setEchoChar('*');

        lblReNewPass = new Label("Nhập lại mật khẩu: ");
        lblReNewPass.setForeground(Config.textColor);
        lblReNewPass.setFont(new Font("Verdana", Font.PLAIN, 16));
        txtReNewPass = new TextField(25);
        txtReNewPass.setEchoChar('*');

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

        panelBtn = new Panel();
        panel = new Panel();
        layout = new GridBagLayout();
        panelBtn.setLayout(layout);
        panel.setLayout(layout);
        gbc = new GridBagConstraints();
        Insets inset = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        addComponent(panelBtn, btnSubmit, 0, 0, 1, 1, inset);
        addComponent(panelBtn, btnCancel, 1, 0, 1, 1, inset);

        addComponent(panel, lblOldPass, 0, 0, 1, 1, inset);
        addComponent(panel, txtOldPass, 1, 0, 1, 1, inset);
        addComponent(panel, lblNewPass, 0, 1, 1, 1, inset);
        addComponent(panel, txtNewPass, 1, 1, 1, 1, inset);
        addComponent(panel, lblReNewPass, 0, 2, 1, 1, inset);
        addComponent(panel, txtReNewPass, 1, 2, 1, 1, inset);
        addComponent(panel, panelBtn, 0, 3, 2, 1, inset);
        this.add(panel);
    }

    private void setEvent() {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Sự kiện nút xác nhận
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPass = txtOldPass.getText().trim();
                String newPass = txtNewPass.getText().trim();
                String reNewPass = txtReNewPass.getText().trim();
                if (oldPass == null || oldPass.equals("")) {
                    DialogUI d = new DialogUI(home, "Thông báo", "Vui lòng nhập mật khẩu cũ!", true, DialogUI.ALERT);
                    d.setVisible(true);
                    return;
                }

                if (newPass == null || newPass.equals("")) {
                    DialogUI d = new DialogUI(home, "Thông báo", "Vui lòng nhập mật khẩu mới!", true, DialogUI.ALERT);
                    d.setVisible(true);
                    return;
                }

                if (reNewPass == null || reNewPass.equals("")) {
                    DialogUI d = new DialogUI(home, "Thông báo", "Vui lòng nhập lại mật khẩu!", true, DialogUI.ALERT);
                    d.setVisible(true);
                    return;
                }

                if (newPass.length() < 3) {
                    DialogUI d = new DialogUI(home, "Thông báo", "Mật khẩu phải ít nhất là 3 kí tự!", true, DialogUI.ALERT);
                    d.setVisible(true);
                    return;
                }

                if (newPass.equals(reNewPass)) {
                    Config.taiKhoan.setPassword(newPass);
                    Config.qlTaiKhoan.DoiMatKhau();
                    dispose();
                    DialogUI d = new DialogUI(home, "Đổi mật khẩu", "Mật khẩu đã được đổi thành công", true, DialogUI.OK);
                    d.setVisible(true);
                } else {
                    DialogUI d = new DialogUI(home, "Thông báo", "Nhập lại mật khẩu không khớp!", true, DialogUI.ALERT);
                    d.setVisible(true);
                    return;
                }
            }
        });

        // Sự kiện nút hủy
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void addComponent(Panel panel, Component component, int column,
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
        fHome a = new fHome();
        a.setVisible(true);
        a.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                a.dispose();
            }
        });
        fTimKiem dialog = new fTimKiem(a);
        dialog.setVisible(true);
    }
}
