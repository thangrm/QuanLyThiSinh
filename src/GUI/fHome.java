/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
import GUI.COMPONENT.DataTable;
import GUI.COMPONENT.MenuBarUI;
import GUI.COMPONENT.ToolBar;
import ENTITY.TuyenSinh;
import GUI.COMPONENT.DialogUI;
import GUI.COMPONENT.PopupMenuListener;
import LIB.Config;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Vector;

public class fHome extends MenuBarUI {

    protected fHome home;
    protected fSuaThiSinh formSuaThiSinh;
    protected fXacNhanXoa formXacNhanXoa;
    protected fTimKiem formTimKiem;

    protected TuyenSinh tuyenSinh;
    protected DataTable tb;
    protected Panel panel;
    protected GridBagLayout layout;
    protected GridBagConstraints gbc;
    protected TextField txtLocTen;
    protected Button btnLocTen;

    protected ToolBar toolBar;
    protected Panel statusPanel;

    public fHome() {
        home = this;
        setUI();
        setEvent();
    }

    private void setUI() {
        this.setSize(1200, 600);
        this.setTitle("Quản lý thí sinh");
        this.setLayout(new BorderLayout());
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        Panel mainPanel = new Panel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.addMouseListener(new PopupMenuListener(home));

        // Thanh công cụ
        toolBar = new ToolBar();
        mainPanel.add(toolBar, BorderLayout.NORTH);

        panel = new Panel();
        layout = new GridBagLayout();
        panel.setLayout(layout);
        Insets inset = new Insets(10, 0, 10, 0);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.CENTER;

        //Hiển thị bảng danh sách thí sinh
        Label lblTimKiem = new Label("Tên: ");
        lblTimKiem.setForeground(Config.textColor);
        lblTimKiem.setFont(new Font("Verdana", Font.PLAIN, 16));
        txtLocTen = new TextField(25);

        btnLocTen = new Button("Lọc");
        btnLocTen.setPreferredSize(new Dimension(80, 25));
        btnLocTen.setForeground(Config.textColor);
        btnLocTen.setBackground(new Color(50, 174, 254));

        tuyenSinh = new TuyenSinh();
        Vector data = tuyenSinh.HienThi();
        tb = new DataTable(home, data);
        Panel panelSearch = new Panel();

        addComponent(panelSearch, lblTimKiem, 0, 0, 1, 1, inset);
        addComponent(panelSearch, txtLocTen, 1, 0, 1, 1, inset);
        addComponent(panelSearch, btnLocTen, 2, 0, 1, 1, inset);
        inset = new Insets(0, 0, 0, 0);
        addComponent(panel, panelSearch, 0, 0, 1, 1, inset);
        addComponent(panel, tb, 0, 1, 1, 1, inset);
        mainPanel.add(panel, BorderLayout.SOUTH);
        this.add(mainPanel);

        //Thanh trạng thái
        Date date = new Date();
        String today = String.format("%1$s %2$tB %2$td, %2$tY", "", date);
        statusPanel = new Panel();
        statusPanel.setBackground(Config.subColor);
        statusPanel.setPreferredSize(new Dimension(this.getWidth(), 25));
        statusPanel.setLayout(new BorderLayout());
        Label statusLabel = new Label(today);
        statusLabel.setForeground(Color.WHITE);
        statusPanel.add(statusLabel, BorderLayout.EAST);
        this.add(statusPanel, BorderLayout.SOUTH);
    }

    private void setEvent() {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        /*====================*/
        /*===== MENU BAR =====*/
        /*====================*/
        
        // Sự kiện thêm mới trên menuBar
        menuItemHeThong1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themThiSinh();
            }
        });
        
        // Sự kiện đổi mật khẩu
        menuItemHeThong2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fDoiMatKhau formDoiMatKhau = new fDoiMatKhau(home);
                formDoiMatKhau.setVisible(true);
            }
        });
        
        // Sự kiện đăng nhập - đăng xuất
        menuItemHeThong3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config.taiKhoan = null;
                Config.isLogin = false;
                fLogin login = null;
                login = new fLogin(home);
                login.setVisible(true);
            }
        });

        // Sự kiện thoát
        menuItemHeThong4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        //Sự kiện tra cứu
        menuItemTraCuu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formTimKiem = new fTimKiem(home);
                formTimKiem.setVisible(true);
            }
        });

        // Sự kiện hiển thị thông tin phiên bản
        menuItemThongTin1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogUI d = new DialogUI(home, "Thông tin", "Nhóm 5 - Version: v1.0.0.", true, DialogUI.OK);
                d.setVisible(true);
            }
        });
        
        /*=========================*/
        /*===== THANH CÔNG CỤ =====*/
        /*=========================*/
        
        // Sự kiện nút thêm mới trên thanh công cụ
        toolBar.addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themThiSinh();
            }
        });

        // Sự kiện nút sửa trên thanh công cụ
        toolBar.updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suaThongTinThiSinh();
            }
        });

        // Sự kiện nút xóa trên thanh công cụ
        toolBar.deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xoaThongTinThiSinh();
            }
        });

        // Sự kiện nút tìm kiếm trên thanh công cụ
        toolBar.searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timKiemThiSinh();
            }
        });

        // Sự kiện nút lọc theo tên
        btnLocTen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tuyenSinh.TimKiemTheoTen(txtLocTen.getText());
                Vector data = tuyenSinh.HienThi();
                tb.setData(data);
                menuBar.revalidate();
                menuBar.repaint();
            }
        });
    }

    public void themThiSinh() {
        if (formThemThiSinh == null) {
            formThemThiSinh = new fThemThiSinh(home);
            formThemThiSinh.setVisible(true);
        } else {
            formThemThiSinh.resetData();
            formThemThiSinh.setVisible(true);
            formThemThiSinh.toFront();
        }
    }

    public void suaThongTinThiSinh() {
        int row = tb.table.getSelectedRow();
        if (row < 0) {
            return;
        }
        if (tb.table.getValueAt(row, 1) == null) {
            return;
        }
        String soBaoDanh = tb.table.getValueAt(row, 1).toString();
        if (soBaoDanh == null || soBaoDanh.equals("")) {
            return;
        }
        if (formSuaThiSinh == null) {
            formSuaThiSinh = new fSuaThiSinh(home);
            formSuaThiSinh.setVisible(true);
        } else {
            formSuaThiSinh.setVisible(true);
            formSuaThiSinh.toFront();
        }
        formSuaThiSinh.layThongTinThiSinh(soBaoDanh);
    }

    public void xoaThongTinThiSinh() {
        int row = tb.table.getSelectedRow();
        if (row < 0) {
            return;
        }
        if (tb.table.getValueAt(row, 1) == null) {
            return;
        }
        String soBaoDanh = tb.table.getValueAt(row, 1).toString();
        if (soBaoDanh == null || soBaoDanh.equals("")) {
            return;
        }
        formXacNhanXoa = new fXacNhanXoa(home, soBaoDanh);
        formXacNhanXoa.setVisible(true);
    }

    public void timKiemThiSinh() {
        formTimKiem = new fTimKiem(home);
        formTimKiem.setVisible(true);
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
        fHome home = new fHome();
        home.setVisible(true);
    }
}
