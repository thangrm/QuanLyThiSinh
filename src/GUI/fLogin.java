/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package GUI;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Moon
 */

import java.awt.*;
import java.awt.event.*;

public class fLogin extends Frame {

    private Panel panel;
    private Label lblTitle;
    private Label lblUser;
    private Label lblPass;
    private Label lblShowPass;
    
    private JTextField txtUser;
    private JPasswordField txtPass;
    private Checkbox ckbshowPass;
    
    private Button btnLogin;
    private Button btnCancel;

    
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    fLogin() {
       setUI();
       setEvent();
    }
    
    private void setUI()
    {   
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
        
        lblShowPass = new Label("Hiển mật khẩu");
        lblShowPass.setForeground(Color.white);
        lblShowPass.setFont(new Font("Verdana", Font.PLAIN, 12));
        
        txtUser = new JTextField(15);
        txtUser.setText("");
        txtPass = new JPasswordField(15);
        //txtPass.setEchoChar('*');
        ckbshowPass = new Checkbox();
        
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
        addComponent(lblTitle, 0, 0, 2, 1, inset);
        addComponent(lblUser, 0, 1, 1, 1, inset);
        addComponent(txtUser, 1, 1, 1, 1, inset);
        addComponent(lblPass, 0, 2, 1, 1, inset);
        addComponent(txtPass, 1, 2, 1, 1, inset);
        
        Panel panelShowPass = new Panel();
        panelShowPass.add(ckbshowPass);
        panelShowPass.add(lblShowPass);
        gbc.anchor = GridBagConstraints.WEST;
        addComponent(panelShowPass, 1, 3, 1, 1,  new Insets(0, 5, 0, 0));
        
        Panel panelBtn = new Panel();
        panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBtn.add(btnLogin);
        panelBtn.add(btnCancel);
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(panelBtn, 0, 4, 2, 1, new Insets(10, 0, 0, 0));
        
        this.add(panel);     
    }
    private void setEvent()
    {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        }); 
        
        // Sự kiện hiện password
        ckbshowPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1)
                    txtPass.setEchoChar((char) 0);
                else
                    txtPass.setEchoChar('*');
            }
        });
        
        // Sự kiện click nút đăng nhập
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("\nTài khoản: " + txtUser.getText());
                System.err.println("\nMật khẩu: " + txtPass.getText());
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
        fLogin login = new fLogin();
        login.setVisible(true);
    }
}
