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

import java.awt.*;
import java.awt.event.*;

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
        DataTable tb = new DataTable();
        
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
    
    private void renderTable(){
        
        TextField STT = new TextField(1);
        STT.setText("#");
        STT.setFocusable(false);
        STT.setForeground(Color.white);
        STT.setBackground(Color.red);
        STT.setFont(new Font("Verdana", Font.BOLD, 12));
        
        TextField SBD = new TextField(12);
        SBD.setText("Số báo danh");
        SBD.setFocusable(false);
        SBD.setForeground(Color.white);
        SBD.setBackground(Color.red);
        SBD.setFont(new Font("Verdana", Font.BOLD, 12));
        
        TextField hoTen = new TextField(20);
        hoTen.setText("Họ và tên");
        hoTen.setFocusable(false);
        hoTen.setForeground(Color.white);
        hoTen.setBackground(Color.red);
        hoTen.setFont(new Font("Verdana", Font.BOLD, 12));
        
        
        TextField diaChi = new TextField(25);
        diaChi.setText("Địa chỉ");
        diaChi.setFocusable(false);
        diaChi.setForeground(Color.white);
        diaChi.setBackground(Color.red);
        diaChi.setFont(new Font("Verdana", Font.BOLD, 12));
        
        TextField khuVuc = new TextField(12);
        khuVuc.setText("Khu vực ưu tiên");
        khuVuc.setFocusable(false);
        khuVuc.setForeground(Color.white);
        khuVuc.setBackground(Color.red);
        khuVuc.setFont(new Font("Verdana", Font.BOLD, 12));
        
        panel = new Panel();
        //panel.setPreferredSize(new Dimension(500, 280));
        layout = new GridBagLayout();
        panel.setLayout(layout);
        gbc = new GridBagConstraints();
        
        Insets inset = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.CENTER;
        addComponent(STT, 0, 0, 1, 1, inset);
        addComponent(SBD, 1, 0, 1, 1, inset);
        addComponent(hoTen, 2, 0, 1, 1, inset);
        addComponent(diaChi, 3, 0, 1, 1, inset);
        addComponent(khuVuc, 4, 0, 1, 1, inset);
        
        this.add(panel);
        
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
