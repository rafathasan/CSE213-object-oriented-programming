/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.user;

import deviceListener.LabelButtonListener;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rafikhan
 */
public class CustomJLabelButton extends JLabel{
    protected String title;
    protected JInternalFrame frame;
    protected LabelButtonListener btnListner;
    protected JDesktopPane drawOver;
    protected JPanel parent;
    public void setComponent( JDesktopPane drawOver, JPanel parent){
        this.drawOver = drawOver;
        this.parent = parent;
        setBackground(parent.getBackground());
        frame.setTitle(title);
        addMouseListener(new LabelButtonListener(this,parent){
            @Override
            public void mousePressed(MouseEvent me) {
                drawOver.removeAll();
                drawOver.add(frame);
                drawOver.validate();
            }
        
        });
    }
}
