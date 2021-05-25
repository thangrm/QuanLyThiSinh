/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;
/**
 *
 * @author Moon
 */

import DATABASE.SQLServer;
import ENTITY.ThiSinh;
import ENTITY.TuyenSinh;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class fHome extends Frame {

    private Panel panel;
    
    private GridBagLayout layout;
    private GridBagConstraints gbc;

    fHome() {
       setUI();
       setEvent();
    }
    
    private void setUI()
    {   
        this.setSize(1200, 380);
        this.setTitle("Quản lý thí sinh");
        this.setLayout(new FlowLayout());
        //this.setBackground(new Color(50, 60, 82)); 
        TuyenSinh tuyenSinh = new TuyenSinh(SQLServer.getThiSinh());
        ThiSinh thiSinh = tuyenSinh.getListThiSinh().get(0);
        Vector data = new Vector();
        data = tuyenSinh.HienThi();
        System.out.println(data.get(0));
        DataTable tb = new DataTable(data);
        
        panel = new Panel();
        //panel.setPreferredSize(new Dimension(500, 280));
        layout = new GridBagLayout();
        panel.setLayout(layout);
        gbc = new GridBagConstraints();
        
        Insets inset = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.CENTER;
        addComponent(tb, 0, 0, 1, 1, inset);
        
        this.add(panel);
    }
    private void setEvent()
    {
        // Sự kiện nút đóng window
        this.addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        }); 
    } 
  
    private void addComponent(Component component, int column,
            int row, int width, int height, Insets inset) {
        gbc.gridx = column;
        gbc.gridy = row;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = inset;
        layout.setConstraints(component, gbc);
        panel.add(component);
    }

    public static void main(String[] args)
    {
        fHome home = new fHome();
        home.setVisible(true);
    }
}
