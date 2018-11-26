/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userFrame.adminFrame;

import classes.user.CustomJLabelButton;
import classes.user.User;
import commonJinternalFrames.AddBusEmployeeButton;
import commonJinternalFrames.AddBusSchuduleButton;
import commonJinternalFrames.AddRouteButton;
import commonJinternalFrames.AddVoucherButton;
import commonJinternalFrames.BookBusButton;
import java.io.Serializable;

/**
 *
 * @author rafikhan
 */
public class TabContainer implements Serializable{
    static public final String DASHBOARD = "Dashboard";
    static public final String EMPLOYEE_LIST = "Employee_List";
    static public final String BOOK_BUS = "Book_Bus";
    static public final String BUS_SCHUDULE = "Bus_Schudule";
    static public final String ADD_BUS = "Add_Bus";
    static public final String ADD_ROUTE = "Add_Route";
    static public final String EMPLOYEE_RECUIT = "Employee_Recuit";
    static public final String ADD_VOUCHER = "Add_Voucher";
    static public final String PAYROLL = "Payroll";
    static public final String REPORT = "Report";
    static public final String REVENUE = "Revenue";
    
    static public CustomJLabelButton getButton(String tab,User user){
        if(tab.equals(DASHBOARD)){
            return new DashBoardButton();
        }else if(tab.equals(EMPLOYEE_LIST)){
            return new EmployeeListButton();
        }else if(tab.equals(BOOK_BUS)){
            return new BookBusButton(user);
        }else if(tab.equals(BUS_SCHUDULE)){
            return new AddBusSchuduleButton();
        }else if(tab.equals(ADD_BUS)){
            return new AddBusEmployeeButton();
        }else if(tab.equals(ADD_ROUTE)){
            return new AddRouteButton();
        }else if(tab.equals(EMPLOYEE_RECUIT)){
            return new EmployeeRecuitFormButton();
        }else if(tab.equals(ADD_VOUCHER)){
            return new AddVoucherButton();
        }else if(tab.equals(PAYROLL)){
            return new PayrollFormButton(user);
        }else if(tab.equals(REPORT)){
            return new ReportGenarationButton();
        }else if(tab.equals(REVENUE)){
            return new RevenueGenarateButton();
        }else{
            return null;
        }
    }
}
