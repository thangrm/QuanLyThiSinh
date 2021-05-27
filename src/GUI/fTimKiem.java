/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DATABASE.SQLServer;
import ENTITY.ThiSinh;
import ENTITY.TuyenSinh;
import GUI.COMPONENT.DialogUI;
import GUI.COMPONENT.ImageUI;
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
public class fTimKiem extends Dialog {

    protected fHome home;
    protected fTimKiem formTimKiem;

    protected Label lblTitle;
    protected Label lblSBD;
    protected Label lblHoTen;
    protected Label lblDiaChi;
    protected Label lblKhuVuc;
    protected Label lblKhoi;
    protected Label lblToan;
    protected Label lblLy;
    protected Label lblHoa;
    protected Label lblSinh;
    protected Label lblVan;
    protected Label lblSu;
    protected Label lblDia;
    protected Label lblTimKiem;

    protected TextField txtSoBaoDanh;
    protected Panel wrapPanel;
    protected Panel mainPanel;
    protected Panel btnPanel;
    protected Panel panel;
    protected Panel panelBtn;
    protected Button btnSubmit;
    protected Button btnCancel;
    protected GridBagLayout layout;
    protected GridBagConstraints gbc;

    public fTimKiem(fHome owner) {
        super(owner, "Tìm kiếm", true);
        this.home = owner;
        this.formTimKiem = this;
        setUI();
        setEvent();
    }

    private void setUI() {
        this.setBackground(Config.mainColor);
        this.setSize(380, 200);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        lblTimKiem = new Label("Số báo danh: ");
        lblTimKiem.setForeground(Config.textColor);
        lblTimKiem.setFont(new Font("Verdana", Font.PLAIN, 16));
        txtSoBaoDanh = new TextField(25);

        btnSubmit = new Button("Tìm");
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

        addComponent(panel, lblTimKiem, 0, 0, 1, 1, inset);
        addComponent(panel, txtSoBaoDanh, 1, 0, 1, 1, inset);
        addComponent(panel, panelBtn, 0, 1, 2, 1, inset);
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
                String soBaoDanh = txtSoBaoDanh.getText().trim();
                if (soBaoDanh == null || soBaoDanh.equals("")) {
                    return;
                }

                ThiSinh thiSinh = SQLServer.getThiSinh(soBaoDanh);
                if (thiSinh == null) {
                    DialogUI d = new DialogUI(home, "Tìm kiếm", "Không tìm thấy thí sinh", true, DialogUI.OK);
                    d.setVisible(true);
                } else {
                    hienThiThongTin(thiSinh);
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

    private void hienThiThongTin(ThiSinh thisinh) {
        this.removeAll();
        this.setSize(620, 450);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        
        lblTitle = new Label("Thông tin thí sinh");
        lblTitle.setForeground(Config.textColor);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 28));

        lblSBD = new Label("Số báo danh: " + thisinh.getSoBaoDanh());
        lblSBD.setForeground(Config.textColor);
        lblSBD.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblHoTen = new Label("Họ và tên: " + thisinh.getHoTen());
        lblHoTen.setForeground(Config.textColor);
        lblHoTen.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblDiaChi = new Label("Địa chỉ: " + thisinh.getDiaChi());
        lblDiaChi.setForeground(Config.textColor);
        lblDiaChi.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblKhuVuc = new Label("Khu vực: " + thisinh.getKhuVuc().getMaKhuVuc());
        lblKhuVuc.setForeground(Config.textColor);
        lblKhuVuc.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblKhoi = new Label("Khối: " + thisinh.getKhoiThi().getTenKhoi());
        lblKhoi.setForeground(Config.textColor);
        lblKhoi.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblToan = new Label("Toán: " + thisinh.getDiemTheoMon(TuyenSinh.TOAN, "-"));
        lblToan.setForeground(Config.textColor);
        lblToan.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblLy = new Label("Lý: " + thisinh.getDiemTheoMon(TuyenSinh.LY, "-"));
        lblLy.setForeground(Config.textColor);
        lblLy.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblHoa = new Label("Hóa: " + thisinh.getDiemTheoMon(TuyenSinh.HOA, "-"));
        lblHoa.setForeground(Config.textColor);
        lblHoa.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblSinh = new Label("Sinh: " + thisinh.getDiemTheoMon(TuyenSinh.SINH, "-"));
        lblSinh.setForeground(Config.textColor);
        lblSinh.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblVan = new Label("Văn: " + thisinh.getDiemTheoMon(TuyenSinh.VAN, "-"));
        lblVan.setForeground(Config.textColor);
        lblVan.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblSu = new Label("Sử: " + thisinh.getDiemTheoMon(TuyenSinh.SU, "-"));
        lblSu.setForeground(Config.textColor);
        lblSu.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblDia = new Label("Địa: " + thisinh.getDiemTheoMon(TuyenSinh.DIA, "-"));
        lblDia.setForeground(Config.textColor);
        lblDia.setFont(new Font("Verdana", Font.PLAIN, 16));

        mainPanel = new Panel();
        wrapPanel = new Panel();
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        wrapPanel.setLayout(layout);
        gbc = new GridBagConstraints();
        Insets inset = new Insets(10, 10, 10, 10);

        gbc.anchor = GridBagConstraints.WEST;
        addComponent(mainPanel, lblSBD, 0, 0, 4, 1, inset);
        addComponent(mainPanel, lblHoTen, 0, 1, 4, 1, inset);
        addComponent(mainPanel, lblDiaChi, 0, 2, 4, 1, inset);
        addComponent(mainPanel, lblKhuVuc, 0, 3, 4, 1, inset);
        addComponent(mainPanel, lblKhoi, 2, 3, 1, 1, inset);
        addComponent(mainPanel, lblToan, 0, 4, 1, 1, inset);
        addComponent(mainPanel, lblLy, 1, 4, 1, 1, inset);
        addComponent(mainPanel, lblHoa, 2, 4, 1, 1, inset);
        addComponent(mainPanel, lblSinh, 3, 4, 1, 1, inset);
        addComponent(mainPanel, lblVan, 0, 5, 1, 1, inset);
        addComponent(mainPanel, lblSu, 1, 5, 1, 1, inset);
        addComponent(mainPanel, lblDia, 2, 5, 1, 1, inset);

        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(wrapPanel, lblTitle, 0, 0, 1, 1, inset);
        addComponent(wrapPanel, mainPanel, 0, 1, 1, 1, inset);
        this.add(wrapPanel);
        this.revalidate();
        this.repaint();
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
