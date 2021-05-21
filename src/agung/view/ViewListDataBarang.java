/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.view;

import agung.db.KoneksiDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ViewListDataBarang extends javax.swing.JFrame {

    /**
     * Creates new form ViewListDataBarang
     */
    //inisialisasi untuk menggabungkan form ini dengan form transaksi
    private ViewTransaksi vT;
    //inisialisasi table model
    private DefaultTableModel model;
    //inisialisasi variable untuk menyimpan data ke database
    private String sql = "";
    public ViewListDataBarang(ViewTransaksi vT) {
        initComponents();
        
        this.vT = vT;
        
        //inisialisasi kolom table
        model = new DefaultTableModel();
        tableDataBarang.setModel(model);
        model.addColumn("id barang");
        model.addColumn("nama barang");
        model.addColumn("satuan barang");
        model.addColumn("jenis barang");
        model.addColumn("ukuran");
        model.addColumn("harga");
        
        //panggil tampil barang supaya barang ditampilkan pertama kali form dibuka
        
        tampilDataBarang("");//harus ada parameter untuk kondisi
        
    }
    
    //fungsi untuk mengambil data barang dari database
    //satu fungsi akan digunakan untuk dua kondisi
    //yaitu untuk menampilkan seluruh barang
    //dan menampilkan data barang berdasarkan pencarian
    private void tampilDataBarang(String data){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        //kondisi pengecekan apakah yang dicari 
        //seluruhnya atau satu saja
        if(data.equals("")){
            sql = "Select * from barang";
        } else sql = "select * from barang where namaBarang LIKE'"+data+"%'";
        
        try {
            Statement stat = (Statement)KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            //proses pengambilan data hasil query
            while(res.next()){
                Object[] hasil;
                hasil = new Object[6];//jumlah object sesuaikan dengan jumlah kolom
                hasil[0] = res.getString("idBarang");//disesuaikan dengan field pada database
                hasil[1] = res.getString("namaBarang");//disesuaikan dengan field pada database
                hasil[2] = res.getString("jenisBarang");//disesuaikan dengan field pada database
                hasil[3] = res.getString("satuan");//disesuaikan dengan field pada database
                hasil[4] = res.getString("ukuran");//disesuaikan dengan field pada database
                hasil[5] = res.getString("harga");//disesuaikan dengan field pada database
                
                model.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewListDataBarang.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        namaBarang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDataBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Daftar Barang");

        jLabel2.setText("Cari Nama Barang");

        namaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaBarangActionPerformed(evt);
            }
        });
        namaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaBarangKeyPressed(evt);
            }
        });

        tableDataBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDataBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaBarangKeyPressed
        // TODO add your handling code here:
        //fungsi ini akan dieksekusi saat kita akan mencari data barang
        tampilDataBarang(namaBarang.getText());
    }//GEN-LAST:event_namaBarangKeyPressed

    private void tableDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataBarangMouseClicked
        // TODO add your handling code here:
        int ambilRow = tableDataBarang.getSelectedRow();
        vT.getNamaBarang().setText(tableDataBarang.getValueAt(ambilRow, 1).toString());
        vT.getHargaBarang().setText(tableDataBarang.getValueAt(ambilRow, 5).toString());
        
        vT.getHargaBarang().requestFocus();//focus ketika table barang di klik masuk ke harga barang
        
        this.dispose();
    }//GEN-LAST:event_tableDataBarangMouseClicked

    private void namaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaBarangActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namaBarang;
    private javax.swing.JTable tableDataBarang;
    // End of variables declaration//GEN-END:variables
}
