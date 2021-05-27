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
import ENTITY.TaiKhoan;
import GUI.COMPONENT.DialogUI;
import LIB.Config;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class fLogin extends Frame {

    private fLogin login;

    private List<TaiKhoan> listTaiKhoan;
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

    public fLogin() throws IOException, ClassNotFoundException {
        setUI();
        setEvent();
        this.login = this;
        this.listTaiKhoan = readFile();
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
                String user = txtUser.getText();
                String pass = txtPass.getText();
                for (TaiKhoan tk : listTaiKhoan) {
                    if (user.equalsIgnoreCase(tk.getUsername()) && pass.equals(tk.getPassword())) {
                        fHome home = new fHome();
                        home.setVisible(true);
                        login.dispose();
                        return;
                    }
                }
                DialogUI d = new DialogUI(login, "Thông báo", "Tài khoản mật khẩu không chính xác", true, DialogUI.ALERT);
                d.setVisible(true);
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

    private void saveFile(List<TaiKhoan> listTaiKhoan) throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\DATABASE\\account.dat";

        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(new FileOutputStream(path));
            os.writeObject(listTaiKhoan);
            System.out.println("Success...");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            os.close();
        }
    }

    private List<TaiKhoan> readFile() throws IOException, ClassNotFoundException {
        String path = System.getProperty("user.dir") + "\\src\\DATABASE\\account.dat";
        List<TaiKhoan> listTaiKhoan;
        ObjectInputStream os = null;
        try {
            os = new ObjectInputStream(new FileInputStream(path));
            listTaiKhoan = (List<TaiKhoan>) os.readObject();
            return listTaiKhoan;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            os.close();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        fLogin login = new fLogin();
        login.setVisible(true);
//        TaiKhoan taiKhoan = new TaiKhoan(); // tao doi tuong myStudent
//        List<TaiKhoan> listTaiKhoan = new ArrayList<>();
//        TaiKhoan tk1 = new TaiKhoan("admin", "admin");
//        TaiKhoan tk2 = new TaiKhoan("thang", "1811");
//
//        listTaiKhoan.add(tk1);
//        listTaiKhoan.add(tk2);
//        login.saveFile(listTaiKhoan);
    }
}
