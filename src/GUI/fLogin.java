/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Moon
 */
public class fLogin extends Frame {

    private Panel panel;
    private Label lblTitle;
    private Label lblUser;
    private Label lblPass;
    private TextField txtUser;
    private TextField txtPass;
    private Button btnLogin;
    private Button btnCancel;
    
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    fLogin() {
       setUI();
    }
    
    private void setUI()
    {  
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
        this.setVisible(true);
        this.setSize(500, 380);
        this.setTitle("Đăng nhập");
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(50, 60, 82));
        
        lblTitle = new Label("   ĐĂNG NHẬP");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 28));
        
        lblUser = new Label("Tài khoản:");
        lblUser.setForeground(Color.white);
        lblUser.setFont(new Font("Verdana", Font.PLAIN,16));
        
        lblPass = new Label("Mật khẩu:");
        lblPass.setForeground(Color.white);
        lblPass.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        txtUser = new TextField(25);
        txtPass = new TextField(25);

        btnLogin = new Button("Đăng nhập");
        btnLogin.setPreferredSize(new Dimension(100, 35));
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(new Color(50, 174, 254));
        btnLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        btnCancel = new Button("Hủy");
        btnCancel.setPreferredSize(new Dimension(80, 35));
        btnCancel.setForeground(Color.white);
        btnCancel.setBackground(new Color(255, 77, 38));
        btnCancel.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        panel = new Panel();
        panel.setPreferredSize(new Dimension(500, 280));
        layout = new GridBagLayout();
        panel.setLayout(layout);
        gbc = new GridBagConstraints();
        
        Insets inset = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.CENTER;
        //gbc.anchor = GridBagConstraints.CENTER;
        
        addComponent(lblTitle, 0, 0, 2, 1, inset);
        addComponent(lblUser, 0, 1, 1, 1, inset);
        addComponent(txtUser, 1, 1, 1, 1, inset);
        addComponent(lblPass, 0, 2, 1, 1, inset);
        addComponent(txtPass, 1, 2, 1, 1, inset);
        
        Panel panelBtn = new Panel();
        panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBtn.add(btnLogin);
        panelBtn.add(btnCancel);
        addComponent(panelBtn, 0, 3, 2, 1, new Insets(10, 0, 0, 0));
        
        this.add(panel);     
    }

    private void addComponent(Component component, int column,
            int row, int width, int height, Insets inset) {
        gbc.gridx = column;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = inset;
        layout.setConstraints(component, gbc);
        panel.add(component);
    }

    public static void main(String[] args)
    {
        fLogin a = new fLogin();
    }
}
