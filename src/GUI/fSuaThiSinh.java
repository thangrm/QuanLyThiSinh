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
import GUI.COMPONENT.NhapThongTin;
import GUI.COMPONENT.DialogUI;
import DATABASE.SQLServer;
import ENTITY.DiemThi;
import ENTITY.ThiSinh;
import ENTITY.TuyenSinh;
import LIB.Config;
import java.awt.*;
import java.awt.MenuBar;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class fSuaThiSinh extends NhapThongTin {
    public Frame parent;
    protected String soBaoDanh;

    public fSuaThiSinh(fHome parent) {
        super();
        this.parent = parent;
        this.frame.setTitle("Sửa thông tin thí sinh");
        this.lblTitle.setText("Chỉnh sửa thông tin thí sinh");
        this.txtSBD.setEnabled(false);
        this.soBaoDanh = null;

        // Sự kiện click nút xác nhận
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh thiSinh = KiemTraDuLieu();
                if (thiSinh == null) {
                    return;
                }
                String messager = tuyenSinh.SuaThongTinThiSinh(thiSinh);
                if (messager.equalsIgnoreCase("OK")) {
                    frame.setVisible(false);
                    parent.tb.updateTable(tuyenSinh.HienThiMotThiSinh(thiSinh));
                    DialogUI d = new DialogUI(frame, "Thành công", "Sửa thông tin thí sinh thành công!", true, DialogUI.OK);
                    d.setVisible(true);
                } else if (messager.equalsIgnoreCase("Error")) {
                    DialogUI d = new DialogUI(frame, "Thông báo", "Sửa không thành công. Vui lòng thử lại sau!", true, DialogUI.ALERT);
                    d.setVisible(true);
                } else {
                    DialogUI d = new DialogUI(frame, "Thông báo", "Sửa không thành công. Vui lòng thử lại sau!", true, DialogUI.ALERT);
                    d.setVisible(true);
                }
                
            }
        });
    }

    public void layThongTinThiSinh(String soBaoDanh) {
        xoaDuLieu();
        ThiSinh thiSinh = SQLServer.getThiSinh(soBaoDanh);
        if (thiSinh == null) {
            return;
        }

        txtSBD.setText(thiSinh.getSoBaoDanh());
        txtHoTen.setText(thiSinh.getHoTen());
        txtDiaChi.setText(thiSinh.getDiaChi());
        cbbKhuVuc.setSelectedItem(thiSinh.getKhuVuc().getMaKhuVuc());
        cbbKhoi.setSelectedItem(thiSinh.getKhoiThi().getTenKhoi());
        txtToan.setText(thiSinh.getDiemTheoMon(TuyenSinh.TOAN));
        txtLy.setText(thiSinh.getDiemTheoMon(TuyenSinh.LY));
        txtHoa.setText(thiSinh.getDiemTheoMon(TuyenSinh.HOA));
        txtSinh.setText(thiSinh.getDiemTheoMon(TuyenSinh.SINH));
        txtVan.setText(thiSinh.getDiemTheoMon(TuyenSinh.VAN));
        txtSu.setText(thiSinh.getDiemTheoMon(TuyenSinh.SU));
        txtDia.setText(thiSinh.getDiemTheoMon(TuyenSinh.DIA));

    }

    public void xoaDuLieu() {
        txtSBD.setText("");
        txtHoTen.setText("");
        txtDiaChi.setText("");
        txtToan.setText("");
        txtLy.setText("");
        txtHoa.setText("");
        txtSinh.setText("");
        txtVan.setText("");
        txtSu.setText("");
        txtDia.setText("");
    }

    public static void main(String[] args) {
        fHome home = new fHome();
        home.setVisible(true);
    }
}
