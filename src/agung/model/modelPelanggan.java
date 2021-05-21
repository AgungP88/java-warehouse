/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agung.model;

import agung.db.KoneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class modelPelanggan {
    private String namaPelanggan;
    private String nomorHp;
    private String jenisKelamin;
    private int umur;
    private String alamat;
    private String idPelanggan;

    
    //hasil generate untuk idPelanggan
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    
    //inisialisasi class koneksi database
    KoneksiDatabase koneksi = new KoneksiDatabase();
    public modelPelanggan() {
        
    }
    
    

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public void simpanDataPelanggan(){
        //inisialisasi query untuk insert kedalam database
        String sql = ("INSERT INTO pelanggan (namaPelanggan, noHp, jenisKelamin, umur, alamat)" 
                + "VALUES ('"+getNamaPelanggan()+"', '"+getNomorHp()+"', '"+getJenisKelamin()+"'"
                + ", '"+getUmur()+"', '"+getAlamat()+"')");
        
        try {
            //inisialisasi preparedstatmen
            PreparedStatement eksekusi = koneksi. getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            //pemberitahuan jika data berhasil di simpan
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+ex);
        }
    }
    
    public void deleteDataPelanggan(){
        String sql = "DELETE FROM pelanggan WHERE idPelanggan = '"+getIdPelanggan()+"'";
        try {
            //inisialisasi preparedstatmen
            PreparedStatement eksekusi = koneksi. getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            //pemberitahuan jika data berhasil di simpan
            JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+ex);
        }
    }
    
    public void updateDataPelanggan(){
        //inisialisasi query untuk insert kedalam database
//        String sql = ("INSERT INTO pelanggan (namaPelanggan, noHp, jenisKelamin, umur, alamat)" 
//                + "VALUES ('"+getNamaPelanggan()+"', '"+getNomorHp()+"', '"+getJenisKelamin()+"'"
//                + ", '"+getUmur()+"', '"+getAlamat()+"')");
          String sql = "UPDATE pelanggan SET namaPelanggan = '"+getNamaPelanggan()+"'"
                  + ",noHp = '"+getNomorHp()+"'"
                  + ",jenisKelamin = '"+getJenisKelamin()+"'"
                  + ",umur = '"+getUmur()+"'"
                  + ",alamat = '"+getAlamat()+"' WHERE idPelanggan = '"+getIdPelanggan()+"'";
        
        try {
            //inisialisasi preparedstatmen
            PreparedStatement eksekusi = koneksi. getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            //pemberitahuan jika data berhasil di simpan
            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+ex);
        }
    }
}
