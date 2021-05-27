/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.COMPONENT.NhapThongTin;
import GUI.COMPONENT.DialogUI;
import ENTITY.ThiSinh;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class fThemThiSinh extends NhapThongTin {

    public fThemThiSinh(Frame parent) {
        super();
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
}
