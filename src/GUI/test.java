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

public class test extends Frame{  
    test(){  
        addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
    }  
    public static void main(String[] args) {  
        new test();  
    }
}