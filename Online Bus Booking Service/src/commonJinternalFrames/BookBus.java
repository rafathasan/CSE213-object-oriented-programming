/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonJinternalFrames;

import classes.Ticket;
import classes.user.User;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import operations.FindTicket;
import operations.FindUser;
import operations.ReadSchudule;

/**
 *
 * @author rafikhan
 */
public class BookBus extends javax.swing.JInternalFrame {

    /**
     * Creates new form BookBus
     */
    private User user;
    
    public BookBus(User user) {
        initComponents();
        this.user = user;
        
        System.out.println("Name : "+user.getName());
        System.out.println("user : "+user.getUsername());
        System.out.println("Email : "+user.getEmail());
        System.out.println("Cell : "+user.getCell());
        System.out.println("User ID: "+user.getId());
        
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setBorder(null);
        setVisible(true);
        
    }
    
    private void loadData(){
        new SwingWorker(){
            @Override
            protected Object doInBackground() throws Exception {
                ArrayList<Ticket> list=null;
                ArrayList<Ticket> found= new ArrayList<Ticket>();
                try{
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("TICKET")));
                    list = (ArrayList<Ticket>) ois.readObject();
                    ois.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                for(int i=0;i<list.size();i++){
                    if(list.get(i).getUserId().equals(user.getId())){
                        found.add(list.get(i));
                    }   
                }

                DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
                dm.setRowCount(0);
                
                for(int i=0;i<found.size();i++){
                    dm.addRow(new Object[]{
                        found.get(i).getId(),
                        found.get(i).getDate(),
                        found.get(i).getBusReg(),
                        found.get(i).getUserId(),
                        found.get(i).getPerson(),
                        found.get(i).getFare(),
                        found.get(i).isPaymentDone(),
                        found.get(i).getPayment().getId()
                    });
                }
                jTable1.setModel(dm);
                return true;
            }   
        }.execute();
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(60, 74, 77));

        jButton1.setText("Make Payment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Export Ticket as Pdf");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("View Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(60, 74, 77));

        jTable1.setBackground(new java.awt.Color(60, 74, 77));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "date", "busReg", "userId", "person", "fare", "Payment", "paymentid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()>-1){
            int row = jTable1.getSelectedRow();
            boolean is = (boolean) jTable1.getValueAt(row, 6);
            if(!is){
                JDialog dialog = null;
                dialog = new JOptionPane(new MakePayment(jTable1), -1, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null).createDialog("Make Payment");
                dialog.pack();
                dialog.setVisible(true);
                loadData();
            }else{
                JOptionPane.showMessageDialog(this, "Already Paid");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        boolean selected = row > -1;
        boolean is = (boolean) jTable1.getValueAt(row, 6);
        if(is && selected){
            Document doc = new Document();
            JFileChooser jfc = new JFileChooser();
            jfc.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
            jfc.showSaveDialog(this);
            try{
                PdfWriter.getInstance(doc, new FileOutputStream(jfc.getSelectedFile()));
                doc.open();
                
                DottedLineSeparator dottedline = new DottedLineSeparator();
                dottedline.setOffset(-2);
                dottedline.setGap(2f);
                
                doc.add(new Paragraph("YOUR BUS TICKET", new Font(Font.FontFamily.COURIER, 18)));
                doc.add(dottedline);
                doc.add(new Paragraph("Keep this with you During Travel", new Font(Font.FontFamily.COURIER, 14)));
                doc.add(dottedline);
                doc.add(Chunk.NEWLINE);
                doc.add(new Paragraph("Date : "+ jTable1.getValueAt(row, 1)));
                doc.add(new Paragraph("Ticket ID : "+ jTable1.getValueAt(row, 0)));
                doc.add(new Paragraph("BUS Registration : "+ jTable1.getValueAt(row, 2)));
                doc.add(dottedline);
                doc.add( new Paragraph("Passenger ID : "+ FindUser.FindUserById(jTable1.getValueAt(row, 3).toString()).getId() ));
                doc.add( new Paragraph("Passenger Name : "+ FindUser.FindUserById(jTable1.getValueAt(row, 3).toString()).getName()));
                doc.add(Chunk.NEWLINE);
                doc.add(new Paragraph("Person : "+ jTable1.getValueAt(row, 4)));
                doc.add(new Paragraph("Payment ID : "+ jTable1.getValueAt(row, 7)));
                doc.add(new Paragraph("Fare :"+ jTable1.getValueAt(row, 5)));
                doc.add(dottedline);
                

                
                doc.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + jfc.getSelectedFile().getAbsolutePath() );
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "PDF Creation Failed");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Make The Payment to Print");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        boolean selected = row > -1;
        boolean is = (boolean) jTable1.getValueAt(row, 6);
        if(!is && selected){
        String id = jTable1.getValueAt(row, 0).toString();
        FindTicket.deleteTicket(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString(), jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString(), jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
            ReadSchudule.decrementSchudule(id);
        loadData();
        }else{
            JOptionPane.showMessageDialog(this, "Cant Remove Paid Ticket");

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()>-1){
            JDialog dialog = null;
            dialog = new JOptionPane(new ViewBus(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()), -1, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null).createDialog("Details");
            dialog.pack();
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    static public void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame fame = new JFrame();
                fame.setSize(800, 500);
                fame.setLayout(new BorderLayout());
                fame.add(new BookBus(null));
                fame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}