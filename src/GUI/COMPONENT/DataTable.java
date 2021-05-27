/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT;

import GUI.fHome;
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
    protected fHome home;
    public JTable table = new JTable() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public DefaultTableModel model;

    public DataTable(fHome home) {
        this.home = home;
        Vector data = new Vector();
        setData(data);
        this.add(new JScrollPane(table));
        table.addMouseListener(new PopupMenuListener(home));
    }

    public DataTable(fHome home, Vector data) {
        this.home = home;
        setData(data);
        this.add(new JScrollPane(table));
        table.addMouseListener(new PopupMenuListener(home));
    }

    public void setData(Vector data) {
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

        model = new DefaultTableModel(data, vctHeader);
        while (model.getRowCount() < 25) {
            model.addRow(new Vector<String>());
        }

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

        for (int i = 4; i < 15; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        this.setSTT();
    }

    public void addARow(Vector data) {
        model.insertRow(0, data);
        model.removeRow(model.getRowCount() - 1);
        this.setSTT();
    }

    public void updateTable(Vector data) {
        int row = table.getSelectedRow();
        model.removeRow(row);
        model.insertRow(row, data);
        model.fireTableDataChanged();
        this.setSTT();
    }

    public void removeRowSelected() {
        int row = table.getSelectedRow();
        model.removeRow(row);
        model.addRow(new Vector());
        this.setSTT();
    }

    public void setSTT() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);
        }
        table.revalidate();
        table.repaint();
        table.addMouseListener(new PopupMenuListener(home));
    }
}
