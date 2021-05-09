/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a;

/**
 *
 * @author Moon
 */
import java.awt.*;  
import java.awt.event.WindowEvent;  
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener; 
import javax.swing.JTextField;
public class test extends Frame{  
    test(){
        Label b = new Label("HJel");
        JTextField a = new JTextField("Hello",20);
        this.add(a);
        setSize(400,400);   
        setVisible(true);  
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
    }  
    public static void main(String[] args) {  
        new test();
    }
}