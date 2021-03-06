import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class ManageResep extends javax.swing.JFrame {
    private String[] dataPopUp;
    private int jumlah;
    private String keterangan;
    private String id_obat;
    private String kode_pemeriksaan;
    private String status_crud;
    private String kode_resep;
    

    /**
     * Creates new form ManageResep
     */
    public ManageResep() {
        initComponents();
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        this.setLocationRelativeTo(null);
    }
    
    public void setKodeP(String v){
        kode_pemeriksaan = v;
    }
    public void setIDO(String v){
        id_obat = v;
    }  
    public void setKeterangan(String v){
        keterangan = v;
    }
    public void setJumlah(int v){
        jumlah = v;
    }
    public void setStatusC(String v){
        status_crud = v;
    }
    public void setIDR(String v){
        kode_resep = v;
    }
    public String getIDR(){
        return kode_resep;
    }
    public String getStatusC(){
        return status_crud;
    }
    public String getKodeP(){
        return kode_pemeriksaan;
    }
    public String getIDO(){
        return id_obat;
    }  
    public String getKeterangan(){
       return keterangan;
    }
    public int getJumlah(){
        return jumlah;
    }
    public void SubmitPemeriksaan(){
        try {
            String sql = "UPDATE tabel_pemeriksaan SET status_pemeriksaan = 'Waiting Payment' WHERE kode_pemeriksaan = '"+getKodeP()+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Resep berhasil Di Submit!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Resep Gagal Di Submit! "+e.getMessage());
        }
    }
    private void searchPemeriksaan(String kode) {
     try {
      String sql = "select * from tabel_pemeriksaan WHERE kode_pemeriksaan = " + kode + "";
      java.sql.Connection conn = (Connection) Koneksi.configDB();
      java.sql.Statement stm = conn.createStatement();
      java.sql.ResultSet res = stm.executeQuery(sql);
      if (res.next()) {
       pemeriksaanExist();
       load_tabel();
      } else {
       JOptionPane.showMessageDialog(null, "Kode Pemeriksaan Tidak Ada!");
      }
     } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error : " + e);
     }
    }
    private void pemeriksaanExist() {
     txtidobat.setEnabled(false);
     txtidobat.setText("");
     txtjumlah.setText("");
     txtketerangan.setText("");
     txtjumlah.setEnabled(true);
     txtketerangan.setEnabled(true);
     btncari.setEnabled(true);
     btnsimpan.setEnabled(true);
     btnupdate.setEnabled(true);
     btnhapus.setEnabled(true);
     btnsubmit.setEnabled(true);
     btnsubmit1.setEnabled(false);
     btncari1.setEnabled(false);
     txtkodepemeriksaan.setEnabled(false);
     setStatusC("tambah");
    }
    public void load_tabel() {
     DefaultTableModel tabelModel = new DefaultTableModel();
     //menampilkan data database kedalam tabel
     tabelModel.addColumn("Nama Obat");
     tabelModel.addColumn("Jumlah");
     tabelModel.addColumn("Keterangan");
     tabelModel.addColumn("Harga");
     tabelModel.addColumn("ID");
     tabelModel.addColumn("IDObat");
     tableresep.setModel(tabelModel);
     try {
      String sql = "SELECT tr.id, tr.jumlah,tr.keterangan,tob.nama_obat,tob.harga_obat,tob.id_obat FROM tabel_resep tr INNER JOIN tabel_obat tob ON tob.id_obat = tr.id_obat WHERE id_pemeriksaan = " + txtkodepemeriksaan.getText() + "";
      java.sql.Connection conn = (Connection) Koneksi.configDB();
      java.sql.Statement stm = conn.createStatement();
      java.sql.ResultSet res = stm.executeQuery(sql);
      while (res.next()) {
       tabelModel.addRow(new Object[] {
        res.getString(4), res.getString(2), res.getString(3), res.getString(5), res.getString(1), res.getString(6)
       });
      }
      tableresep.setModel(tabelModel);
     } catch (Exception e) {}
     tableresep.getColumnModel().getColumn(3).setWidth(0);
     tableresep.getColumnModel().getColumn(3).setMinWidth(0);
     tableresep.getColumnModel().getColumn(3).setMaxWidth(0);
     tableresep.getColumnModel().getColumn(4).setWidth(0);
     tableresep.getColumnModel().getColumn(4).setMinWidth(0);
     tableresep.getColumnModel().getColumn(4).setMaxWidth(0);
     tableresep.getColumnModel().getColumn(5).setWidth(0);
     tableresep.getColumnModel().getColumn(5).setMinWidth(0);
     tableresep.getColumnModel().getColumn(5).setMaxWidth(0);
    }
    public void setDataPopUp(String[] dataPopUp) {
     this.dataPopUp = dataPopUp;
    }

    public String[] getDataPopUp() {
     return dataPopUp;
    }
    public void Insert(){
        try {
            String sql = "INSERT INTO tabel_resep(id_pemeriksaan,id_obat,jumlah,harga,keterangan) VALUES ('"+getKodeP()+"','"+getIDO()+"','"+getJumlah()+"','"+jLabel6.getText()+"','"+getKeterangan()+"')"; //jlabel6 = harga
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            pemeriksaanExist();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void Update(){
           try {
            String sql ="UPDATE tabel_resep SET jumlah = '"+getJumlah()+"', keterangan = '"+getKeterangan()+"' WHERE id = '"+getIDR()+"'"; //jLabel7 = id_obat
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
    }
    public void Delete(){
            try {
            String sql ="DELETE FROM tabel_resep where id='"+getIDR()+"'";//jLabel7 = id_obat
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        txtkodepemeriksaan = new javax.swing.JTextField();
        btncari1 = new javax.swing.JButton();
        btnsubmit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtidobat = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtketerangan = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableresep = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnsubmit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pemeriksaan"));

        jLabel1.setText("Kode Pemeriksaan");

        txtkodepemeriksaan.setEnabled(false);
        txtkodepemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodepemeriksaanActionPerformed(evt);
            }
        });

        btncari1.setText("Cari");
        btncari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncari1ActionPerformed(evt);
            }
        });

        btnsubmit1.setText("Submit");
        btnsubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsubmit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtkodepemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncari1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtkodepemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("ID Obat");

        txtidobat.setEnabled(false);
        txtidobat.setFocusCycleRoot(true);
        txtidobat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidobatActionPerformed(evt);
            }
        });

        btncari.setText("Cari");
        btncari.setEnabled(false);
        btncari.setFocusCycleRoot(true);
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel3.setText("Jumlah Obat");

        txtjumlah.setEnabled(false);
        txtjumlah.setFocusCycleRoot(true);
        txtjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjumlahActionPerformed(evt);
            }
        });
        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjumlahKeyReleased(evt);
            }
        });

        jLabel4.setText("Keterangan");

        txtketerangan.setEnabled(false);
        txtketerangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtketeranganKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtketerangan);

        tableresep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableresep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableresepMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableresep);

        btnsimpan.setText("Simpan");
        btnsimpan.setEnabled(false);
        btnsimpan.setFocusCycleRoot(true);
        btnsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpanMouseClicked(evt);
            }
        });
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnupdate.setText("Update");
        btnupdate.setEnabled(false);
        btnupdate.setFocusCycleRoot(true);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.setEnabled(false);
        btnhapus.setFocusCycleRoot(true);
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnsubmit.setText("Submit");
        btnsubmit.setEnabled(false);
        btnsubmit.setFocusCycleRoot(true);
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("jLabel6");

        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnsubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtidobat)
                                .addComponent(txtjumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btncari)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtidobat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmit1ActionPerformed
        setKodeP(txtkodepemeriksaan.getText());
        searchPemeriksaan(getKodeP());
    }//GEN-LAST:event_btnsubmit1ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        txtidobat.setEnabled(false);
        btncari.setEnabled(false);
        setStatusC("update");
        btnhapus.setEnabled(false);
        btnsubmit.setEnabled(false);
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        txtidobat.setEnabled(false);
        btncari.setEnabled(false);
        txtjumlah.setEnabled(false);
        txtketerangan.setEnabled(false);
        btnsimpan.setText("Delete");
        setStatusC("hapus");
        btnsubmit.setEnabled(false);
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btncari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncari1ActionPerformed
        ResepPemeriksaan rp = new ResepPemeriksaan(new javax.swing.JFrame(), true);
        rp.setVisible(true);
        txtkodepemeriksaan.setText(rp.getAmbilData()[0]);
        setKodeP(rp.getAmbilData()[0]);
    }//GEN-LAST:event_btncari1ActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        ResepObat ro = new ResepObat(new javax.swing.JFrame(), true);
        ro.setVisible(true);
        txtidobat.setText(ro.getAmbilData()[0]);
        setIDO(ro.getAmbilData()[0]);
        jLabel6.setText(ro.getAmbilData()[1]);
    }//GEN-LAST:event_btncariActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
       if(getStatusC() == "tambah"){
            Insert();
        }else if(getStatusC() == "update"){
                Update();
        }else if(getStatusC() == "hapus"){
            Delete();
        }
        load_tabel();
        pemeriksaanExist();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked
        
    }//GEN-LAST:event_btnsimpanMouseClicked

    private void tableresepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableresepMouseClicked
      if(getStatusC() == "update" || getStatusC() == "hapus"){
        int baris = tableresep.rowAtPoint(evt.getPoint());
        String txt_jumlah =tableresep.getValueAt(baris, 1).toString();
        txtjumlah.setText(txt_jumlah);
        setJumlah(Integer.parseInt(txt_jumlah));
        String txt_keterangan =tableresep.getValueAt(baris, 2).toString();
        txtketerangan.setText(txt_keterangan);
        setKeterangan(txt_keterangan);
        String id_resep = tableresep.getValueAt(baris, 4).toString();
        jLabel7.setText(id_resep);
        setIDR(id_resep);
        String id_obat = tableresep.getValueAt(baris, 5).toString();
                txtidobat.setText(id_obat);
        setIDO(id_obat);
      }
    }//GEN-LAST:event_tableresepMouseClicked

    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubmitActionPerformed
        int confirmation = JOptionPane.showConfirmDialog(null, "Anda Yakin?", "Konfirmasi Resep", JOptionPane.YES_NO_OPTION);
        if(confirmation == 0){
            SubmitPemeriksaan();
        }
    }//GEN-LAST:event_btnsubmitActionPerformed

    private void txtkodepemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodepemeriksaanActionPerformed
        setKodeP(txtkodepemeriksaan.getText());
    }//GEN-LAST:event_txtkodepemeriksaanActionPerformed

    private void txtidobatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidobatActionPerformed
        setIDO(txtidobat.getText());
    }//GEN-LAST:event_txtidobatActionPerformed

    private void txtjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjumlahActionPerformed

    }//GEN-LAST:event_txtjumlahActionPerformed

    private void txtketeranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtketeranganKeyReleased
        setKeterangan(txtketerangan.getText());
    }//GEN-LAST:event_txtketeranganKeyReleased

    private void txtjumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyReleased
        setJumlah(Integer.parseInt(txtjumlah.getText()));
    }//GEN-LAST:event_txtjumlahKeyReleased
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
            java.util.logging.Logger.getLogger(ManageResep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageResep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageResep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageResep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageResep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btncari1;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnsubmit;
    private javax.swing.JButton btnsubmit1;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableresep;
    private javax.swing.JTextField txtidobat;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextPane txtketerangan;
    private javax.swing.JTextField txtkodepemeriksaan;
    // End of variables declaration//GEN-END:variables
}
