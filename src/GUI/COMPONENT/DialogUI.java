/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT;

import LIB.Config;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.Frame;
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

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class DialogUI extends Dialog {

    public static int ALERT = 1;
    public static int OK = 2;

    private int type;
    private String messager;
    private Panel panel;
    private Button btnSubmit;
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public DialogUI(Frame owner, String title, String messager, boolean modal, int type) {
        super(owner, title, modal);
        this.messager = messager;
        this.type = type;
        setUI();
        setEvent();
    }

    private void setUI() {
        this.setBackground(Config.mainColor);
        this.setSize(380, 300);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        String pathFolder = System.getProperty("user.dir") + "\\src\\IMAGE\\";
        String path;
        if (this.type == DialogUI.ALERT) {
            path = pathFolder + "alert.png";
        } else if (this.type == DialogUI.OK) {
            path = pathFolder + "ok.png";
        } else {
            path = pathFolder + "ok.png";
        }

        ImageUI iconAlert = new ImageUI(path);
        iconAlert.setPreferredSize(new Dimension(32, 32));

        Label lblMessager = new Label(this.messager);
        lblMessager.setForeground(Config.textColor);
        lblMessager.setFont(new Font("Verdana", Font.PLAIN, 16));

        btnSubmit = new Button("OK");
        btnSubmit.setPreferredSize(new Dimension(150, 30));
        btnSubmit.setForeground(Config.textColor);
        if (this.type == DialogUI.ALERT) {
            btnSubmit.setBackground(new Color(225, 65, 65));
        } else if (this.type == DialogUI.OK) {
            btnSubmit.setBackground(new Color(34, 181, 115));
        } else {
            btnSubmit.setBackground(new Color(34, 181, 115));
        }
        btnSubmit.setFont(new Font("Verdana", Font.PLAIN, 16));

        panel = new Panel();
        layout = new GridBagLayout();
        panel.setLayout(layout);
        gbc = new GridBagConstraints();
        Insets inset = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(panel, lblMessager, 0, 1, 1, 1, inset);
        addComponent(panel, btnSubmit, 0, 2, 1, 1, inset);
        addComponent(panel, iconAlert, 0, 0, 1, 1, inset);
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

        // Sự kiện nút OK
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(".actionPerformed()");
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
        Frame a = new Frame();
        a.setVisible(true);
        a.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                a.dispose();
            }
        });
        DialogUI dialog = new DialogUI(a, "Lỗi", "Vui lòng nhập đầy đủ thông tin", true, DialogUI.ALERT);
        dialog.setVisible(true);
    }
}
