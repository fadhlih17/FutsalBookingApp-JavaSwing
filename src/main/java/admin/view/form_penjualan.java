/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package admin.view;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import org.example.controllers.BookingController;
import org.example.dependencyInjection.BookingControllerFactory;
import org.example.dtos.BookingDetail;
import org.example.exceptions.WarningException;
import org.example.services.impl.ReportService;

public class form_penjualan extends javax.swing.JPanel {
private BookingControllerFactory bookingFactory = new BookingControllerFactory();
    private BookingController bookingController = bookingFactory.controller();
    private ReportService reportService = new ReportService();
    
    public form_penjualan() {
        initComponents();
        Locale local = new Locale("id", "ID");
        Locale.setDefault(local);
        readTableBookingList();
    }
    
    private void readTableBookingList(){
        DefaultTableModel model = (DefaultTableModel) tblBookingListAdmin.getModel();
        int row = 0;
        List<BookingDetail> bookingDetails = null;
        
         String monthCb = (String) cbMonth.getSelectedItem();
        String yearCb = (String) cbYear.getSelectedItem();

        int year = Integer.parseInt(yearCb);
        int month = 0;
        switch (monthCb){
            case "Januari" : month = 1; break;
            case "Februari" : month = 2; break;
            case "Maret" : month = 3; break;
            case "April" : month = 4; break;
            case "Mei" : month = 5; break;
            case "Juni" : month = 6; break;
            case "Juli" : month = 7; break;
            case "Agustus" : month = 8; break;
            case "September" : month = 9; break;
            case "Oktober" : month = 10; break;
            case "November" : month = 11; break;
            case "Desember" : month = 12; break;
        }
        
        if (cbMonth.getSelectedItem().equals("Pilih Bulan")){
            bookingDetails = bookingController.listBookingsByYear(year);
        } else {
            bookingDetails = bookingController.listBookingsByMonthYear(month, year);
        }
        
        model.setRowCount(bookingDetails.size());
        for (BookingDetail bookingDetail : bookingDetails) {
            model.setValueAt(bookingDetail.getBookedId(), row, 0);
            model.setValueAt(bookingDetail.getVenueName(), row, 1);
            model.setValueAt(bookingDetail.getVenueId(), row, 2);
            model.setValueAt(bookingDetail.getDateBooked(), row, 3);
            model.setValueAt(bookingDetail.getEmailUser(), row, 4);
            model.setValueAt(bookingDetail.getPhoneNumber(), row, 5);
            model.setValueAt(bookingDetail.getStartTime(), row, 6);
            model.setValueAt(bookingDetail.getEndTime(), row, 7);
            model.setValueAt(bookingDetail.getPrice(), row, 8);
            row++;
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

        mainPanel1 = new javax.swing.JPanel();
        dataBarang1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookingListAdmin = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        cbMonth = new javax.swing.JComboBox<>();
        cbYear = new javax.swing.JComboBox<>();
        btnPrint = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        mainPanel1.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel1.setForeground(new java.awt.Color(255, 255, 255));
        mainPanel1.setLayout(new java.awt.CardLayout());

        dataBarang1.setBackground(new java.awt.Color(255, 255, 255));
        dataBarang1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("LAPORAN TRANSAKSI");

        tblBookingListAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pemesanan", "Nama Lapangan", "Kode Lapangan", "Tgl Pesanan", "Email", "Nomor Ponsel", "Mulai", "Selesai", "Total"
            }
        ));
        tblBookingListAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookingListAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBookingListAdmin);

        jLabel20.setText("Filter berdasarkan");

        cbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Bulan", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        cbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonthActionPerformed(evt);
            }
        });

        cbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035" }));
        cbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbYearActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(0, 102, 153));
        btnPrint.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print.png"))); // NOI18N
        btnPrint.setText("Cetak");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dataBarang1Layout = new javax.swing.GroupLayout(dataBarang1);
        dataBarang1.setLayout(dataBarang1Layout);
        dataBarang1Layout.setHorizontalGroup(
            dataBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataBarang1Layout.createSequentialGroup()
                .addGroup(dataBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataBarang1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dataBarang1Layout.createSequentialGroup()
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(12, 12, 12)
                        .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE)
        );
        dataBarang1Layout.setVerticalGroup(
            dataBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataBarang1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(dataBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPrint)
                    .addGroup(dataBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dataBarang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addComponent(cbYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        mainPanel1.add(dataBarang1, "card2");

        add(mainPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tblBookingListAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookingListAdminMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBookingListAdminMouseClicked

    private void cbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonthActionPerformed
        // TODO add your handling code here:
        readTableBookingList();
    }//GEN-LAST:event_cbMonthActionPerformed

    private void cbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbYearActionPerformed
        // TODO add your handling code here:
        readTableBookingList();
    }//GEN-LAST:event_cbYearActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        if (!cbMonth.getSelectedItem().equals("Pilih Bulan")) {

            String monthCb = (String) cbMonth.getSelectedItem();
            String yearCb = (String) cbYear.getSelectedItem();

            int year = Integer.parseInt(yearCb);
            int month = 0;
            switch (monthCb){
                case "Januari" : month = 1; break;
                case "Februari" : month = 2; break;
                case "Maret" : month = 3; break;
                case "April" : month = 4; break;
                case "Mei" : month = 5; break;
                case "Juni" : month = 6; break;
                case "Juli" : month = 7; break;
                case "Agustus" : month = 8; break;
                case "September" : month = 9; break;
                case "Oktober" : month = 10; break;
                case "November" : month = 11; break;
                case "Desember" : month = 12; break;
            }

            HashMap params = new HashMap<>();
            params.put("month", month);
            params.put("year", year);

            reportService.print("AdminTransactionReport.jasper", params);
            return;
        }
        throw new WarningException("Pilih periode bulan terlebih dahulu!");
    }//GEN-LAST:event_btnPrintActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox<String> cbMonth;
    private javax.swing.JComboBox<String> cbYear;
    private javax.swing.JPanel dataBarang1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel1;
    private javax.swing.JTable tblBookingListAdmin;
    // End of variables declaration//GEN-END:variables
}
