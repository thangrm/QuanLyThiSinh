/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class TuyenSinh {
    protected List<ThiSinh> listThiSinh;

    public TuyenSinh(List<ThiSinh> listThiSinh) {
        this.listThiSinh = listThiSinh;
    }

    public List<ThiSinh> getListThiSinh() {
        return listThiSinh;
    }

    public void setListThiSinh(List<ThiSinh> listThiSinh) {
        this.listThiSinh = listThiSinh;
    }
    
    public Vector HienThiMotThiSinh(ThiSinh thisinh){
        String TOAN = "MON01";
        String LY = "MON02";
        String HOA = "MON03";
        String SINH = "MON04";
        String VAN = "MON05";
        String SU = "MON06";
        String DIA = "MON07";
        
        Vector row = new Vector();
        row.add(1);
        row.add(thisinh.getSoBaoDanh());
        row.add(thisinh.getHoTen());
        row.add(thisinh.getDiaChi());
        row.add(thisinh.getKhuVuc().getMaKhuVuc());
        row.add(thisinh.getKhuVuc().getDiemUuTien());
        row.add(thisinh.getKhoiThi().getTenKhoi());
        row.add(thisinh.getDiemTheoMon(TOAN));
        row.add(thisinh.getDiemTheoMon(LY));
        row.add(thisinh.getDiemTheoMon(HOA));
        row.add(thisinh.getDiemTheoMon(SINH));
        row.add(thisinh.getDiemTheoMon(VAN));
        row.add(thisinh.getDiemTheoMon(SU));
        row.add(thisinh.getDiemTheoMon(DIA));      
        row.add(thisinh.getTongDiem());
        return row;
    }
    
    public Vector HienThi(){  
        Vector data = new Vector();
        int stt = 0;
        for(ThiSinh thiSinh : listThiSinh){
            stt++;
            Vector row = this.HienThiMotThiSinh(thiSinh);
            row.set(0, stt);
            data.add(row);
        }
        return data;
    }
    
    public void NhapThongTinThiSinh(){}
    
    public void TimKiemTheoSBD(){}
}
