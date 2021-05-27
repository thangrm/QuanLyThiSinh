/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.COMPONENT;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
import java.awt.*;
import java.awt.event.*;

public class ImageUI extends Panel {
    
    Image image;
    
    public ImageUI(String pathFile) {
        this.setSize(new Dimension(400, 400));
        MediaTracker mt = new MediaTracker(this);
        image = Toolkit.getDefaultToolkit().getImage(pathFile);
        mt.addImage(image, 0);
    }
    
    public void update(Graphics g) {
        paint(g);
    }
    
    public void paint(Graphics g) {
        if (image != null) {
            super.paint(g);
            int w = this.getWidth();
            int h = this.getHeight();
            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);
            int x = (w - imageWidth) / 2;
            int y = (h - imageHeight) / 2;
            g.drawImage(image, 0, 0, this);
        } else {
            g.clearRect(0, 0, getSize().width, getSize().height);
        }
    }
}
