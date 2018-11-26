/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import javax.swing.JFrame;

/**
 *
 * @author rafikhan
 */
public class MultipleWindowHandle {
    static public void disposeState(JFrame own, JFrame parent){
        own.dispose();
        parent.setVisible(true);
    }
    static public void hideState(JFrame own, JFrame parent){
        own.setVisible(false);
        parent.setVisible(true);
    }
}
