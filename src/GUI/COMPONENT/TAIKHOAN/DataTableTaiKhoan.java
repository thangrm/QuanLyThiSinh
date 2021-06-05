/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT.TAIKHOAN;

import GUI.COMPONENT.PopupMenuListener;
import GUI.fHome;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class DataTableTaiKhoan extends Panel {

    protected fHome home;
    public JTable table = new JTable() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public DefaultTableModel model;

    public DataTableTaiKhoan(fHome home) {
        this.home = home;
        Vector data = new Vector();
        setData(data);
        this.add(new JScrollPane(table));
        table.addMouseListener(new PopupMenuListenerTaiKhoan(home));
    }

    public DataTableTaiKhoan(fHome home, Vector data) {
        this.home = home;
        setData(data);
        this.add(new JScrollPane(table));
        table.addMouseListener(new PopupMenuListenerTaiKhoan(home));
    }

    public void setData(Vector data) {
        Vector vctHeader = new Vector();
        vctHeader.add("STT");
        vctHeader.add("Tên tai khoản");
        vctHeader.add("Loại tài khoản");

        model = new DefaultTableModel(data, vctHeader);
        while (model.getRowCount() < 25) {
            model.addRow(new Vector<String>());
        }

        table.setModel(model);
        table.setShowGrid(true);
        table.setGridColor(Color.BLACK);
        table.setPreferredSize(new Dimension(800,400));
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        for (int i = 0; i < 3; i++) {
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
        model.fireTableDataChanged();
        table.revalidate();
        table.repaint();
        table.addMouseListener(new PopupMenuListenerTaiKhoan(home));
        home.revalidate();
        home.repaint();
    }
}
