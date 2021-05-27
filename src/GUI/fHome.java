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
import DATABASE.SQLServer;
import ENTITY.ThiSinh;
import ENTITY.TuyenSinh;
import GUI.COMPONENT.DialogUI;
import GUI.COMPONENT.PopupMenuListener;
import LIB.Config;
import java.awt.*;
import java.awt.MenuBar;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

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

        //Hiển thị bảng danh sách thí sinh
        tuyenSinh = new TuyenSinh();
        Vector data = tuyenSinh.HienThi();
        tb = new DataTable(home, data);
        panel = new Panel();
        layout = new GridBagLayout();
        panel.setLayout(layout);
        gbc = new GridBagConstraints();

        Insets inset = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.CENTER;
        addComponent(tb, 0, 0, 1, 1, inset);
        mainPanel.add(panel, BorderLayout.SOUTH);
        this.add(mainPanel);

        //Thanh trạng thái
        statusPanel = new Panel();
        statusPanel.setBackground(Config.subColor);
        statusPanel.setPreferredSize(new Dimension(this.getWidth(), 25));
        statusPanel.setLayout(new BorderLayout());
        Label statusLabel = new Label("status");
        statusLabel.setForeground(Color.WHITE);
        statusPanel.add(statusLabel, BorderLayout.WEST);
        this.add(statusPanel, BorderLayout.SOUTH);
    }

    private void setEvent() {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Sự kiện thêm mới trên menuBar
        menuItemHeThong1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themThiSinh();
            }
        });

        // Sự kiện đăng xuất
        menuItemHeThong2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                fLogin login = null;
                try {
                    login = new fLogin();
                } catch (IOException ex) {
                    Logger.getLogger(fHome.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(fHome.class.getName()).log(Level.SEVERE, null, ex);
                }
                login.setVisible(true);
            }
        });

        // Sự kiện thoát
        menuItemHeThong3.addActionListener(new ActionListener() {
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
    }

    public void themThiSinh() {
        if (formThemThiSinh == null) {
            formThemThiSinh = new fThemThiSinh(home);
            formThemThiSinh.setVisible(true);
        } else {
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
        fHome home = new fHome();
        home.setVisible(true);
    }
}
