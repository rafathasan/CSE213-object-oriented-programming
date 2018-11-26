/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deviceListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author rafikhan
 */
public class LabelMouseListener implements MouseListener{
    Color initial;
    Color change;
    Component own;
    public LabelMouseListener(Component own,Color change) {
        this.own = own;
        this.initial = own.getForeground();
        this.change = change;
    }
public LabelMouseListener(Component own,Component changeComponent) {
        this.own = own;
        this.initial = own.getForeground();
        this.change = changeComponent.getBackground();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        own.setForeground(this.change);
    }

    @Override
    public void mouseExited(MouseEvent me) {
        own.setForeground(this.initial);
    }
    
}
