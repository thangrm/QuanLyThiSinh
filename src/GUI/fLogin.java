/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Moon
 */
import ENTITY.QuanLyTaiKhoan;
import ENTITY.TaiKhoan;
import GUI.COMPONENT.DialogUI;
import LIB.Config;
import java.awt.*;
import java.awt.event.*;

public class fLogin extends Frame {

    private fLogin login;
    private fHome home;

    private Label lblTitle;
    private Label lblUser;
    private Label lblPass;
    private Label lblShowPass;

    private TextField txtUser;
    private TextField txtPass;
    private Checkbox ckbshowPass;

    private Button btnLogin;
    private Button btnCancel;

    private Panel panel;
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    public fLogin(fHome home) {
        this.login = this;
        this.home = home;
        if (Config.qlTaiKhoan == null) {
            Config.qlTaiKhoan = new QuanLyTaiKhoan();
        }
        setUI();
        setEvent();
    }

    private void setUI() {
        this.setSize(500, 380);
        this.setTitle("Đăng nhập");
        this.setLayout(new FlowLayout());
        this.setBackground(Config.mainColor);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        lblTitle = new Label("   ĐĂNG NHẬP");
        lblTitle.setForeground(Config.textColor);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 28));

        lblUser = new Label("Tài khoản:");
        lblUser.setForeground(Config.textColor);
        lblUser.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblPass = new Label("Mật khẩu:");
        lblPass.setForeground(Config.textColor);
        lblPass.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblShowPass = new Label("Hiển mật khẩu");
        lblShowPass.setForeground(Config.textColor);
        lblShowPass.setFont(new Font("Verdana", Font.PLAIN, 12));

        txtUser = new TextField(25);
        txtUser.setText("");
        txtPass = new TextField(25);
        txtPass.setEchoChar('*');
        ckbshowPass = new Checkbox();

        btnLogin = new Button("Đăng nhập");
        btnLogin.setPreferredSize(new Dimension(100, 35));
        btnLogin.setForeground(Config.textColor);
        btnLogin.setBackground(new Color(50, 174, 254));
        btnLogin.setFont(new Font("Verdana", Font.PLAIN, 16));

        btnCancel = new Button("Hủy");
        btnCancel.setPreferredSize(new Dimension(80, 35));
        btnCancel.setForeground(Config.textColor);
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
        addComponent(panelShowPass, 1, 3, 1, 1, new Insets(0, 5, 0, 0));

        Panel panelBtn = new Panel();
        panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBtn.add(btnLogin);
        panelBtn.add(btnCancel);
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(panelBtn, 0, 4, 2, 1, new Insets(10, 0, 0, 0));

        this.add(panel);
    }

    private void setEvent() {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                home.dispose();
                home = new fHome();
                home.setVisible(true);
                dispose();
            }
        });

        // Sự kiện hiện password
        ckbshowPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    txtPass.setEchoChar((char) 0);
                } else {
                    txtPass.setEchoChar('*');
                }
            }
        });

        // Sự kiện click nút đăng nhập
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventLogin();
            }
        });

        // Sự kiện click nút hủy
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.dispose();
                home = new fHome();
                home.setVisible(true);
                dispose();
            }
        });
    }

    public void eventLogin() {
        String user = txtUser.getText();
        String pass = txtPass.getText();
        TaiKhoan tk = Config.qlTaiKhoan.login(user, pass);
        if (tk == null) {
            DialogUI d = new DialogUI(login, "Thông báo", "Tài khoản mật khẩu không chính xác", true, DialogUI.ALERT);
            d.setVisible(true);
        } else {
            Config.taiKhoan = tk;
            Config.isLogin = true;
            home.dispose();
            home = new fHome();
            home.setVisible(true);
            dispose();
        }
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

    public static void main(String[] args) {
        fHome h = new fHome();
        h.setVisible(true);
        fLogin login = new fLogin(h);
        login.setVisible(true);
    }
}
