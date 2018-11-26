/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonJinternalFrames;

import classes.user.CustomJLabelButton;
import java.awt.Font;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author rafikhan
 */
public class AddVoucherButton extends CustomJLabelButton{
    public AddVoucherButton() {
        setText("Add Voucher");
        setHorizontalAlignment(CENTER);
        setOpaque(true);
        setFont(new Font("Serif", Font.BOLD, 18));
        frame = new AddVoutcher();
        title = "Add Voucher";
    }
}
