/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.COMPONENT.NhapThongTin;
import GUI.COMPONENT.DialogUI;
import ENTITY.ThiSinh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class fThemThiSinh extends NhapThongTin {

    private fThemThiSinh formThemThiSinh;
    private fHome home;

    public fThemThiSinh(fHome home) {
        super();
        this.formThemThiSinh = this;
        this.home = home;
        this.lblTitle.setText("Thêm thông tin thí sinh mới");
        this.btnSubmit.setLabel("Thêm mới");

        // Sự kiện click nút xác nhận
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh thiSinh = KiemTraDuLieu();
                if (thiSinh == null) {
                    return;
                }
                String messager = tuyenSinh.NhapThongTinThiSinh(thiSinh);
                if (messager.equalsIgnoreCase("OK")) {
                    formThemThiSinh.dispose();
                    home.tb.addARow(tuyenSinh.HienThiMotThiSinh(thiSinh));
                    DialogUI d = new DialogUI(frame, "Thành công", "Thêm thí sinh mới thành công!", true, DialogUI.OK);
                    d.setVisible(true);
                } else if (messager.equalsIgnoreCase("Duplicate entry")) {
                    DialogUI d = new DialogUI(frame, "Thông báo", "Trùng số báo danh. Vui lòng nhập lại!", true, DialogUI.ALERT);
                    d.setVisible(true);
                } else {
                    DialogUI d = new DialogUI(frame, "Thông báo", "Thêm không thành công. Vui lòng thử lại sau!", true, DialogUI.ALERT);
                    d.setVisible(true);
                }
            }
        });

    }

    public void resetData() {
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
}
