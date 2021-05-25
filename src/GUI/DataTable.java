/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
        Vector data = new Vector();
        setData(data);
        this.add(new JScrollPane(table));
    } 
    
    public DataTable(Vector data) {
        setData(data);
        this.add(new JScrollPane(table));
    }
    
    public void setData(Vector data){
        Vector vctHeader = new Vector();
        vctHeader.add("STT");
        vctHeader.add("SBD");
        vctHeader.add("Họ và tên");
        vctHeader.add("Địa chỉ");
        vctHeader.add("Khu vực");
        vctHeader.add("Điểm cộng");
        vctHeader.add("Khối");
        vctHeader.add("Toán");
        vctHeader.add("Lý");
        vctHeader.add("Hóa");
        vctHeader.add("Sinh");
        vctHeader.add("Văn");
        vctHeader.add("Sử");
        vctHeader.add("Địa");
        vctHeader.add("Tổng điểm");

        DefaultTableModel model = new DefaultTableModel(data, vctHeader);

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
    }
    
    public static void main(String[] args) {
        DataTable m = new DataTable();
    }
}
