/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT;

import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JComboBox;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
public class ComboBoxUI extends JComboBox {

    public ComboBoxUI() {
        super();
        this.setPreferredSize(new Dimension(200, 25));
    }

    public ComboBoxUI(Object[] data) {
        super(data);
        this.setPreferredSize(new Dimension(200, 25));
    }
    
     public ComboBoxUI(Vector data) {
        super(data);
        this.setPreferredSize(new Dimension(200, 25));
    }
}
