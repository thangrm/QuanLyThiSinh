/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT;

import GUI.COMPONENT.DialogUI;
import GUI.COMPONENT.ComboBoxUI;
import DATABASE.SQLServer;
import ENTITY.DiemThi;
import ENTITY.Khoi;
import ENTITY.KhuVuc;
import ENTITY.ThiSinh;
import ENTITY.TuyenSinh;
import GUI.fHome;
import GUI.fSuaThiSinh;
import LIB.Config;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class NhapThongTin extends Frame {

    protected Frame frame;
    protected TuyenSinh tuyenSinh;

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

    protected TextField txtSBD;
    protected TextField txtHoTen;
    protected TextField txtDiaChi;
    protected ComboBoxUI cbbKhuVuc;
    protected ComboBoxUI cbbKhoi;
    protected TextField txtToan;
    protected TextField txtLy;
    protected TextField txtHoa;
    protected TextField txtSinh;
    protected TextField txtVan;
    protected TextField txtSu;
    protected TextField txtDia;

    protected Button btnSubmit;
    protected Button btnCancel;

    protected Panel wrapPanel;
    protected Panel mainPanel;
    protected Panel btnPanel;
    protected GridBagLayout layout;
    protected GridBagConstraints gbc;

    public NhapThongTin() {
        this.tuyenSinh = new TuyenSinh();
        this.frame = this;
        setUI();
        setEvent();
    }

    public NhapThongTin(TuyenSinh tuyenSinh) {
        this.frame = this;
        this.tuyenSinh = tuyenSinh;
        setUI();
        setEvent();
    }

    protected void setUI() {
        this.setSize(600, 600);
        this.setTitle("Chỉnh sửa thông tin thí sinh");
        this.setLayout(new FlowLayout());
        this.setBackground(Config.mainColor);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        lblTitle = new Label("Thông tin thí sinh");
        lblTitle.setForeground(Config.textColor);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 28));

        lblSBD = new Label("Số báo danh:");
        lblSBD.setForeground(Config.textColor);
        lblSBD.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblHoTen = new Label("Họ và tên:");
        lblHoTen.setForeground(Config.textColor);
        lblHoTen.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblDiaChi = new Label("Địa chỉ:");
        lblDiaChi.setForeground(Config.textColor);
        lblDiaChi.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblKhuVuc = new Label("Khu vực:");
        lblKhuVuc.setForeground(Config.textColor);
        lblKhuVuc.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblKhoi = new Label("Khối:");
        lblKhoi.setForeground(Config.textColor);
        lblKhoi.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblToan = new Label("Toán: ");
        lblToan.setForeground(Config.textColor);
        lblToan.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblLy = new Label("Lý: ");
        lblLy.setForeground(Config.textColor);
        lblLy.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblHoa = new Label("Hóa: ");
        lblHoa.setForeground(Config.textColor);
        lblHoa.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblSinh = new Label("Sinh: ");
        lblSinh.setForeground(Config.textColor);
        lblSinh.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblVan = new Label("Văn: ");
        lblVan.setForeground(Config.textColor);
        lblVan.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblSu = new Label("Sử: ");
        lblSu.setForeground(Config.textColor);
        lblSu.setFont(new Font("Verdana", Font.PLAIN, 16));

        lblDia = new Label("Địa: ");
        lblDia.setForeground(Config.textColor);
        lblDia.setFont(new Font("Verdana", Font.PLAIN, 16));

        txtSBD = new TextField(25);
        txtHoTen = new TextField(25);
        txtDiaChi = new TextField(25);
        txtSBD = new TextField(25);
        txtHoTen = new TextField(25);
        txtToan = new TextField(25);
        txtLy = new TextField(25);
        txtHoa = new TextField(25);
        txtSinh = new TextField(25);
        txtVan = new TextField(25);
        txtSu = new TextField(25);
        txtDia = new TextField(25);

        cbbKhuVuc = new ComboBoxUI(tuyenSinh.PhanTichKhuVucThanhVector());
        cbbKhoi = new ComboBoxUI(tuyenSinh.PhanTichKhoiThanhVector());
        cbbKhoi.setPreferredSize(new Dimension(200, 25));

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

        mainPanel = new Panel();
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);

        gbc = new GridBagConstraints();
        Insets inset = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        addComponent(mainPanel, lblSBD, 0, 1, 1, 1, inset);
        addComponent(mainPanel, lblHoTen, 0, 2, 1, 1, inset);
        addComponent(mainPanel, lblDiaChi, 0, 3, 1, 1, inset);
        addComponent(mainPanel, lblKhuVuc, 0, 4, 1, 1, inset);
        addComponent(mainPanel, lblKhoi, 0, 5, 1, 1, inset);
        addComponent(mainPanel, lblToan, 0, 6, 1, 1, inset);
        addComponent(mainPanel, lblLy, 0, 7, 1, 1, inset);
        addComponent(mainPanel, lblHoa, 0, 8, 1, 1, inset);
        addComponent(mainPanel, lblSinh, 0, 9, 1, 1, inset);
        addComponent(mainPanel, lblVan, 0, 10, 1, 1, inset);
        addComponent(mainPanel, lblSu, 0, 11, 1, 1, inset);
        addComponent(mainPanel, lblDia, 0, 12, 1, 1, inset);

        addComponent(mainPanel, txtSBD, 1, 1, 1, 1, inset);
        addComponent(mainPanel, txtHoTen, 1, 2, 1, 1, inset);
        addComponent(mainPanel, txtDiaChi, 1, 3, 1, 1, inset);
        addComponent(mainPanel, cbbKhuVuc, 1, 4, 1, 1, inset);
        addComponent(mainPanel, cbbKhoi, 1, 5, 1, 1, inset);
        addComponent(mainPanel, txtToan, 1, 6, 1, 1, inset);
        addComponent(mainPanel, txtLy, 1, 7, 1, 1, inset);
        addComponent(mainPanel, txtHoa, 1, 8, 1, 1, inset);
        addComponent(mainPanel, txtSinh, 1, 9, 1, 1, inset);
        addComponent(mainPanel, txtVan, 1, 10, 1, 1, inset);
        addComponent(mainPanel, txtSu, 1, 11, 1, 1, inset);
        addComponent(mainPanel, txtDia, 1, 12, 1, 1, inset);
        lblSinh.setVisible(false);
        lblVan.setVisible(false);
        lblSu.setVisible(false);
        lblDia.setVisible(false);
        txtSinh.setVisible(false);
        txtVan.setVisible(false);
        txtSu.setVisible(false);
        txtDia.setVisible(false);
        cbbKhoi.setSelectedItem(null);

        btnPanel = new Panel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnPanel.add(btnSubmit);
        btnPanel.add(btnCancel);

        wrapPanel = new Panel();
        wrapPanel.setLayout(layout);
        gbc.anchor = GridBagConstraints.CENTER;
        addComponent(wrapPanel, lblTitle, 0, 0, 1, 1, inset);
        addComponent(wrapPanel, mainPanel, 0, 1, 1, 1, inset);
        addComponent(wrapPanel, btnPanel, 0, 2, 1, 1, inset);
        this.add(wrapPanel);
    }

    protected void setEvent() {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        //Sự kiện thay đổi khối thi
        cbbKhoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String khoiThi = (String) cbbKhoi.getSelectedItem();
                if (khoiThi.equalsIgnoreCase("A")) {
                    lblToan.setVisible(true);
                    lblLy.setVisible(true);
                    lblHoa.setVisible(true);
                    lblSinh.setVisible(false);
                    lblVan.setVisible(false);
                    lblSu.setVisible(false);
                    lblDia.setVisible(false);

                    txtToan.setVisible(true);
                    txtLy.setVisible(true);
                    txtHoa.setVisible(true);
                    txtSinh.setVisible(false);
                    txtVan.setVisible(false);
                    txtSu.setVisible(false);
                    txtDia.setVisible(false);
                    wrapPanel.validate();
                    wrapPanel.repaint();
                } else if (khoiThi.equalsIgnoreCase("B")) {
                    lblToan.setVisible(true);
                    lblLy.setVisible(false);
                    lblHoa.setVisible(true);
                    lblSinh.setVisible(true);
                    lblVan.setVisible(false);
                    lblSu.setVisible(false);
                    lblDia.setVisible(false);

                    txtToan.setVisible(true);
                    txtLy.setVisible(false);
                    txtHoa.setVisible(true);
                    txtSinh.setVisible(true);
                    txtVan.setVisible(false);
                    txtSu.setVisible(false);
                    txtDia.setVisible(false);
                    wrapPanel.validate();
                    wrapPanel.repaint();
                } else if (khoiThi.equalsIgnoreCase("C")) {
                    lblToan.setVisible(false);
                    lblLy.setVisible(false);
                    lblHoa.setVisible(false);
                    lblSinh.setVisible(false);
                    lblVan.setVisible(true);
                    lblSu.setVisible(true);
                    lblDia.setVisible(true);

                    txtToan.setVisible(false);
                    txtLy.setVisible(false);
                    txtHoa.setVisible(false);
                    txtSinh.setVisible(false);
                    txtVan.setVisible(true);
                    txtSu.setVisible(true);
                    txtDia.setVisible(true);
                    wrapPanel.validate();
                    wrapPanel.repaint();
                }

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

    public boolean kiemTraDiem(String diem, String name) {
        diem = diem.trim();
        if (diem == null || diem.equals("")) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Điểm " + name + " không được để trống", true, DialogUI.ALERT);
            d.setVisible(true);
            return false;
        }
        if (diem.matches("^([0-9]([\\.][0-9]+)?)|10$") == false) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Điểm " + name + " chỉ được phép là số từ 0 - 10", true, DialogUI.ALERT);
            d.setVisible(true);
            return false;
        }
        return true;
    }

    public ThiSinh KiemTraDuLieu() {
        String SBD = txtSBD.getText().trim();
        String hoTen = txtHoTen.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String khoiThi = (String) cbbKhoi.getSelectedItem();
        String khuVuc = (String) cbbKhuVuc.getSelectedItem();
        String diemToan = txtToan.getText().trim();
        String diemLy = txtLy.getText().trim();
        String diemHoa = txtHoa.getText().trim();
        String diemSinh = txtSinh.getText().trim();
        String diemVan = txtVan.getText().trim();
        String diemSu = txtSu.getText().trim();
        String diemDia = txtDia.getText().trim();
        List<DiemThi> listDiem = new ArrayList<>();

        if (SBD == null || SBD.equals("")) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Số báo danh không được để trống", true, DialogUI.ALERT);
            d.setVisible(true);
            return null;
        }

        if (SBD.length() > 10) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Số báo danh tối đa là 10 kí tự", true, DialogUI.ALERT);
            d.setVisible(true);
            return null;
        }

        if (hoTen == null || hoTen.equals("")) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Họ tên không được để trống", true, DialogUI.ALERT);
            d.setVisible(true);
            return null;
        }

        if (diaChi == null || diaChi.equals("")) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Địa chỉ không được để trống", true, DialogUI.ALERT);
            d.setVisible(true);
            return null;
        }

        if (khoiThi == null || khoiThi.equals("")) {
            DialogUI d = new DialogUI(frame, "Thông báo", "Vui lòng chọn khối thi của thí sinh", true, DialogUI.ALERT);
            d.setVisible(true);
            return null;
        }

        if (khoiThi.equalsIgnoreCase("A")) {
            if (kiemTraDiem(diemToan, "toán") == false) {
                return null;
            }
            if (kiemTraDiem(diemLy, "lý") == false) {
                return null;
            }
            if (kiemTraDiem(diemHoa, "hóa") == false) {
                return null;
            }

            DiemThi diemThiToan = new DiemThi(TuyenSinh.TOAN, diemToan);
            DiemThi diemThiLy = new DiemThi(TuyenSinh.LY, diemLy);
            DiemThi diemThiHoa = new DiemThi(TuyenSinh.HOA, diemHoa);
            listDiem.add(diemThiToan);
            listDiem.add(diemThiLy);
            listDiem.add(diemThiHoa);

        } else if (khoiThi.equalsIgnoreCase("B")) {
            if (kiemTraDiem(diemToan, "toán") == false) {
                return null;
            }
            if (kiemTraDiem(diemHoa, "hóa") == false) {
                return null;
            }
            if (kiemTraDiem(diemSinh, "sinh") == false) {
                return null;
            }

            DiemThi diemThiToan = new DiemThi(TuyenSinh.TOAN, diemToan);
            DiemThi diemthiHoa = new DiemThi(TuyenSinh.HOA, diemHoa);
            DiemThi diemThiSinh = new DiemThi(TuyenSinh.SINH, diemSinh);
            listDiem.add(diemThiToan);
            listDiem.add(diemthiHoa);
            listDiem.add(diemThiSinh);

        } else if (khoiThi.equalsIgnoreCase("C")) {
            if (kiemTraDiem(diemVan, "văn") == false) {
                return null;
            }
            if (kiemTraDiem(diemSu, "sử") == false) {
                return null;
            }
            if (kiemTraDiem(diemDia, "địa") == false) {
                return null;
            }

            DiemThi diemThiVan = new DiemThi(TuyenSinh.VAN, diemVan);
            DiemThi diemThiSu = new DiemThi(TuyenSinh.SU, diemSu);
            DiemThi diemThiDia = new DiemThi(TuyenSinh.DIA, diemDia);
            listDiem.add(diemThiVan);
            listDiem.add(diemThiSu);
            listDiem.add(diemThiDia);
        }
        KhuVuc khuVucTS = new KhuVuc(null, 0f);
        for (KhuVuc element : tuyenSinh.getListKhuVuc()) {
            if (element.getMaKhuVuc().equals(khuVuc)) {
                khuVucTS = new KhuVuc(element.getMaKhuVuc(), element.getDiemUuTien());
            }
        }

        Khoi khoiTS = new Khoi(null, null);
        for (Khoi element : tuyenSinh.getListKhoiThi()) {
            if (element.getTenKhoi().equals(khoiThi)) {
                khoiTS = new Khoi(element.getMaKhoi(), element.getTenKhoi());
            }
        }

        ThiSinh thiSinh = new ThiSinh(SBD, khuVucTS, khoiTS, hoTen, diaChi, listDiem);
        return thiSinh;
    }

    protected void addComponent(Panel panel, Component component, int column,
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
        fSuaThiSinh add = new fSuaThiSinh(new fHome());
        add.setVisible(true);
    }
}
