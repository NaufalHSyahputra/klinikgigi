import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;
public class ManagePasien extends javax.swing.JFrame {

    private String id_pasien="";
    private String nama_pasien="";
    private String tgl_lahir_pasien="";
    private String jenis_kelamin_pasien="Laki-Laki";
    private String nohp_pasien="";
    private String alamat_pasien="";
    private String status_crud="";
    
    public ManagePasien() {
        initComponents();
        batal();
        load_table();
        this.setLocationRelativeTo(null);
    }

    public void setIDP(String v) {
        id_pasien = v;
    }
    public void setNamaP(String v){
        nama_pasien = v;
    }
    public void setTGLP(String v){
        tgl_lahir_pasien = v;
    }
    public void setJKP(String v){
        jenis_kelamin_pasien = v;
    }
    public void setNohpP(String v){
        nohp_pasien = v;
    }
    public void setAlamatP(String v){
        alamat_pasien = v;
    }
    public void setStatusC(String v){
        status_crud = v;
    }
    public String getIDP(){
        return id_pasien;
    }
    public String getNamaP(){
        return nama_pasien;
    }
    public String getTGLP(){
        return tgl_lahir_pasien;
    }
    public String getJKP(){
        return jenis_kelamin_pasien;
    }
    public String getNohpP(){
        return nohp_pasien;
    }
    public String getAlamatP(){
        return alamat_pasien;
    }
    public String getStatusC(){
        return status_crud;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane2 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidpasien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnamapasien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txttanggalpasien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnohppasien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbjkpasien = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamatpasien = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelpasien = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID Pasien");

        txtidpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpasienActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Pasien");

        txtnamapasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamapasienActionPerformed(evt);
            }
        });
        txtnamapasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnamapasienKeyReleased(evt);
            }
        });

        jLabel3.setText("Tanggal Lahir Pasien");

        txttanggalpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalpasienActionPerformed(evt);
            }
        });
        txttanggalpasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttanggalpasienKeyReleased(evt);
            }
        });

        jLabel4.setText("Alamat Pasien");

        jLabel5.setText("Jenis Kelamin Pasien");

        txtnohppasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnohppasienActionPerformed(evt);
            }
        });
        txtnohppasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnohppasienKeyReleased(evt);
            }
        });

        jLabel6.setText("Nohp Pasien");

        cbjkpasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        cbjkpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjkpasienActionPerformed(evt);
            }
        });

        txtalamatpasien.setColumns(20);
        txtalamatpasien.setRows(5);
        txtalamatpasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtalamatpasienKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtalamatpasien);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttanggalpasien, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtnamapasien)
                            .addComponent(txtidpasien))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtnohppasien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbjkpasien, javax.swing.GroupLayout.Alignment.LEADING, 0, 283, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtidpasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbjkpasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnamapasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtnohppasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txttanggalpasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 11, 800, 180));

        tabelpasien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelpasien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpasienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelpasien);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 860, 190));

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

        btnhapus.setText("Delete");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 120, 40));

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 120, 40));

        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 120, 40));

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        getContentPane().add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void reset() {
    txtidpasien.setText(null);
    txtnamapasien.setText(null);
    txttanggalpasien.setText(null);
    txtnohppasien.setText(null);
    cbjkpasien.setSelectedItem(this);
    txtalamatpasien.setText(null);

}
private void batal() {
    txtidpasien.setEnabled(false);
    txtnamapasien.setEnabled(false);
    txttanggalpasien.setEnabled(false);
    txtnohppasien.setEnabled(false);
    cbjkpasien.setEnabled(false);
    txtalamatpasien.setEnabled(false);
    btnreset.setEnabled(false);
    btnbatal.setEnabled(false);
    btnsimpan.setEnabled(false);
    btnhapus.setEnabled(true);
    btnedit.setEnabled(true);
    btntambah.setEnabled(true);
    setStatusC("");
    reset();
}
private void enable_all_TF() {
    txtidpasien.setEnabled(true);
    txtnamapasien.setEnabled(true);
    txttanggalpasien.setEnabled(true);
    txtnohppasien.setEnabled(true);
    cbjkpasien.setEnabled(true);
    txtalamatpasien.setEnabled(true);

}
public void insertData() {
    try {
        String sql = "INSERT INTO tabel_pasien VALUES (null,'" + getNamaP() + "','" + getJKP() + "','" + getAlamatP() + "','" + getTGLP() + "','" + getNohpP() + "')";
        java.sql.Connection conn = (Connection) Koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        reset();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
public void updateData() {
    try {
        String sql = "UPDATE tabel_pasien SET nama_pasien = '" + getNamaP() + "', jk_pasien = '" + getJKP() + "',alamat_pasien= '" + getAlamatP() + "',tgllahir_pasien= '" + getTGLP() + "',nohp_pasien= '" + getNohpP() + "' WHERE id_pasien = '" + getIDP() + "'";
        java.sql.Connection conn = (Connection) Koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "data berhasil di edit");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Perubahan Data Gagal" + e.getMessage());
    }
}
public void deleteData() {
    try {
        String sql = "delete from tabel_pasien where id_pasien='" + getIDP() + "'";
        java.sql.Connection conn = (Connection) Koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(this, "berhasil di hapus");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}
public boolean verifikasiData() {
    if (getNamaP() == "") {
        JOptionPane.showMessageDialog(this, "Nama Pasien Masih Kosong");
        return false;
    } else if (getAlamatP() == "") {
        JOptionPane.showMessageDialog(this, "Alamat Pasien Masih Kosong");
        return false;
    } else if (getJKP() == "") {
        JOptionPane.showMessageDialog(this, "Jenis Kelamin Pasien Masih Kosong");
        return false;
    } else if (getTGLP() == "") {
        JOptionPane.showMessageDialog(this, "Tanggal Larhir Pasien Masih Kosong");
        return false;
    } else if (getNohpP() == "") {
        JOptionPane.showMessageDialog(this, "Nomor HP Pasien Masih Kosong");
        return false;
    } else {
        return true;
    }
}
    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        btntambah.setEnabled(false);
        btnhapus.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        enable_all_TF();
        txtidpasien.setEnabled(false);
        setStatusC("tambah");
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        if (getStatusC() == "tambah") {
            if(verifikasiData() == true){
                insertData();
                load_table();
                batal();
            }
        } else if (getStatusC() == "edit") {
            if(verifikasiData() == true){
                updateData(); 
                load_table();
                batal();
            }
        } else if (getStatusC() == "hapus") {
            if(verifikasiData() == true){
                deleteData();  
                load_table();
                batal();
            }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        JOptionPane.showMessageDialog(null, "Silahkan Klik Data Yang Ingin Diedit Pada Tabel Dibawah");
        btntambah.setEnabled(false);
        btnhapus.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        enable_all_TF();
        txtidpasien.setEnabled(false);
        setStatusC("edit");
    }//GEN-LAST:event_btneditActionPerformed

    private void tabelpasienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpasienMouseClicked
        if(getStatusC() == "edit" || getStatusC() == "hapus"){
        int baris = tabelpasien.rowAtPoint(evt.getPoint());
        String id_pasien =tabelpasien.getValueAt(baris, 0).toString();
        txtidpasien.setText(id_pasien);
        setIDP(id_pasien);
        String nama_pasien =tabelpasien.getValueAt(baris, 1).toString();
        txtnamapasien.setText(nama_pasien);
        setNamaP(nama_pasien);
        String jr = tabelpasien.getValueAt(baris, 2).toString();
        cbjkpasien.setSelectedItem(jr);
        setJKP(jr);
        String alamat=tabelpasien.getValueAt(baris, 3).toString();
        txtalamatpasien.setText(alamat);
        setAlamatP(alamat);
        String tgllahir = tabelpasien.getValueAt(baris, 4).toString();
        txttanggalpasien.setText(tgllahir);
        setTGLP(tgllahir);
        String nohp = tabelpasien.getValueAt(baris, 5).toString();
        txtnohppasien.setText(nohp);
        setNohpP(nohp);
        }
    }//GEN-LAST:event_tabelpasienMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        JOptionPane.showMessageDialog(null, "Silahkan Klik Data Yang Ingin Dihapus Pada Tabel Dibawah, dan klik Delete Data");
        btntambah.setEnabled(false);
        btnhapus.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        btnsimpan.setText("Delete Data");
        txtidpasien.setEnabled(false);
        setStatusC("hapus");
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbatalActionPerformed

    private void txtidpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpasienActionPerformed
        JOptionPane.showMessageDialog(null, getIDP());
    }//GEN-LAST:event_txtidpasienActionPerformed

    private void txtnamapasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamapasienActionPerformed
    }//GEN-LAST:event_txtnamapasienActionPerformed

    private void txttanggalpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalpasienActionPerformed
        setTGLP(txttanggalpasien.getText());
    }//GEN-LAST:event_txttanggalpasienActionPerformed

    private void cbjkpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjkpasienActionPerformed
        setJKP(cbjkpasien.getSelectedItem().toString());
    }//GEN-LAST:event_cbjkpasienActionPerformed

    private void txtnohppasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnohppasienActionPerformed
        setNohpP(txtnohppasien.getText());
    }//GEN-LAST:event_txtnohppasienActionPerformed

    private void txtalamatpasienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalamatpasienKeyReleased
        setAlamatP(txtalamatpasien.getText());
    }//GEN-LAST:event_txtalamatpasienKeyReleased

    private void txtnamapasienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamapasienKeyReleased
        setNamaP(txtnamapasien.getText());
    }//GEN-LAST:event_txtnamapasienKeyReleased

    private void txttanggalpasienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttanggalpasienKeyReleased
        setTGLP(txttanggalpasien.getText());
    }//GEN-LAST:event_txttanggalpasienKeyReleased

    private void txtnohppasienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnohppasienKeyReleased
        setNohpP(txtnohppasien.getText());
    }//GEN-LAST:event_txtnohppasienKeyReleased
private void load_table() {
    //menampilkan data database kedalam tabel
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Pasien");
    model.addColumn("Nama Pasien");
    model.addColumn("Jenis Kelamin");
    model.addColumn("Alamat");
    model.addColumn("Tgl Lahir");
    model.addColumn("Nomor Telp");
    try {
        int no = 1;
        String sql = "select * from tabel_pasien";
        java.sql.Connection conn = (Connection) Koneksi.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
            model.addRow(new Object[] {
                res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)
            });
        }
        tabelpasien.setModel(model);
    } catch (Exception e) {}
}
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
            java.util.logging.Logger.getLogger(ManagePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> cbjkpasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelpasien;
    private javax.swing.JTextArea txtalamatpasien;
    private javax.swing.JTextField txtidpasien;
    private javax.swing.JTextField txtnamapasien;
    private javax.swing.JTextField txtnohppasien;
    private javax.swing.JTextField txttanggalpasien;
    // End of variables declaration//GEN-END:variables
}
