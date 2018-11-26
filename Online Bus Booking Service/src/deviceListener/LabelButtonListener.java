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
import javax.swing.JPanel;

/**
 *
 * @author rafikhan
 */
public class LabelButtonListener implements MouseListener{
    Color initial;
    Color change;
    private Component parent;
    private Component own;
    private Component domain;
    private boolean triger=true;

    /**
     *
     * @param own
     * own represent the Label object itself.
     * @param domain
     * domain represent other component which color will adopt.
     */
    public void setDrawOnParent(Component own){
        this.own = own;
        initial = own.getBackground();
        change = own.getBackground().darker();
        own.setBackground(initial);
    }
    
    public LabelButtonListener() {
    }
    public LabelButtonListener(Component own, Component domain) {
        this.own = own;
        this.domain = domain;
        initial = own.getBackground();
        change = domain.getBackground();
        own.setBackground(initial);
    }
    public LabelButtonListener(Component own){
        this.own=own;
        initial = own.getBackground();
        change = own.getBackground().darker();
        own.setBackground(initial);
    }
    public LabelButtonListener(Component own, Color color,Component domain) {
        this.own = own;
        this.domain = domain;
        initial = color;
        change = domain.getBackground();
        own.setBackground(initial);
    }
    public LabelButtonListener(Component own, JPanel parent) {
        this.parent = parent;
        this.own=own;
        initial = parent.getBackground();
        change = parent.getBackground().darker();
        own.setBackground(initial);
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
        if(own!=null){
            own.setBackground(change);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(own!=null){
            own.setBackground(initial);
        }
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
    
}
