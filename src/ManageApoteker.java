import java.sql.Connection;
import javax.swing.*; 
import javax.swing.table.*;
public class ManageApoteker extends javax.swing.JFrame {
    
    private String id_apoteker="";
    private String nama_apoteker="";
    private String username_apoteker="";
    private String password_apoteker="";
    private String nohp_apoteker="";
    private String alamat_apoteker="";
    private String status_crud="";
    
    public ManageApoteker() {
        initComponents();
        reset();
        loadTable();
    }
    
    public void setIDA(String v) {
     id_apoteker = v;
    }
    public void setNamaA(String v) {
     nama_apoteker = v;
    }
    public void setUsernameA(String v) {
     username_apoteker = v;
    }
    public void setPassA(String v) {
     password_apoteker = v;
    }
    public void setNohpA(String v) {
     nohp_apoteker = v;
    }
    public void setAlamatA(String v) {
     alamat_apoteker = v;
    }
    public void setStatusC(String v) {
     status_crud = v;
    }
    public String getIDA() {
     return id_apoteker;
    }
    public String getNamaA() {
     return nama_apoteker;
    }
    public String getUsernameA() {
     return username_apoteker;
    }
    public String getPassA() {
     return password_apoteker;
    }
    public String getNohpA() {
     return nohp_apoteker;
    }
    public String getAlamatA() {
     return alamat_apoteker;
    }
    public String getStatusC() {
     return status_crud;
    }
    public void loadTable() {
     //menampilkan data database kedalam tabel
     DefaultTableModel model = new DefaultTableModel();
     model.addColumn("ID");
     model.addColumn("Nama");
     model.addColumn("Alamat");
     model.addColumn("Nomor Telp");
     model.addColumn("Username");
     model.addColumn("Password");
     try {
      int no = 1;
      String sql = "select * from tabel_apoteker";
      java.sql.Connection conn = Koneksi.configDB();
      java.sql.Statement stm = conn.createStatement();
      java.sql.ResultSet res = stm.executeQuery(sql);
      while (res.next()) {
       model.addRow(new Object[] {
        res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)
       });
      }
      tableapoteker.setModel(model);
     } catch (Exception e) {}
    }
    //batal
    public void batal() {
     txtida.setEnabled(false);
     txtnamaa.setEnabled(false);
     txtnohp.setEnabled(false);
     txtpassa.setEnabled(false);
     txtusernamea.setEnabled(false);
     txtalamata.setEnabled(false);
     btnreset.setEnabled(false);
     btnbatal.setEnabled(false);
     btnsimpan.setEnabled(false);
     btndelete.setEnabled(true);
     btnedit.setEnabled(true);
     btntambah.setEnabled(true);
     setStatusC("");
     reset();
    }
    //reset
    public void reset() {
     txtusernamea.setText(null);
     txtida.setText(null);
     txtnamaa.setText(null);
     txtnohp.setText(null);
     txtpassa.setText(null);
     txtalamata.setText(null);
    }
    //Dipanggil Saat ingin mengenable semua text Field
    public void enableAllTF() {
     txtida.setEnabled(true);
     txtnamaa.setEnabled(true);
     txtnohp.setEnabled(true);
     txtpassa.setEnabled(true);
     txtusernamea.setEnabled(true);
     txtalamata.setEnabled(true);
    }
    public void insertData() {
     try {
      String sql = "INSERT INTO tabel_apoteker VALUES (null,'" + txtnamaa.getText() + "','" + txtalamata.getText() + "','" + txtnohp.getText() + "','" + txtusernamea.getText() + "','" + txtpassa.getText() + "')";
      java.sql.Connection conn = Koneksi.configDB();
      java.sql.PreparedStatement pst = conn.prepareStatement(sql);
      pst.execute();
      JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
      batal();
     } catch (Exception e) {
      JOptionPane.showMessageDialog(this, e.getMessage());
     }
    }
    public void updateData() {
     try {
      String sql = "UPDATE tabel_apoteker SET nama = '" + txtnamaa.getText() + "', alamat = '" + txtalamata.getText() + "',nohp= '" + txtnohp.getText() + "',username= '" + txtusernamea.getText() + "',password= '" + txtpassa.getText() + "' WHERE id = '" + txtida.getText() + "'";
      java.sql.Connection conn = Koneksi.configDB();
      java.sql.PreparedStatement pst = conn.prepareStatement(sql);
      pst.execute();
      JOptionPane.showMessageDialog(null, "data berhasil di edit");
     } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Perubahan Data Gagal" + e.getMessage());
     }
    }
    public void deleteData() {
     try {
      String sql = "delete from tabel_apoteker where id='" + txtida.getText() + "'";
      java.sql.Connection conn = Koneksi.configDB();
      java.sql.PreparedStatement pst = conn.prepareStatement(sql);
      pst.execute();
      JOptionPane.showMessageDialog(this, "berhasil di hapus");
     } catch (Exception e) {
      JOptionPane.showMessageDialog(this, e.getMessage());
     }
    }
    public boolean verifikasiData(){
        if(getNamaA() == ""){
            JOptionPane.showMessageDialog(this, "Nama Apoteker Masih Kosong");
            return false;
        }else if(getAlamatA() == ""){
            JOptionPane.showMessageDialog(this, "Alamat Apoteker Masih Kosong");
            return false;
        }else if(getUsernameA() == ""){
            JOptionPane.showMessageDialog(this, "Username Apoteker Masih Kosong");
            return false;
        }else if(getPassA() == ""){
            JOptionPane.showMessageDialog(this, "Password Apoteker Masih Kosong");
            return false;
        }else if(getNohpA() == ""){
            JOptionPane.showMessageDialog(this, "Nomor HP Apoteker Masih Kosong");
            return false;
        }else{
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane2 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnamaa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnohp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamata = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtusernamea = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpassa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableapoteker = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID Apoteker");

        txtida.setEnabled(false);
        txtida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidaKeyReleased(evt);
            }
        });

        jLabel2.setText("Nama Apoteker");

        txtnamaa.setEnabled(false);
        txtnamaa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnamaaKeyReleased(evt);
            }
        });

        jLabel4.setText("Alamat Apoteker");

        txtnohp.setEnabled(false);
        txtnohp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnohpKeyReleased(evt);
            }
        });

        jLabel6.setText("Nohp Apoteker");

        txtalamata.setColumns(20);
        txtalamata.setRows(5);
        txtalamata.setEnabled(false);
        txtalamata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtalamataKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtalamata);

        jLabel8.setText("Username Apoteker");

        txtusernamea.setEnabled(false);
        txtusernamea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtusernameaKeyReleased(evt);
            }
        });

        jLabel9.setText("Password Apoteker");

        txtpassa.setEnabled(false);
        txtpassa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpassaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(21, 790, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpassa, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtusernamea)
                            .addComponent(txtnamaa, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtida))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnohp, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnamaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtusernamea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtpassa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 11, 800, 180));

        tableapoteker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableapoteker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableapotekerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableapoteker);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 850, 190));

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 120, 40));

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 120, 40));

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 120, 40));

        btnsimpan.setText("Simpan");
        btnsimpan.setEnabled(false);
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 120, 40));

        btnbatal.setText("Batal");
        btnbatal.setEnabled(false);
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 120, 40));

        btnreset.setText("Reset");
        btnreset.setEnabled(false);
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        btntambah.setEnabled(false); 
        btndelete.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        enableAllTF();
        txtida.setEnabled(false); // disable txtid . id tergenerate otomatis
        setStatusC("tambah");
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        if (getStatusC() == "tambah") {
            if(verifikasiData() == true){
                insertData();
                loadTable();
                batal();
            }
        } else if (getStatusC() == "edit") {
            if(verifikasiData() == true){
                updateData(); 
                loadTable();
                batal();
            }
        } else if (getStatusC() == "hapus") {
            if(verifikasiData() == true){
                deleteData();  
                loadTable();
                batal();
            }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        JOptionPane.showMessageDialog(null, "Silahkan Klik Data Yang Ingin Diedit Pada Tabel Dibawah");
        btntambah.setEnabled(false);
        btndelete.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        enableAllTF();
        txtida.setEnabled(false);
        setStatusC("edit");
    }//GEN-LAST:event_btneditActionPerformed

    private void tableapotekerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableapotekerMouseClicked
        if (getStatusC() == "edit" || getStatusC() == "hapus") {
         int baris = tableapoteker.rowAtPoint(evt.getPoint());
         String id = tableapoteker.getValueAt(baris, 0).toString();
         txtida.setText(id);
         String nama = tableapoteker.getValueAt(baris, 1).toString();
         txtnamaa.setText(nama);
         String alamat = tableapoteker.getValueAt(baris, 2).toString();
         txtalamata.setText(alamat);
         String nohp = tableapoteker.getValueAt(baris, 3).toString();
         txtnohp.setText(nohp);
         String username = tableapoteker.getValueAt(baris, 4).toString();
         txtusernamea.setText(username);
         String password = tableapoteker.getValueAt(baris, 5).toString();
         txtpassa.setText(password);
        }
    }//GEN-LAST:event_tableapotekerMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        JOptionPane.showMessageDialog(null, "Silahkan Klik Data Yang Ingin Dihapus Pada Tabel Dibawah, dan klik Delete Data");
        btntambah.setEnabled(false);
        btndelete.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        btnsimpan.setText("Delete Data");
        txtida.setEnabled(false);
        setStatusC("hapus");
    }//GEN-LAST:event_btndeleteActionPerformed

    private void txtidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidaKeyReleased
        setIDA(txtida.getText());
    }//GEN-LAST:event_txtidaKeyReleased

    private void txtnamaaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaaKeyReleased
        setNamaA(txtnamaa.getText());
    }//GEN-LAST:event_txtnamaaKeyReleased

    private void txtusernameaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameaKeyReleased
        setUsernameA(txtusernamea.getText());
    }//GEN-LAST:event_txtusernameaKeyReleased

    private void txtpassaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassaKeyReleased
        setPassA(txtpassa.getText());
    }//GEN-LAST:event_txtpassaKeyReleased

    private void txtnohpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnohpKeyReleased
        setNohpA(txtnohp.getText());
    }//GEN-LAST:event_txtnohpKeyReleased

    private void txtalamataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalamataKeyReleased
        setAlamatA(txtalamata.getText());
    }//GEN-LAST:event_txtalamataKeyReleased

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        reset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        batal();
    }//GEN-LAST:event_btnbatalActionPerformed
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
            java.util.logging.Logger.getLogger(ManageApoteker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageApoteker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageApoteker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageApoteker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageApoteker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableapoteker;
    private javax.swing.JTextArea txtalamata;
    private javax.swing.JTextField txtida;
    private javax.swing.JTextField txtnamaa;
    private javax.swing.JTextField txtnohp;
    private javax.swing.JTextField txtpassa;
    private javax.swing.JTextField txtusernamea;
    // End of variables declaration//GEN-END:variables
}
