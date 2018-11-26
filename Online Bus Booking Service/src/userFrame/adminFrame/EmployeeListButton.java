/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userFrame.adminFrame;

import classes.user.CustomJLabelButton;
import deviceListener.LabelButtonListener;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;

/**
 *
 * @author rafikhan
 */
public class EmployeeListButton extends CustomJLabelButton{
    public EmployeeListButton() {
        setText("Employee List");
        setHorizontalAlignment(CENTER);
        setOpaque(true);
        setFont(new Font("Serif", Font.BOLD, 18));
        frame = new EmployeeList();
        title = "Employee List";
    }
}
