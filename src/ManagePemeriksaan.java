/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class ManagePemeriksaan extends javax.swing.JFrame {

    private String[] dataPopUp;
    private String id_dokter;
    private String nama_dokter;
    private String id_pasien;
    private String nama_pasien;
    private String id_pemeriksaan;
    private String tanggal;
    private String status="Pending";
    private String status_crud;
    /**
     * Creates new form ManagePasien
     */
    public ManagePemeriksaan() {
        initComponents();
        reset();
        load_table();
        this.setLocationRelativeTo(null);
    }
    public void setIDD(String v){
        id_dokter = v;
    }
    public void setIDP(String v){
        id_pasien = v;
    }  
    public void setIDPE(String v){
        id_pemeriksaan = v;
    } 
    public void setNamaD(String v){
        nama_dokter = v;
    }
    public void setNamaP(String v){
        nama_pasien = v;
    }
    public void setTanggal(String v){
        tanggal = v;
    }
    public void setStatus(String v){
        status = v;
    }
    public void setStatusC(String v){
        status_crud = v;
    }
    public String getIDD(){
        return id_dokter;
    }
    public String getIDP(){
        return id_pasien;
    }  
    public String getIDPE(){
        return id_pemeriksaan;
    } 
    public String getNamaD(){
        return nama_dokter;
    }
    public String getNamaP(){
       return nama_pasien;
    }
    public String getTanggal(){
       return tanggal;
    }
    public String getStatus(){
        return status;
    }
    public String getStatusC(){
        return status_crud;
    }     
        //batal
    public void batal() {
     txtiddokter.setEnabled(false);
     txtnamadokter.setEnabled(false);
     txtidpasien.setEnabled(false);
     txtnamapasien.setEnabled(false);
     txtid.setEnabled(false);
     txttanggal.setEnabled(false);
     txtjam.setEnabled(false);
     cboxstatus.setEnabled(false);
     btnreset.setEnabled(false);
     btnbatal.setEnabled(false);
     btnsimpan.setEnabled(false);
     btnhapus.setEnabled(true);
     btnedit.setEnabled(true);
     btntambah.setEnabled(true);
     setStatusC("");
     reset();
    }
    //reset
    public void reset() {
     txtiddokter.setText(null);
     txtnamadokter.setText(null);
     txtidpasien.setText(null);
     txtnamapasien.setText(null);
     txtid.setText(null);
    }
    //Dipanggil Saat ingin mengenable semua text Field
    public void enableAllTF() {
     txtid.setEnabled(true);
     txttanggal.setEnabled(true);
     txtjam.setEnabled(true);
     cboxstatus.setEnabled(true);
    }
    public void insertData() {
        try {
            String sql = "INSERT INTO tabel_pemeriksaan(id_dokter,id_pasien,tanggal_pemeriksaan,status_pemeriksaan) VALUES ('"+getIDD()+"','"+getIDP()+"','"+getTanggal()+"','"+getStatus()+"')";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            reset();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void updateData() {
           try {
            String sql ="UPDATE tabel_pemeriksaan SET id_dokter = '"+getIDD()+"', id_pasien = '"+getIDP()+"',tanggal_pemeriksaan = '"+getTanggal()+"',status_pemeriksaan= '"+getStatus()+"' WHERE kode_pemeriksaan = '"+getIDPE()+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
    }
    public void deleteData() {
            try {
            String sql ="DELETE FROM tabel_pemeriksaan where kode_pemeriksaan='"+getIDPE()+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public boolean verifikasiData(){
        if(getIDP() == ""){
            JOptionPane.showMessageDialog(this, "Pasien Masih Kosong");
            return false;
        }else if(getIDD() == ""){
            JOptionPane.showMessageDialog(this, "Dokter Masih Kosong");
            return false;
        }else{
            return true;
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

        jOptionPane2 = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtidpasien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnamapasien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablepemeriksaan = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtiddokter = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtnamadokter = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboxstatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtjam = new javax.swing.JSpinner(new SpinnerDateModel());
        txttanggal = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pasien"));

        jLabel1.setText("ID Pasien");

        txtidpasien.setEnabled(false);
        txtidpasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidpasienActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Pasien");

        txtnamapasien.setEnabled(false);
        txtnamapasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamapasienActionPerformed(evt);
            }
        });

        jButton2.setText("Cari");
        jButton2.setEnabled(false);
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
                    .addComponent(txtnamapasien)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtidpasien, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel7))
                            .addComponent(jLabel2))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidpasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnamapasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel7))
        );

        tablepemeriksaan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablepemeriksaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepemeriksaanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablepemeriksaan);

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setText("Delete");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.setEnabled(false);
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setText("Batal");
        btnbatal.setEnabled(false);
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnreset.setText("Reset");
        btnreset.setEnabled(false);
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Dokter"));

        jLabel8.setText("ID Dokter");

        txtiddokter.setEnabled(false);
        txtiddokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiddokterActionPerformed(evt);
            }
        });

        jLabel9.setText("Nama Dokter");

        txtnamadokter.setEnabled(false);
        txtnamadokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamadokterActionPerformed(evt);
            }
        });

        jButton1.setText("Cari");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnamadokter)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(jLabel10))
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtiddokter, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtiddokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnamadokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jLabel10))
        );

        jLabel3.setText("Waktu Pemeriksaan");

        jLabel4.setText("Status");

        cboxstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "On Process", "Waiting Payment", "Success", "Cancel" }));
        cboxstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxstatusActionPerformed(evt);
            }
        });

        jLabel5.setText("ID Pemeriksaan");

        txtid.setEnabled(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(txtjam, "HH:mm:ss");
        txtjam.setEditor(timeEditor);
        // will only show the current time
        txtjam.setEnabled(false);
        txtjam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjamKeyReleased(evt);
            }
        });

        txttanggal.setEnabled(false);
        txttanggal.setFormats(new String[]{"yyyy-MM-dd"});
        txttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttanggalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtjam, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cboxstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboxstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnreset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        txtid.setEnabled(false);
        txttanggal.setEnabled(true);
        txtjam.setEnabled(true);
        cboxstatus.setEnabled(true);
        txtid.setText("");
        cboxstatus.setSelectedIndex(0);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        btntambah.setEnabled(false);
        btnhapus.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
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
        txtid.setEnabled(false);
        txttanggal.setEnabled(true);
        txtjam.setEnabled(true);
        cboxstatus.setEnabled(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        btntambah.setEnabled(false);
        btnhapus.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        setStatusC("edit");
    }//GEN-LAST:event_btneditActionPerformed

    private void tablepemeriksaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepemeriksaanMouseClicked
        if(getStatusC() == "edit" || getStatusC() == "hapus"){
        int baris = tablepemeriksaan.rowAtPoint(evt.getPoint());
        String kode_pemeriksaan =tablepemeriksaan.getValueAt(baris, 0).toString();
        txtid.setText(kode_pemeriksaan);
        setIDPE(kode_pemeriksaan);
        String id_pasien =tablepemeriksaan.getValueAt(baris, 6).toString();
        txtidpasien.setText(id_pasien);
        setIDP(id_pasien);
        String id_dokter =tablepemeriksaan.getValueAt(baris, 5).toString();
        txtiddokter.setText(id_dokter);
        setIDD(id_dokter);
        String nama_dokter = tablepemeriksaan.getValueAt(baris, 1).toString();
        txtnamadokter.setText(nama_dokter);
        setNamaD(nama_dokter);
        String nama_pasien = tablepemeriksaan.getValueAt(baris, 2).toString();
        txtnamapasien.setText(nama_pasien);
        setNamaP(nama_pasien);
        String status_pemeriksaan =tablepemeriksaan.getValueAt(baris, 4).toString();
        cboxstatus.setSelectedItem(status_pemeriksaan);
        setStatus(status_pemeriksaan);
        }
    }//GEN-LAST:event_tablepemeriksaanMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        JOptionPane.showMessageDialog(null, "Silahkan Klik Data Yang Ingin Dihapus Pada Tabel Dibawah, dan klik Delete Data");
        btntambah.setEnabled(false);
        btnhapus.setEnabled(false);
        btnedit.setEnabled(false);
        btnreset.setEnabled(true);
        btnbatal.setEnabled(true);
        btnsimpan.setEnabled(true);
        btnsimpan.setText("Delete Data");
        setStatusC("hapus");
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txtnamapasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamapasienActionPerformed
           setNamaP(txtnamapasien.getText());
    }//GEN-LAST:event_txtnamapasienActionPerformed

    private void txtidpasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidpasienActionPerformed
           setIDP(txtidpasien.getText());
    }//GEN-LAST:event_txtidpasienActionPerformed

    private void txtiddokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiddokterActionPerformed

    }//GEN-LAST:event_txtiddokterActionPerformed

    private void txtnamadokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamadokterActionPerformed

    }//GEN-LAST:event_txtnamadokterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PemeriksaanDokter pd = new PemeriksaanDokter(new javax.swing.JFrame(), true);
        pd.setVisible(true);
        txtiddokter.setText(pd.getAmbilData()[0]);
        setIDD(pd.getAmbilData()[0]);
        txtnamadokter.setText(pd.getAmbilData()[1]);
        setNamaD(pd.getAmbilData()[1]);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       PemeriksaanPasien pp = new PemeriksaanPasien(new javax.swing.JFrame(), true);
        pp.setVisible(true);
        txtidpasien.setText(pp.getAmbilData()[0]);
        setIDP(pp.getAmbilData()[0]);
        txtnamapasien.setText(pp.getAmbilData()[1]);
        setNamaP(pp.getAmbilData()[1]);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        setIDPE(txtid.getText());
    }//GEN-LAST:event_txtidActionPerformed

    private void txttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttanggalActionPerformed
        setTanggal(Tanggalan());
    }//GEN-LAST:event_txttanggalActionPerformed

    private void txtjamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjamKeyReleased
        setTanggal(Tanggalan());
    }//GEN-LAST:event_txtjamKeyReleased

    private void cboxstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxstatusActionPerformed
        setStatus(cboxstatus.getSelectedItem().toString());
    }//GEN-LAST:event_cboxstatusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        batal();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        reset();
    }//GEN-LAST:event_btnresetActionPerformed
private void load_table(){
        //menampilkan data database kedalam tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pemeriksaan");
        model.addColumn("Nama Dokter");
        model.addColumn("Nama Pasien");
        model.addColumn("Tanggal Pemeriksaan");
        model.addColumn("Status Pemeriksaan");
        model.addColumn("ID Dokter");
        model.addColumn("ID Pasien");
        try {
            int no=1;
            String sql = "select p.kode_pemeriksaan,d.nama_dokter,pa.nama_pasien,p.tanggal_pemeriksaan,p.status_pemeriksaan,p.id_dokter,p.id_pasien from tabel_pemeriksaan p INNER JOIN tabel_dokter d ON p.id_dokter = d.id_dokter INNER JOIN tabel_pasien pa ON pa.id_pasien = p.id_pasien";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
            tablepemeriksaan.setModel(model);
        } catch (Exception e) {
        }
        //Hide Kolom
        tablepemeriksaan.getColumnModel().getColumn(5).setWidth(0);
        tablepemeriksaan.getColumnModel().getColumn(5).setMinWidth(0);
        tablepemeriksaan.getColumnModel().getColumn(5).setMaxWidth(0); 
        tablepemeriksaan.getColumnModel().getColumn(6).setWidth(0);
        tablepemeriksaan.getColumnModel().getColumn(6).setMinWidth(0);
        tablepemeriksaan.getColumnModel().getColumn(6).setMaxWidth(0); 
}
private String Tanggalan(){
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
txttanggal.setFormats(dateFormat);
DateFormat sysDate = new SimpleDateFormat("yyyy/MM/dd");
JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(txtjam, "HH:mm:ss");
txtjam.setEditor(timeEditor);
String date_to_store = sysDate.format(txttanggal.getDate()).toString()+" "+timeEditor.getFormat().format(txtjam.getValue());
return date_to_store;
}
public void setDataPopUp(String[] dataPopUp)
{
this.dataPopUp = dataPopUp;
}
	
public String[] getDataPopUp()
{
return dataPopUp;
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
            java.util.logging.Logger.getLogger(ManagePemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePemeriksaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePemeriksaan().setVisible(true);
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
    private javax.swing.JComboBox<String> cboxstatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablepemeriksaan;
    private javax.swing.JTextField txtid;
    public javax.swing.JTextField txtiddokter;
    public javax.swing.JTextField txtidpasien;
    private javax.swing.JSpinner txtjam;
    public javax.swing.JTextField txtnamadokter;
    public javax.swing.JTextField txtnamapasien;
    private org.jdesktop.swingx.JXDatePicker txttanggal;
    // End of variables declaration//GEN-END:variables
}
