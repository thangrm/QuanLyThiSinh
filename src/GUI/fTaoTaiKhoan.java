/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ENTITY.TaiKhoan;
import ENTITY.ThiSinh;
import GUI.COMPONENT.DialogUI;
import GUI.COMPONENT.TAIKHOAN.NhapThongTinTaiKhoan;
import LIB.Config;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class fTaoTaiKhoan extends NhapThongTinTaiKhoan{
    
    private fTaoTaiKhoan formTaoTaiKhoan;
    private fHome home;

    public fTaoTaiKhoan(fHome home) {
        super();
        this.formTaoTaiKhoan = this;
        this.home = home;
        this.lblTitle.setText("Thêm thông tin tài khoản mới");
        this.btnSubmit.setLabel("Thêm mới");

        // Sự kiện click nút xác nhận
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaiKhoan tk = ThemTaiKhoan();
                if(tk != null)
                {
                    home.tbTaiKhoan.addARow(Config.qlTaiKhoan.HienThiMotTaiKhoan(tk));
                }
            }
        });

    }

    public void resetData() {
        txtUsername.setText("");
    }
}
