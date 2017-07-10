import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class StrukTransaksi extends javax.swing.JFrame {
    private String id_pemeriksaan;
    private int subtotal=0;
    private int gtot=0;
    private int ppn=0;
    private int kembali=0;
    private int jumlah=0;
    /**
     * Creates new form StrukTransaksi
     */
    public StrukTransaksi() {
        initComponents();
    }
    public StrukTransaksi(String data){
        initComponents();
    }
    
    public void setIDP(String v){
        id_pemeriksaan=v;
    }
    private String setCurrency(int v){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(v);
    }
    public String getIDP(){
        return id_pemeriksaan;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelHObat = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelHDokter = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        labelSubTotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelKembali = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelBayar = new javax.swing.JLabel();
        labelPPN = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Klinik Medical Care");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Struk Transaksi");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pembayaran"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Harga Obat");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 83, 227, 44));

        labelHObat.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelHObat.setText("Rp. 1.000.000,00");
        jPanel2.add(labelHObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 195, 44));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Harga Dokter");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 227, 44));

        labelHDokter.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelHDokter.setText("Rp. 0,00");
        jPanel2.add(labelHDokter, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 203, 44));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 450, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Subtotal");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 227, 44));

        labelSubTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelSubTotal.setText("Rp. 1.000.000");
        jPanel2.add(labelSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 195, 44));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Kembalian");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 227, 44));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("PPN (10%)");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 227, 44));

        labelKembali.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelKembali.setText("Rp. 100.000");
        jPanel2.add(labelKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 195, 44));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Bayar");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 227, 44));

        labelBayar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelBayar.setText("Rp. 100.000");
        jPanel2.add(labelBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 195, 44));

        labelPPN.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelPPN.setText("Rp. 100.000");
        jPanel2.add(labelPPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 195, 44));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Total");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 227, 44));

        labelTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTotal.setText("Rp. 0,00");
        jPanel2.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 195, 44));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 272, 450, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Semoga Lekas Sembuh");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Terima Kasih");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)))
                .addGap(132, 132, 132))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(jLabel4)
                    .addContainerGap(175, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(492, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(59, 59, 59)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            String sql = "SELECT SUM(o.harga_obat) tot_obat, d.tarif_dokter tot_dokter, t.total_bayar from tabel_transaksi t INNER JOIN tabel_pemeriksaan p ON p.kode_pemeriksaan = t.id_pemeriksaan INNER JOIN tabel_dokter d ON d.id_dokter = p.id_dokter INNER JOIN tabel_resep r ON r.id_pemeriksaan = p.kode_pemeriksaan INNER JOIN tabel_obat o ON o.id_obat = r.id_obat WHERE t.id_transaksi = "+getIDP();
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            if(res.next())
            {
                subtotal = res.getInt("tot_obat")+res.getInt("tot_dokter");
                ppn = subtotal*10/100;
                gtot = subtotal+ppn;
                labelHObat.setText(setCurrency(res.getInt("tot_obat")));
                labelHDokter.setText(setCurrency(res.getInt("tot_dokter")));
                labelSubTotal.setText(setCurrency(subtotal));
                labelPPN.setText(setCurrency(ppn));
                labelTotal.setText(setCurrency(gtot));
                labelBayar.setText(setCurrency(res.getInt("total_bayar")));
                labelKembali.setText(setCurrency(res.getInt("total_bayar")-gtot));
            }else{
                JOptionPane.showMessageDialog(null, "Kode Pemeriksaan Tidak Ada!");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error : "+e);
        }
    }//GEN-LAST:event_formWindowOpened

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StrukTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StrukTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StrukTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StrukTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StrukTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelBayar;
    private javax.swing.JLabel labelHDokter;
    private javax.swing.JLabel labelHObat;
    private javax.swing.JLabel labelKembali;
    private javax.swing.JLabel labelPPN;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTotal;
    // End of variables declaration//GEN-END:variables
}
