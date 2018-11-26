/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deviceAdapter;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author rafikhan
 */
public class CustomWindowAdapter extends WindowAdapter{
    private final Container parent;
    private final Container owner;

    public CustomWindowAdapter(Container parent, Container owner) {
        this.parent = parent;
        this.owner = owner;
    }

    @Override
    public void windowOpened(WindowEvent we) {
        parent.setEnabled(false);
        ((JFrame) owner).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    
    @Override
    public void windowClosing(WindowEvent we) {
        parent.setEnabled(true);
        ((JFrame) owner).dispose();
    }
}
