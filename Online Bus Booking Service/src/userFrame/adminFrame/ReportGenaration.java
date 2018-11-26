/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userFrame.adminFrame;

import classes.Bus;
import classes.BusSchedule;
import classes.Ticket;
import classes.user.Employee;
import classes.user.Passenger;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import operations.CreateFreeChart;
import operations.FindBusByID;
import operations.FindEmployee;
import operations.FindPassenger;
import operations.FindTicket;
import operations.ReadSchudule;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author rafikhan
 */
public class ReportGenaration extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReportGenaration
     */
    private JFreeChart chart;
    private ArrayList<String> dataSet;
    public ReportGenaration() {
        super("Report");
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setBorder(null);
        setVisible(true);
        pieChart();
        barChart();
        try {
            lineChart();
        } catch (Exception ex) {
        }
    }
    
    private void barChart(){
        DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
//        bardataset.setValue(1, "A1", "2015" );
//        bardataset.setValue(5, "A2", "2015" );
//        bardataset.setValue(8, "B1", "2014" );
        ArrayList<BusSchedule> busList = ReadSchudule.getBusSchudule();
        ArrayList<Ticket> tList = FindTicket.getTicket();
        ArrayList<Bus> bList = FindBusByID.getBuses();
        
        int val;
        for(BusSchedule temp: busList){
            val=0;
            for(Ticket temj: tList){
                if(temp.getId().equals(temj.getId())){
                    val++;
                }
            }
            bardataset.setValue(val, "Sales", temp.getDepartCity() );
            
            val=0;
            for(Bus temk: bList){
                if(temp.getBusReg().equals(temk.getRegNo())){
                    val++;
                }
            }
            bardataset.setValue(val, "Bus", temp.getDepartCity() );
        }
        
        CreateFreeChart.createBarChart("Route", "Sales", "Points", bardataset, jPanel15);
    }
    
    private void pieChart(){
        DefaultPieDataset piedataset = new DefaultPieDataset();
        
        int val=0;
        for(Employee temp:FindEmployee.getEmployee()){
            val++;
        }
        piedataset.setValue("Employee", new Integer(val));
        
        val=0;
        for(Passenger temp:FindPassenger.getPassenger()){
            val++;
        }
        piedataset.setValue("Passenger", new Integer(val));
        
        val = 0;
        for(Bus temp:FindBusByID.getBuses()){
            val++;
        }
        piedataset.setValue("Bus", new Integer(val));
        
        val = 0;
        for(BusSchedule temp:ReadSchudule.getBusSchudule()){
            val++;
        }
        piedataset.setValue("Route", new Integer(val));
        
        CreateFreeChart.createPieChart("Resource", piedataset, jPanel7);
    }
    
    private void lineChart() throws ParseException, InterruptedException{
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        ArrayList<Ticket> list = FindTicket.getTicket();
        ArrayList<String> tempDataSet = new ArrayList<String>();
        Date start, end;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if(datePicker1.getText().equals("")||datePicker2.getText().equals("")){
            try {
                start = getFirstDateOfMonth(new Date());
                end = getLastDateOfMonth(new Date());
            } catch (Exception ex) {
                start = getFirstDateOfMonth(new Date());
                end = getLastDateOfMonth(new Date());
                JOptionPane.showMessageDialog(this, "Date Format Failed!");
            }
        }else{
            start = sdf.parse(datePicker1.getText());
            end = sdf.parse(datePicker2.getText());
        }
        int val;
        Calendar cal = Calendar.getInstance();
        
        while(!start.after(end)){
            val=0;
            for(Ticket temp:list){
                if( fmt.format(start).equals(fmt.format(sdf.parse(temp.getDate()))) ){
                    val++;
                }
            }
            cal.setTime(start);
            dataset.setValue(val,"Sales" , String.valueOf(cal.get(Calendar.DATE)));
            
            tempDataSet.add(String.valueOf(cal.get(Calendar.DATE)));
            tempDataSet.add(String.valueOf(val));
            
            start = addDays(start, 1);
        }
        chart = CreateFreeChart.createLineChart("Sales", "Day of Month", "Sale", dataset, jPanel11);
        this.dataSet = tempDataSet;
    }
    
    private void lineChartWeek() throws ParseException, InterruptedException{
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        ArrayList<Ticket> list = FindTicket.getTicket();
        ArrayList<String> tempDataSet = new ArrayList<String>();
        Date start, end;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if(datePicker1.getText().equals("")||datePicker2.getText().equals("")){
            try {
                start = getFirstDateOfMonth(new Date());
                end = getLastDateOfMonth(new Date());
            } catch (Exception ex) {
                start = getFirstDateOfMonth(new Date());
                end = getLastDateOfMonth(new Date());
                JOptionPane.showMessageDialog(this, "Date Format Failed!");
            }
        }else{
            start = sdf.parse(datePicker1.getText());
            end = sdf.parse(datePicker2.getText());
        }
        int val;
        Calendar cal = Calendar.getInstance();
        LocalDate localDate;
        LocalDate localDateC;
        
        
        while(!start.after(end)){
            val=0;
            localDate = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            for(Ticket temp:list){
                localDateC = sdf.parse(temp.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if( localDate.getDayOfWeek().equals(localDateC.getDayOfWeek()) ){
                    val++;
                }
            }
            cal.setTime(start);
            dataset.setValue(val,"Sales" , localDate.getDayOfWeek().toString());//String.valueOf(cal.get(Calendar.DAY_OF_WEEK)));
            
            tempDataSet.add(localDate.getDayOfWeek().toString());
            tempDataSet.add(String.valueOf(val));
            
            start = addDays(start, 1);
        }
        chart = CreateFreeChart.createLineChart("Sales", "Day of Month", "Sale", dataset, jPanel11);
        this.dataSet = tempDataSet;
    }
    
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
        
    public static boolean isSameDay(Date date1, Date date2) {

    long julianDayNumber1 = date1.getTime();
    long julianDayNumber2 = date2.getTime();

    return julianDayNumber1 == julianDayNumber2;
}
    
    public static Date getFirstDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }
    
    public static Date getLastDateOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();

        jPanel4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Company", jPanel4);

        jPanel9.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        jButton1.setText("Filter By Date(Day)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("From");

        jLabel2.setText("To");

        jButton2.setText("Filter By Date(Week)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Genarate Sales Report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(132, 132, 132))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22)
                        .addComponent(jButton2))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 799, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Sales", jPanel9);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel15.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel14, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Route", jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
        lineChart();
        } catch (Exception ex) {   
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
            // TODO add your handling code here:
        try {
            lineChartWeek();
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            Document doc = new Document();
            JFileChooser jfc = new JFileChooser();
            jfc.setSelectedFile(new File("save.pdf"));
            //jfc.setFileFilter(new FileNameExtensionFilter("PDF", "pdf"));
            //jfc.showSaveDialog(this);
            try{
                PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(jfc.getSelectedFile()));
                doc.open();
                
                DottedLineSeparator dottedline = new DottedLineSeparator();
                dottedline.setOffset(-2);
                dottedline.setGap(2f);
                
                Paragraph date = new Paragraph(new Date().toString()); 
                date.setAlignment(Element.ALIGN_RIGHT);
                
                doc.add(Image.getInstance("logo.png"));
                doc.add(date);
                Paragraph header = new Paragraph("SALES REPORT", new Font(Font.FontFamily.COURIER, 18));
                header.setAlignment(Element.ALIGN_CENTER);
                doc.add(header);
                doc.add(dottedline);
                doc.add(Chunk.NEWLINE);
                java.awt.Image originalImage = chart.createBufferedImage(500, 300);
                Image image1 = Image.getInstance(originalImage,Color.white);
                doc.add(image1);
                doc.add(dottedline);
                header = new Paragraph("TABLE", new Font(Font.FontFamily.COURIER, 14));
                header.setAlignment(Element.ALIGN_CENTER);
                doc.add(header);
                
                PdfPTable table = new PdfPTable(2);
                table.addCell("Y");
                table.addCell("X");
                
                for(String str:dataSet){
                    table.addCell(str);
                }
                doc.add(table);
                
                
                doc.close();
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + jfc.getSelectedFile().getAbsolutePath() );
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "PDF Creation Failed");
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    static public void main(String args[]) throws Exception{
        
        javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReportGenaration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
