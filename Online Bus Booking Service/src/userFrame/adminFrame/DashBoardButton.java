/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userFrame.adminFrame;

import classes.user.CustomJLabelButton;
import commonJinternalFrames.AddBusEmployee;
import deviceListener.LabelButtonListener;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

/**
 *
 * @author rafikhan
 */
public class DashBoardButton extends CustomJLabelButton{
    public DashBoardButton() {
        setText("Dashboard");
        setHorizontalAlignment(CENTER);
        setOpaque(true);
        setFont(new Font("Serif", Font.BOLD, 18));
        frame = new DashBoard();
        title = "Add Bus";
    }
}
