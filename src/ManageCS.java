import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;
public class ManageCS extends javax.swing.JFrame {
    
    private String id_cs;
    private String nama_cs;
    private String alamat_cs;
    private String nohp_cs;
    private String username_cs;
    private String password_cs;
    private String status_crud;

    public ManageCS() {
        initComponents();
        reset();
        load_table();
        this.setLocationRelativeTo(null);
    }
    
    public void setIDCS(String v){
        id_cs = v;
    }
    public void setNamaCS(String v){
        nama_cs = v;
    }
    public void setAlamatCS(String v){
        alamat_cs = v;
    }
    public void setNohpCS(String v){
        nohp_cs = v;
    }
    public void setUsernameCS(String v){
        username_cs = v;
    }
    public void setPasswordCS(String v){
        password_cs = v;
    }
    public void setStatusC(String v){
        status_crud = v;
    }
    public String getIDCS(){
        return id_cs;
    }
    public String getNamaCS(){
        return nama_cs;
    }
    public String getAlamatCS(){
       return alamat_cs;
    }
    public String getNohpCS(){
       return nohp_cs;
    }
    public String getUsernameCS(){
       return username_cs;
    }
    public String getPasswordCS(){
       return password_cs;
    }
    public String getStatusC(){
       return status_crud;
    }
    private void load_table(){
        //menampilkan data database kedalam tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Nomor Telp");
        model.addColumn("Username");
        model.addColumn("Password");
        try {
            int no=1;
            String sql = "select * from tabel_customerservice";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            tabelcs.setModel(model);
        } catch (Exception e) {
        }
}
    //batal
    public void batal() {
     txtidcs.setEnabled(false);
     txtnamacs.setEnabled(false);
     txtnohpcs.setEnabled(false);
     txtpasscs.setEnabled(false);
     txtusernamecs.setEnabled(false);
     txtalamatcs.setEnabled(false);
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
     txtusernamecs.setText(null);
     txtidcs.setText(null);
     txtnamacs.setText(null);
     txtnohpcs.setText(null);
     txtpasscs.setText(null);
     txtalamatcs.setText(null);
    }
    //Dipanggil Saat ingin mengenable semua text Field
    public void enableAllTF() {
     txtidcs.setEnabled(true);
     txtnamacs.setEnabled(true);
     txtnohpcs.setEnabled(true);
     txtpasscs.setEnabled(true);
     txtusernamecs.setEnabled(true);
     txtalamatcs.setEnabled(true);
    }
    public void insertData() {
     try {
      String sql = "INSERT INTO tabel_customerservice VALUES (null,'" + getNamaCS() + "','" + getAlamatCS() + "','" + getNohpCS() + "','" + getUsernameCS() + "','" + getPasswordCS() + "')";
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
      String sql = "UPDATE tabel_customerservice SET nama = '" + getNamaCS() + "', alamat = '" + getAlamatCS() + "',nohp= '" + getNohpCS() + "',username= '" + getUsernameCS() + "',password= '" + getPasswordCS() + "' WHERE id = '" + getIDCS() + "'";
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
      String sql = "delete from tabel_customerservice where id='" + getIDCS() + "'";
      java.sql.Connection conn = (Connection) Koneksi.configDB();
      java.sql.PreparedStatement pst = conn.prepareStatement(sql);
      pst.execute();
      JOptionPane.showMessageDialog(this, "berhasil di hapus");
     } catch (Exception e) {
      JOptionPane.showMessageDialog(this, e.getMessage());
     }
    }
    public boolean verifikasiData(){
        if(getNamaCS() == ""){
            JOptionPane.showMessageDialog(this, "Nama CS Masih Kosong");
            return false;
        }else if(getAlamatCS() == ""){
            JOptionPane.showMessageDialog(this, "Alamat CS Masih Kosong");
            return false;
        }else if(getUsernameCS() == ""){
            JOptionPane.showMessageDialog(this, "Username CS Masih Kosong");
            return false;
        }else if(getPasswordCS() == ""){
            JOptionPane.showMessageDialog(this, "Password CS Masih Kosong");
            return false;
        }else if(getNohpCS() == ""){
            JOptionPane.showMessageDialog(this, "Nomor HP CS Masih Kosong");
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
        txtidcs = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnamacs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnohpcs = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamatcs = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtusernamecs = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpasscs = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelcs = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID CS");

        txtidcs.setEnabled(false);

        jLabel2.setText("Nama CS");

        txtnamacs.setEnabled(false);
        txtnamacs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnamacsKeyReleased(evt);
            }
        });

        jLabel4.setText("Alamat CS");

        txtnohpcs.setEnabled(false);
        txtnohpcs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnohpcsKeyReleased(evt);
            }
        });

        jLabel6.setText("Nohp CS");

        txtalamatcs.setColumns(20);
        txtalamatcs.setRows(5);
        txtalamatcs.setEnabled(false);
        txtalamatcs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtalamatcsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtalamatcs);

        jLabel8.setText("Username CS");

        txtusernamecs.setEnabled(false);
        txtusernamecs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtusernamecsKeyReleased(evt);
            }
        });

        jLabel9.setText("Password CS");

        txtpasscs.setEnabled(false);
        txtpasscs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasscsKeyReleased(evt);
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
                            .addComponent(txtpasscs, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtusernamecs)
                            .addComponent(txtnamacs, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtidcs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtnohpcs, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnohpcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnamacs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtusernamecs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtpasscs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        tabelcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelcsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelcs);

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
        txtidcs.setEnabled(false);
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
        btndelete.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        enableAllTF();
        txtidcs.setEnabled(false);
        setStatusC("edit");
    }//GEN-LAST:event_btneditActionPerformed

    private void tabelcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelcsMouseClicked
        if(getStatusC() == "edit" || getStatusC() == "hapus"){
        int baris = tabelcs.rowAtPoint(evt.getPoint());
        String id =tabelcs.getValueAt(baris, 0).toString();
        txtidcs.setText(id);
        setIDCS(id);
        String nama =tabelcs.getValueAt(baris, 1).toString();
        txtnamacs.setText(nama);
        setNamaCS(nama);
        String alamat = tabelcs.getValueAt(baris, 2).toString();
        txtalamatcs.setText(alamat);
        setAlamatCS(alamat);
        String nohp=tabelcs.getValueAt(baris, 3).toString();
        txtnohpcs.setText(nohp);
        setNohpCS(nohp);
        String username = tabelcs.getValueAt(baris, 4).toString();
        txtusernamecs.setText(username);
        setUsernameCS(username);
        String password = tabelcs.getValueAt(baris, 5).toString();
        txtpasscs.setText(password);
        setPasswordCS(password);
        }
    }//GEN-LAST:event_tabelcsMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        JOptionPane.showMessageDialog(null, "Silahkan Klik Data Yang Ingin Dihapus Pada Tabel Dibawah, dan klik Delete Data");
        btntambah.setEnabled(false);
        btndelete.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        btnsimpan.setText("Delete Data");
        txtidcs.setEnabled(false);
        setStatusC("hapus");
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        reset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        batal();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void txtnamacsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamacsKeyReleased
        setNamaCS(txtnamacs.getText());
    }//GEN-LAST:event_txtnamacsKeyReleased

    private void txtusernamecsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernamecsKeyReleased
        setUsernameCS(txtusernamecs.getText());
    }//GEN-LAST:event_txtusernamecsKeyReleased

    private void txtpasscsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasscsKeyReleased
        setPasswordCS(txtpasscs.getText());
    }//GEN-LAST:event_txtpasscsKeyReleased

    private void txtnohpcsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnohpcsKeyReleased
        setNohpCS(txtnohpcs.getText());
    }//GEN-LAST:event_txtnohpcsKeyReleased

    private void txtalamatcsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalamatcsKeyReleased
        setAlamatCS(txtalamatcs.getText());
    }//GEN-LAST:event_txtalamatcsKeyReleased
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
            java.util.logging.Logger.getLogger(ManageCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCS().setVisible(true);
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
    private javax.swing.JTable tabelcs;
    private javax.swing.JTextArea txtalamatcs;
    private javax.swing.JTextField txtidcs;
    private javax.swing.JTextField txtnamacs;
    private javax.swing.JTextField txtnohpcs;
    private javax.swing.JTextField txtpasscs;
    private javax.swing.JTextField txtusernamecs;
    // End of variables declaration//GEN-END:variables
}
