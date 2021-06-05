/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ENTITY.TaiKhoan;
import GUI.COMPONENT.DialogUI;
import GUI.COMPONENT.ImageUI;
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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class fCapLaiMatKhau extends Dialog {

    private fHome home;

    private String username;
    private String messager;
    private Panel panel;
    private Panel panelBtn;
    private Button btnSubmit;
    private Button btnCancel;
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public fCapLaiMatKhau(fHome owner, String username) {
        super(owner, "Xác nhận", true);
        this.messager = "Bạn có muốn cấp lại mật khẩu cho: " + username;
        this.username = username;
        this.home = owner;
        setUI();
        setEvent();
    }

    private void setUI() {
        this.setBackground(Config.mainColor);
        this.setSize(450, 300);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        String path = System.getProperty("user.dir") + "\\src\\IMAGE\\alert.png";
        ImageUI iconAlert = new ImageUI(path);
        iconAlert.setPreferredSize(new Dimension(32, 32));

        Label lblMessager = new Label(this.messager);
        lblMessager.setForeground(Config.textColor);
        lblMessager.setFont(new Font("Verdana", Font.PLAIN, 16));

        btnSubmit = new Button("Đồng ý");
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

        addComponent(panel, iconAlert, 0, 0, 1, 1, inset);
        addComponent(panel, lblMessager, 0, 1, 1, 1, inset);
        addComponent(panel, panelBtn, 0, 2, 1, 1, inset);
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
                List<TaiKhoan> listTaiKhoan = Config.qlTaiKhoan.getListTaiKhoan();
                int n = listTaiKhoan.size();
                for (int i = 0; i < n; i++) {
                    if (username.equals(listTaiKhoan.get(i).getUsername())) {
                        try {
                            Random rand = new Random();
                            int ranNum = rand.nextInt(999999) + 100000;
                            String pass = String.format("%s%d", username, ranNum);
                            TaiKhoan tk = listTaiKhoan.get(i);
                            tk.setPassword(pass);
                            listTaiKhoan.set(i, tk);
                            Config.qlTaiKhoan.setListTaiKhoan(listTaiKhoan);
                            Config.qlTaiKhoan.saveFile(listTaiKhoan);
                            dispose();
                            DialogUI d = new DialogUI(home, "Thông báo", "Mật khẩu cấp lại là : " + pass, true, DialogUI.OK);
                            d.setSize(600, 300);
                            d.setVisible(true);
                        } catch (IOException ex) {
                            System.out.println("Lưu file không thành công");
                        }
                        break;
                    }
                }
                dispose();
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
        fXacNhanXoa dialog = new fXacNhanXoa(a, "123456");
        dialog.setVisible(true);
    }
}
