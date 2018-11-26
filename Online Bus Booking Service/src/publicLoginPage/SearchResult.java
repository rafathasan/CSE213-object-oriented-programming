/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicLoginPage;

import classes.BusSchedule;
import classes.Ticket;
import deviceAdapter.CustomWindowAdapter;
import deviceListener.LabelButtonListener;
import deviceListener.MouseDragListener;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import operations.FindBusByID;
import operations.MultipleWindowHandle;

/**
 *
 * @author rafikhan
 */
public class SearchResult extends javax.swing.JFrame {

    /**
     * Creates new form SearchResult
     */
    public Search parent;
    private SearchResult own=this;
    public SearchResult(Search parent) {
        initComponents();
        this.parent = parent;
        
        jLabelPerson.setText( parent.jSpinner1.getValue().toString() );
        
        jPanel2.addMouseListener(new MouseDragListener(jPanel2));
        
        jLabel6.addMouseListener(new LabelButtonListener(jLabel6){
            @Override
            public void mousePressed(MouseEvent me) {
                if(jTable1.getSelectedRow()>-1){
                if( JOptionPane.showOptionDialog(own, "Already have Account ?", "Tell us", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION ){
                    
                    int row = jTable1.getSelectedRow();
                    Ticket t = new Ticket(
                    jTable1.getValueAt(row, 8).toString(),
                    "",
                    parent.datePicker1.getText(),
                    jTable1.getValueAt(row, 1).toString(),
                    Integer.valueOf(parent.jSpinner1.getValue().toString()) ,
                    Integer.valueOf(jLabelTotal.getText())
                    );
                    
                    MultipleWindowHandle.disposeState(new Search(new Splash()), new LoginPage(own, t));
                    own.dispose();
                }else{
                    
                    int row = jTable1.getSelectedRow();
                    Ticket t = new Ticket(
                    jTable1.getValueAt(row, 8).toString(),
                    "",
                    parent.datePicker1.getText(),
                    jTable1.getValueAt(row, 1).toString(),
                    Integer.valueOf(parent.jSpinner1.getValue().toString()) ,
                    Integer.valueOf(jLabelTotal.getText())
                    );
                    
                    MultipleWindowHandle.disposeState(new Search(new Splash()),new Registration(own, t));
                    own.dispose();
                }
                }else{
                    
                }
            }
            
        });
        jLabel20.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }
            @Override
            public void mousePressed(MouseEvent me) {
                MultipleWindowHandle.disposeState(own, parent);
            }
            @Override
            public void mouseReleased(MouseEvent me) {
            }
            @Override
            public void mouseEntered(MouseEvent me) {
            }
            @Override
            public void mouseExited(MouseEvent me) {            
            }
        });
        
        
        
        
        loadData();
    }
    
    private void loadData(){
        ArrayList<BusSchedule> list=null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("SCHEDULE")));
            list = (ArrayList<BusSchedule>) ois.readObject();
            ois.close();
        }catch(Exception ex){
        }
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        if(list!=null){
            for(int i=0; i<list.size() ; i++){
                if(list.get(i).isActive()){
                    if(!list.get(i).getBusReg().equals("")){
                        if( list.get(i).getDepartCity().equals(parent.jComboBox2.getSelectedItem().toString()) 
                                &&
                                list.get(i).getArriveCity().equals(parent.jComboBox1.getSelectedItem().toString()) 
                                ){
                            if( FindBusByID.byReg(list.get(i).getBusReg()).isAc() == parent.checkbox1.getState()  ){
                                Date sdf1 = null,sdf2 = null,sdf3 = null;
                                try{
                                    SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                                    sdf1 = sdf.parse( list.get(i).getStart() );
                                    sdf2 = sdf.parse( list.get(i).getEnd() );
                                    sdf3 = sdf.parse( parent.datePicker1.getText() );
                                }catch(Exception ex){
                                    System.out.println(ex);
                                }
                                if( sdf1.before(sdf3) && sdf2.after(sdf3) ){
                                    if( Integer.valueOf(parent.jSpinner1.getValue().toString()) <= list.get(i).getSeatAvailable() ){
                                        dm.addRow(new Object[]{
                                            FindBusByID.byReg(list.get(i).getBusReg()).getCompany(),
                                            list.get(i).getBusReg(),
                                            list.get(i).getDepartCity(),
                                            list.get(i).getArriveCity(),
                                            list.get(i).getDepart(),
                                            list.get(i).getArriving(),
                                            list.get(i).getSeatAvailable(),
                                            FindBusByID.byReg(list.get(i).getBusReg()).calcTotalFare(),
                                            list.get(i).getId()
                                        });
                                    }
                                }
                            }
                        }
                    }
                }
            }
            jTable1.setModel(dm);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabelPerson = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabelFare = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(41, 44, 61));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(66, 182, 145));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Book");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 140, 70));

        jTable1.setBackground(new java.awt.Color(41, 44, 61));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Company", "BusReg", "Dapart City", "Arrive City", "Dapart Time", "Arrive Time", "Seat Available", "Fare", "Ticket Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 800, 320));

        jPanel3.setLayout(new java.awt.GridLayout(0, 8));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 800, -1));

        jPanel2.setBackground(new java.awt.Color(66, 182, 145));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Total = ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Find and book your bus");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 10, 120));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Amount Breakdown :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jLabelPerson.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPerson.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPerson.setText(" ");
        jPanel1.add(jLabelPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 60, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Bus Fare = ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 100, -1));

        jLabelTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setText(" ");
        jPanel1.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 60, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 160, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Person = ");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 100, -1));

        jLabelFare.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelFare.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFare.setText(" ");
        jPanel1.add(jLabelFare, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 60, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("X");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 10, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        jLabelFare.setText(jTable1.getValueAt(row, 7).toString());
        int total = Integer.valueOf(jLabelFare.getText())* Integer.valueOf(parent.jSpinner1.getValue().toString());
        jLabelTotal.setText( String.valueOf(total) );
    }//GEN-LAST:event_jTable1MousePressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFare;
    private javax.swing.JLabel jLabelPerson;
    public javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
