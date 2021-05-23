/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class DataTable extends Panel {

    private JTable table = new JTable();

    public DataTable() {

        String data[][] = {{"1", "2018601856", "Hoàng Văn Thắng", "Thường Tín - Hà Nội", "KV2", "0.25","A","10","9","9","-","-","-","-","28.25"},
        {"2", "2018601761", "Trần Công Sơn", "Hải Dương", "KV2-NT", "0.5","B","10","-","9","8","-","-","-","27.5"},
        {"3", "2018600804", "Nguyễn Xuân Quang", "Quảng Ninh", "KV1", "0.75","C","-","-","-","-","9","9","9","27.75"}};
        String columns[] = {"STT", "SBD", "Họ và tên", "Địa chỉ", "khu vực", "Điểm cộng", "Khối", "Toán", "Lý", "Hóa", "Sinh", "Văn", "Sử", "Địa", "Tổng điểm"};
        DefaultTableModel model = new DefaultTableModel(data, columns);

        table.setModel(model);
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        table.setSize(800, 300);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);

        table.getColumnModel().getColumn(0).setPreferredWidth(35);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(6).setPreferredWidth(60);
        table.getColumnModel().getColumn(7).setPreferredWidth(38);
        table.getColumnModel().getColumn(8).setPreferredWidth(38);
        table.getColumnModel().getColumn(9).setPreferredWidth(38);
        table.getColumnModel().getColumn(10).setPreferredWidth(38);
        table.getColumnModel().getColumn(11).setPreferredWidth(38);
        table.getColumnModel().getColumn(12).setPreferredWidth(38);
        table.getColumnModel().getColumn(13).setPreferredWidth(38);
        table.getColumnModel().getColumn(14).setPreferredWidth(80);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        for(int i = 4; i < 15; i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        add(new JScrollPane(table));
    }

    public static void main(String[] args) {
        DataTable m = new DataTable();
    }
}
